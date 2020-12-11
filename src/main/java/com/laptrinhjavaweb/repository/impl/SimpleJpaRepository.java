package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.repository.JpaRepository;

public class SimpleJpaRepository<T> implements JpaRepository<T> {

	private Class<T> zClass;

	@SuppressWarnings("unchecked")
	public SimpleJpaRepository() {
		zClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estate32020module1part1", "root",
					"12345678");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<T> findAll() {
		List<T> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String tableName = "";
			if (zClass.isAnnotationPresent(Table.class)) {
				Table table = zClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			String sql = "select * from " + tableName;
			rs = stmt.executeQuery(sql);
			/*
			 * while (rs.next()) { CustomerEntity customerEntity = new CustomerEntity();
			 * customerEntity.setFullName(rs.getString("fullname"));
			 * customerEntity.setPhone(rs.getString("phone")); results.add(customerEntity);
			 * }
			 */

			if (zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				Field[] fields = zClass.getDeclaredFields();
				while (rs.next()) {
					T object = zClass.newInstance();
					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
						String columnName = resultSetMetaData.getColumnName(i + 1);
						Object columnValue = rs.getObject(i + 1);
						for (Field field : fields) {
							if (field.isAnnotationPresent(Column.class)) {
								Column column = field.getAnnotation(Column.class);
								if (column.name().equals(columnName) && columnValue != null) {
									// set gia tri
									BeanUtils.setProperty(object, field.getName(), columnValue);
									break;
								}
							}
						}
					}
					results.add(object);
				}
			}
//			results.forEach(a -> System.out.print(a.toString()));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					conn.close();
				}
				if (rs != null) {
					conn.close();
				}

			} catch (Exception se) {
				se.printStackTrace();
			}
		}
		return results;
	}

	@Override
	public void insert(Object object) {
		String sql = buildSqlInsert();
		PreparedStatement stmt = null;
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(sql);
			Class<?> aClass = object.getClass();
			int index = 1;
			for (Field field : aClass.getDeclaredFields()) {
				field.setAccessible(true);
				stmt.setObject(index, field.get(object));
				index++;
			}
			stmt.executeUpdate();
			connection.commit();
			System.out.println("insert success");
		} catch (Exception e) {
			System.out.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					connection.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private String buildSqlInsert() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}

		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		for (Field field : zClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");
			}
		}
		String sql = "INSERT INTO " + tableName + " (" + fields.toString() + ") VALUES(" + params.toString() + ")";
		return sql;
	}
}
