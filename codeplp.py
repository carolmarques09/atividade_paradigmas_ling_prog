# Controle de Estoque

import mysql.connector

from tkinter import *
from tkinter import ttk

def init_prog():

    # colors
    azul = "#0394fc"
    branco = "#ffffff"
    preto = "#000000"
    vermelho =  "##d92316"
    verde = "##30d927"

    

# Conexão com o MySQL

try:

    conn = mysql.connector.connect(
        user='root',
        password='whyblu3',
        host='localhost:8080',
        database='estoque_discos'
    )

    if conn.is_connected():
        print("Conectado com sucesso!")
        cursor = conn.cursor()
        cursor.execute("SELECT DATABASE();")
        record = cursor.fetchone()
        print(f"Connected to database: {record}")

except mysql.connector.Error as err:
    print(f"Error: {err}")
finally:
    if 'conn' in locals() and conn.is_connected():
        cursor.close()
        conn.close()

estoque = {}

def adicionar_produto(nome, quantidade):
    estoque[nome] = estoque.get(nome, 0) + quantidade
    print(f"{nome} adicionado. Estoque: {estoque[nome]}")

def vender_produto(nome, quantidade):
    if nome in estoque and estoque[nome] >= quantidade:
        estoque[nome] -= quantidade
        print(f"{nome} vendido. Estoque: {estoque[nome]}")
    else:
        print("Estoque insuficiente ou produto inexistente.")

# adicionar_produto(estoque)
# vender_produto(estoque)

def alterar_produto(nome, quantidade):
    id_busca = int(input("Digite o ID do produto que deseja alterar: "))

    produto_encontrado = None
    for produto in nome and quantidade:
        if produto["id"] == id_busca:
            produto_encontrado = produto
            break

    if produto_encontrado:
        print(f"Produto encontrado: {produto_encontrado}")
        novo_nome = input(f"Novo nome ({produto_encontrado['nome']}): ")
        nova_quantidade = int(input(f"Nova quantidade ({produto_encontrado['quantidade']}): "))
        novo_preco = float(input(f"Novo preço ({produto_encontrado['preco']}): "))

        produto_encontrado['nome'] = novo_nome if novo_nome else produto_encontrado['nome']
        produto_encontrado['quantidade'] = nova_quantidade
        produto_encontrado['preco'] = novo_preco

        print("Produto alterado com sucesso!")
    else:
        print("Produto não encontrado no estoque.")

# Testando a função
# alterar_produto(estoque)
# print(estoque)