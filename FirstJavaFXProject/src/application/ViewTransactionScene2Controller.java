package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Database.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class ViewTransactionScene2Controller implements Initializable {
	@FXML
	private Label labelWalletName;
	@FXML
	private TableView<TableModel> dbTable;
	@FXML
	private TableColumn<TableModel, String> dbDate;
	@FXML
	private TableColumn<TableModel, String> dbCategory;
	@FXML
	private TableColumn<TableModel, String> dbValue;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	
	ObservableList<TableModel> listView = FXCollections.observableArrayList();
	
	
	@FXML
	public void switchToViewTransactionsScene2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String walletName = ViewTransactionScene1Controller.CbChooseViewWaletValue;
		labelWalletName.setText("Wallet: "+walletName);
		
		//database view
		dbDate.setCellValueFactory(new PropertyValueFactory<>("dbDate"));
		dbCategory.setCellValueFactory(new PropertyValueFactory<>("dbCategory"));
		dbValue.setCellValueFactory(new PropertyValueFactory<>("dbValue"));
		try {
			Connect connect1 = Connect.getConnection();
			String query = "SELECT * FROM user WHERE walletName = '" + walletName + "'";
			
			ResultSet rs = connect1.executeQuery(query);
	
			while(rs.next()) {
				listView.add(new TableModel(
						rs.getString("transactDate"),
						rs.getString("transactCategory"),
						(rs.getBoolean("isExpense")?"(-)  ":"(+) ")+"IDR "+String.format("%,.2f", rs.getDouble("transactValue"))));
			}
			dbTable.setItems(listView);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
