package com.java.interfaces.funcionais;

public class InterfacesFuncionaisApp {

	public static void main(String[] args) {
		InterfacesFuncionaisApp interf = new InterfacesFuncionaisApp();
		interf.ex5();
	}
	
	void ex5() {
		Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");
		
		System.out.println(validadorCEP.valida("60.813-550"));
		System.out.println(validadorCEP.valida("60813-550"));
	}
	
	void ex4() {
		Validador<String> validadorCEP = new Validador<String>() {
			public boolean valida(String valor) {
				return valor.matches("[0-9]{5}-[0-9]{3}");
			}
		};
		
		System.out.println(validadorCEP.valida("60.813-550"));
		System.out.println(validadorCEP.valida("60813-550"));
	}
	void ex3() {
		new Thread(() -> {
			for (int i = 0; i <= 1000; i++) {
				System.out.println(i);
			}
		}).start();
	}
	
	void ex2() {
		Runnable r = () -> {
			for (int i = 0; i <= 1000; i++) {
				System.out.println(i);
			}
		};
		new Thread(r).start();
	}
	
	void ex1() {
		Runnable r = new Runnable() {
			public void run() {
				for (int i = 0; i <= 1000; i++) {
					System.out.println(i);
				}
			}
		};
		new Thread(r).start();
	}
}
