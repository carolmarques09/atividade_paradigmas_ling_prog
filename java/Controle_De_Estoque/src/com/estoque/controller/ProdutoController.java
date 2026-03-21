package com.estoque.controller;

import com.estoque.dao.ProdutoDAO;
import com.estoque.model.Produto;
import com.estoque.util.Validador;

import java.util.List;

public class ProdutoController {

    private ProdutoDAO dao;

    public ProdutoController() {
        this.dao = new ProdutoDAO();
    }

    public void cadastrarProduto(String nome, int quantidade, double preco) {

        try {
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

            System.out.println("Produto cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    public void listarProdutos() {
        try {
            List<Produto> lista = dao.listar();

            if (lista.isEmpty()) {
                System.out.println("Nenhum produto cadastrado.");
                return;
            }

            for (Produto p : lista) {
                System.out.println("ID: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Quantidade: " + p.getQuantidade());
                System.out.println("Preço: " + p.getPreco());
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
    }

    public void atualizarEstoque(int id, int novaQuantidade) {

        try {
            if (novaQuantidade < 0) {
                throw new IllegalArgumentException("Quantidade inválida!");
            }

            dao.atualizarQuantidade(id, novaQuantidade);

            System.out.println("Estoque atualizado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Erro ao atualizar estoque: " + e.getMessage());
        }
    }

    public void removerProduto(int id) {

        try {
            dao.deletar(id);
            System.out.println("Produto removido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao remover produto: " + e.getMessage());
        }
    }
}