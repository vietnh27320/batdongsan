package com.laptrinhjavaweb.oop;


public class Application1 {
	public static void main(String[] args) {
		CaChim1 caChim = new CaChimCon();
		caChim.setColorHair("màu vàng");
		caChim.boi();
//		caChim.bay();
		System.out.println("Mùa lông chim: " + caChim.getColorHair());
		CaSau caSau = new CaSau();
		caSau.boi();
	}
}
	