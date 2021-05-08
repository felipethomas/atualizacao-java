package novidades.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import novidades.java8.lambda.Usuario;

public class StreamsApp {
	
	public static void main(String[] args) {
		Supplier<StreamsApp> criadorDeApps = StreamsApp::new;
		StreamsApp app = criadorDeApps.get();
		app.ex26();
	}
	
	void ex26() {
		List<Usuario> usuarios = ex();
		
		boolean hasModerator = usuarios
				.stream()
				.anyMatch(u -> u.isModerador());
		
		System.out.println(hasModerator);
	}
	
	void ex25() {
		List<Usuario> usuarios = ex();
		
		usuarios.stream()
			.iterator()
			.forEachRemaining(System.out::println);
	}
	
	void ex24() {
		List<Usuario> usuarios = ex();
		
		int total = usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.reduce(1, (a,b) -> a * b);
		
		System.out.println(total);
	}
	
	void ex23() {
		List<Usuario> usuarios = ex();
		
		int valorInicial = 0;
		IntBinaryOperator operacao = (a, b) -> a + b;
		
		int total = usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.reduce(valorInicial, operacao); //reduce(0, Integer::sum);
		
		System.out.println(total);
	}
	
	void ex22() {
		List<Usuario> usuarios = ex();

		int total = usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.sum();
		
		System.out.println(total);
	}
	
	void ex21() {
		List<Usuario> usuarios = ex();

		Optional<Usuario> max = usuarios
				.stream()
				.max(Comparator.comparing(Usuario::getPontos));
		
		Usuario maximaPontuacao = max.get();
		System.out.println(maximaPontuacao);
	}
	
	void ex20() {
		List<Usuario> usuarios = ex();
		
		usuarios.stream()
			.sorted(Comparator.comparing(Usuario::getNome))
			.peek(System.out::println)
			.collect(Collectors.toList());
	}
	
	void ex19() {
		List<Usuario> usuarios = ex();
		
		usuarios.stream()
			.filter(u -> u.getPontos() > 100)
			.peek(System.out::println)
			.findAny();
	}
	
	void ex18() {
		List<Usuario> usuarios = ex();
		
		Optional<Usuario> usuario = usuarios
				.stream()
				.filter(u -> u.getPontos() > 100)
				.findAny();
		
		System.out.println(usuario.get());
	}
	
	void ex17() {
		List<Usuario> usuarios = ex();
		
		usuarios.stream()
			.filter(u -> u.getPontos() > 100)
			.sorted(Comparator.comparing(Usuario::getNome))
			.forEach(System.out::println);
	}
	
	void ex16() {
		List<Usuario> usuarios = ex();
		
		Optional<String> max = usuarios.stream()
				.max(Comparator.comparingInt(Usuario::getPontos))
				.map(u -> u.getNome());
		
		max.ifPresent(valor -> System.out.println(valor));
	}
	
	void ex15() {
		List<Usuario> usuarios = ex();
		
		usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.average()
			.ifPresent(media -> System.out.println(media));
	}
	
	void ex14() {
		List<Usuario> usuarios = List.of();
		
		usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.average()
			.ifPresent(media -> System.out.println(media));
	}
	
	void ex13() {
		List<Usuario> usuarios = List.of();
		
		double media = usuarios.stream()
				.mapToInt(Usuario::getPontos)
				.average()
				.orElseThrow(IllegalStateException::new);
		
		System.out.println(media);
	}
	
	void ex12() {
		List<Usuario> usuarios = List.of();
		
		double media = usuarios.stream()
				.mapToInt(Usuario::getPontos)
				.average()
				.orElse(0.0);
		
		System.out.println(media);
	}
	
	void ex11() {
		List<Usuario> usuarios = ex();
		
		double media = usuarios.stream()
				.mapToInt(Usuario::getPontos)
				.average()
				.getAsDouble();
		
		System.out.println(media);
	}
	
	void ex10() {
		List<Usuario> usuarios = ex();
		
		IntStream stream = usuarios.stream()
				.mapToInt(Usuario::getPontos);
		
		stream.forEach(System.out::println);
	}
	
	void ex9() {
		List<Usuario> usuarios = ex();
		
		List<Integer> pontos = usuarios.stream()
				.map(Usuario::getPontos)
				.collect(Collectors.toList());
		
		pontos.forEach(System.out::println);
	}
	
	void ex8() {
		List<Usuario> usuarios = ex();
		
		List<Integer> pontos = usuarios.stream()
				.map(u -> u.getPontos())
				.collect(Collectors.toList());
		
		pontos.forEach(System.out::println);
	}
	
	void ex7() {
		List<Usuario> usuarios = ex();
		
		Set<Usuario> set = usuarios.stream()
				.filter(u -> u.getPontos() > 100)
				.collect(Collectors.toCollection(HashSet::new));
		
		set.forEach(System.out::println);
	}
	
	void ex6() {
		List<Usuario> usuarios = ex();
		
		List<Usuario> maisQue100 = usuarios.stream()
				.filter(u -> u.getPontos() > 100)
				.collect(Collectors.toList());
		
		maisQue100.forEach(System.out::println);
	}
	
	void ex5() {
		List<Usuario> usuarios = ex();
		
		usuarios
			.stream()
			.filter(u -> u.getPontos() > 100)
			.forEach(Usuario::tornaModerador);
		
		usuarios
			.stream()
			.filter(Usuario::isModerador)
			.forEach(System.out::println);
	}
	
	void ex4() {
		List<Usuario> usuarios = ex();
		
		usuarios
			.stream()
			.filter(u -> u.getPontos() > 100)
			.forEach(Usuario::tornaModerador);
	}
	
	void ex3() {
		List<Usuario> usuarios = ex();
		
		usuarios
			.stream()
			.filter(u -> u.getPontos() > 100)
			.forEach(System.out::println);
	}
	
	void ex2() {
		List<Usuario> usuarios = ex();
		
		Stream<Usuario> stream = usuarios
				.stream()
				.filter(u -> u.getPontos() > 100);
		
		stream.forEach(System.out::println);
	}
	
	void ex1() {
		List<Usuario> usuarios = ex();
		
		usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
		
		usuarios
			.subList(0, 10)
			.forEach(Usuario::tornaModerador);
		
		usuarios.forEach(System.out::println);
	}
	
	@SuppressWarnings("serial")
	private List<Usuario> ex() {
		return new ArrayList<Usuario>() {
			{
				add(new Usuario("Friedrich Gauss", 90));
				add(new Usuario("Paulo Silveira", 150));
				add(new Usuario("Rodrigo Turini", 120));
				add(new Usuario("Guilherme Silva", 190));
				add(new Usuario("Felipe Thomas", 140));
				add(new Usuario("Raphael Henrique", 180));
				add(new Usuario("Rodrigo Fialho", 130));
				add(new Usuario("Pedro Alcantara", 110));
				add(new Usuario("Gustavo Silva", 170));
				add(new Usuario("Johnny Depp", 160));
				add(new Usuario("Robert De Niro", 200));
				add(new Usuario("Felipe Nunes ", 100));
			}
		};
	}

}
