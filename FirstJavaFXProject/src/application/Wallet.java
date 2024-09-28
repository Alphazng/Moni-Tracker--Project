package application;

import java.util.ArrayList;
import java.util.Date;

public class Wallet {
	protected String walletName;
	protected double walletTotal;
	protected ArrayList<Transaction> transactions = new ArrayList<>();

	public Wallet(String walletName) {
		super();
		this.walletName = walletName;
	}

	public String getWalletName() {
		return walletName;
	}

	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	public double getWalletTotal() {
		return walletTotal;
	}

	public void setWalletTotal(double walletTotal) {
		this.walletTotal = walletTotal;
	}

	public ArrayList<Transaction> getTransaction() {
		return transactions;
	}

	public void setTransaction(ArrayList<Transaction> transaction) {
		this.transactions = transaction;
	}

	public void addTransaction(int value, String category, boolean isExpense) {
		if (isExpense) {
			transactions.add(new Expense(value, category, new Date()));
		} else {
			transactions.add(new Income(value, category, new Date()));
		}
	}

	public void printTransactions() {

		for (Transaction x : transactions) {
			if (x instanceof Expense) {
				
				System.out.println(((Expense) x).toString());
				
			} else if (x instanceof Income) {
				
				System.out.println(((Income) x).toString());
				
			}
		}
	}
	
}
