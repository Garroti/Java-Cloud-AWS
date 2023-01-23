package br.com.apiprodutoawscloud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.apiprodutoawscloud.entity.Produto;
import br.com.apiprodutoawscloud.repository.ProdutoRepository;
import br.com.apiprodutoawscloud.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public List<Produto> buscarTodos() {
		return this.produtoRepository.findAll();
	}

	@Override
	public Produto salvar(Produto produto) {
		return this.produtoRepository.save(produto);
	}

	@Override
	public void delete(Long id) {
		try {
			this.produtoRepository.deleteById(id);
		} catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao excluir o produto");
		}
	}
	
}
