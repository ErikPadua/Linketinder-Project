package test

import main.model.Pessoa
import main.model.PessoaFisica
import main.model.PessoaJuridica
import main.service.PessoaService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PessoaServiceTest {

    @Test
    void testCadastrarEmpresa() {
        List<Pessoa> mockPessoasJuridicas = []
        Pessoa empresa = new PessoaJuridica(id: 0,nome:"EmpresaTest", email: "et@et.com.br",cnpj: "0000001-00",pais: "Brasil",estado: "MG",cep: "000001",desc: "Descrição EmpresaTest",competenciasDesejadas: ["competencia 1", "competencia 2", "competencia 3"])

        PessoaService.cadastrarPessoaJuridica(empresa,mockPessoasJuridicas)

        Assertions.assertEquals(empresa,mockPessoasJuridicas.get(0))
        Assertions.assertTrue(mockPessoasJuridicas.size() == 1)
        Assertions.assertTrue(mockPessoasJuridicas.get(0).id == 0)
        Assertions.assertTrue(mockPessoasJuridicas.get(0).nome == "EmpresaTest")
    }

    @Test
    void testCadastrarUsuario() {
        List<Pessoa> mockPessoasFisicas = []
        Pessoa usuario = new PessoaFisica(id: 0,nome: "UsuarioTest", email: "ut@gmail.com", cpf: "00000000001", idade: 50, estado: "GO", cep: "00000002", desc: "Descrição UsuarioTest", competencias: ["competencia 1", "competencia 2"])

        PessoaService.cadastrarPessoaFisica(usuario,mockPessoasFisicas)

        Assertions.assertEquals(usuario,mockPessoasFisicas.get(0))
        Assertions.assertTrue(mockPessoasFisicas.size() == 1)
        Assertions.assertTrue(mockPessoasFisicas.get(0).id == 0)
        Assertions.assertTrue(mockPessoasFisicas.get(0).nome == "UsuarioTest")
    }

}
