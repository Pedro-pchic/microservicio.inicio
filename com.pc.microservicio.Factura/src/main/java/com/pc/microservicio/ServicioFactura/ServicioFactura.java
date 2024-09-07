package com.pc.microservicio.ServicioFactura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pc.microservicio.factura.Factura;
import com.pc.microservicio.interfaz.IServicioFactura;
@Service
public class ServicioFactura implements IServicioFactura{

	private List<Factura> facturas = new ArrayList<>();
	
	@Override
	public Factura crearFactura(Factura factura) {
		facturas.add(factura);
		return factura;
	}

	@Override
	public List<Factura> obtenerTodoLasFacturas() {
		return facturas;
	}

	@Override
	public Optional<Factura> obtenerFacturaPorId(Long id) {
		return facturas.stream().filter(factura -> factura.getId().equals(id)).findFirst();
	}

	@Override
	public Optional<Factura> actualizarFacturas(Long id, Factura facturaDetails) {
			return obtenerFacturaPorId(id).map(factura ->{
				factura.setClienteId(facturaDetails.getClienteId());
				factura.setFecha(facturaDetails.getFecha());
				factura.setMonto(facturaDetails.getMonto());
				return factura;
			});
	}

	@Override
	public boolean eliminiarFactura(Long id) {
		return facturas.removeIf(factura -> factura.getId().equals(id));
	}
	
}
