package org.erock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


import lombok.extern.log4j.Log4j;


@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		@Test
		public void testConnection() {
			Connection con = null;
			try{
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"book_ex",
						"book_ex"
						);
				log.info("con : " + con);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(con != null)con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	/*
	 * Connection con =null;; try {
	 * Class.forName("oracle.jdbc.driver.OracleDriver"); con =
	 * DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe",
	 * "book_ex", "book_ex" ); log.info("con : " + con);
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }finally { try { if(con != null)
	 * con.close(); } catch (SQLException e) { e.printStackTrace(); } } }
	 */