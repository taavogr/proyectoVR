package com.upc.factory;

public class Factory {
	
	private static Factory fac;
	
	private Factory(){
		
	}
	
	private static Factory getInstance(){
		if(fac==null)
			fac = new Factory();
		return fac;
	}

}
