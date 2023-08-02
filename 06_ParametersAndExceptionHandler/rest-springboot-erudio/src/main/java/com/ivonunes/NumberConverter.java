package com.ivonunes;

public class NumberConverter {
	

	public static Double convertToDouble(String n) {
		// TODO Auto-generated method stub
		if (n==null) return 0D;
		String num = n.replaceAll(",", ".");
		return Double.parseDouble(num);
	}

	public static boolean isNumeric(String n) {
		if (n == null) return false;
		String num = n.replaceAll(",", ".");
		return num.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	

}
