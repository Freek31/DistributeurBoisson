/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Distributeur;
import model.Piece;
import model.Pieces;
import model.Produit;
import model.Stocker;

/**
 * | @Author : @Fred || 19 f�vr. 2020 || 14:55:17 | *
 *
 */
public class View extends JFrame implements Observer {
	// CONSTANTES

	// ATTRIBUTS
	private static final long serialVersionUID = 1L;

	private ArrayList<JButton> buttons1 = new ArrayList<JButton>();
	private ArrayList<JButton> buttons2 = new ArrayList<JButton>();
	private JButton b = new JButton();
	// Controleur associ�
	// private ActionListener al;

	// BANDEAU
	private JPanel bandeauHaut = new JPanel();
	private JTextField msgBandeauHaut = new JTextField("Distributeur Automatique de boissons");;

	// SELECTEUR DE BOISSONS
	private JPanel panelSelBoissons = new JPanel();

	// MONNAYEUR
	private JPanel panelMonnayeur = new JPanel();
	private JTextField txtVeuillezInsrerArgent;

	// BANDEAU MESSAGE BAS
	private JPanel panelBandeauBasMsg = new JPanel();
	private JTextField messageBandeauBas = new JTextField("          choisissez votre boisson          ");

	// CREATION DE LIHM
	public View(Stocker<Produit> rack) {
		Container contenu = getContentPane();
		setSize(400, 400);

		// BANDEAU
		contenu.add(this.bandeauHaut, BorderLayout.NORTH);
		this.bandeauHaut.add(msgBandeauHaut);

		// SELECTEUR DE BOISSONS
		contenu.add(this.panelSelBoissons, BorderLayout.CENTER);
		panelSelBoissons.setLayout(new GridLayout(0, 2));

		// On cree un bouton pour chaque boisson
		for (Entry<String, String> p : (rack.getHashmapT()).entrySet()) {
			JButton temp = new JButton(p.getValue());
			temp.setActionCommand(p.getKey());
			this.buttons1.add(temp);
			panelSelBoissons.add(temp);
		}

		// MONAYEUR
		this.panelBandeauBasMsg.add(messageBandeauBas);
		contenu.add(this.panelMonnayeur, BorderLayout.EAST);

		// affichage montant insere
		this.panelMonnayeur.setLayout(new BorderLayout());
		txtVeuillezInsrerArgent = new JTextField();
		txtVeuillezInsrerArgent.setText("Veuillez ins\u00E9rer Argent");
		txtVeuillezInsrerArgent.setBackground(Color.BLACK);
		txtVeuillezInsrerArgent.setForeground(Color.GREEN);
		txtVeuillezInsrerArgent.setHorizontalAlignment(JTextField.RIGHT);
		this.panelMonnayeur.add(txtVeuillezInsrerArgent, BorderLayout.NORTH);

		// Creation des boutons des pieces
		JPanel panel2 = new JPanel();
		this.panelMonnayeur.add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

		for (Pieces p : Pieces.values()) {
			JButton temp = new JButton(p.getNom());
			temp.setActionCommand(p.getId());
			this.buttons2.add(temp);
			panel2.add(temp);
		}
		b = new JButton("Valider");
		panel2.add(Box.createHorizontalStrut(100));
		b.setActionCommand("V");
		panel2.add(b);
		// BANDEAU BAS
		contenu.add(this.panelBandeauBasMsg, BorderLayout.SOUTH);
		this.panelBandeauBasMsg.add(messageBandeauBas);
	}

	public void afficher() {
		setVisible(true);
	}

	// mise a jour du compteur piece inserees et texte boisson choisit
	@Override
	public void update(Observable o, Object arg) {
		if (((Distributeur) o).getChoix() == "P") {
			this.txtVeuillezInsrerArgent.setText(((Distributeur) o).getMontantInsere() / 100f + " �");
		} else if (((Distributeur) o).getChoix() == "B") {
			this.messageBandeauBas.setText("Boisson selectionn�e : " + ((Distributeur) o).getBoissonSelectionnee());
		} else if (((Distributeur) o).getChoix() == "V"){
			this.messageBandeauBas.setText("Monnaie insere/rendu : " + ((Distributeur) o).getMontantInsere()/ 100f + " � / " + ((Distributeur) o).getMontantARendre()/ 100f + " � ");
		}
	}

	public void setListener(ActionListener al) {
		for (JButton n : buttons1) {
			n.addActionListener(al);
		}

		for (JButton n : buttons2) {
			n.addActionListener(al);
		}
		b.addActionListener(al);
	}
}
