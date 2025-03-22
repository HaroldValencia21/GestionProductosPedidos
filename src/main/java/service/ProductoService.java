package com.productosypedidos.gestion_productos_pedidos.service;

import com.productosypedidos.gestion_productos_pedidos.model.Producto;
import com.productosypedidos.gestion_productos_pedidos.utils.JsonUtil;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private static final String FILE_PATH = "src/main/resources/data/productos.json";
    private List<Producto> productos = JsonUtil.cargarProductosDesdeJson(FILE_PATH);

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        JsonUtil.guardarProductosEnJson(FILE_PATH, productos);
    }
}
