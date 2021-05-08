package novidades.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UsuarioApp {

	public static void main(String... args) {
		UsuarioApp app = new UsuarioApp();
		app.ex34();
	}
	
	void ex34() {
		List<Usuario> filtradosOrdenados = ex().parallelStream()
			.filter(u -> u.getPontos() > 100)
			.sorted(Comparator.comparing(Usuario::getNome))
			.collect(Collectors.toList());
		
		System.out.println(filtradosOrdenados);
	}
	
	void ex33() {
		String nomes = ex()
			.stream()
			.map(Usuario::getNome)
			.collect(Collectors.joining(", "));
		
		System.out.println(nomes);
	}
	
	void ex32() {
		Map<Boolean, Integer> pontuacaoPorTipo = ex()
			.stream()
			.collect(
				Collectors.partitioningBy(
					Usuario::isModerador,
					Collectors.summingInt(Usuario::getPontos)));
		
		System.out.println(pontuacaoPorTipo);
	}
	
	void ex31() {
		Map<Boolean, List<String>> nomesPorTipo = ex()
			.stream()
			.collect(
				Collectors.partitioningBy(
					Usuario::isModerador,
					Collectors.mapping(Usuario::getNome, Collectors.toList())));
		
		System.out.println(nomesPorTipo);
	}
	
	void ex30() {
		Map<Boolean, List<Usuario>> moderadores = ex()
			.stream()
			.collect(Collectors.partitioningBy(Usuario::isModerador));
		
		System.out.println(moderadores);
	}
	
	void ex29() {
		Map<Integer, List<Usuario>> pontuacao = ex()
			.stream()
			.collect(Collectors.groupingBy(Usuario::getPontos));
		
		System.out.println(pontuacao);
	}
	
	void ex28() {
		Grupo englishSpeakers = new Grupo();
		englishSpeakers.addAll(ex());
		
		Grupo spanishSpeakers = new Grupo();
		spanishSpeakers.addAll(ex());
		
		List<Grupo> groups = Arrays.asList(englishSpeakers, spanishSpeakers);
		
		groups.stream()
			.flatMap(g -> g.getUsuarios().stream())
			.distinct()
			.forEach(System.out::println);
	}
	
	void ex27() {
		Random random = new Random(0);
		IntStream
			.generate(() -> random.nextInt())
			.limit(100)
			.boxed()
			.collect(Collectors.toList());
	}
	
	void ex26() {
		boolean hasModerator = ex().stream()
			.anyMatch(Usuario::isModerador);
		
		System.out.println(hasModerator);
	}
	
	void ex25() {
		ex().stream()
			.iterator()
			.forEachRemaining(System.out::println);
	}
	
	void ex24() {
		int total = ex().stream()
			.reduce(0, (atual, u) -> atual + u.getPontos(), Integer::sum);
		
		System.out.println(total);
	}
	
	void ex23() {
		int multiplicacao = ex().stream()
			.mapToInt(Usuario::getPontos)
			.reduce(1, (a,b) -> a * b);
		
		System.out.println(multiplicacao);
	}
	
	void ex22() {
		int total = ex().stream()
			.mapToInt(Usuario::getPontos)
			.reduce(0, Integer::sum);
		
		System.out.println(total);
	}
	
	void ex21() {
		int total = ex().stream()
			.mapToInt(Usuario::getPontos)
			.reduce(0, (a, b) -> a + b);
		
		System.out.println(total);
	}
	
	void ex20() {
		int total = ex().stream()
			.mapToInt(Usuario::getPontos)
			.sum();
		
		System.out.println(total);
	}
	
	void ex19() {
		double pontuacaoMedia = ex().stream()
			.mapToInt(Usuario::getPontos)
			.average()
			.getAsDouble();
		
		System.out.println(pontuacaoMedia);
	}
	
	void ex18() {
		ex().stream()
			.sorted(Comparator.comparing(Usuario::getNome))
			.peek(System.out::println)
			.findAny();
	}
	
	void ex17() {
		ex().stream()
			.filter(u -> u.getPontos() > 100)
			.peek(System.out::println)
			.findAny();
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
		Usuario user1 = new Usuario("Paulo Silveira", 150, true);
		Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);
		Usuario user4 = new Usuario("Sergio Lopes", 120);
		Usuario user5 = new Usuario("Adriano Almeida", 100);

		return Arrays.asList(user1, user2, user3, user4, user5);
	}
}
