/**
 * 
 */
package model;

/**
 * | @Author : @Fred || 19 févr. 2020 || 15:06:11 | *
 *
 */

public class Produit implements Stockable{
	//ATTRIBUTS
	private String id;
	private String 	nom;
	private int 	qty;
	private int 	prix;
	
	//CONSTRUCTEURs
	
	public Produit(String id, String nom) {
		
		this.id = id;
		this.nom = nom;
		this.qty = 0;// initialisation du stock
		this.prix = 0;// initialisation du prix
	}

	public Produit(String id, String nom, int prix) {
		
		this.id = id;
		this.nom = nom;
		this.qty = 0; // initialisation du stock
		this.prix = prix;
	}
	
	public Produit(String id, String nom, int qty, int prix) {
		this.id = id;
		this.nom = nom;
		this.qty = qty;
		this.prix = prix;
	}
	//GETTEURS&SETTEURS
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public int getPrix() {
		return prix;
	}
	
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
	// Polymorphisme/surcharge de stockable
	@Override
	public String getId() {
		
		return this.id;
	}
	
	@Override
	public void addQty() {
		this.qty++;
	}

	@Override
	public void addQty(int combien) {
		this.qty += combien;
	}

	@Override
	public void removeQty() {
		this.qty --;
	}

	@Override
	public boolean dispo() {
		return this.qty > 0;
	}
}
