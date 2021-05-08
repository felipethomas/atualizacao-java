package novidades.java8.interfaces.funcionais;

@FunctionalInterface
public interface Validador<T> {
	boolean valida(T t);
}
