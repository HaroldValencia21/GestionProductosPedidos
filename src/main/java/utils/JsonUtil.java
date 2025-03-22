package com.productosypedidos.gestion_productos_pedidos.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productosypedidos.gestion_productos_pedidos.model.Producto;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Producto> cargarProductosDesdeJson(String filePath) {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Producto>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el JSON", e);
        }
    }

    public static void guardarProductosEnJson(String filePath, List<Producto> productos) {
        try {
            objectMapper.writeValue(new File(filePath), productos);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el JSON", e);
        }
    }
}
