package com.motorph.backend;

public class IDs {

private String SSS;
private String Philhealth;
private String TIN;
private String PagIbig;

public IDs (String SSS, String Philhealth, String TIN, String PagIbig) {
	this.SSS = SSS; 
	this.Philhealth = Philhealth;
	this.TIN = TIN;
	this.PagIbig = PagIbig; 	
    }
    
public String getSSS() { return SSS; } 
public String getPhilhealth() {return Philhealth;}
public String getTIN() {return TIN;}
public String getPagIbig() { return PagIbig; }

}
