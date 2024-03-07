package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	public void callProcess(String proc) {
		try {
			Runtime.getRuntime().exec(proc);
		} catch(Exception e) {
			String msgError = e.getMessage();
			System.err.println(msgError);
			if(msgError.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(proc);
				try{
					Runtime.getRuntime().exec(buffer.toString());
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			} else{
				e.printStackTrace();
			}
		}
	}
	public void ip(String os) {
		String proc = "ipconfig";
		if(os.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(proc);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					if(linha.contains("Adaptador") || linha.contains("IPv4")) {
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Sistema Operacional Incompátivel.");
		}
	}
	public void ping(String os) {
		String proc = "ping -4 -n 10 www.google.com";
		if(os.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(proc);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					if(linha.contains("dia = ")) {
						String media[] = linha.split("=");
						System.out.println("A media do ping é:" + media[3]);
						linha = buffer.readLine();
					}else {
						System.out.println("Calculando media...");
						linha = buffer.readLine();
					}
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Sistema Operacional Incompátivel.");
		}

	}
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	public String getOs() {
		return os(); 
	}
}
