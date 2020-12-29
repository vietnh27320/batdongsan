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
import java.util.Map;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.repository.JpaRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

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

    public List<T> findAll(Object... where) {
        List<T> results = new ArrayList<>();
        ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
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
            StringBuilder builder = new StringBuilder("select * from " + tableName + " A where 1=1 ");
            if (where != null && where.length > 0) {
                builder.append(where[0]);
            }
            rs = stmt.executeQuery(builder.toString());
            /*
             * while (rs.next()) { CustomerEntity customerEntity = new CustomerEntity();
             * customerEntity.setFullName(rs.getString("fullname"));
             * customerEntity.setPhone(rs.getString("phone")); results.add(customerEntity);
             * }
             */
            results = resultSetMapper.mapRow(rs, this.zClass);
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
    public List<T> findAll(String sql) {
        List<T> results = new ArrayList<>();
        ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            results = resultSetMapper.mapRow(rs, this.zClass);
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
    public Long insert(Object object) {
        String sql = buildSqlInsert();
        PreparedStatement stmt = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Class<?> aClass = object.getClass();
            int index = 1;
            for (Field field : aClass.getDeclaredFields()) {
                field.setAccessible(true);
                stmt.setObject(index, field.get(object));
                index++;
            }
            stmt.executeUpdate();
            resultSet = stmt.getGeneratedKeys();
            connection.commit();
            while (resultSet.next()) {
                return resultSet.getLong(1);
            }
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
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }

    @Override
    public T findById(long id) {
        return null;
    }

    @Override
    public void delete(long id) {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            String tableName = "";
            if (zClass.isAnnotationPresent(Table.class)) {
                Table table = zClass.getAnnotation(Table.class);
                tableName = table.name();
            }

            String sql = "DELETE FROM " + tableName + " where id = " + id;
            statement = conn.createStatement();

            if (conn != null) {
                statement.execute(sql);
                conn.commit();
            }


        } catch (Exception e) {
            if (conn != null) {
                try {

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    conn.close();
                }


            } catch (Exception se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void deleteByProperty(String where) {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            String tableName = "";
            if (zClass.isAnnotationPresent(Table.class)) {
                Table table = zClass.getAnnotation(Table.class);
                tableName = table.name();
            }

            String sql = "DELETE FROM " + tableName + " " + where;
            statement = conn.createStatement();

            if (conn != null) {
                statement.execute(sql);
                conn.commit();
            }


        } catch (Exception e) {
            if (conn != null) {
                try {

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    conn.close();
                }


            } catch (Exception se) {
                se.printStackTrace();
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

    protected StringBuilder createSqlCommon(StringBuilder where, Map<String, Object> params) {
        if (params != null && params.size() > 0) {
            String[] keys = new String[params.size()];
            Object[] values = new Object[params.size()];
            int i = 0;
            for (Map.Entry<String, Object> item : params.entrySet()) {
                keys[i] = item.getKey();
                values[i] = item.getValue();
                i++;
            }
            for (int j = 0; j < keys.length; j++) {
                if ((values[j] instanceof String) && (StringUtils.isNotBlank(values[j].toString()))) {
                    where.append(" and A." + keys[j] + " like '%" + values[j] + "%'");
                } else if ((values[j] instanceof Integer) && (values[j] != null)) {
                    where.append(" and A." + keys[j] + " = " + values[j] + "");
                }
            }
        }
        return where;
    }

}
