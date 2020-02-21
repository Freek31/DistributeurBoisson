import controler.MonControleur;
import model.Distributeur;
import model.Monayeur;
import model.Piece;
import model.Produit;
import model.Stocker;
import view.View;

/**
 * 
 */

/**
 * | @Author : @Fred || 19 févr. 2020 || 14:53:46 | *
 *
 */
public class Lanceur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creation dun monayeur et ajout du 
		Monayeur monMonnayeur = new Monayeur();
		monMonnayeur.addItem(new Piece("Piece(s) de 0.10€", 10, 5));
		monMonnayeur.addItem(new Piece("Piece(s) de 0.20€", 20, 5));
		monMonnayeur.addItem(new Piece("Piece(s) de 0.50€", 50, 5));
		monMonnayeur.addItem(new Piece("Piece(s) de 1€", 100, 5));
		monMonnayeur.addItem(new Piece("Piece(s) de 2€", 200, 5));
		
		//System.out.println(monMonnayeur.getItemById(1).getValeur());
		
		Stocker<Produit> rack = new Stocker<Produit>();
		rack.addItem(new Produit("B1",  "coca",         5,  60));
		rack.addItem(new Produit("B2",  "sprite",       5,  80));
		rack.addItem(new Produit("B3",  "orangina",     5,  80));
		rack.addItem(new Produit("B4",  "canada dry",   5,  80));
		//System.out.println(rack.getItemById(2).getNom());
		
		View f = new View(rack);
		
		// declaration d'un modele
		Distributeur modeleDeLApplication = new Distributeur(rack, monMonnayeur);
		
		
		// declaration du controleur
		MonControleur ctrl = new MonControleur(modeleDeLApplication);

		// Présenter le controleur à la vue
		f.setListener(ctrl);

		// j'ajoute ma fenetre à la liste des observer de mon modele
		modeleDeLApplication.addObserver(f);
		
		f.afficher();
	}

}
