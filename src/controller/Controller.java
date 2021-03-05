package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controller {
	
	public Controller() {
		super();
	}
	
	public String os() {
		return System.getProperty("os.name");
	}
	
	public void system(String os) {
		if (os.contains("Windows")) {
			try {
				Process process = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = process.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					linha = buffer.readLine();
					System.out.println(linha);
				}
				fluxo.close();
				leitor.close();
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}else {
			try {
				Process process = Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo = process.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					linha = buffer.readLine();
					System.out.println(linha);
				}
				fluxo.close();
				leitor.close();
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		}
	public void killProcessPid(String os, int param)throws IOException {
		if (os.contains("Windows")) {
			String cmdPid = "TASKKILL /PID";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			pid = param;
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			try {
				
				
				Runtime.getRuntime().exec(buffer.toString());
			} catch (NumberFormatException e) {
				System.out.println("O que foi inserido não corresponde a um pid");
			}
			
		}else {
			String cmdPid = "kill -9";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			try {
				pid = param;
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);
				
				Runtime.getRuntime().exec(buffer.toString());
			} catch (NumberFormatException e) {
				
			}
		}
	}
	
	public void killProcessName(String os, String param)throws IOException {
		if (os.contains("Windows")) {
			String cmdPid = "TASKKILL /IM";
	
			StringBuffer buffer = new StringBuffer();
			
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(param);
			try {
				
				Runtime.getRuntime().exec(buffer.toString());
			} catch (NumberFormatException e) {
				System.out.println("O que foi inserido não corresponde a um nome de processo");
			}
		}else {
			String cmdPid = "pkill -f";

			StringBuffer buffer = new StringBuffer();
			try {
				
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(param);
				
				Runtime.getRuntime().exec(buffer.toString());
			} catch (NumberFormatException e) {

			}
		}
	}

	}
	
	

