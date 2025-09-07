package main.model

class PessoaJuridica extends Pessoa {
    String cnpj
    String pais
    List competenciasDesejadas

    @Override
    String toString(){
        "\tId: $id\n\tNome: $nome\n\tEmail: $email\n\tCNPJ: $cnpj\n\tPais: $pais\n\tEstado: $estado\n\tCEP: $cep\n\tDescrição: $desc\n\tCompetencias Desejadas: $competenciasDesejadas"
    }
}
