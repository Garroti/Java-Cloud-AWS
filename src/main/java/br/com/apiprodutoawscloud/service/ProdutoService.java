package br.com.apiprodutoawscloud.service;

import java.util.List;

import br.com.apiprodutoawscloud.entity.Produto;

public interface ProdutoService {
	List<Produto> buscarTodos();
	Produto salvar(Produto produto);
	void delete(Long id);
}
