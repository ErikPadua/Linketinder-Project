package main.model

class PessoaFisica extends Pessoa {
    String cpf
    Integer idade
    List competencias

    @Override
    String toString(){
        "\tId: $id\n\tNome: $nome\n\tEmail: $email\n\tCPF: $cpf\n\tIdade: $idade\n\tEstado: $estado\n\tCEP: $cep\n\tDescrição: $desc\n\tCompetencias: $competencias"
    }
}
