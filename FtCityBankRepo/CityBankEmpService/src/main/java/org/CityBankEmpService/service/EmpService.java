package org.CityBankEmpService.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpService {
	private static final String SELECT_EMP_QUERY = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=? ORDER BY EMPLOYEE_ID";

	public String empService(int empid) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet ressultset = null;

		// System.out.println("EmpService.empService()");

		try {
			// System.out.println("EmpService.empService(try)");
			// Register the Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// System.out.println("class loaded");

			// create connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "system");
			// System.out.println("connected to the db");

			// create statement
			if (connection != null) {
				stmt = connection.prepareStatement(SELECT_EMP_QUERY);
				// System.out.println("prepared stmt created");
				// set query param value(s)
				stmt.setInt(1, empid);
				// System.out.println("params passed");
			}

			// execute the query and fetch the results
			if (stmt != null) {
				ressultset = stmt.executeQuery();
				// System.out.println("query executed ");
				if (ressultset.next()) {
					// System.out.println("inside resultset-if(true)");

					java.sql.Date dbSqlDate = ressultset.getDate("HIRE_DATE");
					String phno = ressultset.getString("PHONE_NUMBER");
					System.out.println("EMPLOYEE_ID:" + ressultset.getInt("EMPLOYEE_ID") + "\nFIRST_NAME: "
							+ ressultset.getString("FIRST_NAME") + "\nLAST_NAME:" + ressultset.getString("LAST_NAME")
							+ "\nEMAIL:" + ressultset.getString("EMAIL") + "\nPHONE_NUMBER:" + phno + "\nHIRE_DATE :"
							+ dbSqlDate + "\nJOB_ID:" + ressultset.getString("JOB_ID") + "\nSALARY:"
							+ ressultset.getInt("SALARY") + "\nCOMMISSION_PCT:" + ressultset.getInt("COMMISSION_PCT")
							+ "\nMANAGER_ID: " + ressultset.getString("MANAGER_ID") + "\nDEPARTMENT_ID:"
							+ ressultset.getString("DEPARTMENT_ID"));

				} else {
					System.out.println("ENTERD WRONG EMP ID =\"" + empid + "\"");
				}
			} // if

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} finally {

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (ressultset != null) {
					ressultset.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} // finally
		return "records fetched successfully";

	}

	public static void main(String[] args) throws Exception {
		// System.out.println("EmpService.main()");
		System.out.println("EMP details from Employees table Of HR ");
		Scanner sc = null;
		try {
			// System.out.println("EmpService.main(try)");
			sc = new Scanner(System.in);
			System.out.println("Enter a valid emp_id (100-206) : ");
			int empid = sc.nextInt();
			EmpService eservice = new EmpService();
			eservice.empService(empid);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}// main
}// class