package projet_java.trunk;

import javax.swing.JFrame;

public class Manager {

	static JFrame Affichage;
	
	Manager() {
		ManagerGUI mGUI = new ManagerGUI();
		
		//mGUI.setVisible(true);
	}
	
	public static void main(String[] args) {
		Manager m = new Manager();
		System.out.println(Agent.affiche());
	}
}
