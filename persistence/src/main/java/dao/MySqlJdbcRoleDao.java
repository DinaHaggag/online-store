package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.RoleDto;

public class MySqlJdbcRoleDao implements RoleDao {

	@Override
	public RoleDto getRoleById(int id) {
		try {
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user WHERE id = ?");  
			
			while(rs.next()) {
				RoleDto role = new RoleDto();
				role.setId(rs.getInt("id"));
				return role;
			}
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}

