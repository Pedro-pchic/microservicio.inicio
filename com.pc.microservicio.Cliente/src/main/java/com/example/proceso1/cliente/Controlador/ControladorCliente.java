package com.example.proceso1.cliente.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proceso1.Clientes.Cliente;
import com.example.proceso1.ServicioCliente.ServicioCliente;



@RestController
@RequestMapping("/api/clientes")
public class ControladorCliente {
	private final ServicioCliente servicioCliente;
	
	public ControladorCliente(ServicioCliente servicioCliente) {
		this.servicioCliente = servicioCliente;
	}
	
	@PostMapping // crear clientes 
	public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
		Cliente nuevoCliente = servicioCliente.crearCliente(cliente);
		return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
	}
	
	@GetMapping // obtener todo los clientes 
	public ResponseEntity<List<Cliente>> obtenerTodoLosClientes(){
		List<Cliente> clientes = servicioCliente.obtenerTodoLosClientes();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}") // obtener id de clientes
	public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id){
		Optional<Cliente> cliente = servicioCliente.obtenerClientePorId(id);
		return cliente.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/{id}") //actualizar cliente
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails){
		Optional<Cliente> cliente = servicioCliente.actualizarClientes(id, clienteDetails);
		return cliente.map(ResponseEntity::ok).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//eliminar clientes 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCliente(@PathVariable Long id){
	boolean deleted = servicioCliente.eliminarCliente(id);
		return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
