package br.com.ideais.estagio.service;

import java.util.List;

public  interface AbstractService<T> {

	public boolean delete(Long id);

	public T findbyId(Long id);

	public List<T> list();

	public boolean saveOrUpdate(T t);

	public void persist(T t);
}
