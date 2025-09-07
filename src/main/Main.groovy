//Erik de Oliveira Pádua

import domain.Pessoa
import domain.PessoaFisica
import domain.PessoaJuridica
import service.PessoaService

Scanner input = new Scanner(System.in)
escolha = 0;

Pessoa candidato1 = new PessoaFisica(nome: "Robson", email: "robson@gmail.com", cpf: "123123124", idade: 31, estado: "MT", cep: "32351", desc: "Trabalho com angular e java", competencias: ["Angular", "Java"])
Pessoa candidato2 = new PessoaFisica(nome: "Chico", email: "chico@gmail.com", cpf: "435551512", idade: 21, estado: "GO", cep: "21414", desc: "Trabalho com python e spring", competencias: ["Python", "Spring Framework"])
Pessoa candidato3 = new PessoaFisica(nome: "Morgana", email: "morgana@gmail.com", cpf: "7959569656", idade: 19, estado: "RJ", cep: "55254", desc: "Trabalho com javascript e delphin", competencias: ["Javascript", "Delphin"])
Pessoa candidato4 = new PessoaFisica(nome: "Bjorn", email: "bjorn@gmail.com", cpf: "785685674", idade: 43, estado: "SC", cep: "454634", desc: "Trabalho com Golang e possuo certificações oracle", competencias: ["Golang", "Oracle"])
Pessoa candidato5 = new PessoaFisica(nome: "Douglas", email: "douglas@gmail.com", cpf: "57457454", idade: 29, estado: "GO", cep: "796796", desc: "Trabalho com rust e c++", competencias: ["Rust", "C++"])

Pessoa empresa1 = new PessoaJuridica(nome:"Seu Zé LTDA", email: "seuze@seuze.com.br",cnpj: "34581591827-53",pais: "Brasil",estado: "MG",cep: "352352",desc: "Preciso de desenvolvedor python,java e c++",competenciasDesejadas: ["Python","Java","C++"])
Pessoa empresa2 = new PessoaJuridica(nome:"Amazon", email: "amazon@amazon.com",cnpj: "3532623623-43",pais: "EUA",estado: "NY",cep: "35125151",desc: "Preciso de desenvolvedor rust,oracle e angular",competenciasDesejadas: ["Rust","Oracle","Angular"])
Pessoa empresa3 = new PessoaJuridica(nome:"Ave Transportes", email: "ave@ave.com.br",cnpj: "35235235-64",pais: "Brasil",estado: "SP",cep: "57457453",desc: "Preciso de desenvolvedor c e delphin",competenciasDesejadas: ["C","Delphin"])
Pessoa empresa4 = new PessoaJuridica(nome:"Oracle", email: "oracle@oracle.com.br",cnpj: "3532532-42",pais: "Brasil",estado: "AM",cep: "7955454",desc: "Preciso de desenvolvedor java e spring",competenciasDesejadas: ["Java","Spring"])
Pessoa empresa5 = new PessoaJuridica(nome:"Ifood", email: "ifood@ifood.com.br",cnpj: "42421412-32",pais: "Brasil",estado: "SP",cep: "36347324",desc: "Preciso de desenvolvedor golang",competenciasDesejadas: ["Golang"])

List<Pessoa> pessoasFisicas = [candidato1, candidato2, candidato3, candidato4, candidato5]
List<Pessoa> pessoasJuridicas = [empresa1,empresa2,empresa3,empresa4,empresa5]

do {
    println "\n\n\t\tLinkeTinder Menu\n"
    println "\t1 - [Listar Empresas ]"
    println "\t2 - [Listar Candidato]"
    println "\t3 - [Criar Cadastro  ]"
    println "\n\t4 - [Sair]"
    print "\n\tSelecionar: "

    escolha = input.nextInt()

    if(escolha == 1) PessoaService.listarPessoas(pessoasJuridicas)
    if(escolha == 2) PessoaService.listarPessoas(pessoasFisicas)
    if(escolha == 3) PessoaService.cadastrarPessoa(pessoasFisicas,pessoasJuridicas)


} while (escolha != 4)


