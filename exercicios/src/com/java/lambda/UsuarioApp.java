package com.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class UsuarioApp {

	public static void main(String... args) {
		UsuarioApp app = new UsuarioApp();

		app.ex9();
	}
	
	void ex9() {
		List<Usuario> usuarios = ex();
		
		usuarios.forEach(u -> u.tornaModerador());
		usuarios.forEach(u -> System.out.println(u.isModerador()));
	}
	
	void ex8() {
		List<Usuario> usuarios = ex();
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}
	
	void ex7() {
		List<Usuario> usuarios = ex();
		
		Consumer<Usuario> mostrador = u -> System.out.println(u.getNome());
		
		usuarios.forEach(mostrador);
	}
	
	void ex6() {
		List<Usuario> usuarios = ex();
		
		Consumer<Usuario> mostrador = 
				u -> { System.out.println(u.getNome()); };
				
		usuarios.forEach(mostrador);
	}

	void ex5() {
		List<Usuario> usuarios = ex();
		
		Consumer<Usuario> mostrador = 
				(Usuario u) -> { System.out.println(u.getNome()); };
				
		usuarios.forEach(mostrador);
	}

	void ex4() {
		List<Usuario> usuarios = ex();

		usuarios.forEach(new Consumer<Usuario>() {
			public void accept(Usuario u) {
				System.out.println(u.getNome());
			}
		});
	}

	void ex3() {
		List<Usuario> usuarios = ex();

		Consumer<Usuario> mostrador = new Consumer<Usuario>() {
			public void accept(Usuario u) {
				System.out.println(u.getNome());
			}
		};

		usuarios.forEach(mostrador);
	}

	void ex2() {
		List<Usuario> usuarios = ex();

		Mostrador mostrador = new Mostrador();
		usuarios.forEach(mostrador);
	}

	void ex1() {
		List<Usuario> usuarios = ex();

		for (Usuario u : usuarios) {
			System.out.println(u.getNome());
		}
	}

	private List<Usuario> ex() {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);

		return Arrays.asList(user1, user2, user3);
	}
}
