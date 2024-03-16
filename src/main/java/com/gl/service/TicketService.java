package com.gl.service;

import java.util.List;

import com.gl.model.Ticket;

public interface TicketService {

	public void addTicket(Ticket ticket);
	public void updateTicket(Ticket ticket,int tid);
	public void deleteById(int tid);
	
	public Ticket getTicketById(int tid);
	public List<Ticket> getAllTickets();
	
}
