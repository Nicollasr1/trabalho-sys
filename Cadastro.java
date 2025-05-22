package com.example.demo;

public class Cadastro {
    private String nome;
    private String codigo;
    private String equipamentoSelecionado;
    private boolean devolvido = false;

    public Cadastro(String nome, String codigo, String equipamentoSelecionado) {
        this.nome = nome;
        this.codigo = codigo;
        this.equipamentoSelecionado = equipamentoSelecionado;
        this.devolvido = false;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getEquipamentoSelecionado() {return equipamentoSelecionado;}
    public void setEquipamentoSelecionado(String equipamentoSelecionado) {this.equipamentoSelecionado = equipamentoSelecionado;}

    public boolean isDevolvido() { return devolvido; }
    public void setDevolvido(boolean devolvido) { this.devolvido = devolvido;}

    @Override
    public String toString() { return "Funcionário: " + nome + " | Equipamento: " + equipamentoSelecionado + " | Código: " + codigo + " | Devolvido: " + (devolvido ? "Sim" : "Não");
    }

}
