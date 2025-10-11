package service

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDate

class CompetenciaService {

    static void cadastrarCompetencia(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o nome da competencia: "

        String habilidade = input.nextLine()

        String sql = "INSERT INTO competence (skill, createat, updateat) VALUES (?,?,?)"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            query.setString(1, habilidade)
            query.setDate(2,java.sql.Date.valueOf(LocalDate.now()))
            query.setDate(3,java.sql.Date.valueOf(LocalDate.now()))

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao cadastrar a competência"
        }
    }

    static void listarCompetencias(Connection conn) {
        String sql = "SELECT id, skill FROM competence ORDER BY id"

        PreparedStatement query = conn.prepareStatement(sql)
        ResultSet result = query.executeQuery()

        while (result.next()){
            printf("\n\tCompetência ID: %d\n\tCompetência: %s\n - \n", result.getInt("id"), result.getString("skill"))
        }
    }

    static void atualizarCompetencia(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o id da competencia: "
        Integer id = Integer.parseInt(input.nextLine())

        print "\n\tInsira o nome da competencia: "
        String habilidade = input.nextLine()

        String sql = "UPDATE competence SET skill = ?, updateat = ? WHERE id = ?"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            query.setString(1, habilidade)
            query.setDate(2,java.sql.Date.valueOf(LocalDate.now()))
            query.setInt(3,id)

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao atualizar a competência"
        }
    }

    static void deletarCompetencia(Connection conn) {
        Scanner input = new Scanner(System.in)

        print "\n\tInsira o id da competencia: "
        Integer id = Integer.parseInt(input.nextLine())

        String sql = "DELETE FROM competence WHERE id = ?"

        try {
            PreparedStatement query = conn.prepareStatement(sql)
            query.setInt(1, id)

            query.executeUpdate()
        } catch (Exception e){
            println "Erro ao deletar a competência"
        }
    }
}
