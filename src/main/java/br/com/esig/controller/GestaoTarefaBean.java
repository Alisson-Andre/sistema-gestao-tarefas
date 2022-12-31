package br.com.esig.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.MatchMode;

import br.com.esig.annotations.Transactional;
import br.com.esig.persistence.daointerface.DAO;
import br.com.esig.persistence.model.Tarefa;
import br.com.esig.persistence.model.enums.Prioridade;
import br.com.esig.persistence.model.enums.Situacao;
import br.com.esig.utils.FacesMessages;

@Named
@ViewScoped
public class GestaoTarefaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Tarefa> tarefaDao;
	
	@Inject
	private FacesMessages messages;
	
	private Tarefa tarefa;
	
	private List<Tarefa> listaTarefas;
	
	private List<FilterMeta> filterBy;
	
	@PostConstruct
	public void atualizarTarefas() {
		this.listaTarefas = tarefaDao.listAll();
		
		filterBy = new ArrayList<>();

        filterBy.add(FilterMeta.builder()
                .field("situacao")
                .filterValue(Situacao.EM_ANDAMENTO)
                .matchMode(MatchMode.EQUALS)
                .build());
	}
	
	public void prepararNovaTarefa() {
		tarefa = new Tarefa();
	}
	
	@Transactional
	public void salvar() {
		tarefaDao.save(tarefa);
		atualizarTarefas();
		
		messages.info("Tarefa salva com sucesso!");
	}

	@Transactional
	public void excluir() {
		tarefaDao.remove(tarefa);
		tarefa = null;
		atualizarTarefas();
		
		messages.info("Tarefa excluída com sucesso!");
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getListaTarefas() {
		return listaTarefas;
	}
	
	
	public List<FilterMeta> getFilterBy() {
		return filterBy;
	}

	public Prioridade[] getPrioridade() {
		return Prioridade.values();
	}
	
	public Situacao[] getSituacao() {
		return Situacao.values();
	}
	
}
