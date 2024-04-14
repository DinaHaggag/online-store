package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ProductDto;
import dto.PurchaseDto;

public class MySqlJdbcPurchaseDao implements PurchaseDao {
	
	private UserDao userDao;
	private ProductDao productDao;
	
	{
		userDao = new MySqlJdbcUserDao();
		productDao = new MySqlJdbcProductDao();
	}

	@Override
	public void savePurchase(PurchaseDto purchase) {
		Connection con;
		try {
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			
			PreparedStatement  ps = con.prepareStatement("INSERT INTO purchase (fk_purchase_user) VALUES (?);", Statement.RETURN_GENERATED_KEYS);
			PreparedStatement  psPurchaseProduct  = con.prepareStatement("INSERT INTO purchase_product (purchase_id, product_id) VALUES (?, ?)");
			
			ps.executeUpdate();
			var generatedKeys = ps.getGeneratedKeys();
			
			while (generatedKeys.next()) {
            	
            	for (ProductDto product : purchase.getProductDtos()) {
            		psPurchaseProduct.setLong(1, generatedKeys.getLong(1));
            		psPurchaseProduct.setInt(2, product.getId());
            		psPurchaseProduct.addBatch();
            	}
            	
            	psPurchaseProduct.executeBatch();
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PurchaseDto> getPurchasesByUserId(int userId) {
		Connection con;
		try {
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			PreparedStatement  ps = con.prepareStatement("SELECT * FROM purchase WHERE fk_purchase_user = ?");
			
			List<PurchaseDto> purchases = new ArrayList<>();
			var rs= ps.executeQuery();
			while (rs.next()) {
				PurchaseDto purchase = new PurchaseDto();
				purchase.setId(rs.getInt("id"));
				purchase.setUserDto(userDao.getUserById(rs.getInt("fk_purchase_user")));
				
				List<ProductDto> products = new ArrayList<>();
				try (var psProducts = con.prepareStatement("SELECT * FROM purchase_product WHERE purchase_id = " + purchase.getId());
						var rsProducts = psProducts.executeQuery()) {
					
					while (rsProducts.next()) {
						products.add(productDao.getProductById(rsProducts.getInt("product_id")));
					}
				}
				purchase.setProductDtos(products);
				purchases.add(purchase);
			}
		
		return purchases;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<PurchaseDto> getPurchases() {
		Connection con;
		try {
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/online_shop","root","Dina27kmh");
			PreparedStatement  ps = con.prepareStatement("SELECT * FROM purchase");
			
			List<PurchaseDto> purchases = new ArrayList<>();
			var rs = ps.executeQuery();
			
			while (rs.next()) {
				PurchaseDto purchase = new PurchaseDto();
				purchase.setId(rs.getInt("id"));
				purchase.setUserDto(userDao.getUserById(rs.getInt("fk_purchase_user")));
				
				List<ProductDto> products = new ArrayList<>();
				try (var psProducts = con.prepareStatement("SELECT * FROM purchase_product WHERE purchase_id = " + purchase.getId());
						var rsProducts = psProducts.executeQuery()) {
					
					while (rs.next()) {
						products.add(productDao.getProductById(rs.getInt("product_id")));
					}
				}
				purchase.setProductDtos(products);
				purchases.add(purchase);
			}
		
		return purchases;
		} catch (SQLException e) {
	
			e.printStackTrace();
			return null;
		}
		
	}


}
