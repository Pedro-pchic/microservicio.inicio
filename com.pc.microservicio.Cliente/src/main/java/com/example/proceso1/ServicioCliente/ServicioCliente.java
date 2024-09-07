package com.example.proceso1.ServicioCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proceso1.Clientes.Cliente;
import com.example.proceso1.Interfaz.IServicioCliente;


@Service 
public class ServicioCliente implements IServicioCliente{
	private List<Cliente> clientes = new ArrayList<>();

	@Override
	public Cliente crearCliente(Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	@Override
	public List<Cliente> obtenerTodoLosClientes() {
		return clientes;
	}

	@Override
	public Optional<Cliente> obtenerClientePorId(Long id) {
		return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst();
	}

	@Override
	public Optional<Cliente> actualizarClientes(Long id, Cliente clienteDetails) {
		return obtenerClientePorId(id).map(cliente -> {
			cliente.setNombre(clienteDetails.getNombre());
			cliente.setCorreo(clienteDetails.getCorreo());
			cliente.setTelefono(clienteDetails.getTelefono());
			return cliente;
				
		});
	}

	@Override
	public boolean eliminarCliente(Long id) {
	 return clientes.removeIf(cliente -> cliente.getId().equals(id));
	}
	
	
	
	
}
