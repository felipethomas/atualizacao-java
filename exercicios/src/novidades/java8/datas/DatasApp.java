package novidades.java8.datas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DatasApp {
	
	public static void main(String... args) {
		DatasApp app = new DatasApp();
		app.ex24();
	}
	
	void ex24() {
		LocalDateTime agora = LocalDateTime.now();
		LocalDateTime daquiAUmaHora = LocalDateTime.now().plusHours(1);
		Duration duration = Duration.between(agora, daquiAUmaHora);
		
		if (duration.isNegative()) {
			duration = duration.negated();
		}
		
		System.out.printf("%s horas, %s minutos ou %s segundos",
				duration.toHours(), duration.toMinutes(), duration.getSeconds());
	}
	
	void ex23() {
		LocalDate agora = LocalDate.now();
		LocalDate outraData = LocalDate.of(2025, Month.JANUARY, 25);
		Period periodo = Period.between(outraData, agora);
		
		if (periodo.isNegative()) {
			periodo = periodo.negated();
		}
		
		System.out.printf("%s anos, %s meses e %s dias",
				periodo.getYears(), periodo.getMonths(),  periodo.getDays());
	}
	
	void ex22() {
		LocalDate agora = LocalDate.now();
		LocalDate outraData = LocalDate.of(2025, Month.JANUARY, 25);
		Period periodo = Period.between(outraData, agora);
		
		System.out.printf("%s anos, %s meses e %s dias",
				periodo.getYears(), periodo.getMonths(),  periodo.getDays());
	}
	
	void ex21() {
		LocalDate agora = LocalDate.now();
		LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);
		Period periodo = Period.between(outraData, agora);
		
		System.out.printf("%s anos, %s meses e %s dias",
				periodo.getYears(), periodo.getMonths(),  periodo.getDays());
	}
	
	void ex20() {
		LocalDate agora = LocalDate.now();
		LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);
		
		long dias = ChronoUnit.DAYS.between(outraData, agora);
		long meses = ChronoUnit.MONTHS.between(outraData, agora);
		long anos = ChronoUnit.YEARS.between(outraData, agora);
		
		System.out.printf("%s dias, %s meses ou %s anos", dias, meses, anos);
	}
	
	void ex19() {
		LocalDate agora = LocalDate.now();
		LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);
		long dias = ChronoUnit.DAYS.between(outraData, agora);
		
		System.out.println(dias);
	}
	
	void ex18() {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String resultado = agora.format(formatador);
		LocalDate agoraEmData = LocalDate.parse(resultado, formatador);
		
		System.out.println(agoraEmData);
	}
	
	void ex17() {
		LocalDateTime agora = LocalDateTime.now();
		
		System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
	
	void ex16() {
		LocalDateTime agora = LocalDateTime.now();
		String resultado = agora.format(DateTimeFormatter.ISO_LOCAL_TIME);
		
		System.out.println(resultado);
	}
	
	void ex15() {
		Locale pt = new Locale("pt");
		LocalDate diaDaSemana = LocalDate.now();
		
		System.out.println(diaDaSemana.getDayOfWeek().getDisplayName(TextStyle.FULL, pt));
	}
	
	void ex14() {
		Locale pt = new Locale("pt");
		
		System.out.println(Month.DECEMBER
				.getDisplayName(TextStyle.FULL, pt));
		
		System.out.println(Month.DECEMBER
				.getDisplayName(TextStyle.SHORT, pt));
	}
	
	void ex13() {
		System.out.println(Month.DECEMBER.firstMonthOfQuarter());
		System.out.println(Month.DECEMBER.plus(2));
		System.out.println(Month.DECEMBER.minus(1));
	}
	
	void ex12() {
		System.out.println("hoje é dia: "+ MonthDay.now().getDayOfMonth());
		
		YearMonth ym = YearMonth.from(LocalDate.now());
		System.out.println(ym.getMonth() + " " + ym.getYear());
	}
	
	void ex11() {
		ZonedDateTime tokyo = ZonedDateTime
			.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
				
		ZonedDateTime saoPaulo = ZonedDateTime
			.of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("America/Sao_Paulo"));
		
		System.out.println(tokyo.isEqual(saoPaulo));
	}
	
	void ex10() {
		LocalDate dataDoPassado = LocalDate.now().withYear(1988);
		System.out.println(dataDoPassado.getYear());
	}
	
	void ex9() {
		LocalDate date = LocalDate.of(2014, 12, 25);
		LocalDateTime dateTime = LocalDateTime.of(2014, 12, 25, 10, 30);
		
		System.out.println(date);
		System.out.println(dateTime);
	}
	
	void ex8() {
		LocalTime agora = LocalTime.now();
		LocalDate hoje = LocalDate.now();
		LocalDateTime dataEhora = hoje.atTime(agora);
		
		ZonedDateTime dataComHoraETimezone =
				dataEhora.atZone(ZoneId.of("America/Sao_Paulo"));
		
		LocalDateTime semTimeZone = dataComHoraETimezone.toLocalDateTime();
		
		System.out.println(semTimeZone);
	}
	
	void ex7() {
		LocalTime agora = LocalTime.now();
		LocalDate hoje = LocalDate.now();
		LocalDateTime dataEhora = hoje.atTime(agora);
		
		ZonedDateTime dataComHoraETimezone =
				dataEhora.atZone(ZoneId.of("America/Sao_Paulo"));
		
		System.out.println(dataComHoraETimezone);
	}
	
	void ex6() {
		LocalTime agora = LocalTime.now();
		LocalDate hoje = LocalDate.now();
		LocalDateTime dataEhora = hoje.atTime(agora);
		System.out.println(dataEhora);
	}
	
	void ex5() {
		LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12,0);
		System.out.println(hojeAoMeioDia);
	}
	
	void ex4() {
		LocalTime agora = LocalTime.now();
		System.out.println(agora);
	}
	
	void ex3() {
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora);
	}
	
	void ex2() {
		LocalDate anoPassado = LocalDate.now().minusYears(1);
		System.out.println(anoPassado);
	}
	
	void ex1() {
		LocalDate mesQueVem = LocalDate.now().plusMonths(1);
		System.out.println(mesQueVem);
	}

}
