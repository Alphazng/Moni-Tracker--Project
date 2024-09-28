package application;

import java.util.ArrayList;

public class User {
	static public ArrayList<Wallet> wallets = new ArrayList<>();
	static public ArrayList<String> walletNames = new ArrayList<>();
	
	static public void addWallet(Wallet wallet) {
		wallets.add(wallet);
	}
	
	static public void addWalletNames(String walletName) {
		walletNames.add(walletName);
	}
	
	static public void setWalletNames(ArrayList<String> newWalletNames) {
		walletNames = newWalletNames;
	}
	
}
