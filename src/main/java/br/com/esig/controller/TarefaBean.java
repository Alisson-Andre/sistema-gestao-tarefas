package br.com.esig.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.esig.annotations.Transactional;
import br.com.esig.persistence.dao.DAOTarefaFilter;
import br.com.esig.persistence.daointerface.DAO;
import br.com.esig.persistence.model.Tarefa;
import br.com.esig.persistence.model.enums.Prioridade;
import br.com.esig.persistence.model.enums.Situacao;
import br.com.esig.utils.FacesMessages;

@Named
@ViewScoped
public class TarefaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private DAOTarefaFilter daoTarefaFilter;

	@Inject
	private DAO<Tarefa> tarefaDao;

	@Inject
	private FacesMessages messages;

	@Inject
	private Tarefa tarefaFiltro;

	private Tarefa tarefa;

	private Tarefa editTarefa;

	private List<Tarefa> listaTarefas;

	@PostConstruct
	public void carregarTarefas() {
		listaTarefas = daoTarefaFilter.listagemTarefaEmAndamento();
		tarefa = new Tarefa();
	}

	public void listaFiltrada() {
		listaTarefas = daoTarefaFilter.listagemTarefaFiltrada(tarefaFiltro);
	}

	public String prepararNovaTarefa() {
		tarefa = new Tarefa();
		return "tarefacadastro.xhtml?faces-redirect=true";
	}

	@Transactional
	public void salvar() {
		tarefa.setSituacao(Situacao.EM_ANDAMENTO);
		tarefaDao.save(tarefa);

		messages.info("Tarefa salva com sucesso!");
		tarefa = new Tarefa();
	}

	@Transactional
	public String excluir(Tarefa tarefa) {
		tarefaDao.remove(tarefa);
		messages.info("Tarefa excluída com sucesso!");

		return "tarefalista.xhtml?faces-redirect=true";
	}

	public void editTarefa(Tarefa tarefa) {
		tarefa.setTarefaEdit(true);
	}

	@Transactional
	public void salvarTarefaEditada() {
			tarefa.setTarefaEdit(false);
			tarefaDao.save(tarefa);
	}

	@Transactional
	public String tarefaConcluir() {
		tarefa.setSituacao(Situacao.CONCLUIDA);
		tarefaDao.save(tarefa);

		return "tarefalista.xhtml?faces-redirect=true";
	}

	public String renderConcluido(Tarefa tarefa) {

		if (tarefa.getSituacao().equals(Situacao.EM_ANDAMENTO))
			return "true";
		else
			return "false";
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Tarefa getTarefaFiltro() {
		return tarefaFiltro;
	}

	public void setTarefaFiltro(Tarefa tarefaFiltro) {
		this.tarefaFiltro = tarefaFiltro;
	}

	public Tarefa getEditTarefa() {
		return editTarefa;
	}

	public void setEditTarefa(Tarefa editTarefa) {
		this.editTarefa = editTarefa;
	}

	public List<Tarefa> getListaTarefas() {
		return listaTarefas;
	}

	public Prioridade[] getPrioridade() {
		return Prioridade.values();
	}

	public Situacao[] getSituacao() {
		return Situacao.values();
	}

}
