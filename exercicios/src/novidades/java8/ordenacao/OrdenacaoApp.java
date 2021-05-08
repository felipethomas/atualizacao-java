package novidades.java8.ordenacao;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import novidades.java8.lambda.Usuario;

public class OrdenacaoApp {

	public static void main(String[] args) {
		OrdenacaoApp app = new OrdenacaoApp();
		app.ex16();
	}
	
	void ex16() {
		List<Usuario> usuarios = ex();
		
		usuarios.sort(comparing(Usuario::getPontos).reversed());
		
		usuarios.forEach(u -> System.out.println(u.getPontos()));
	}
	
	void ex15() {
		List<Usuario> usuarios = ex();
		
		usuarios.sort(Comparator.nullsLast(
			comparing(Usuario::getNome)));
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}
	
	void ex14() {
		List<Usuario> usuarios = ex();
		
		usuarios.sort(Comparator
				.comparingInt(Usuario::getPontos)
				.thenComparing(Usuario::getNome));
		
		usuarios.forEach(u -> System.out.println(u.getPontos()));
	}
	
	void ex13() {
		Comparator<Usuario> comparador = Comparator
			.comparingInt(Usuario::getPontos)
			.thenComparing(Usuario::getNome);
		
		List<Usuario> usuarios = ex();
		
		usuarios.sort(comparador);
		usuarios.forEach(u -> System.out.println(u.getPontos()));
	}
	
	void ex12() {
		List<Usuario> usuarios = ex();
		Function<Usuario, String> byName = Usuario::getNome;
		
		usuarios.sort(comparing(byName));
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}
	
	void ex11() {
		List<Usuario> usuarios = ex();

		usuarios.sort(comparing(Usuario::getPontos));
		usuarios.forEach(u -> System.out.println(u.getPontos()));
	}
	
	void ex10() {
		List<Usuario> usuarios = ex();

		usuarios.sort(comparingInt(u -> u.getPontos()));
		usuarios.forEach(u -> System.out.println(u.getPontos()));
	}
	
	void ex9() {
		List<String> palavras =
				Arrays.asList("Casa do Código", "Alura", "Caelum");

		palavras.sort(Comparator.naturalOrder());
		palavras.forEach(p -> System.out.println(p));
	}

	void ex8() {
		List<Usuario> usuarios = ex();

		usuarios.sort(comparing(u -> u.getNome()));
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	void ex7() {
		List<Usuario> usuarios = ex();

		usuarios.sort(Comparator.comparing(u -> u.getNome()));
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	void ex6() {
		List<Usuario> usuarios = ex();

		Comparator<Usuario> comparador = Comparator.comparing(u -> u.getNome());
		usuarios.sort(comparador);

		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	void ex5() {
		List<Usuario> usuarios = ex();

		usuarios.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	void ex4() {
		List<Usuario> usuarios = ex();

		Collections.sort(usuarios, (o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getNome(), o2.getNome()));

		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	void ex3() {
		List<Usuario> usuarios = ex();

		Collections.sort(usuarios, (o1, o2) -> o1.getNome().compareTo(o2.getNome()));

		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	void ex2() {
		Comparator<Usuario> comparador = (o1, o2) -> o1.getNome().compareTo(o2.getNome());

		List<Usuario> usuarios = ex();
		Collections.sort(usuarios, comparador);

		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	void ex1() {
		Comparator<Usuario> comparador = new Comparator<Usuario>() {
			public int compare(Usuario o1, Usuario o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		};

		List<Usuario> usuarios = ex();
		Collections.sort(usuarios, comparador);

		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	private List<Usuario> ex() {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);

		return Arrays.asList(user1, user2, user3);
	}

}
