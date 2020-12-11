package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.IBuildingRepository;

public class BuildingRepository extends SimpleJpaRepository<BuildingEntity> implements IBuildingRepository {

	@Override
	public void update(BuildingEntity buidingEntity) {
		PreparedStatement stmt = null;
//		Statement stmt = null;
		Connection connection = null;
		try {
			connection = this.getConnection();
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement("update building set name = ? where id = ?");
//			String sql = "update building set name = '" + buidingEntity.getName() + "' where id = "
//					+ buidingEntity.getId() + "";
//			stmt = connection.createStatement();
			stmt.setString(1, buidingEntity.getName());// 1 specifies the first parameter in the query
			stmt.setLong(2, buidingEntity.getId());
			stmt.executeUpdate();
//			stmt.executeUpdate(sql);
			connection.commit();
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

//	@Override
//	public void save(BuildingEntity newBuilding) {
//		StringBuilder sql = new StringBuilder("INSERT INTO building(name)");
//		sql.append(" VALUES(?)");
//		PreparedStatement stmt = null;
////		Statement stmt = null;
//		Connection connection = null;
//		try {
//			connection = this.getConnection();
//			connection.setAutoCommit(false);
//			stmt = connection.prepareStatement(sql.toString());
////			String sql = "update building set name = '" + buidingEntity.getName() + "' where id = "
////					+ buidingEntity.getId() + "";
////			stmt = connection.createStatement();
//			stmt.setString(1, newBuilding.getName());// 1 specifies the first parameter in the query
//			stmt.executeUpdate();
////			stmt.executeUpdate(sql);
//			connection.commit();
//		} catch (Exception e) {
//			System.out.println(e);
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (stmt != null) {
//					connection.close();
//				}
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		}
//	}

	@Override
	public void delete(long id) {
		StringBuilder sql = new StringBuilder("DELETE FROM building WHERE id = ?");
		sql.append(" VALUES(?)");
		PreparedStatement stmt = null;
		Connection connection = null;
		try {
			connection = this.getConnection();
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(sql.toString());
			stmt.setLong(1, id);
			stmt.executeUpdate();
			connection.commit();
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

}

//	@Override
//	public List<BuildingEntity> findAll() {
//		List<BuildingEntity> results = new ArrayList<>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estate32020module1part1", "root","12345678");
//			stmt = conn.createStatement();
//
//			String sql = "Select * from building";
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				BuildingEntity buildingEntity = new BuildingEntity();
//				buildingEntity.setName(rs.getString("name"));
//				buildingEntity.setWard(rs.getString("ward"));
//				results.add(buildingEntity);
//			}
//			return results;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//				if (stmt != null) {
//					conn.close();
//				}
//				if (rs != null) {
//					conn.close();
//				}
//
//			} catch (Exception se) {
//				se.printStackTrace();
//			}
//		}
//		String sql = "select * from building";	
//		return this.findAll(sql);
//	}
