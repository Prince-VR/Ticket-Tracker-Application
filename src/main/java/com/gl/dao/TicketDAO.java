package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.gl.model.Ticket;


@Repository
public interface TicketDAO extends JpaRepository<Ticket, Integer>{

}
