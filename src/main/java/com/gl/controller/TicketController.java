package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.model.Ticket;
import com.gl.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {

	@Autowired
	TicketService tservice;

	@RequestMapping("/tickets")
	public String goHome(Model m) {
		m.addAttribute("ticketList", tservice.getAllTickets());

		return "homePage";
	}

	@RequestMapping("/showAddForm")
	public String addTickets(Model m) {
		m.addAttribute("ticket", new Ticket());
		return "showAddForm";
	}

	@PostMapping("/processAdd")
	public String processAdd(@ModelAttribute("ticket") Ticket ticket) {
		tservice.addTicket(ticket);
		return "redirect:/admin/tickets";
	}

	@RequestMapping("/deleteById/{tid}")
	public String deleteById(@PathVariable("tid") int tid) {
		System.out.println(tid);
		tservice.deleteById(tid);
		return "redirect:/admin/tickets";
	}

	@RequestMapping("/editById/{tid}")
	public String updateById(@PathVariable("tid") int tid, Model m) {
		m.addAttribute("ticket", tservice.getTicketById(tid));
		return "showUpdateForm";
	}

	@PostMapping("/processUpdate")
	public String processUpdate(@ModelAttribute("ticket") Ticket ticket, Model m) {
		tservice.updateTicket(ticket, ticket.getTid());
		return "redirect:/admin/tickets";
	}

	@RequestMapping("/viewById/{tid}")
	public String viewById(@PathVariable("tid") int tid, Model m) {
		m.addAttribute("ticket", tservice.getTicketById(tid));
		return "viewForm";
	}

}
