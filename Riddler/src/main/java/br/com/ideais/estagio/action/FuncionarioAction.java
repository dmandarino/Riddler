package br.com.ideais.estagio.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ideais.estagio.model.Etapa;
import br.com.ideais.estagio.model.Feitos;
import br.com.ideais.estagio.model.Funcionario;
import br.com.ideais.estagio.service.EtapaService;
import br.com.ideais.estagio.service.FuncionarioService;

import com.opensymphony.xwork2.ActionContext;

public class FuncionarioAction implements CRUDAction {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private EtapaService etapaService;

	private Funcionario funcionario = new Funcionario();

	private List<Long> etapasSelecionadas = new LinkedList<Long>();

	private List<Funcionario> funcionarios;

	private HashMap<String, List<Feitos>> mapa;
	
	private HashMap<String, Collection<Feitos>> mapaPendente;
	
	private HashMap<String, Collection<Feitos>> mapaUrgente;

	public String execute() throws Exception {
		return SUCCESS;
	}

	public void prepare() throws Exception {
		if (getFuncionarioFromRequest() != null) {
			funcionario = funcionarioService
					.findbyId(getFuncionarioFromRequest());
		}
	}

	public String save() {
		try {
			System.out.println(funcionario.getNome() + " "
					+ funcionario.getDataDeAdmissao());
			if (funcionario.getNome().equals("")) {
				erroCampoVazio();
				return ERROR;
			}

			Collection<Etapa> etapas = new LinkedList<Etapa>();
			for (Long etapaSelecionada : etapasSelecionadas) {
				Etapa etapa = etapaService.findbyId(etapaSelecionada);
				etapas.add(etapa);
			}

			funcionarioService.saveOrUpdate(funcionario, etapas);

			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
//	public String atualizar() {
//		try{
//			funcionarioService.atualizar(getFuncionarioFromRequest(), funcionario);
//			return SUCCESS;
//		}catch(Exception e){
//			System.out.println(e);
//		}
//		return ERROR;	}

	public String editarTarefas() {
		System.out.println(getFuncionarioFromRequest());
		try {
			mapa = funcionarioService
					.editarTarefas(getFuncionarioFromRequest());
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e);
		}
		return ERROR;
	}
	
	public String listarTarefasPendentes() {
		try {
			setMapaPendente(funcionarioService.listarTarefasPendentes());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listarTarefasUrgentes() {
		try {
			setMapaPendente(funcionarioService.listarTarefasUrgentes());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String update() {
		try {
			funcionarioService.saveOrUpdate(funcionario);
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e);
		}
		return ERROR;
	}

	public String delete() {
		
		if(funcionarioService.delete(getFuncionarioFromRequest()))
			return SUCCESS;
		else
			return ERROR;

	}

//	public String delete() {
//		if(funcionarioService.delete(funcionario))
//			return SUCCESS;
//		return ERROR;
//	}

	
	public String create() {
		return SUCCESS;
	}

	public String list() {
		System.out.println(" -------------------------------------------___> entrei " + funcionario.getNome());
		if(funcionario.getNome() == null)
			funcionarios = funcionarioService.list();
		else
			funcionarios = funcionarioService.findFuncionariosLike(funcionario.getNome());
		
		return SUCCESS;
	}

	private Long getFuncionarioFromRequest() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);

		if (request.getParameter("id") != null)
			return Long.parseLong(request.getParameter("id"));

		return null;
	}

	// REDIRECIONA A MESSAGEM DE ERRO PARA A TELA

	private void erroCampoVazio() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("erro", "Preencha os campos por favor");
	}

	//
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public List<Long> getEtapasSelecionadas() {
		return etapasSelecionadas;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public HashMap<String, List<Feitos>> getMapa() {
		return mapa;
	}

	public void setMapa(HashMap<String, List<Feitos>> mapa) {
		this.mapa = mapa;
	}

	public HashMap<String, Collection<Feitos>> getMapaPendente() {
		return mapaPendente;
	}

	public void setMapaPendente(HashMap<String, Collection<Feitos>> mapaPendente) {
		this.mapaPendente = mapaPendente;
	}
	
	public void setMapaUrgente(HashMap<String, Collection<Feitos>> mapaUrgente) {
		this.mapaUrgente = mapaUrgente;
	}
	public HashMap<String, Collection<Feitos>> getMapaUrgente() {
		return mapaUrgente;
	}
	
	

}
