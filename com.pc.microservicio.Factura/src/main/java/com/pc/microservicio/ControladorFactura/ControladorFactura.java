package com.pc.microservicio.ControladorFactura;

import com.pc.microservicio.factura.Factura;

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

import com.pc.microservicio.ServicioFactura.ServicioFactura;
import com.pc.microservicio.factura.Factura;
@RestController
@RequestMapping("/api/factura")
public class ControladorFactura {
	private final ServicioFactura servicioFactura;
	
	public ControladorFactura(ServicioFactura servicioFactura) {
		this.servicioFactura = servicioFactura;
	}
	
	@PostMapping // crear una factura nueva
	public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura){
		Factura nuevoFactura = servicioFactura.crearFactura(factura);
		return new ResponseEntity<>(nuevoFactura, HttpStatus.CREATED);
	}
	
	@GetMapping // obtener todas las facturas 
	public ResponseEntity<List<Factura>> obtenerTodoLosFactura(){
		List<Factura> factura = servicioFactura.obtenerTodoLasFacturas();
		return new ResponseEntity<>(factura, HttpStatus.OK);
	}
	
	@GetMapping("/{id}") // obtener id de la factura
	public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id){
		Optional<Factura> factura = servicioFactura.obtenerFacturaPorId(id);
		return factura.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/{id}") //actualizar id de la factura
	public ResponseEntity<Factura> actualizarFactura(@PathVariable Long id, @RequestBody Factura facturaDetails){
		Optional<Factura> factura = servicioFactura.actualizarFacturas(id, facturaDetails);
		return factura.map(ResponseEntity::ok).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//eliminar clientes 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarFactura(@PathVariable Long id){
	boolean deleted = servicioFactura.eliminiarFactura(id);
		return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
