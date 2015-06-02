package com.whammich.roadblock.utils;

public class Utils {

	public static String capitalizeFirstLetter(String entry) {
		return Character.toUpperCase(entry.charAt(0)) + entry.substring(1);
	}
}