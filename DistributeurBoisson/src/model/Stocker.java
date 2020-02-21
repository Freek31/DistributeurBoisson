/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * | @Author : @Fred || 19 f�vr. 2020 || 15:04:33 | *
 *
 */
public class Stocker<T extends Stockable> {
	protected Map<Integer, T> stock = new HashMap<Integer, T>();

	public T getItemById(Integer id) {
		return stock.get(id);
	}

	public void addItem(T item) {
		stock.put(getIdInt(item.getId()), item);
	}

	public void removeItem(Integer id) {
		stock.remove(id);
	}

	public void removeItem(Stockable item) {
		stock.remove(Integer.parseInt(item.getId()));
	}

	public int getsize() {
		return this.stock.size();
	}
	
	public int getIdInt(String idComplet) {
		return Integer.parseInt(idComplet.replaceAll("[^0-9]", ""));
	}
	

	public HashMap<String, String> getHashmapT() {
		HashMap<String, String> output = new HashMap<String, String>();
		for (Entry<Integer, T> p : stock.entrySet()) {
			output.put(p.getValue().getId(), p.getValue().getNom());
		}
		return output;
	}

}

