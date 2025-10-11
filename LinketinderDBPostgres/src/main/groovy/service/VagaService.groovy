package service

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDate

class VagaService {

    static void cadastrarVaga(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o ID da empresa: "
        Integer id = Integer.parseInt(input.nextLine())

        ArrayList<String> nomeDados = ["Nome", "Descrição", "Estado", "Cidade"]
        ArrayList<String> dados = new ArrayList<>()

        nomeDados.each { String nome ->
            printf("\nInsira o seu/sua %s: ", nome)
            dados.add(input.nextLine())
        }

        String sql = "INSERT INTO vacancy (name, description, state, city, id_company, createat, updateat) VALUES (?,?,?,?,?,?,?)"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            for (int i = 0; i < 4; i++) {
                query.setString(i + 1, dados.get(i))
            }
            query.setInt(5,id)
            query.setDate(6,java.sql.Date.valueOf(LocalDate.now()))
            query.setDate(7,java.sql.Date.valueOf(LocalDate.now()))

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao cadastrar a vaga"
        }
    }

    static void listarVagas(Connection conn) {
        String sql = "SELECT co.name AS company, v.id,v.name,v.description,v.state,v.city, STRING_AGG(c.skill, ', ') FROM vacancy v LEFT JOIN vacancy_competence vc ON v.id = vc.id_vacancy  LEFT JOIN competence c ON vc.id_competence = c.id LEFT JOIN company co ON co.id = v.id_company GROUP BY v.id, co.name ORDER BY v.id"
        PreparedStatement query = conn.prepareStatement(sql)
        ResultSet result = query.executeQuery()

        while (result.next()) {
            printf("\n\tVaga ID: %d\n\tEmpresa: %s\n\tVaga: %s\n\tDescrição: %s\n\tLocal: %s,%s\n\tCompetencias Desejadas: %s\n - \n", result.getInt("id"), result.getString("company"), result.getString("name"), result.getString("description"), result.getString("city"), result.getString("state"), result.getString("string_agg"))
        }
    }

    static void atualizarVaga(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o ID da vaga: "
        Integer id = Integer.parseInt(input.nextLine())

        print "\n\tInsira o ID da empresa: "
        Integer idEmpresa = Integer.parseInt(input.nextLine())

        ArrayList<String> nomeDados = ["Nome", "Descrição", "Estado", "Cidade"]
        ArrayList<String> dados = new ArrayList<>()

        nomeDados.each { String nome ->
            printf("\nInsira o seu/sua %s: ", nome)
            dados.add(input.nextLine())
        }

        String sql = "UPDATE vacancy SET name = ?, description = ?, state = ?, city = ?, id_company = ?, updateat = ? WHERE id = ?"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            for (int i = 0; i < 4; i++) {
                query.setString(i + 1, dados.get(i))
            }
            query.setInt(5,idEmpresa)
            query.setDate(6,java.sql.Date.valueOf(LocalDate.now()))
            query.setInt(7,id)

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao atualizar a vaga"
        }
    }

    static void deletarVaga(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o id da vaga: "
        Integer id = Integer.parseInt(input.nextLine())

        String sql = "DELETE FROM vacancy WHERE id = ?"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            query.setInt(1, id)

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao deletar a vaga"
        }
    }
}
