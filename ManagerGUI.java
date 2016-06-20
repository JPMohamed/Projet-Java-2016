package V1;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerGUI implements ActionListener {

	ManagerGUI(int n) {
		//init();
		JButton bInit = new JButton("Init");
		JButton bPaP = new JButton ("Pas a Pas");
		JButton bResol = new JButton ("Resolution");
		GridLayout d = new GridLayout(n+1, n);
		JFrame fenetre = new JFrame();
		JPanel affichage = new JPanel();
		affichage.setPreferredSize(new Dimension(350,400));
		JTextArea map=new JTextArea();
		affichage.add(map);
		JPanel commande = new JPanel();
		Container c = fenetre.getContentPane();
		c.setLayout(d);
		commande.add(bInit);
		commande.add(bPaP);
		commande.add(bResol);
		c.add(commande);
		bInit.addActionListener(this);
		bPaP.addActionListener(this);
		bResol.addActionListener(this);
		c.add(affichage);
		
		Manager.Affichage = fenetre;
		fenetre.setVisible(true);
		fenetre.setSize(n*120, n*150 );
	    fenetre.setLocationRelativeTo(null);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if (s.equals("Init")) {
			Carrefour.init();
			
			System.out.println("Bouton Init");
			//affichage.add()
			
		}
		else if (s.equals("Point a Point")) {
			System.out.println("Bouton Point a Point");
		}
		else if (s.equals("Resolution")) {
			System.out.println("Bouton Resolution");
		}
	}


}
