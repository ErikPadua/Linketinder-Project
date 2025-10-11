package view

import service.CandidatoService
import service.CompetenciaService
import service.EmpresaService
import service.VagaService

import java.sql.Connection

class Menu {

    static void startMenu(Connection conn) {

        Integer escolha
        Scanner input = new Scanner(System.in)

        while (1) {
            menuInicial()
            escolha = Integer.parseInt(input.nextLine())

            if (escolha == 1) {
                while (1) {
                    menuEmpresa()
                    escolha = Integer.parseInt(input.nextLine())

                    if (escolha == 1) EmpresaService.cadastrarEmpresa(conn)
                    if (escolha == 2) EmpresaService.listarEmpresas(conn)
                    if (escolha == 3) EmpresaService.atualizarEmpresa(conn)
                    if (escolha == 4) EmpresaService.deletarEmpresa(conn)
                    if (escolha == 5) break
                }
                escolha = 0
            }

            if (escolha == 2) {
                while (1) {
                    menuCandidato()
                    escolha = Integer.parseInt(input.nextLine())

                    if (escolha == 1) CandidatoService.cadastrarCandidato(conn)
                    if (escolha == 2) CandidatoService.listarCandidatos(conn)
                    if (escolha == 3) CandidatoService.atualizarCandidato(conn)
                    if (escolha == 4) CandidatoService.deletarCandidato(conn)
                    if (escolha == 5) break
                }
                escolha = 0
            }

            if (escolha == 3) {
                while (1) {
                    menuVaga()
                    escolha = Integer.parseInt(input.nextLine())

                    if (escolha == 1) VagaService.cadastrarVaga(conn)
                    if (escolha == 2) VagaService.listarVagas(conn)
                    if (escolha == 3) VagaService.atualizarVaga(conn)
                    if (escolha == 4) VagaService.deletarVaga(conn)
                    if (escolha == 5) break
                }
                escolha = 0
            }

            if (escolha == 4) {
                while (1) {
                    menuCompetencia()
                    escolha = Integer.parseInt(input.nextLine())

                    if (escolha == 1) CompetenciaService.cadastrarCompetencia(conn)
                    if (escolha == 2) CompetenciaService.listarCompetencias(conn)
                    if (escolha == 3) CompetenciaService.atualizarCompetencia(conn)
                    if (escolha == 4) CompetenciaService.deletarCompetencia(conn)
                    if (escolha == 5) break
                }
                escolha = 0
            }


            if (escolha == 5) break
        }
    }

    static void menuInicial() {
        println "\n\n\t\tLinkeTinder\n"
        println "\t1 - [Menu Empresa]"
        println "\t2 - [Menu Candidato]"
        println "\t3 - [Menu Vaga]"
        println "\t4 - [Menu Competência]"
        println "\n\t5 - [Sair]"
        print "\n\tSelecionar: "
    }

    static void menuEmpresa() {
        println "\n\n\t\tLinkeTinder Empresa\n"
        println "\t1 - [Cadastrar]"
        println "\t2 - [Listar]"
        println "\t3 - [Atualizar]"
        println "\t4 - [Deletar]"
        println "\n\t5 - [Voltar]"
        print "\n\tSelecionar: "
    }

    static void menuCandidato() {
        println "\n\n\t\tLinkeTinder Candidato\n"
        println "\t1 - [Cadastrar]"
        println "\t2 - [Listar]"
        println "\t3 - [Atualizar]"
        println "\t4 - [Deletar]"
        println "\n\t5 - [Voltar]"
        print "\n\tSelecionar: "
    }

    static void menuVaga() {
        println "\n\n\t\tLinkeTinder Vaga\n"
        println "\t1 - [Cadastrar]"
        println "\t2 - [Listar]"
        println "\t3 - [Atualizar]"
        println "\t4 - [Deletar]"
        println "\n\t5 - [Voltar]"
        print "\n\tSelecionar: "
    }

    static void menuCompetencia() {
        println "\n\n\t\tLinkeTinder Competência\n"
        println "\t1 - [Cadastrar]"
        println "\t2 - [Listar]"
        println "\t3 - [Atualizar]"
        println "\t4 - [Deletar]"
        println "\n\t5 - [Voltar]"
        print "\n\tSelecionar: "
    }

}

