package com.Banco.BancoDigital;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoDigitalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BancoDigitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");

		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);
		cc.depositar(500);
		cc.transferir(100, poupanca);

		poupanca.depositar(200);
		poupanca.transferir(50000, cc);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}

}
