package com.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Bread implements Serializable  {
	private static final long serialVersionUID=2L;
	@Id
	int ID;
	@Column(name="NAME")
	String NAME;
	String TYPE;
	String DESCRIPTION;
	float QUANTITY;
	float PRICE;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public float getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(float qUANTITY) {
		QUANTITY = qUANTITY;
	}
	public float getPRICE() {
		return PRICE;
	}
	public void setPRICE(float pRICE) {
		PRICE = pRICE;
	}
	
	
		
	

}
