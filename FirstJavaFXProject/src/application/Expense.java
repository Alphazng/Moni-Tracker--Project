package application;

import java.util.Date;

public class Expense extends Transaction {

	public Expense(double value, String category, Date date) {
		super(value, category, date);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "(-) IDR"+value+" | "+category+" | "+date.toString();
//		String str = String.format("(-) IDR%-15d  %s\n%s", value, category, date.toString());
		
		return str;
	}

}
