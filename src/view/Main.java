package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController rc = new RedesController();
		String so = rc.getOs();
		int option = 0;
		while(option != 9) {
			option = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção: \n"
					+ "1: Verificar Sistema Operacional.\n"
					+ "2: Verificar IP. \n"
					+ "3: Verificar ping médio.\n"
					+ "9: Sair"));
			switch(option) {
				case 1:	
					System.out.println(so);
					break;
				case 2:
					rc.ip(so);
					break;
				case 3:
					rc.ping(so);
					break;
				case 9:
					break;
				default:
					System.out.println("Opção inválida!");
					break;
					
			}
		}
	}
}
