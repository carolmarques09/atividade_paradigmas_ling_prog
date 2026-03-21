package com.estoque.controller;

import com.estoque.dao.ProdutoDAO;
import com.estoque.model.Produto;
import com.estoque.util.Validador;

import java.sql.SQLException;
import java.util.List;

public class ProdutoController {

    private ProdutoDAO dao;

    public ProdutoController() {
        this.dao = new ProdutoDAO();
    }

    public void cadastrarProduto(String nome, int quantidade, double preco) {

        if (!Validador.nomeValido(nome)) {
            throw new IllegalArgumentException("Nome inválido!");
        }

        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inválida!");
        }

        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido!");
        }

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);

        dao.inserir(produto);
    }

    public List<Produto> listarProdutos() throws SQLException {
        return dao.listar();
    }

    public void atualizarEstoque(int id, int novaQuantidade) throws SQLException {

        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("Quantidade inválida!");
        }

        dao.atualizarQuantidade(id, novaQuantidade);
    }

    public void removerProduto(int id) throws SQLException {
        dao.deletar(id);
    }

    // chama o DAO (Data Access Object)
}
