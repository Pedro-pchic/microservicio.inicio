package com.example.proceso1.Controlador;

import com.example.proceso1.proveedor.Proveedor;
import com.example.proceso1.ProveedorServicio.ServicioProveedor;

import java.util.ArrayList;
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

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorControlador {
	public final ServicioProveedor servicioProveedor;
	
	public ProveedorControlador(ServicioProveedor servicioProveedor) {
		this.servicioProveedor = servicioProveedor;
	}
	
	//crear un nuevo proveedor por me dio de @PostMapping
	@PostMapping 
	public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor){
		Proveedor nuevoProveedor = servicioProveedor.crearProveedor(proveedor);
		return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
	}
	@GetMapping//lsita de los proveedores
	public ResponseEntity<List<Proveedor>> ObtenerTodoLosProveedores(){
	List<Proveedor> proveedores= servicioProveedor.obtenerTodosLosProveedores();
		return new ResponseEntity<>(proveedores, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}") //obtiene un proveedor por su ID
	public ResponseEntity<Proveedor> obtenerProveedoresPorId(@PathVariable Long id){
		Optional<Proveedor> proveedor = servicioProveedor.obtenerProveedorPorId(id);
		return proveedor.map(ResponseEntity::ok).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//actualizar los proveedores existentes 
	@PutMapping("/{id}")
	public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorDetails){
		Optional<Proveedor> proveedor = Optional.of(servicioProveedor.actualizarProveedor(id, proveedorDetails));
		return proveedor.map(ResponseEntity::ok).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//Eliminar proveedor por ID
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id){
		boolean deleted = servicioProveedor.eliminarProveedor(id);
		return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	}
	
	

