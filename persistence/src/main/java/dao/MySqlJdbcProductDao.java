package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ProductDto;

public class MySqlJdbcProductDao implements ProductDao {

	@Override
	public List<ProductDto> getProducts() {
		Connection con;
		try {
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from product"); 
			
			List<ProductDto> products = new ArrayList<>();
			
			while (rs.next()) {
				ProductDto product = new ProductDto();
				product.setId(rs.getInt("id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getBigDecimal("price"));
				products.add(product);
			}
			
			return products;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public ProductDto getProductById(int productId) {
		
		try {
			Connection con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from product"); 
			
			while (rs.next()) {
				ProductDto product = new ProductDto();
				product.setId(rs.getInt("id"));
			
				return product;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
