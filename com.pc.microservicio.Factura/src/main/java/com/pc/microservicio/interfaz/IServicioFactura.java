package com.pc.microservicio.interfaz;


import java.util.List;
import java.util.Optional;

import com.pc.microservicio.factura.Factura;
public interface IServicioFactura {
	Factura crearFactura(Factura factura);
	List<Factura> obtenerTodoLasFacturas();
	Optional<Factura> obtenerFacturaPorId(Long id);
	Optional<Factura> actualizarFacturas(Long id, Factura facturaDetails);
	boolean eliminiarFactura(Long id);
}
