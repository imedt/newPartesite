package fr.afcepf.al23.partesite.webutil;

import fr.afcepf.al23.model.entities.Pack;

public class PackWrap {
	private Pack pack;
	private int quantity;
	
	public PackWrap(Pack pack){
		this.pack = pack;
	}
	
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
