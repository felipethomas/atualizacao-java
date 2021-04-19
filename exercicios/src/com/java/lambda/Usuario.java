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
	
	public Usuario(String nome, int pontos, boolean moderador) {
		this.pontos = pontos;
		this.nome = nome;
		this.moderador = moderador;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (moderador ? 1231 : 1237);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + pontos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (moderador != other.moderador)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pontos != other.pontos)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nome=" + nome + ",\t pontos=" + pontos + ",\t moderador=" + moderador;
	}
}
