package com.java.lambda;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grupo {
	private Set<Usuario> usuarios = new HashSet<>();

	public void addAll(List<Usuario> usuarios) {
		this.usuarios.addAll(usuarios);
	}

	public Set<Usuario> getUsuarios() {
		return Collections.unmodifiableSet(this.usuarios);
	}
}
