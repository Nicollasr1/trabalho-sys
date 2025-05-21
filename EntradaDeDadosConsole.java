package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class EntradaDeDadosConsole implements CommandLineRunner {

    private List<Cadastro> cadastros = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    @Override
    public void run(String... args) throws Exception {
        int opcao;
        do {
            System.out.println("\n Selecione a opção que deseja");
            System.out.println("1 -> Cadastrar Equipamento");
            System.out.println("2 -> Devolução do Equipamento");
            System.out.println("3 -> Histórico Atualizado");
            System.out.println("0 -> Encerrar");

            switch (opcao) {
                case 1 -> cadastrarEquipamentos();
                case 2 -> devolverEquipamento();
                case 3 -> historico();
                case 0 -> System.out.println("Desconectando...");
                default -> System.out.println("Opção Inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarEquipamentos() {
        System.out.println("Nome do funcionário: ");
        String nome = scanner.nextLine();

        String martelo = "Martelo - ID001";
        String oculos = "Óculos de Proteção - ID002";
        String trena = "Trena - ID003";
        String luva = "Luva - ID004";
        String fenda = "Chave de Fenda - ID0005";


        System.out.println("\n Equipamentos Disponíveis:");
        System.out.println(martelo);
        System.out.println(oculos);
        System.out.println(trena);
        System.out.println(luva);
        System.out.println(fenda);

        System.out.println("Digite o código do produto");
        String codigo = scanner.nextLine().toUpperCase();

        String equipamentoSelecionado = null;

        switch (codigo) {
            case "ID001" -> equipamentoSelecionado = martelo;
            case "ID002" -> equipamentoSelecionado = oculos;
            case "ID003" -> equipamentoSelecionado = trena;
            case "ID004" -> equipamentoSelecionado = luva;
            case "ID005" -> equipamentoSelecionado = fenda;
            default -> System.out.println("Código inválido!");
        }
        if (equipamentoSelecionado != null) {
            System.out.println(nome + "pegou " + equipamentoSelecionado);
        }
        cadastros.add(new Cadastro(nome, codigo, equipamentoSelecionado));
    }
        private void devolverEquipamento() {
            if (cadastros.isEmpty()) {
                System.out.println("Nenhum equipamento cadastrado para devolução.");
                return;
            }

            System.out.println("\n EQUIPAMENTOS EMPRESTADOS:");
            boolean algumEmprestado = false;
            for (int i = 0; i < cadastros.size(); i++) {
                Cadastro c = cadastros.get(i);
                if (!c.isDevolvido()) {
                    System.out.println((i + 1) + " - " + c);
                    algumEmprestado = true;
                }
            }
        }




    private void historico() {
        if (cadastros.isEmpty()) {
            System.out.println("Nenhum Equipamento Cadastrado!");
            return;
        }
        System.out.println("\n HISTÓRICO DE CADASTROS  ");
        for (int i = 0; i < cadastros.size(); i++) {
            System.out.println((i + 1) + " - " + cadastros.get(i));
        }
    }


}
