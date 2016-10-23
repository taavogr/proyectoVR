package com.upc.factory;

import com.upc.dao.ICorreodao;
import com.upc.dao.impl.Correodao;

public class Factory {
	
	private static Factory fac;
	
	private Factory(){
		
	}
	
	public static Factory getInstance(){
		if(fac==null)
			fac = new Factory();
		return fac;
	}
	
	public ICorreodao getCorreodao(){
		
		return new Correodao();
	}

}
