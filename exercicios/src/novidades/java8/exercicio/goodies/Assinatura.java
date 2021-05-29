package novidades.java8.exercicio.goodies;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class Assinatura {
	
	private BigDecimal tarifaMensal;
	private LocalDateTime inicio;
	private Optional<LocalDateTime> termino;
	private Cliente cliente;
	
	public Assinatura(BigDecimal tarifaMensal, LocalDateTime inicio, Cliente cliente) {
		super();
		this.tarifaMensal = tarifaMensal;
		this.inicio = inicio;
		this.termino = Optional.empty();
		this.cliente = cliente;
	}
	
	public Assinatura(BigDecimal tarifaMensal, LocalDateTime inicio, LocalDateTime termino, Cliente cliente) {
		super();
		this.tarifaMensal = tarifaMensal;
		this.inicio = inicio;
		this.termino = Optional.of(termino);
		this.cliente = cliente;
	}

	public BigDecimal getTarifaMensal() {
		return tarifaMensal;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public Optional<LocalDateTime> getTermino() {
		return termino;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public BigDecimal getTotalPago() {
		return getTarifaMensal()
			.multiply(new BigDecimal(ChronoUnit.MONTHS
				.between(getInicio(),
					getTermino().orElse(LocalDateTime.now()))));
	}
	
}
