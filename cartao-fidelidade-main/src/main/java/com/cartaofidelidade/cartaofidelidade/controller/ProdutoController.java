package com.cartaofidelidade.cartaofidelidade.controller;

import com.cartaofidelidade.cartaofidelidade.exceptions.RegraNegocioException;
import com.cartaofidelidade.cartaofidelidade.model.Loja;
import com.cartaofidelidade.cartaofidelidade.model.Produto;
import com.cartaofidelidade.cartaofidelidade.service.impl.ProdutoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    public ProdutoServiceImpl produtoService;

    public ProdutoController(ProdutoServiceImpl produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> salvarProduto(@RequestBody Produto produto) {
        Loja loja = null;
        try {
            Produto produtoSalvo = produtoService.cadastrarProduto(produto, loja);
            return new ResponseEntity(produtoSalvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<String> excluirProduto(@PathVariable Long id) {
        try {
            Produto produto = produtoService.buscarProdutoPorId(id);
            Loja loja = produtoService.obterLojaDoProduto(produto);
            produtoService.excluirProduto(produto, loja);
            String mensagem = "Produto excluído com sucesso";
            return ResponseEntity.ok(mensagem);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/alterar")
    public ResponseEntity<?> alterarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        try {
            Produto produtoExistente = produtoService.buscarProdutoPorId(id);
            if (produtoExistente == null) {
                return ResponseEntity.notFound().build();
            }
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setValor(produto.getValor());
            Produto produtoAtualizado = produtoService.cadastrarProduto(produtoExistente, produtoExistente.getLoja());

            return ResponseEntity.ok(produtoAtualizado);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}



