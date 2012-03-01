package com.activequant.domainmodel.trade.event;


public class OrderCancelledEvent extends OrderTerminalEvent {
	private String cancellationMessage;

	public String getCancellationMessage() {
		return cancellationMessage;
	}

	public void setCancellationMessage(String cancellationMessage) {
		this.cancellationMessage = cancellationMessage;
	}
}