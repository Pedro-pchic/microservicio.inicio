package com.pc.microservicio.Interfaz;

import java.util.List;
import java.util.Optional;

import com.pc.microservicio.Empleado.Empleado;

public interface IEmpleado {
	Empleado crearEmpleado(Empleado empleado);
	List<Empleado> obtenerTodoLosEmpleado();
	Optional<Empleado> obtenerEmpleadoPorId(Long id);
	Optional<Empleado> actualizarEmpleado(Long id, Empleado empleadoDetails);
	boolean eliminiarEmpleado(Long id);
}
