package service

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDate

class EmpresaService {

    static void cadastrarEmpresa(Connection conn) {
        Scanner input = new Scanner(System.in)
        ArrayList<String> nomeDados = ["Nome", "CNPJ", "Email", "Descrição", "Pais", "CEP", "Senha"]
        ArrayList<String> dados = new ArrayList<>()

        nomeDados.each { String nome ->
            printf("\nInsira o seu/sua %s: ", nome)
            dados.add(input.nextLine())
        }

        String sql = "INSERT INTO company (name, cnpj, email, description, country, cep, password, createat, updateat) VALUES (?,?,?,?,?,?,?,?,?)"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            for (int i = 0; i < 7; i++) {
                query.setString(i + 1, dados.get(i))
            }
            query.setDate(8,java.sql.Date.valueOf(LocalDate.now()))
            query.setDate(9,java.sql.Date.valueOf(LocalDate.now()))

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao cadastrar o empresa"
        }

    }

    static void listarEmpresas(Connection conn) {
        String sql = "SELECT id, name, cnpj, email, description, country, cep FROM company ORDER BY id"

        PreparedStatement query = conn.prepareStatement(sql)
        ResultSet result = query.executeQuery()

        while (result.next()) {
            printf("\n\tEmpresa ID: %d\n\tEmpresa: %s\n\tCNPJ: %s\n\tEmail: %s\n\tDescrição: %s\n\tPais: %s\n\tCEP: %s\n - \n", result.getInt("id"), result.getString("name"), result.getString("cnpj"), result.getString("email"), result.getString("description"), result.getString("country"), result.getString("cep"))
        }
    }

    static void atualizarEmpresa(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o id da empresa: "
        Integer id = Integer.parseInt(input.nextLine())

        ArrayList<String> nomeDados = ["Nome", "CNPJ", "Email", "Descrição", "Pais", "CEP", "Senha"]
        ArrayList<String> dados = new ArrayList<>()

        nomeDados.each { String nome ->
            printf("\nInsira o seu/sua %s: ", nome)
            dados.add(input.nextLine())
        }

        String sql = "UPDATE company SET name = ?, cnpj = ?, email = ?, description = ?, country = ?, cep = ?, password = ?, updateat = ? WHERE id = ?"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            for (int i = 0; i < 7; i++) {
                query.setString(i + 1, dados.get(i))
            }
            query.setDate(8,java.sql.Date.valueOf(LocalDate.now()))
            query.setInt(9,id)

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao atualiza a empresa"
        }
    }

    static void deletarEmpresa(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o id da empresa: "
        Integer id = Integer.parseInt(input.nextLine())

        String sql = "DELETE FROM company WHERE id = ?"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            query.setInt(1, id)

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao deletar a empresa"
        }
    }
}
