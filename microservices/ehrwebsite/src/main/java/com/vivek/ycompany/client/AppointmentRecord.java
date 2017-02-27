package com.vivek.ycompany.client;


 

 
public class AppointmentRecord {

 	long id;
    
    private String doctor;
    private String patient;
    
    
    //Set<Passenger> passengers;

	public AppointmentRecord() {
	}    
    
	public AppointmentRecord(String doctor,String patient) {
		this.doctor = doctor;
		this.patient = patient;
		
 	}


	@Override
	public String toString() {
		return "AppointmentRecord [id=" + id + ", doctor=" + doctor + ", patient=" + patient + "]";
	}
    
    
    
}
