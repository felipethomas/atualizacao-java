package com.java.interfaces.funcionais;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java.lambda.Usuario;

public class InterfacesFuncionaisApp {

	public static void main(String[] args) {
		InterfacesFuncionaisApp interf = new InterfacesFuncionaisApp();
		interf.ex8();
	}
	
	void ex9() {
		Predicate<Usuario> predicado = new Predicate<Usuario>() {
			public boolean test(Usuario u) {
				return u.getPontos() > 160;
			}
		};
		
		ArrayList<Usuario> usuarios = ex();
		
		usuarios.removeIf(predicado);
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}
	
	void ex8() {
		ArrayList<Usuario> usuarios = ex();
		
		Consumer<Usuario> mostraMensagem = u -> 
			System.out.println("antes de imprimir os nomes");
		
		Consumer<Usuario> imprimeNome = u ->
			System.out.println(u.getNome());
		
		usuarios.forEach(mostraMensagem.andThen(imprimeNome));
	}

	void ex7() {
		int numero = 5;
		
		new Thread(() -> {
			System.out.println(numero);
		}).start();
	}
	
	void ex6() {
		final int numero = 5;
		
		new Thread(() -> {
			System.out.println(numero);
		}).start();
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
	
	@SuppressWarnings("serial")
	private ArrayList<Usuario> ex() {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);

		return new ArrayList<Usuario>() {
			{
				add(user1);
				add(user2);
				add(user3);
			}
		};
	}
}
