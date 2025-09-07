package main.view

class EntradaTerminal {

    static LinkedHashMap<String,String> dadosCadastroPessoaJuridica(){
        List<String> keys = ["nome", "email", "cnpj", "pais", "estado", "cep", "desc"]
        Map<String,String> request = new LinkedHashMap()
        Scanner input = new Scanner(System.in)

        println "\n\tDigite os dados referente a empresa\n"
        keys.each { key ->
            print "\tDigite o ${key}: "
            request[key] = input.nextLine()
        }

        return request
    }

    static LinkedHashMap<String,String> dadosCadastroPessoaFisica(){
        List<String> keys = ["nome", "email", "cpf", "estado", "cep", "desc"]
        Map<String,String> request = new LinkedHashMap()
        Scanner input = new Scanner(System.in)

        println "\n\tDigite os dados referente ao usuário\n"
        keys.each { key ->
            print "\tDigite o ${key}: "
            request[key] = input.nextLine()
        }

        return request
    }
}
