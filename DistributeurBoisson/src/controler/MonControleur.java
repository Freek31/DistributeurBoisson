/**
 * 
 */
package controler;

import java.awt.event.ActionListener;

import model.Distributeur;
import model.Pieces;

import java.awt.event.ActionEvent;

/**
 * | @Author : @Fred || 20 f�vr. 2020 || 08:08:51 | *
 *
 */
public class MonControleur implements ActionListener {
	private Distributeur modele;

	/**
	 * @param modele
	 */
	public MonControleur(Distributeur modele) {
		super();
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("je reponds � la sonnette");

		// On veut separer 2 cas : les evenements boutons boisson 'B*'/boutons pieces
		// 'P*'
		if (modele.getIdChar(e.getActionCommand()) == 'B') {
			System.out.println("cest une boisson!");
			modele.setPrixBoissonSelectionnee(modele.getRack().getItemById(Character.getNumericValue(e.getActionCommand().charAt(1))).getPrix());
			modele.boissonSelectionnee(
					modele.getRack().getItemById(Character.getNumericValue(e.getActionCommand().charAt(1))).getNom());
			modele.setChoix("B");
		} else if (modele.getIdChar(e.getActionCommand()) == 'P') {
			System.out.println("c'est une piece!");
			modele.insere(Pieces.valueOf(e.getActionCommand()).getValeur());
			modele.setChoix("P");
		} else if(e.getActionCommand() == "V"){
			modele.setChoix("V");
			modele.setMontantInsere(modele.getMontantInsere());
			modele.setMontantARendre();
			
			modele.CalculPiecesARendre();
		}
	}
}
