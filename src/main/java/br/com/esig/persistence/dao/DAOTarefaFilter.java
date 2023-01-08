package br.com.esig.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.esig.persistence.model.Tarefa;
import br.com.esig.persistence.model.enums.Prioridade;
import br.com.esig.persistence.model.enums.Situacao;

public class DAOTarefaFilter implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public List<Tarefa> listagemTarefaEmAndamento() {
		String jpql = "Select t from Tarefa t where t.situacao='EM_ANDAMENTO'";
		TypedQuery<Tarefa> query = em.createQuery(jpql, Tarefa.class);
		return query.getResultList();
	}

	public List<Tarefa> listagemTarefaFiltrada(Tarefa tarefa) {
		TypedQuery<Tarefa> query = em.createQuery(criarQueryFiltro(tarefa), Tarefa.class);
		return query.getResultList();
	}

	public String criarQueryFiltro(Tarefa tarefa) {
		String queryCriada = "Select t from Tarefa t where ";

		if (tarefa.getId() != null) {
			queryCriada += "t.id = " + tarefa.getId() + " and ";
		}

		if (tarefa.getTitulo() != null) {
			queryCriada += "t.titulo like '%" + tarefa.getTitulo() + "%' and ";
		}

		if (tarefa.getResponsavel() != null) {
			queryCriada += "t.responsavel like '%" + tarefa.getResponsavel() + "%' and ";
		}

		if (tarefa.getDescricao() != null) {
			queryCriada += "t.descricao like '%" + tarefa.getDescricao() + "%' and ";
		}

		if (tarefa.getPrioridade() == null) {
			queryCriada += "";
		} else if (tarefa.getPrioridade().equals(Prioridade.ALTA)) {
			queryCriada += "t.prioridade like 'ALTA' and ";
		} else if (tarefa.getPrioridade().equals(Prioridade.MEDIA)) {
			queryCriada += "t.prioridade like 'MEDIA' and ";
		} else if (tarefa.getPrioridade().equals(Prioridade.BAIXA)) {
			queryCriada += "t.prioridade like 'BAIXA' and ";
		}

		if (tarefa.getSituacao().equals(Situacao.EM_ANDAMENTO)) {
			queryCriada += "t.situacao like 'EM_ANDAMENTO'";
		} else if (tarefa.getSituacao().equals(Situacao.CONCLUIDA)) {
			queryCriada += "t.situacao like 'CONCLUIDA'";
		}

		return queryCriada;
	}
}
