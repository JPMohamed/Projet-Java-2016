package projet_java.trunk;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerGUI extends JFrame implements ActionListener {

	ManagerGUI() {
		//init();
		
		this.setTitle("Projet Java");
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanel container = new JPanel();
		container.setPreferredSize(new Dimension(450, 550));
		GridBagLayout general = new GridBagLayout();
		container.setLayout(general);
		GridBagConstraints c = new GridBagConstraints();
		
		
		JButton bInit = new JButton ("Init");
		JButton bPaP = new JButton ("Pas a pas");
		JButton bResol = new JButton ("Resolution");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 2;
		container.add(bInit, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 2;
		container.add(bPaP, c);
		
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 2;
		container.add(bResol, c);
				
		JTextArea affichage = new JTextArea();
		Carrefour.init();
		String result;
		result = Agent.affiche();
		affichage.setText(result);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 3;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 1;

		container.add(affichage, c);
		//this.getContentPane().add(affichage);
		bInit.addActionListener(this);
		bPaP.addActionListener(this);
		bResol.addActionListener(this);
		
		this.setContentPane(container);
		this.setVisible(true);
		/*JButton bInit = new JButton("Init");
		JButton bPaP = new JButton ("Pas a Pas");
		JButton bResol = new JButton ("Resolution");
		GridLayout d = new GridLayout();
		d.setColumns(3);
		d.setRows(2);
		d.setHgap(10);
		d.setVgap(5);
		JFrame fenetre = new JFrame();
		JPanel affichage = new JPanel();
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
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/ 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if (s.equals("Init")) {
			Carrefour.init();
			//affichage.setText(Agent.affiche());
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
