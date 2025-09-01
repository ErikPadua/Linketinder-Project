package domain

class PessoaJuridica extends Pessoa {
    String cnpj
    String pais
    List competenciasDesejadas

    @Override
    String toString(){
        "\tNome: $nome\n\tEmail: $email\n\tCNPJ: $cnpj\n\tPais: $pais\n\tEstado: $estado\n\tCEP: $cep\n\tDescrição: $desc\n\tCompetencias Desejadas: $competenciasDesejadas"
    }
}
