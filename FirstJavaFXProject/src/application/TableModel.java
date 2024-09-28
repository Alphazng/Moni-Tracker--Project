package application;

public class TableModel {
	String dbDate, dbCategory, dbValue;

	public TableModel(String dbDate, String dbCategory, String dbValue) {
		super();
		this.dbDate = dbDate;
		this.dbCategory = dbCategory;
		this.dbValue = dbValue;
	}

	public String getDbDate() {
		return dbDate;
	}

	public void setDbDate(String dbDate) {
		this.dbDate = dbDate;
	}

	public String getDbCategory() {
		return dbCategory;
	}

	public void setDbCategory(String dbCategory) {
		this.dbCategory = dbCategory;
	}

	public String getDbValue() {
		return dbValue;
	}

	public void setDbValue(String dbValue) {
		this.dbValue = dbValue;
	}
	
}
