package novidades.java8.exercicio.goodies;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Loja {

	public static List<Cliente> clientes;
	public static List<Produto> produtos;
	public static List<Pedido> pedidos;
	public static List<Assinatura> assinaturas;

	public static void main(String[] args) {
		Loja loja = new Loja();
		loja.inicializarBancoDeDados();
		loja.ordenarPorData();
		loja.totalDoPedido1();
		loja.totalDeTodosOsPedidos();
		loja.campeaoDeVendas();
		loja.totalPorProduto();
		loja.produtosDeCadaCliente();
		loja.clienteMaisEspecial();
		loja.pagamentosPorAnoMes();
		loja.faturamentoPorMes();
		loja.quantidadeDeMesesPagosPelaAssinatura();
		loja.totalPagoPelaAssinatura();
		loja.totalPagoPorTodasAssinaturas();
	}

	private void ordenarPorData() {
		pedidos.stream()
			.sorted(comparing(Pedido::getData))
			.forEach(out::println);
	}
	
	private void totalDoPedido1() {
		pedidos.get(0).getProdutos().stream()
			.map(Produto::getPreco)
			.reduce(BigDecimal::add)
			.ifPresent(out::println);
	}
	
	private void totalDeTodosOsPedidos() {
		pedidos.stream()
			.flatMap(p -> p.getProdutos().stream().map(Produto::getPreco))
			.reduce(BigDecimal::add)
			.ifPresent(out::println);
	}
	
	private void campeaoDeVendas() {
		Map<Produto, Long> resumo = pedidos.stream()
			.flatMap(p -> p.getProdutos().stream())
			.collect(groupingBy(Function.identity(), counting()));
		
		resumo.entrySet()
			.forEach(out::println);
		
		resumo.entrySet().stream()
			.max(comparing(Map.Entry::getValue))
			.ifPresent(out::println);
	}
	
	private void totalPorProduto() {
		Map<Produto, BigDecimal> totalPorProduto = pedidos.stream()
			.flatMap(p -> p.getProdutos().stream())
			.collect(groupingBy(Function.identity(), 
					reducing(BigDecimal.ZERO, Produto::getPreco, BigDecimal::add)));
		
		totalPorProduto.entrySet().stream()
			.sorted(comparing(Map.Entry::getValue))
			.forEach(System.out::println);
	}
	
	private void produtosDeCadaCliente() {
		Map<Cliente, List<List<Produto>>> produtosPorCliente = pedidos.stream()
			.collect(groupingBy(Pedido::getCliente, 
					mapping(Pedido::getProdutos, toList())));
		
		Map<Cliente, List<Produto>> produtosPorClienteReduzido = produtosPorCliente.entrySet()
			.stream()
			.collect(toMap(Map.Entry::getKey,
					e -> e.getValue().stream()
						.flatMap(List::stream)
						.collect(toList())));
			
		produtosPorClienteReduzido.entrySet().stream()
			.sorted(comparing(e -> e.getKey().getNome()))
			.forEach(System.out::println);
	}
	
	private void clienteMaisEspecial() {
		Function<Pedido, BigDecimal> pedidoComTotal =
			p -> p.getProdutos().stream()
				.map(Produto::getPreco)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
			
		Map<Cliente, BigDecimal> valorTotalPorCliente = pedidos.stream()
			.collect(groupingBy(Pedido::getCliente,
					reducing(BigDecimal.ZERO, 
							pedidoComTotal, 
							BigDecimal::add)));	
		
		valorTotalPorCliente.entrySet().stream()
			.sorted(comparing(Map.Entry::getValue))
			.forEach(System.out::println);
	}
	
	private void pagamentosPorAnoMes() {
		Map<YearMonth, List<Pedido>> pagamentosPorAnoMes = pedidos.stream()
			.collect(groupingBy(p -> YearMonth.from(p.getData())));
		
		pagamentosPorAnoMes.entrySet().stream()
			.forEach(System.out::println);
	}
	
	private void faturamentoPorMes() {
		Map<YearMonth, BigDecimal> faturamentoPorMes = pedidos.stream()
			.collect(groupingBy(p -> YearMonth.from(p.getData()),
				reducing(BigDecimal.ZERO,
					p -> p.getProdutos().stream()
						.map(Produto::getPreco)
						.reduce(BigDecimal.ZERO,
							BigDecimal::add),
							BigDecimal::add)));
		
		faturamentoPorMes.entrySet().stream()
			.forEach(System.out::println);
	}
	
	private void quantidadeDeMesesPagosPelaAssinatura() {
		Assinatura assinatura1 = assinaturas.get(0);
		
		long meses = ChronoUnit.MONTHS
				.between(assinatura1.getInicio(), 
						assinatura1.getTermino().orElse(LocalDateTime.now()));
		
		System.out.print(meses);
	}
	
	private void totalPagoPelaAssinatura() {
		Assinatura assinatura1 = assinaturas.get(0);
		
		BigDecimal total = assinatura1.getTarifaMensal()
			.multiply(new BigDecimal(ChronoUnit.MONTHS
				.between(assinatura1.getInicio(),
					assinatura1.getTermino().orElse(LocalDateTime.now()))));
		
		System.out.print(total);
	}
	
	private void totalPagoPorTodasAssinaturas() {
		BigDecimal total = assinaturas.stream()
				.map(Assinatura::getTotalPago)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		System.out.print(total);
	}

	private void inicializarBancoDeDados() {
		Cliente paulo = new Cliente("Paulo Silveira");
		Cliente rodrigo = new Cliente("Rodrigo Turini");
		Cliente guilherme = new Cliente("Guilherme Silveira");
		Cliente adriano = new Cliente("Adriano Almeida");

		Produto bach = new Produto("Bach Completo", Paths.get("/music/bach.mp3"), new BigDecimal(100));
		Produto poderosas = new Produto("Poderosas Anita", Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
		Produto bandeira = new Produto("Bandeira Brasil", Paths.get("/images/brasil.jpg"), new BigDecimal(50));
		Produto beauty = new Produto("Beleza Americana", Paths.get("beauty.mov"), new BigDecimal(150));
		Produto vingadores = new Produto("Os Vingadores", Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
		Produto amelie = new Produto("Amelie Poulain", Paths.get("/movies/amelie.mov"), new BigDecimal(100));

		LocalDateTime hoje = LocalDateTime.now();
		LocalDateTime ontem = hoje.minusDays(1);
		LocalDateTime mesPassado = hoje.minusMonths(1);
		Pedido pedido1 = new Pedido(asList(bach, poderosas), hoje, paulo);
		Pedido pedido2 = new Pedido(asList(bach, bandeira, amelie), ontem, rodrigo);
		Pedido pedido3 = new Pedido(asList(beauty, vingadores, bach), hoje, adriano);
		Pedido pedido4 = new Pedido(asList(bach, poderosas, amelie), mesPassado, guilherme);
		Pedido pedido5 = new Pedido(asList(beauty, amelie), ontem, paulo);
		
		BigDecimal tarifaMensal = new BigDecimal("99.90");
		Assinatura assinatura1 = new Assinatura(tarifaMensal, ontem.minusMonths(5), paulo);
		Assinatura assinatura2 = new Assinatura(tarifaMensal, ontem.minusMonths(8), hoje.minusMonths(1), rodrigo);
		Assinatura assinatura3 = new Assinatura(tarifaMensal, ontem.minusMonths(5), hoje.minusMonths(2), adriano);

		clientes = asList(paulo, rodrigo, guilherme, adriano);
		produtos = asList(bach, poderosas, bandeira, beauty, vingadores, amelie);
		pedidos = asList(pedido1, pedido2, pedido3, pedido4, pedido5);
		assinaturas = asList(assinatura1, assinatura2, assinatura3);
	}

}
