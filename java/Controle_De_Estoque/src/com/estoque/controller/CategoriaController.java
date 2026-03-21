package com.estoque.controller;

import com.estoque.dao.CategoriaDAO;
import com.estoque.model.Categoria;
import com.estoque.util.Validador;

import java.sql.SQLException;
import java.util.List;

public class CategoriaController {

    private CategoriaDAO dao;

    public CategoriaController() {
        this.dao = new CategoriaDAO();
    }

    public void cadastrarCategoria(String nome) throws SQLException {
        if (!Validador.nomeValido(nome)) {
            throw new IllegalArgumentException("Nome inválido!");
        }

        Categoria categoria = new Categoria();
        categoria.setNome(nome);

        dao.inserir(categoria);
    }

    public List<Categoria> listarCategorias() throws SQLException {
        return dao.listar();
    }

    public void deletarCategoria(int id) throws SQLException {
        dao.deletar(id);
    }
}
