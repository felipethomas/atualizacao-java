package novidades.java8.exercicio.goodies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class Pedido {

	private List<Produto> produtos;
	private LocalDateTime data;
	private Cliente cliente;

	public Pedido(List<Produto> produtos, LocalDateTime data, Cliente cliente) {
		super();
		this.produtos = Collections.unmodifiableList(produtos);
		this.data = data;
		this.cliente = cliente;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return "[Pedido: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
			+ " " + cliente + " " + produtos + "]";
	}

}
