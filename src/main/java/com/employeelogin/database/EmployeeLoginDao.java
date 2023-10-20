package com.employeelogin.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import java.sql.SQLException;
import com.employeelogin.bean.EmployeeLoginBean;
import com.employeelogin.database.DB;

public class EmployeeLoginDao {

	public boolean validate(EmployeeLoginBean empbean) {
		boolean status = false;
		try {
			Connection conn = DB.connect();

			// Create a statement object.
			PreparedStatement pstm = conn
					.prepareStatement("SELECT * FROM employeecredentials WHERE username=? AND password=?");
			pstm.setString(1, empbean.getUsername());
			pstm.setString(2, empbean.getPassword());

			ResultSet rest = pstm.executeQuery();
			return rest.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public EmployeeLoginBean[] listEmployees() {
		List<EmployeeLoginBean> resp = new ArrayList<>();
		try {
			Connection conn = DB.connect();
			Statement stmt = conn.createStatement();
			ResultSet rest = stmt.executeQuery("SELECT * FROM employeecredentials");
			while(rest.next()) {
				String uname = rest.getString(1);
				String pswd = rest.getString(2);
				resp.add(new EmployeeLoginBean(uname, pswd));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp.toArray(new EmployeeLoginBean[resp.size()]);
	}
}
