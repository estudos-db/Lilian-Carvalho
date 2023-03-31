package com.example.supermercadoprova.utils;

import java.text.DecimalFormat;

public abstract class DoubleDuasCasasDecimais {
	public static double converterDoubleDoisDecimais(double precoDouble) {
		DecimalFormat fmt = new DecimalFormat("0.00");
		String string = fmt.format(precoDouble);
		String[] part = string.split("[,]");
		String string2 = part[0] + "." + part[1];
		double preco = Double.parseDouble(string2);
		return preco;
	}

}
