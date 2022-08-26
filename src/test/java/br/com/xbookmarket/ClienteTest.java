package br.com.xbookmarket;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	Cliente cliente;
	String senha = "password@123";
	String nome = "Daniel";
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("Daniel", "email@dominio.com.br", "1199999-9999", "111222333-88", "44555666X", "Rua da rua, numero, bairro, cidade, UF", "password@123");
	}
	
	@Test
	public void testSetSenha() {
		
		cliente.setSenha(senha);
		assertEquals(cliente.getSenha(), senha);
	}
	
	@Test
	public void testSetNome() {
		
		cliente.setNome(nome);
		assertEquals(cliente.getNome(), nome);
	}

}
