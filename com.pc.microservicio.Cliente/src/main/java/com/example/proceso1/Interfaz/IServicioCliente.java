package com.example.proceso1.Interfaz;

import com.example.proceso1.Clientes.Cliente;

import java.util.List;
import java.util.Optional;
public interface IServicioCliente {
	Cliente crearCliente(Cliente cliente);
	List<Cliente> obtenerTodoLosClientes();
	Optional<Cliente> obtenerClientePorId(Long id);
	Optional<Cliente> actualizarClientes(Long id, Cliente clienteDetails);
	boolean eliminarCliente(Long id);
}
