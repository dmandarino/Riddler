package br.com.ideais.estagio.service;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ideais.estagio.dao.FuncionarioDao;
import br.com.ideais.estagio.model.Etapa;
import br.com.ideais.estagio.model.Feitos;
import br.com.ideais.estagio.model.Funcionario;

@Service
public class FuncionarioService implements AbstractService<Funcionario> {

	@Autowired
	private FuncionarioDao fDao;
	
	public void persist(Funcionario funcionario){
		fDao.persist(funcionario);
	}
	
	public boolean saveOrUpdate(Funcionario funcionario){
		return fDao.saveOrUpdate(funcionario);
	}

	public boolean saveOrUpdate(Funcionario funcionario, Collection<Etapa> etapasSelecionadas) {
		for (Etapa etapa : etapasSelecionadas) {
			System.out.println(etapa.getNome());
		}
		List<Feitos> feitos = new LinkedList<Feitos>();
		for (Etapa etapa : etapasSelecionadas) {
			Feitos f = new Feitos();
			f.setEtapa(etapa);
			f.setFuncionario(funcionario);
			feitos.add(f);
		}
		funcionario.setFeitos(feitos);
		
		return fDao.saveOrUpdate(funcionario);
	}

	public List<Funcionario> list() {
		return fDao.list();
	}
	

	public Funcionario findbyId(Long id) {
		return fDao.findById(id);
	}
	
	public boolean delete(Funcionario funcionario){
		return fDao.delete(funcionario);
	}

	public void setfDao(FuncionarioDao fDao) {
		this.fDao = fDao;
	}
		
}

