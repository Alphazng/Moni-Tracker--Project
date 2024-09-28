package application;

import java.util.Date;

public abstract class Transaction {
	protected double value;
	protected String category;
	protected Date date;

	public Transaction(double value, String category, Date date) {
		super();
		this.value = value;
		this.category = category;
		this.date = date;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public abstract String toString();

}
