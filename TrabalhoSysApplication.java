package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
public class TrabalhoSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoSysApplication.class, args);
	}

}

	@Component
class EntradadeDadosConsole2 implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			Scanner scanner = new Scanner(System.in);
			String continuar;

			do {
				System.out.println("\n--- ");
			}


		}
	}