package main.view

import main.model.Pessoa
import main.model.PessoaFisica
import main.model.PessoaJuridica
import main.service.PessoaService

class Menu {

    static void startMenu(){
        Pessoa candidato1 = new PessoaFisica(id: 0,nome: "Robson", email: "robson@gmail.com", cpf: "123123124", idade: 31, estado: "MT", cep: "32351", desc: "Trabalho com angular e java", competencias: ["Angular", "Java"])
        Pessoa candidato2 = new PessoaFisica(id: 1,nome: "Chico", email: "chico@gmail.com", cpf: "435551512", idade: 21, estado: "GO", cep: "21414", desc: "Trabalho com python e spring", competencias: ["Python", "Spring Framework"])
        Pessoa candidato3 = new PessoaFisica(id: 2,nome: "Morgana", email: "morgana@gmail.com", cpf: "7959569656", idade: 19, estado: "RJ", cep: "55254", desc: "Trabalho com javascript e delphin", competencias: ["Javascript", "Delphin"])
        Pessoa candidato4 = new PessoaFisica(id: 3,nome: "Bjorn", email: "bjorn@gmail.com", cpf: "785685674", idade: 43, estado: "SC", cep: "454634", desc: "Trabalho com Golang e possuo certificações oracle", competencias: ["Golang", "Oracle"])
        Pessoa candidato5 = new PessoaFisica(id: 4,nome: "Douglas", email: "douglas@gmail.com", cpf: "57457454", idade: 29, estado: "GO", cep: "796796", desc: "Trabalho com rust e c++", competencias: ["Rust", "C++"])

        Pessoa empresa1 = new PessoaJuridica(id: 0,nome:"Seu Zé LTDA", email: "seuze@seuze.com.br",cnpj: "34581591827-53",pais: "Brasil",estado: "MG",cep: "352352",desc: "Preciso de desenvolvedor python,java e c++",competenciasDesejadas: ["Python", "Java", "C++"])
        Pessoa empresa2 = new PessoaJuridica(id: 1,nome:"Amazon", email: "amazon@amazon.com",cnpj: "3532623623-43",pais: "EUA",estado: "NY",cep: "35125151",desc: "Preciso de desenvolvedor rust,oracle e angular",competenciasDesejadas: ["Rust","Oracle","Angular"])
        Pessoa empresa3 = new PessoaJuridica(id: 2,nome:"Ave Transportes", email: "ave@ave.com.br",cnpj: "35235235-64",pais: "Brasil",estado: "SP",cep: "57457453",desc: "Preciso de desenvolvedor c e delphin",competenciasDesejadas: ["C","Delphin"])
        Pessoa empresa4 = new PessoaJuridica(id: 3,nome:"Oracle", email: "oracle@oracle.com.br",cnpj: "3532532-42",pais: "Brasil",estado: "AM",cep: "7955454",desc: "Preciso de desenvolvedor java e spring",competenciasDesejadas: ["Java","Spring"])
        Pessoa empresa5 = new PessoaJuridica(id: 4,nome:"Ifood", email: "ifood@ifood.com.br",cnpj: "42421412-32",pais: "Brasil",estado: "SP",cep: "36347324",desc: "Preciso de desenvolvedor golang",competenciasDesejadas: ["Golang"])

        List<Pessoa> pessoasFisicas = [candidato1, candidato2, candidato3, candidato4, candidato5]
        List<Pessoa> pessoasJuridicas = [empresa1,empresa2,empresa3,empresa4,empresa5]

        Integer escolha
        Scanner input = new Scanner(System.in)

        while (1){
            mostrarMenu()
            escolha = Integer.parseInt(input.nextLine())

            if (escolha == 1) PessoaService.listarPessoas(pessoasJuridicas)
            if (escolha == 2) PessoaService.listarPessoas(pessoasFisicas)
            if (escolha == 3) {
                while (1) {
                    mostrarMenuCadastrar()
                    escolha = Integer.parseInt(input.nextLine())

                    if(escolha == 1) PessoaService.cadastrarPessoaJuridica(null,pessoasJuridicas)
                    if(escolha == 2) PessoaService.cadastrarPessoaFisica(null,pessoasFisicas)
                    if(escolha == 3) break
                }
            }
            if(escolha == 4) break
        }
    }

     static void mostrarMenu(){
        println "\n\n\t\tLinkeTinder Menu\n"
        println "\t1 - [Listar Empresas ]"
        println "\t2 - [Listar Candidato]"
        println "\t3 - [Criar Cadastro  ]"
        println "\n\t4 - [Sair]"
        print "\n\tSelecionar: "
    }

    static void mostrarMenuCadastrar(){
        println "\n\n\t\tCadastro Menu\n"
        println "\t1 - [Cadastrar Empresas ]"
        println "\t2 - [Cadastrar Candidato]"
        println "\n\t3 - [Voltar]"
        print "\n\tSelecionar: "
    }
}
