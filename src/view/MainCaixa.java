package view;
import controller.Caixathreads;
public class MainCaixa {

	public static void main(String[] args) {
		//criacao das 20 operações aleatorias
		for(int i = 0; i <20 ; i++) {
			String tipo = Math.random() > 0.5 ? "Saque" : "Depósito"; // determinar o tipo aleatoriamente
			int codconta = i +1; 
			double saldo = Math.random()*1000;
			double valortransacao = Math.random()*500;
			
			Caixathreads caixa = new Caixathreads(tipo, codconta, saldo, valortransacao);
			caixa.start();
		}
	}

}
