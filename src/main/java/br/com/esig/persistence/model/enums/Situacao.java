package br.com.esig.persistence.model.enums;

public enum Situacao {

	EM_ANDAMENTO("Em andamento"), CONCLUIDA("Concluída");

	private String descricao;

	Situacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
