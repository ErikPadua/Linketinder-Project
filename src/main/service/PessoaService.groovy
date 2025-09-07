package main.service

import main.model.Pessoa
import main.model.PessoaFisica
import main.model.PessoaJuridica
import main.view.EntradaTerminal

class PessoaService {

    static void listarPessoas(List<Pessoa> listaPessoas) {
        listaPessoas.each { pessoa ->
            println "\n\n\t\t-\n"
            println pessoa
        }
    }

    static Pessoa cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica, List<Pessoa> empresas) {
        if (!pessoaJuridica) {
            Scanner input = new Scanner(System.in)
            List competenciasDesejadas = []
            String competencia
            Map dados = EntradaTerminal.dadosCadastroPessoaJuridica()

            while (1) {
                print "\tDigite as competências desejadas (deixe vazio caso queira para de adicionar): "
                competencia = input.nextLine()
                if (competencia) competenciasDesejadas.add(competencia)
                else break;
            }

            Pessoa pessoa = new PessoaJuridica(dados)
            pessoa.competenciasDesejadas = competenciasDesejadas
            pessoa.id = empresas.size()

            empresas.add(pessoa)
            return pessoa

        } else {
            Pessoa pessoa = pessoaJuridica

            empresas.add(pessoa)
            return pessoa
        }
    }

    static Pessoa cadastrarPessoaFisica(PessoaFisica pessoaFisica, List<Pessoa> usuarios) {
        if (!pessoaFisica) {
            Scanner input = new Scanner(System.in)
            List competencias = []
            String competencia
            Map dados = EntradaTerminal.dadosCadastroPessoaFisica()

            print "\tDigite a idade: "
            Integer idade = Integer.parseInt(input.nextLine())

            while (1) {
                print "\tDigite as competências desejadas (deixe vazio caso queira para de adicionar): "
                competencia = input.nextLine()
                if (competencia) competencias.add(competencia)
                else break;
            }

            Pessoa pessoa = new PessoaFisica(dados)
            pessoa.idade = idade
            pessoa.competencias = competencias
            pessoa.id = usuarios.size()

            usuarios.add(pessoa)
            return pessoa

        } else {
            Pessoa pessoa = pessoaFisica

            usuarios.add(pessoa)
            return pessoa
        }
    }
}
