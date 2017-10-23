package com.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Cakes implements Serializable {
	private static final long serialVersionUID=3L;
	@Id
	String ID;
	String NAME;
	String DESCRIPTION;
	float QUANTITY;
	float PRICE;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
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