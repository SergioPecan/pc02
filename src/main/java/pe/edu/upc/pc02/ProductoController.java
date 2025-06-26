package pe.edu.upc.pc02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping
    public ResponseEntity<?> registrarProducto(@RequestBody Producto producto) {
        Producto guardado = productoRepository.save(producto);
        return ResponseEntity.status(201).body(
                String.format("Producto registrado con ID: %d", guardado.getId())
        );
    }
}
