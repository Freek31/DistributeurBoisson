/**
 * 
 */
package model;

/**
 * | @Author : @Fred || 19 févr. 2020 || 15:07:59 | *
 *
 */
public class Piece implements Stockable{
private static int cpt = 1; 
	
	private String id;
	private String  nom;
	private int     valeur;
	private int 	quantity;
	
	
	public Piece(String nom, int valeur, int qte) {
		super();
		this.id = "P" + Integer.toString(cpt++);
		this.nom= nom;
		this.valeur = valeur;
		this.quantity = qte;
	}
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	@Override
	public int getQty() {
		// TODO Auto-generated method stub
		return this.quantity;
	}

	@Override
	public void addQty() {
		// TODO Auto-generated method stub
		this.quantity++;
	}

	@Override
	public void addQty(int combien) {
		// TODO Auto-generated method stub
		this.quantity+=combien;
	}

	@Override
	public void removeQty() {
		// TODO Auto-generated method stub
		this.quantity--;
	}

	@Override
	public boolean dispo() {
		// TODO Auto-generated method stub
		return this.quantity>0;
	}

	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param id
	 * @param nom
	 * @param valeur
	 * @param quantity
	 */
}
