package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.TicketDAO;
import com.gl.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketDAO tdao;
	
	@Override
	public void addTicket(Ticket ticket) {
		tdao.save(ticket);

	}

	
	@Override
	public void updateTicket(Ticket ticket, int tid) {
		Ticket t1 = tdao.findById(tid).get();
		
		t1.setTicketTitle(ticket.getTicketTitle());
		t1.setTicketDescription(ticket.getTicketDescription());
		t1.setTicketCreatedDate(ticket.getTicketCreatedDate());
		
		tdao.save(t1);

	}
	

	@Override
	public void deleteById(int tid) {
		tdao.deleteById(tid);

	}

	
	@Override
	public Ticket getTicketById(int tid) {
		
		return tdao.findById(tid).get();
	}

	
	@Override
	public List<Ticket> getAllTickets() {
		
		return tdao.findAll();
	}

	
}
