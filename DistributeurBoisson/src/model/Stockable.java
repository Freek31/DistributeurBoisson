/**
 * 
 */
package model;

/**
 * | @Author : @Fred || 19 f�vr. 2020 || 15:03:03 | *
 *
 */
public interface Stockable {
	public String 	getId();
	public void 	addQty();
	public void 	addQty(int combien);
	public void		removeQty();
	public boolean 	dispo();
	public String getNom();
	public int    getQty();
}
