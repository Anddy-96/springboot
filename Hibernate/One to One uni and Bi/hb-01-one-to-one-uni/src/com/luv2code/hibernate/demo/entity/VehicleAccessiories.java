package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicleAcc")
public class VehicleAccessiories {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prodid")
	private int prodID;
	
	@Column(name = "prodname")
	private String prodName;
	
	@Column(name = "prodamo")
	private int prodAmo;
	
	@Column(name = "proddes")
	private String prodDes;
	
	
	public VehicleAccessiories() {
		
	}
	
	

	public VehicleAccessiories(String prodName, int prodAmo, String prodDes) {
		super();
		this.prodName = prodName;
		this.prodAmo = prodAmo;
		this.prodDes = prodDes;
	}



	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdAmo() {
		return prodAmo;
	}

	public void setProdAmo(int prodAmo) {
		this.prodAmo = prodAmo;
	}

	public String getProdDes() {
		return prodDes;
	}

	public void setProdDes(String prodDes) {
		this.prodDes = prodDes;
	}

	@Override
	public String toString() {
		return "VehicleAccessiories [prodID=" + prodID + ", prodName=" + prodName + ", prodAmo=" + prodAmo
				+ ", prodDes=" + prodDes + "]";
	}
	
	
	
	
}
