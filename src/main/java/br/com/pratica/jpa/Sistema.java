package br.com.pratica.jpa;

import java.util.List;

import br.com.pratica.jpa.dao.AlunoDAO;
import br.com.pratica.jpa.dao.CarroDAO;
import br.com.pratica.jpa.dao.ClienteDAO;
import br.com.pratica.jpa.dao.CursoDAO;
import br.com.pratica.jpa.dao.CursoRegistroDAO;
import br.com.pratica.jpa.dao.DAO;
import br.com.pratica.jpa.dao.EnderecoDAO;
import br.com.pratica.jpa.models.Aluno;
import br.com.pratica.jpa.models.Carro;
import br.com.pratica.jpa.models.Cliente;
import br.com.pratica.jpa.models.Curso;
import br.com.pratica.jpa.models.CursoRegistro;
import br.com.pratica.jpa.models.Endereco;

public class Sistema {
	
//	private static void msg(String msg) {
//		System.out.println(msg);
//	}
	
	// Separar informa√ß√£o no console
	private static void msg2() {
		System.out.println(" - - - - - ");
	}

	public static void main(String[] args) {
		
		popularBancoDeDados();
		
		ClienteDAO clienteDAO = new ClienteDAO(Cliente.class);
		EnderecoDAO enderecoDAO = new EnderecoDAO(Endereco.class);
		CarroDAO carroDAO = new CarroDAO(Carro.class);
		CursoDAO cursoDAO = new CursoDAO(Curso.class);
		AlunoDAO alunoDAO = new AlunoDAO(Aluno.class);
		CursoRegistroDAO cursoRegistroDAO = new CursoRegistroDAO();
		
		msg2();
		
		List<Cliente> clientes = clienteDAO.obterTodosClientes();
		clienteDAO.fechar();
		
		List<Endereco> enderecos = enderecoDAO.obterTodosEnderecos();
		enderecoDAO.fechar();
		
		List<Carro> carros = carroDAO.obterTodosCarros();
		carroDAO.fechar();
		
		List<Curso> cursos = cursoDAO.obterTodosCursos();
		cursoDAO.fechar();
		
		List<Aluno> alunos = alunoDAO.obterTodosAlunos();
		alunoDAO.fechar();
		
		List<CursoRegistro> cursoRegistros = cursoRegistroDAO.obterTodosRegistros();
		cursoDAO.fechar();
		
		msg2();

		System.out.println("N∫ DE CLIENTES: " + clientes.size());
		System.out.println("N∫ DE ENDERECOS: " + enderecos.size());
		System.out.println("N∫ DE CARROS: " + carros.size());
		System.out.println("N∫ DE CURSOS: " + cursos.size());
		System.out.println("N∫ DE ALUNOS: " + alunos.size());
		System.out.println("N∫ DE CURSOS-REGISTROS: " + cursoRegistros.size());
		
		msg2();
		
	}

