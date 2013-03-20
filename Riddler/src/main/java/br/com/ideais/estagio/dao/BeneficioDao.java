package br.com.ideais.estagio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ideais.estagio.model.Beneficio;
import br.com.ideais.estagio.model.Etapa;

@Service
@Transactional
public class BeneficioDao extends AbstractDao<Beneficio> {
	@Autowired
	HibernateTemplate hibernateTemplate;

	public boolean saveOrUpdate(Beneficio beneficio) {
		try {
			for (Beneficio beneficioSalvo : list()) {
				if (beneficio.getNome().equals(beneficioSalvo.getNome())) {
					return false;
				}
			}
			hibernateTemplate.saveOrUpdate(beneficio);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean delete(Beneficio beneficio) {
		try {
			for (Etapa etapa : beneficio.getEtapas()) {
				hibernateTemplate.delete(etapa);
			}
			hibernateTemplate.delete(beneficio);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
