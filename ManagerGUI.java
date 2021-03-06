package projet_java.trunk;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerGUI extends JFrame implements ActionListener {

	JPanel container;
	GridBagLayout general;
	GridBagConstraints c;
	JButton bInit;
	JButton bPaP;
	JButton bResol;
	JTextArea affichage;
	String result;
	
	ManagerGUI() {
		//init();
		
		this.setTitle("Projet Java");
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container = new JPanel();
		container.setPreferredSize(new Dimension(450, 550));
		general = new GridBagLayout();
		container.setLayout(general);
		c = new GridBagConstraints();
		
		
		bInit = new JButton ("Init");
		bPaP = new JButton ("Pas a pas");
		bResol = new JButton ("Resolution");
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
				
		affichage = new JTextArea();
		affichage.setFont(new Font("Courier", Font.PLAIN, 12));
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
			Robot.initRobot();
			affichage.setText(Agent.affiche());
			System.out.println("Bouton Init");
			
			//affichage.add()
			
		}
		else if (s.equals("Pas a pas")) {
			System.out.println("Bouton Point a Point");
			Robot.pasApas();
			affichage.setText(Agent.affiche());
		}
		else if (s.equals("Resolution")) {
			System.out.println("Bouton Resolution");
		}
	}


}
