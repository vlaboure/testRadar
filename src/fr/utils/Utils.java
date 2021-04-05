package fr.utils;

import java.util.Random;

public class Utils {
	public static int randVitesse(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min ) + min; 
	}
	
	public static String tab(int nbre){
		String res = "";
		for(int i=0;i<nbre;i++){
			res += "\t";
		}
		return res;
	}
}
