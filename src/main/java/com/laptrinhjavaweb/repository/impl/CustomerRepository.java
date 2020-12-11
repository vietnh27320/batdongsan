package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.ICustomerRepository;

public class CustomerRepository extends SimpleJpaRepository<CustomerEntity> implements ICustomerRepository {

//	@Override
//	public List<CustomerEntity> findAll() {
//		List<CustomerEntity> results = new ArrayList<>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estate32020module1part1", "root",
//					"12345678");
//			stmt = conn.createStatement();
//			String sql = "Select * from customer";
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				CustomerEntity customerEntity = new CustomerEntity();
//				customerEntity.setFullName(rs.getString("fullname"));
//				customerEntity.setPhone(rs.getString("phone"));
//				results.add(customerEntity);
//			}
//			results.forEach(a -> System.out.print(a.toString()));
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
//		String sql = "select * from customer";
//		return this.findAll(sql);
//	}

}
