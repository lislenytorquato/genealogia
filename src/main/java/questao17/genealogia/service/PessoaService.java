package questao17.genealogia.service;

import questao17.genealogia.exception.PessoaException;
import questao17.genealogia.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaService {


    private List<Pessoa> pessoas = new ArrayList<>();

    public void criarPessoa(Pessoa pessoaNova){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaNova.getNome());
        pessoa.setIdade(pessoaNova.getIdade());
        pessoa.setPai(pessoaNova.getPai());
        pessoa.setMae(pessoaNova.getMae());
        pessoas.add(pessoa);
    }

    public void deletarPessoa (Pessoa pessoa){
        pessoas.remove(pessoa);
    }
    public List<Pessoa> listarPessoas(){
        return pessoas;
    }
    public String exibirGenealogia(Pessoa pessoa) throws PessoaException {
        String pessoaString = "";
        if (pessoa.getPai() != null && pessoa.getMae() != null){
            pessoaString = pessoa.toString();
        }else if (pessoa.getPai() == null){
            throw new PessoaException("Pai não encontrado");
        }else {
            throw new PessoaException("Mae não encontrada");
        }
        return pessoaString;
    }


}
