package com.pc.microservicio.ServicioEmpleado;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pc.microservicio.Empleado.Empleado;
import com.pc.microservicio.Interfaz.IEmpleado;
@Service
public class ServicioEmpleado  implements IEmpleado{
	private List<Empleado> empleados = new ArrayList<>();
	@Override
	public Empleado crearEmpleado(Empleado empleado) {
		empleados.add(empleado);
		return empleado;
	}

	@Override
	public List<Empleado> obtenerTodoLosEmpleado() {
		return empleados;
	}

	@Override
	public Optional<Empleado> obtenerEmpleadoPorId(Long id) {
		return empleados.stream().filter(empleado -> empleado.getId().equals(id)).findFirst();
	}

	@Override
	public Optional<Empleado> actualizarEmpleado(Long id, Empleado empleadoDetails) {
		return obtenerEmpleadoPorId(id).map(empleado ->{
			empleado.setId(empleadoDetails.getId());
			empleado.setNombre(empleado.getNombre());
			empleado.setPuesto(empleadoDetails.getPuesto());
			empleado.setSalario(empleadoDetails.getSalario());
			return empleado;
		});
	}

	@Override
	public boolean eliminiarEmpleado(Long id) {
		return empleados.removeIf(empleado -> empleado.getId().equals(id));
	}
	
}
