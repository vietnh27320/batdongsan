package com.laptrinhjavaweb.oop;

public abstract class CaChim1 extends LopCa {

	private String colorHair;

	@Override
	public void boi() {
		System.out.println("cá chim bơi theo kiểu cá chim anh yêu em");
	}

	public String getColorHair() {
		return colorHair;
	}

	public void setColorHair(String colorHair) {
		this.colorHair = colorHair;
	}

//	public abstract void bay();

}
