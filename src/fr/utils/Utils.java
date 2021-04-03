package fr.utils;

import java.util.Random;

public class Utils {
	public static int randVitesse(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min ) + min; 
	}
}
