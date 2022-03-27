package br.com.pratica.jpa;

import java.util.List;

import br.com.pratica.jpa.dao.DAO;
import br.com.pratica.jpa.models.Cliente;
import br.com.pratica.jpa.models.Endereco;

public class Sistema {

	public static void main(String[] args) {

		DAO<Cliente> clienteDAO = popularBancoDeDados();
		
		List<Cliente> clientes = clienteDAO.consulta("obterTodosClientes");
		
		for (Cliente c : clientes) {
			System.out.println("ID: " + c.getId() + " | " + "NOME: " + c.getNome());
		}

	}

	private static DAO<Cliente> popularBancoDeDados() {
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
		
		DAO<Cliente> clienteDAO = new DAO<>(Cliente.class);
		clienteDAO.abrirTransacao()
			.incluir(cliente)
			.incluir(cliente2)
			.incluir(cliente3)
			.incluir(cliente4)
			.incluir(cliente5)
			.incluir(cliente6)
			.incluir(cliente7)
			.comitarTransacao();
		return clienteDAO;
	}

}
