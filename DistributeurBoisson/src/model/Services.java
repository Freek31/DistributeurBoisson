/**
 * 
 */
package model;



/**
 * | @Author : @Fred || 20 févr. 2020 || 15:35:40 | *
 *
 */
public class Services {

	//Calcule le min de 2 short
	public static int Min(int a, int b) {
		int min;
		if (a < b) {
			min = a;
		} else {
			min = b;
		}
		return min;
	}
	
	//Calcule le max de 2 short
	public static int Max(int a, int b) {
		int max;
		if (a > b) {
			max = a;
		} else {
			max = b;
		}
		return max;
	}

	
}

