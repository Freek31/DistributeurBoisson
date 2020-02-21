package views;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.MonModel;

import java.awt.Color;

/**
 * 
 */

/**
 * @author 1501224
 *
 */
public class View1 extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5711124519531463046L;
	
	private static final String LIBELLEA = "Bouton A";
	private static final String LIBELLEB = "Bouton B";
	
	private JButton button1, button2;
	private JLabel etiquetteDeDonnee;
	/**
	 * @throws HeadlessException
	 */
	public View1() {
		super();
		
		
		setSize(400,200);
		
		this.button1 = new JButton(LIBELLEA);
		this.button1.setActionCommand("menfous"); //
		
		this.button2 = new JButton(LIBELLEB);
		this.button2.setActionCommand("comprandpo");
		
		Container contenu = getContentPane();
		contenu.setBackground(Color.GREEN);
		contenu.setLayout(new FlowLayout());
		contenu.add(button1);
		contenu.add(button2);
		
		etiquetteDeDonnee = new JLabel("ici étiquette de donnée");
		contenu.add(etiquetteDeDonnee);
		
	}
	
	public void afficher() {
		setVisible(true);
	}

	
	private void rafraichirAffichage(MonModel leModele) {
		this.etiquetteDeDonnee.setText(leModele.getMessage());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("on me dit dans l oreillette que ca a bouge");
		rafraichirAffichage((MonModel) o);
		
	}
	
	public void setListener (ActionListener al) {
		button1.addActionListener(al);
		button2.addActionListener(al);
	}
	
	

}
