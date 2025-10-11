package service

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDate
import java.time.Period

class CandidatoService {

    static void cadastrarCandidato(Connection conn) {
        Scanner input = new Scanner(System.in)
        ArrayList<String> nomeDados = ["Nome", "Sobrenome", "Data de Nascimento (yyyy-mm-dd)", "Email", "CPF", "Pais", "CEP", "Descrição", "Senha"]
        ArrayList<String> dados = new ArrayList<>()

        nomeDados.each { String nome ->
            printf("\nInsira o seu/sua %s: ", nome)
            dados.add(input.nextLine())
        }

        String sql = "INSERT INTO candidate (name, surname, date_of_birth, email, cpf, country, cep, description, password, createat, updateat) VALUES (?,?,?,?,?,?,?,?,?,?,?)"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            for (int i = 0; i < 9; i++) {
                if (i == 2) query.setDate(i + 1, java.sql.Date.valueOf(dados.get(i)))
                else query.setString(i + 1, dados.get(i))
            }
            query.setDate(10, java.sql.Date.valueOf(LocalDate.now()))
            query.setDate(11, java.sql.Date.valueOf(LocalDate.now()))

            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao cadastrar o candidato"
        }
    }

    static void listarCandidatos(Connection conn) {
        String sql = "SELECT c.id,c.date_of_birth,c.email,c.description,c.country, STRING_AGG(cp.skill, ', ') FROM candidate c LEFT JOIN candidate_competence cc ON c.id = cc.id_candidate LEFT JOIN competence cp ON cc.id_competence = cp.id GROUP BY c.id ORDER BY c.id"
        PreparedStatement query = conn.prepareStatement(sql)
        ResultSet result = query.executeQuery()

        while (result.next()) {
            LocalDate dataNascimento = result.getDate("date_of_birth").toLocalDate()
            int idade = Period.between(dataNascimento, LocalDate.now()).getYears()

            printf("\n\tCandidato ID: %d\n\tIdade: %d\n\tEmail: %s\n\tDescrição: %s\n\tPais: %s\n\tCompetencias: %s\n - \n", result.getInt("id"), idade, result.getString("email"), result.getString("description"), result.getString("country"), result.getString("string_agg"))
        }
    }

    static void atualizarCandidato(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o id do candidato: "
        Integer id = Integer.parseInt(input.nextLine())

        ArrayList<String> nomeDados = ["Nome", "Sobrenome", "Data de Nascimento (yyyy-mm-dd)", "Email", "CPF", "Pais", "CEP", "Descrição", "Senha"]
        ArrayList<String> dados = new ArrayList<>()

        nomeDados.each { String nome ->
            printf("\nInsira o seu/sua %s: ", nome)
            dados.add(input.nextLine())
        }

        String sql = "UPDATE candidate SET name = ?, surname = ?, date_of_birth = ?, email = ?, cpf = ?, country = ?, cep = ?, description = ?, password = ?, updateat = ? WHERE id = ?"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            for (int i = 0; i < 9; i++) {
                if (i == 2) query.setDate(i + 1, java.sql.Date.valueOf(dados.get(i)))
                else query.setString(i + 1, dados.get(i))
            }
            query.setDate(10, java.sql.Date.valueOf(LocalDate.now()))
            query.setInt(11,id)

            query.executeUpdate()
        } catch (Exception e) {
            println "Erro ao atualizar o candidato"
        }
    }

    static void deletarCandidato(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o id do candidato: "
        Integer id = Integer.parseInt(input.nextLine())

        String sql = "DELETE FROM candidate WHERE id = ?"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            query.setInt(1, id)

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao deletar o candidato"
        }
    }
}

