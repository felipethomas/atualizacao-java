package com.java.lambda;

public class Usuario {
	private String nome;
	private int pontos;
	private boolean moderador;
	
	public Usuario() {
		this.moderador = false;
	}
	
	public Usuario(String nome) {
		this.nome = nome;
		this.moderador = false;
	}

	public Usuario(String nome, int pontos) {
		this.pontos = pontos;
		this.nome = nome;
		this.moderador = false;
	}

	public String getNome() {
		return nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void tornaModerador() {
		this.moderador = true;
	}

	public boolean isModerador() {
		return moderador;
	}

	public String toString() {
		return "Usuario " + nome;
	}
}
