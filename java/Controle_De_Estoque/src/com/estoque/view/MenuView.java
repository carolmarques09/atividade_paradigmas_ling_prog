package com.estoque.view;

import com.estoque.controller.ProdutoController;
import java.util.Scanner;

public class MenuView {

    private final Scanner scanner = new Scanner(System.in);
    private final ProdutoController produtoController = new ProdutoController();

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarProduto() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        produtoController.cadastrarProduto(nome, quantidade, preco);
    }

    private void listarProdutos() {
        produtoController.listarProdutos();
    }
}