package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.UserDto;

public class MySqlJdbcUserDao implements UserDao {
	
private RoleDao roleDao;
	
	{
		roleDao = new MySqlJdbcRoleDao();
	}

	@Override
	public boolean saveUser(UserDto user) {
		try {
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			
			PreparedStatement  ps = con.prepareStatement("INSERT INTO user (first_name, last_name, email, fk_user_role, "
					+ "money, credit_card, password) VALUES (?, ?, ?, ?, ?, ?, ?)");  
			
				ps.setString(1, user.getFirstName());
		        ps.setString(2, user.getLastName());
		        ps.setString(3, user.getEmail());
		        ps.setBigDecimal(5, user.getMoney());      
		        ps.setString(6, user.getCreditCard());
		        ps.setString(7, user.getPassword());
		        
		        int rowsAffected = ps.executeUpdate(); 
			
			
			con.close();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<UserDto> getUsers() {
		Connection con;
		try {
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user WHERE email = ?"); 
			List<UserDto> users = new ArrayList<>();
			
			while (rs.next()) {
				UserDto user = new UserDto();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setRoleDto(roleDao.getRoleById(rs.getInt("fk_user_role")));
				user.setMoney(rs.getBigDecimal("money"));
				user.setCreditCard(rs.getString("credit_card"));
				user.setPassword(rs.getString("password"));
				users.add(user);
				
				return users;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public UserDto getUserByEmail(String userEmail) {
		try {
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user WHERE email = ?");  
			
			while(rs.next()) {
			UserDto user = new UserDto();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setRoleDto(roleDao.getRoleById(rs.getInt("fk_user_role")));
			user.setMoney(rs.getBigDecimal("money"));
			user.setCreditCard(rs.getString("credit_card"));
			user.setPassword(rs.getString("password"));
			return user; 
			}
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getUserById(int id) {
		try {
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user WHERE id = ?");  
			
			while(rs.next()) {
			UserDto user = new UserDto();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setRoleDto(roleDao.getRoleById(rs.getInt("fk_user_role")));
			user.setMoney(rs.getBigDecimal("money"));
			user.setCreditCard(rs.getString("credit_card"));
			user.setPassword(rs.getString("password"));
			return user; 
			}
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