	private static void popularBancoDeDados() {
		
		Cliente cliente = new Cliente("Kelly", "56894");
		Cliente cliente2 = new Cliente("Fernando", "95684");
		Cliente cliente3 = new Cliente("Julia", "94515");
		Cliente cliente4 = new Cliente("Amanda", "19458");
		Cliente cliente5 = new Cliente("Helio", "65455");
		Cliente cliente6 = new Cliente("Gustavo", "48312");
		Cliente cliente7 = new Cliente("Giovana", "88516");
		
		Endereco endereco = new Endereco("81561-784", cliente);
		Endereco endereco2 = new Endereco("74891-150", cliente2);
		Endereco endereco3 = new Endereco("45685-205", cliente3);
		Endereco endereco4 = new Endereco("89401-904", cliente4);
		Endereco endereco5 = new Endereco("58905-156", cliente5);
		Endereco endereco6 = new Endereco("34861-568", cliente6);
		Endereco endereco7 = new Endereco("54806-584", cliente7);
		
		Carro carro = new Carro("Palio", "FIAT", "ABC-1234", cliente);
		Carro carro2 = new Carro("Civic", "HONDA", "DEF-9876", cliente);
		Carro carro3 = new Carro("UNO", "FIAT", "HAD-5182", cliente2);
		Carro carro4 = new Carro("Corolla", "HONDA", "FAD-1548", cliente3);
		Carro carro5 = new Carro("UNO", "FIAT", "JWX-1590", cliente3);
		Carro carro6 = new Carro("Palio", "FIAT", "YBJ-6482", cliente4);
		Carro carro7 = new Carro("Corolla", "HONDA", "LKA-3080", cliente5);
		Carro carro8 = new Carro("UNO", "FIAT", "YBA-4861", cliente6);
		Carro carro9 = new Carro("Palio", "FIAT", "PPA-0257", cliente6);
		Carro carro10 = new Carro("Palio", "FIAT", "JJA-9099", cliente6);
		Carro carro11 = new Carro("Corolla", "HONDA", "TGA-3157", cliente7);
		Carro carro12 = new Carro("Civic", "HONDA", "YAF-6485", cliente7);
		
		Curso curso = new Curso("Angular");
		Curso curso2 = new Curso("Java");
		Curso curso3 = new Curso("Javascript");

		Aluno aluno = new Aluno("Gustavo", "156485", "123");
		Aluno aluno2 = new Aluno("Eliana", "289165", "159");
		Aluno aluno3 = new Aluno("Hellen", "954982", "156");
		Aluno aluno4 = new Aluno("Felipe", "614865", "456");
		Aluno aluno5 = new Aluno("Amanda", "486153", "756");
		Aluno aluno6 = new Aluno("Joao", "348168", "654");

		CursoRegistro cursoRegistro = new CursoRegistro(curso2, aluno);
		CursoRegistro cursoRegistro2 = new CursoRegistro(curso3, aluno);
		CursoRegistro cursoRegistro3 = new CursoRegistro(curso, aluno2);
		CursoRegistro cursoRegistro4 = new CursoRegistro(curso, aluno3);
		CursoRegistro cursoRegistro5 = new CursoRegistro(curso2, aluno4);
		CursoRegistro cursoRegistro6 = new CursoRegistro(curso, aluno5);
		CursoRegistro cursoRegistro7 = new CursoRegistro(curso2, aluno5);
		CursoRegistro cursoRegistro8 = new CursoRegistro(curso3, aluno5);
		CursoRegistro cursoRegistro9 = new CursoRegistro(curso2, aluno6);

		DAO<Object> dao = new DAO<Object>();
		dao.abrirTransacao()
			.incluir(cliente).incluir(endereco).incluir(carro).incluir(carro2)
			.incluir(cliente2).incluir(endereco2).incluir(carro3)
			.incluir(cliente3).incluir(endereco3).incluir(carro4).incluir(carro5)
			.incluir(cliente4).incluir(endereco4).incluir(carro6)
			.incluir(cliente5).incluir(endereco5).incluir(carro7)
			.incluir(cliente6).incluir(endereco6).incluir(carro8).incluir(carro9).incluir(carro10)
			.incluir(cliente7).incluir(endereco7).incluir(carro11).incluir(carro12)
			.incluir(curso)
			.incluir(curso2)
			.incluir(curso3)
			.incluir(aluno)
			.incluir(aluno2)
			.incluir(aluno3)
			.incluir(aluno4)
			.incluir(aluno5)
			.incluir(aluno6)
			.incluir(cursoRegistro)
			.incluir(cursoRegistro2)
			.incluir(cursoRegistro3)
			.incluir(cursoRegistro4)
			.incluir(cursoRegistro5)
			.incluir(cursoRegistro6)
			.incluir(cursoRegistro7)
			.incluir(cursoRegistro8)
			.incluir(cursoRegistro9)
			.comitarTransacao()
			.fechar();
	}

}
