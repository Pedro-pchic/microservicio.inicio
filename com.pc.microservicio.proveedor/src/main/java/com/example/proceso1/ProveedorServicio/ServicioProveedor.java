package com.example.proceso1.ProveedorServicio;

import org.springframework.stereotype.Service;
import com.example.proceso1.proveedor.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioProveedor {
    private List<Proveedor> proveedores = new ArrayList<>();
    private Long idCounter = 1L;

    // Crear un nuevo proveedor
    public Proveedor crearProveedor(Proveedor proveedor) {
        proveedor.setId(idCounter++); // Asigna un ID único al nuevo proveedor
        proveedores.add(proveedor);
        return proveedor;
    }

    // Obtener la lista de todos los proveedores
    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedores;
    }

    // Obtener un proveedor por su ID
    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        return proveedores.stream().filter(proveedor -> proveedor.getId().equals(id)).findFirst();
    }

    // Actualizar un proveedor existente por ID
    public Proveedor actualizarProveedor(Long id, Proveedor proveedorActualizado) {
        return obtenerProveedorPorId(id).map(proveedor -> {
            proveedor.setNombre(proveedorActualizado.getNombre());
            proveedor.setDireccion(proveedorActualizado.getDireccion());
            proveedor.setTelefono(proveedorActualizado.getTelefono());
            return proveedor;
        }).orElse(null);
    }

    // Eliminar un proveedor por ID
    public boolean eliminarProveedor(Long id) {
        return proveedores.removeIf(proveedor -> proveedor.getId().equals(id));
    }
}
