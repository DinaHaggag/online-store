package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.CategoryDto;

public class MySqlJdbcCategoryDao implements CategoryDao{

	@Override
	public CategoryDto getCategoryByCategoryId(int id) {
		try {
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			
			PreparedStatement  ps = con.prepareStatement("SELECT * FROM category WHERE id = ?");  
			
			
			var rs = ps.executeQuery();
			
			while (rs.next()) {
				CategoryDto category = new CategoryDto();
				category.setId(rs.getInt("id"));
				category.setCategoryName(rs.getString("category_name"));
				return category;
			}
			
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
