package com.activequant.domainmodel.trade.event;


public class OrderPendingEvent extends OrderTerminalEvent {
	private String cancellationMessage;

	public String getCancellationMessage() {
		return cancellationMessage;
	}

	public void setCancellationMessage(String cancellationMessage) {
		this.cancellationMessage = cancellationMessage;
	}
	
	

	public String toString(){
		return "Order " + super.getRefOrderId() + " pending: " + cancellationMessage; 
	}
	
}
