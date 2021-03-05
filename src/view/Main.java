package view;

import java.io.IOException;
import java.util.Scanner;

import controller.Controller;

public class Main {

	public static void main(String[] args) throws IOException {
		Controller cont = new Controller();
		String os = cont.os();
		Scanner ler = new Scanner(System.in);
		int commandPid=20;
		String commandName="";
		int opc = 50;
		
		do {
				System.out.println("Insira o processo que você deseja chamar: \n"
						+ "0 - listar processos \n"
						+ "1 - matar por pid \n"
						+ "2 - matar por nome \n"
						+ "3 - sair");
				opc = ler.nextInt();
		if (opc == 0) {
			cont.system(os);
		}		
			
			
				else if (opc == 1) {
				System.out.println("Digite o número do pid");
				commandPid = ler.nextInt();
				cont.killProcessPid(os, commandPid);
				System.out.println("Insira o processo que você deseja chamar: \n"
						+ "0 - listar processos \n"
						+ "1 - matar por pid \n"
						+ "2 - matar por nome \n"
						+ "3 - sair");
				
				opc = ler.nextInt();
			}else if(opc == 2) {
				System.out.println("Digite o nome do processo");
				commandName = ler.next();
				cont.killProcessName(os, commandName);
				System.out.println("Insira o processo que você deseja chamar: \n"
						+ "0 - listar processos \n"
						+ "1 - matar por pid \n"
						+ "2 - matar por nome \n"
						+ "3 - sair");
				opc = ler.nextInt();
			}
			
		}while(opc != 3);
		ler.close();

			
	}

}
