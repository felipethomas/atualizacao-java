package com.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

public class UsuarioApp {

	public static void main(String... args) {
		UsuarioApp app = new UsuarioApp();
		app.ex16();
	}
	
	void ex16() {
		BiFunction<Integer, Integer, Integer> max = Math::max;
		ToIntBiFunction<Integer, Integer> max2 = Math::max;
		IntBinaryOperator max3 = Math::max;
		
		System.out.printf("%1$d %2$d %3$d", max.apply(1, 2), max2.applyAsInt(3, 4), max3.applyAsInt(5, 6));
	}
	
	void ex15() {
		BiFunction<String, Integer, Usuario> criadorDeUsuarios = Usuario::new;
		
		Usuario rodrigo = criadorDeUsuarios.apply("Rodrigo Turini", 50);
		Usuario paulo = criadorDeUsuarios.apply("Paulo Silveira", 300);
		
		System.out.printf("%1$s %2$s \n", rodrigo.getNome(), rodrigo.getPontos());
		System.out.printf("%1$s %2$s", paulo.getNome(), paulo.getPontos());
	}
	
	void ex14() {
		Function<String, Usuario> criadorDeUsuarios = Usuario::new;
		
		Usuario rodrigo = criadorDeUsuarios.apply("Rodrigo Turini");
		Usuario paulo = criadorDeUsuarios.apply("Paulo Silveira");
		
		System.out.println(rodrigo.getNome());
		System.out.println(paulo.getNome());
	}
	
	void ex13() {
		Supplier<Usuario> criadorDeUsuarios = Usuario::new;
		Usuario novo = criadorDeUsuarios.get();
		System.out.println(novo.getNome());
	}
	
	void ex12() {
		List<Usuario> usuarios = ex();
		usuarios.forEach(System.out::println);
	}
	
	void ex11() {
		Usuario rodrigo = new Usuario("Rodrigo Turini", 50);
		Runnable bloco = rodrigo::tornaModerador;
		
		bloco.run();
	}
	
	void ex10() {
		List<Usuario> usuarios = ex();
		
		usuarios.forEach(Usuario::tornaModerador);
		usuarios.forEach(u -> System.out.println(u.isModerador()));
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
