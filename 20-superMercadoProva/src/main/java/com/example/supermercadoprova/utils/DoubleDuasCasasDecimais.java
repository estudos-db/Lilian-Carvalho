package com.example.supermercadoprova.utils;

import java.text.DecimalFormat;

public abstract class DoubleDuasCasasDecimais {
	public static double converterDoubleDoisDecimais(double precoDouble) {
		DecimalFormat df = new DecimalFormat("#0.00");
		return Double.parseDouble(df.format(precoDouble));
	}

}
