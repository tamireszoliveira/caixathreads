package controller;
import java.util.concurrent.Semaphore;

public class Caixathreads extends Thread {
	private static final Semaphore saque = new Semaphore(1);
	private static final Semaphore deposito = new Semaphore(1);
	
	private String tipo; // indica se é saq ou dep
	private int codconta;
	private double saldo;
	private double valortransacao;
	
	public Caixathreads(String tipo, int codconta, double saldo, double valortransacao) {
		this.tipo = tipo;
		this.codconta = codconta;
		this.saldo = saldo;
		this.valortransacao = valortransacao;
	}
	@Override
	public void run() {
		try {
			if(tipo.equalsIgnoreCase("Saque")) {
			saque.acquire();
			realizarsaque();
			saque.release();
			} else if (tipo.equalsIgnoreCase("Depósito")){
				deposito.acquire();
				realizardeposito();
				deposito.release();
			}
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}	
		private void realizarsaque() {
			if(saldo >= valortransacao) {
				saldo -= valortransacao;
				System.out.println("Operação realizada com sucesso");
			} else {
				System.out.println("Ocorreu uma falha na transação");
			}
		}
		private void realizardeposito() {
			saldo += valortransacao;
			System.out.println("Operação realizada com sucesso");
		}
}
