package com.java.arquivos;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArquivosApp {
	
	public static final String DIR_ARQUIVOS = "./src/com/java/arquivos"; 
	
	public static void main(String... args) {
		ArquivosApp app = new ArquivosApp();
		app.ex8();
	}
	
	void ex8() {
		try {
			Map<Path, List<String>> lines =
					Files.list(Paths.get(DIR_ARQUIVOS))
						.filter(p -> p.toString().endsWith(".txt"))
						.collect(Collectors.toMap(
							Function.identity(),
							p -> lines(p).collect(Collectors.toList())));
			
			System.out.println(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void ex7() {
		try {
			Map<Path, Long> lines =
					Files.list(Paths.get(DIR_ARQUIVOS))
						.filter(p -> p.toString().endsWith(".txt"))
						.collect(Collectors.toMap(
							p -> p,
							p -> lines(p).count()));
			
			System.out.println(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void ex6() {
		try {
			IntStream chars =
					Files.list(Paths.get(DIR_ARQUIVOS))
						.filter(p -> p.toString().endsWith(".txt"))
						.flatMap(p -> lines(p))
						.flatMapToInt(s -> s.chars());
			
			chars.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void ex5() {
		try {
			Stream<String> strings =
					Files.list(Paths.get(DIR_ARQUIVOS))
						.filter(p -> p.toString().endsWith(".pdf"))
						.flatMap(p -> lines(p));
			
			strings.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void ex4() {
		try {
			Stream<Stream<String>> strings =
					Files.list(Paths.get(DIR_ARQUIVOS))
						.filter(p -> p.toString().endsWith(".pdf"))
						.map(p -> lines(p));
			
			strings.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void ex3() {
		try {
			Files.list(Paths.get(DIR_ARQUIVOS))
				.filter(p -> p.toString().endsWith(".pdf"))
				.map(p -> lines(p))
				.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void ex2() {
		try {
			Files.list(Paths.get(DIR_ARQUIVOS))
				.filter(p -> p.toString().endsWith(".pdf"))
				.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void ex1() {
		try {
			Files.list(Paths.get(DIR_ARQUIVOS))
				.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Stream<String> lines(Path p) {
		try {
			return Files.lines(p);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

}
