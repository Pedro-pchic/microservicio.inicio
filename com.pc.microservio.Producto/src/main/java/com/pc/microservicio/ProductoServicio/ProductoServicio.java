package com.pc.microservicio.ProductoServicio;

import org.springframework.stereotype.Service;

import com.pc.microservicio.Producto.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    private List<Producto> productos = new ArrayList<>();
    private Long contadorId = 1L;

    // Crear un nuevo producto
    public Producto crearProducto(Producto producto) {
        producto.setId(contadorId++);
        productos.add(producto);
        return producto;
    }

    // Obtener un producto por ID
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    // Actualizar un producto
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Optional<Producto> productoExistente = obtenerProductoPorId(id);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
            return producto;
        }
        return null;
    }

    // Eliminar un producto por ID
    public boolean eliminarProducto(Long id) {
        return productos.removeIf(p -> p.getId().equals(id));
    }
}
