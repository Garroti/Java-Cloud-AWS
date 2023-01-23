package br.com.apiprodutoawscloud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.apiprodutoawscloud.entity.Produto;
import br.com.apiprodutoawscloud.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		return ResponseEntity.ok(produtoService.buscarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		var novoProduto = produtoService.salvar(produto);
		return new ResponseEntity<>(novoProduto, null, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		produtoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
