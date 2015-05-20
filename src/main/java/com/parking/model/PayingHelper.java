package com.parking.model;


public class PayingHelper {
	
	public static double calculePayingAmount(Ticket ticket, double hourlyRate){
		
		long totalHours = ((ticket.getExitTime().getTime() - ticket.getEntranceTime().getTime() )/ 1000)/3600;
		
		return totalHours * hourlyRate;
		
	}
	
	//...all other stuff of money from real world...

}
