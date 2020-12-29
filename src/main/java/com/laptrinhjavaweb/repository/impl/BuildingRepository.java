package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import org.apache.commons.lang.StringUtils;

public class BuildingRepository extends SimpleJpaRepository<BuildingEntity> implements IBuildingRepository {

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder builder, Map<String, Object> params) {
        StringBuilder sql = new StringBuilder("select * from building A");
        if (builder.getStaffId() != null) {
            sql.append(" inner join assignmentbuilding ab on A.id = ab.buildingid");
        }
        sql = this.createSqlCommon(sql, params);
        sql = createSqlSpecial(sql, builder);
        if (builder.getStaffId() != null) {
            sql.append(" and ab.staff = " + builder.getStaffId() + "");
        }
        return this.findAll(sql.toString());
    }

    @Override
    public void deleteBuilding(long[] ids) {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            statement = conn.createStatement();

            for (long item : ids) {
                String sql1 = "DELETE FROM rentarea where buildingid = " + item + "";
                statement.execute(sql1);
                String sql2 = "DELETE FROM assignmentbuilding where buildingid = " + item + "";
                statement.execute(sql2);
                String sql3 = "DELETE FROM building where id = " + item + "";
                statement.execute(sql3);
            }


            if (conn != null) {

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

    private StringBuilder createSqlSpecial(StringBuilder sql, BuildingSearchBuilder builder) {
        if (builder.getCostRentFrom() != null) {
            sql.append(" and A.rentprice >= " + builder.getCostRentFrom() + "");
        }
        if (builder.getCostRentTo() != null) {
            sql.append(" and A.rentprice <= " + builder.getCostRentTo() + "");
        }
        if (builder.getTypes() != null && builder.getTypes().length > 0) {
            sql.append(" and (");
            /*for (String item : builder.getTypes()) {
                if (item.equals(builder.getTypes()[0])) {
                    sql.append("A.type like '%" + item + "%'");
                } else {
                    sql.append(" or A.type like '%" + item + "%'");
                }
            }*/
            String sqlType = Arrays.stream(builder.getTypes()).map(item -> "A.type like '%" + item + "%'").collect(Collectors.joining(" or "));
            sql.append(sqlType);
            sql.append(")");
        }
        if (builder.getAreaRentFrom() != null || builder.getAreaRentTo() != null) {
            sql.append(" and EXISTS (SELECT * from rentarea r WHERE (r.buildingid = A.id) and (");
            if (builder.getAreaRentFrom() != null) {
                sql.append(" and r.value >= " + builder.getAreaRentFrom() + "");
            }
            if (builder.getAreaRentTo() != null) {
                sql.append(" and r.value <= " + builder.getAreaRentTo() + "");
            }
            sql.append("))");
        }
        return sql;
    }

}
//	@Override
//	public void update(BuildingEntity buidingEntity) {
//		PreparedStatement stmt = null;
////		Statement stmt = null;
//		Connection connection = null;
//		try {
//			connection = this.getConnection();
//			connection.setAutoCommit(false);
//			stmt = connection.prepareStatement("update building set name = ? where id = ?");
////			String sql = "update building set name = '" + buidingEntity.getName() + "' where id = "
////					+ buidingEntity.getId() + "";
////			stmt = connection.createStatement();
//			stmt.setString(1, buidingEntity.getName());// 1 specifies the first parameter in the query
//			stmt.setLong(2, buidingEntity.getId());
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

//	@Override
//	public void delete(long id) {
//		StringBuilder sql = new StringBuilder("DELETE FROM building WHERE id = ?");
//		sql.append(" VALUES(?)");
//		PreparedStatement stmt = null;
//		Connection connection = null;
//		try {
//			connection = this.getConnection();
//			connection.setAutoCommit(false);
//			stmt = connection.prepareStatement(sql.toString());
//			stmt.setLong(1, id);
//			stmt.executeUpdate();
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
//
//}
//
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

