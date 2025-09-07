package service

import domain.Pessoa
import domain.PessoaFisica
import domain.PessoaJuridica

class PessoaService {

    static void listarPessoas(List<Pessoa> listaPessoas) {
        listaPessoas.each { pessoa ->
            println "\n\n\t\t-\n"
            println pessoa
        }
    }

    static void cadastrarPessoa(List<Pessoa> pessoasFisicas, List<Pessoa> pessoasJuridicas) {
        Scanner input = new Scanner(System.in)

        println "\n\n\t\tCadastro Menu\n"
        println "\t1 - [Cadastrar Empresas ]"
        println "\t2 - [Cadastrar Candidato]"
        println "\n\t3 - [Voltar]"
        print "\n\tSelecionar: "

        Integer escolha = Integer.parseInt(input.nextLine())

        if (escolha == 3) return
        if (escolha == 1) {
            List competenciasDesejadas = []
            String competencia

            println "\n\tDigite os dados referente a empresa\n"
            print "\tDigite o Nome: "
            String nome = input.nextLine()
            print "\tDigite o Email: "
            String email = input.nextLine()
            print "\tDigite o CNPJ: "
            String cnpj = input.nextLine()
            print "\tDigite o Pais: "
            String pais = input.nextLine()
            print "\tDigite o Estado: "
            String estado = input.nextLine()
            print "\tDigite o CEP: "
            String cep = input.nextLine()
            print "\tDigite a Descrição: "
            String desc = input.nextLine()

            do {
                print "\tDigite as competências desejadas (deixe vazio caso queira para de adicionar): "
                competencia = input.nextLine()
                if (competencia) competenciasDesejadas.add(competencia)
            } while (competencia)


            Pessoa pessoa = new PessoaJuridica(nome: nome, email: email, cnpj: cnpj, pais: pais, estado: estado, cep: cep, desc: desc, competenciasDesejadas: competenciasDesejadas)
            pessoasJuridicas.add(pessoa)
        }
        if (escolha == 2) {
            List competencias = []
            String competencia

            println "\n\tDigite os dados referente ao usuário\n"
            print "\tDigite o Nome: "
            String nome = input.nextLine()
            print "\tDigite o Email: "
            String email = input.nextLine()
            print "\tDigite o CPF: "
            String cpf = input.nextLine()
            print "\tDigite o Idade: "
            Integer idade = Integer.parseInt(input.nextLine())
            print "\tDigite o Estado: "
            String estado = input.nextLine()
            print "\tDigite o CEP: "
            String cep = input.nextLine()
            print "\tDigite a Descrição: "
            String desc = input.nextLine()

            do {
                print "\tDigite suas competências (deixe vazio caso queira para de adicionar): "
                competencia = input.nextLine()
                if (competencia) competencias.add(competencia)
            } while (competencia)

            Pessoa pessoa = new PessoaFisica(nome: nome, email: email, cpf: cpf, idade: idade, estado: estado, cep: cep, desc: desc,competencias:competencias)
            pessoasFisicas.add(pessoa)
        }
    }
}
