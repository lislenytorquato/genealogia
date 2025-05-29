package questao17.genealogia.model;

import java.util.Objects;

public class Pessoa {
    private String nome;
    private Integer idade;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa() {
    }

    public Pessoa(String nome, Integer idade, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.idade = idade;
        this.pai = pai;
        this.mae = mae;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(idade, pessoa.idade) && Objects.equals(nome, pessoa.nome) && Objects.equals(pai, pessoa.pai) && Objects.equals(mae, pessoa.mae);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, pai, mae);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pai=" + pai +
                ", mae=" + mae +
                '}';
    }
}
