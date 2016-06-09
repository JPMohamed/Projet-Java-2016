package projet_java;

import javax.swing.JFrame;

public class Manager {

	static JFrame Affichage;
	
	Manager() {
		ManagerGUI mGUI = new ManagerGUI(5);
		
		//mGUI.setVisible(true);
	}
	
	public static void main(String[] args) {
		Manager m = new Manager();
	}
}
