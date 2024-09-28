package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import application.User;

public class DbHandler {
	
	String walletName, transactCategory;
	Double transactValue;
	Timestamp transactDate;
	boolean isExpense;
	
	public static void insert(String walletName, Double transactValue, String transactCategory, Timestamp transactDate, boolean isExpense) {
		Connect con = Connect.getConnection();
		
		String query = String.format(
				"INSERT INTO `user`(`walletName`, `transactId`, `transactValue`, `transactCategory`, `transactDate`, `isExpense`)"
				+ "VALUES ('%s', NULL, '%f', '%s', '%s', '%d')",
				walletName, transactValue, transactCategory, transactDate.toString(), isExpense?1:0);
	
		con.executeUpdate(query);
	}
	
	public static void loadWalletName() {
		Connect con = Connect.getConnection();
		
		String query = "SELECT * FROM user";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while (rs.next()) {
				String walletName = rs.getString("walletName");

				if (!User.walletNames.contains(walletName)) {
					User.walletNames.add(walletName);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAll() {
		Connect con = Connect.getConnection();
		
		String query = "SELECT * FROM user";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while (rs.next()) {
				System.out.printf("%s %f %s %s %b\n",
						rs.getString("walletName"),
						rs.getDouble("transactValue"),
						rs.getString("transactCategory"),
						rs.getTimestamp("transactDate").toString(),
						rs.getBoolean("isExpense"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
