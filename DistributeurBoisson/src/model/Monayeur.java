/**
 * 
 */
package model;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import model.Distributeur;



/**
 * | @Author : @Fred || 20 f�vr. 2020 || 08:16:12 | *
 *
 */
public class Monayeur extends Stocker<Piece> {
	
	
	private Monayeur ArgentARendre;

	public Monayeur CalculMonnaieARendre(int montantARendre){
		//Initialisations
				
				int resteARendre = montantARendre;
				boolean validation = false; // La machine peut pas rendre l'argent si false!

				// On calcule le nombre de pieces a rendre en favorisant les plus grosses pieces
				for (int nbRendue200 = Services.Min( (100 / Pieces.values()[4].getValeur()),
						getItemById(4).getQty()); (nbRendue200 >= 0) && (validation == false); nbRendue200--) {
					resteARendre = (int) (montantARendre - (nbRendue200 * Pieces.values()[4].getValeur()));// le reste � rendre, le montant � rendre moins ce que j'ai d�ja rendu

					for (int nbRendue100 = Services.Min((int) (resteARendre / Pieces.values()[3].getValeur()),
							stock.get(3).getQty()); nbRendue100 >= 0; nbRendue100--) {
						resteARendre = (int) (montantARendre - (nbRendue200 * Pieces.values()[4].getValeur()
								+ nbRendue100 * Pieces.values()[3].getValeur()));

						for (int nbRendue050 = Services.Min((int) (resteARendre / Pieces.values()[2].getValeur()),
								stock.get(2).getQty()); nbRendue050 >= 0; nbRendue050--) {
							resteARendre = (int) (montantARendre - (nbRendue050 * Pieces.values()[2].getValeur()
									+ nbRendue200 * Pieces.values()[4].getValeur()
									+ nbRendue100 * Pieces.values()[3].getValeur()));

							for (int nbRendue020 = Services.Min((int) (resteARendre / Pieces.values()[1].getValeur()),
									stock.get(1).getQty()); nbRendue020 >= 0; nbRendue020--) {
								resteARendre = (int) (montantARendre - (nbRendue050 * Pieces.values()[2].getValeur()
										+ nbRendue200 * Pieces.values()[4].getValeur()
										+ nbRendue100 * Pieces.values()[3].getValeur()
										+ nbRendue020 * Pieces.values()[1].getValeur()));

								for (int nbRendue010 = Services.Min((int) (resteARendre / Pieces.values()[0].getValeur()),
										stock.get(0).getQty()); nbRendue010 >= 0; nbRendue010--) {
									resteARendre = (int) (montantARendre - (nbRendue010 * Pieces.values()[0].getValeur()
											+ nbRendue050 * Pieces.values()[2].getValeur()
											+ nbRendue200 * Pieces.values()[4].getValeur()
											+ nbRendue100 * Pieces.values()[3].getValeur()
											+ nbRendue020 * Pieces.values()[1].getValeur()));

									// Affichage du nombre de chacune des pieces rendues
									if (resteARendre == 0) {
									/*	Phrase.Affichage("Le distributeur vous rend " + nbRendue200 + " piece(s) de 2euro, "
												+ nbRendue100 + " piece(s) de 1euro, " + nbRendue050 + " piece(s) de 50 cts,  "
												+ nbRendue020 + " piece(s) de 20cts et " + nbRendue010 + " piece(s) de 10 cts");*/
										validation = true; // Super la machine peut rendre l'argent!
										
										this.ArgentARendre.addItem(new Piece("Piece(s) de 0.10�", 10, nbRendue010));
										this.ArgentARendre.addItem(new Piece("Piece(s) de 0.20�", 20, nbRendue020));
										this.ArgentARendre.addItem(new Piece("Piece(s) de 0.50�", 50, nbRendue050));
										this.ArgentARendre.addItem(new Piece("Piece(s) de 1�", 100, nbRendue100));
										this.ArgentARendre.addItem(new Piece("Piece(s) de 2�", 200, nbRendue200));
									}
								}

							}

						}

					}

				}
				return this.ArgentARendre;
				

	}
}
	
