package com.estoque.view;

import com.estoque.controller.ProdutoController;
import java.util.Scanner;

public class ProdutoView {

    public void mostrarCadastro() {
        Scanner sc = new Scanner(System.in);
        ProdutoController controller = new ProdutoController();

        try {
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            controller.cadastrarProduto(nome, quantidade, preco);

            System.out.println("Produto cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}