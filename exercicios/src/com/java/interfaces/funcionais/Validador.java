package com.java.interfaces.funcionais;

@FunctionalInterface
public interface Validador<T> {
	boolean valida(T t);
}
