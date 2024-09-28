package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Database.DbHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

public class AddTransactionSceneController implements Initializable {
	@FXML
	private ChoiceBox<String> cbChooseWallet;
	@FXML
	private TextField tfTransactionValue;
	@FXML
	private TextField tfTransactionCategory;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	
	// Event Listener on Button.onAction
	@FXML
	public void expenseBtn(ActionEvent event) throws IOException {
		String walletName = cbChooseWallet.getValue();
		double value = Double.parseDouble(tfTransactionValue.getText());
		String category = tfTransactionCategory.getText();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		
//		if (!validateBtnClicked(value, category)) {
//			return;
//		}
		
		DbHandler.insert(walletName, value, category, date, true);
		
		// template switch to main scene
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	// Event Listener on Button.onAction
	@FXML
	public void incomeBtn(ActionEvent event) throws IOException {
		String walletName = cbChooseWallet.getValue();
		double value = Double.parseDouble(tfTransactionValue.getText());
		String category = tfTransactionCategory.getText();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		
//		if (!validateBtnClicked(value, category)) {
//			return;
//		}
		
		DbHandler.insert(walletName, value, category, date, false);
		
		// template switch to main scene
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cbChooseWallet.getItems().setAll(User.walletNames);
		
	}
	
	public boolean validateBtnClicked(int value, String category) {
		value = Integer.parseInt(tfTransactionValue.getText());
		category = tfTransactionCategory.getText();
		
		// vd: 0 <= value <= x, category <= 30
//		if (value < 0) {
//			return false;
//		}
		
		return true;
	}
	
	@FXML
	public void switchToMainScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
