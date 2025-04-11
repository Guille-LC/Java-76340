package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Concesionaria;

@SpringBootApplication
public class FacturacionPrimeraEntregaLavieroCorreiaApplication implements CommandLineRunner {
	
	@Autowired
	private DaoFactory dao;
	
	public static void main(String[] args) {
		SpringApplication.run(FacturacionPrimeraEntregaLavieroCorreiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 try {
			 
			 Concesionaria coche1 = new Concesionaria("Ferrari",1990);
			 Concesionaria coche2 = new Concesionaria("BMW",1992);
			 Concesionaria coche3 = new Concesionaria("Aston Martin",2000);
			 Concesionaria coche4 = new Concesionaria("Porsche",1980);
			 Concesionaria coche5 = new Concesionaria("Mercedes Benz",1985);
			 
			 Cliente cliente1 = new Cliente("Dexter","Holland",33456123,59);
			 Cliente cliente2 = new Cliente("Mark","Hoppus",40456123,53);
			 Cliente cliente3 = new Cliente("Angus","Young",50456123,70);
			 Cliente cliente4 = new Cliente("Robert","Plant",63456123,76);
			 Cliente cliente5 = new Cliente("Roger","Waters",83456123,81);
			 
			 dao.persistirConcesionaria(coche1);
			 dao.persistirConcesionaria(coche2);
			 dao.persistirConcesionaria(coche3);
			 dao.persistirConcesionaria(coche4);
			 dao.persistirConcesionaria(coche5);
			 
			 dao.persistirCliente(cliente1);
			 dao.persistirCliente(cliente2);
			 dao.persistirCliente(cliente3);
			 dao.persistirCliente(cliente4);
			 dao.persistirCliente(cliente5);
			 
		 }	catch(Exception err) {
			 err.printStackTrace(System.err);
		 };
		
	}
	
	
}
