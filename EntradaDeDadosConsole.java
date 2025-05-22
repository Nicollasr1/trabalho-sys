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

        int opcao = -1;
        do {
            System.out.println("\nSelecione a opção que deseja");
            System.out.println("1 -> Cadastrar Equipamento");
            System.out.println("2 -> Devolução do Equipamento");
            System.out.println("3 -> Histórico Atualizado");
            System.out.println("0 -> Encerrar");
            opcao = scanner.nextInt();
            scanner.nextLine();


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

        String martelo = "Martelo";
        String oculos = "Óculos de Proteção";
        String trena = "Trena";
        String luva = "Luva";
        String fenda = "Chave de Fenda";


        System.out.println("\n Equipamentos Disponíveis:");
        System.out.println(martelo + " | Id: 1");
        System.out.println(oculos + " | Id: 2");
        System.out.println(trena + " | Id: 3");
        System.out.println(luva + " | Id: 4");
        System.out.println(fenda + " | Id: 5");


        System.out.println("\n Digite o código do produto:");
        String codigo = scanner.nextLine().toUpperCase();

        String equipamentoSelecionado = null;

        switch (codigo) {
            case "1" -> equipamentoSelecionado = martelo;
            case "2" -> equipamentoSelecionado = oculos;
            case "3" -> equipamentoSelecionado = trena;
            case "4" -> equipamentoSelecionado = luva;
            case "5" -> equipamentoSelecionado = fenda;
            default -> System.out.println("Código inválido!");
        }
        if (equipamentoSelecionado != null) {
            System.out.println(nome + " pegou " + equipamentoSelecionado);
            cadastros.add(new Cadastro(nome, codigo, equipamentoSelecionado));
        }

    }

        private void devolverEquipamento() {
            if (cadastros.isEmpty()) {
                System.out.println("Nenhum equipamento cadastrado para devolução.");
                return;
            }

            System.out.println("\n EQUIPAMENTOS EMPRESTADOS:");
            boolean algumEmprestado = false;

            for (Cadastro c : cadastros) {
                if (!c.isDevolvido()) {
                    System.out.println(c);
                    algumEmprestado = true;
                }
            }
            if (!algumEmprestado) {
                System.out.println("Todos os equipamentos já foram devolvidos.");
                return;
            }

            System.out.println("Informe o nome do funcionário: ");
            String nome = scanner.nextLine();

            System.out.println("Informe o código do equipamento que deseja devolver: ");
            String equipamento = scanner.nextLine().toUpperCase();

            boolean encontrado = false;

            for (Cadastro c : cadastros) {
                if (c.getNome().equalsIgnoreCase(nome) && c.getCodigo().equals(equipamento) && !c.isDevolvido()) {
                    c.setDevolvido(true);
                    System.out.println("Equipamento devolvido com sucesso!");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Equipamento não encontrado ou já devolvido!");
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
