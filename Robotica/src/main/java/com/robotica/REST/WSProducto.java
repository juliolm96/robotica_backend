package com.robotica.REST;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robotica.models.Producto;
import com.robotica.models.ProductoVista;
import com.robotica.services.ProductoService;

@RestController
@RequestMapping("robotica/productos")
public class WSProducto {

	private static final Log bitacora = LogFactory.getLog(WSProducto.class);

	@Autowired
	ProductoService productoService;

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<ProductoVista>> consultar() {

		List<ProductoVista> productosList = new ArrayList<>();

		try {
			productosList = productoService.consultar();
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<List<ProductoVista>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<ProductoVista>>(productosList, HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/{articuloId}")
	public ResponseEntity<ProductoVista> buscar(@PathVariable("articuloId") int id) {

		ProductoVista producto = new ProductoVista();
		
		try {
			producto = productoService.buscar(id);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<ProductoVista>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductoVista>(producto, HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Void> insertar(@RequestBody Producto producto) {

		try {
			productoService.insertar(producto);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Void> actualizar(@RequestBody Producto producto) {
		
		try {
			productoService.actualizar(producto);
		} catch (Exception e) {
			bitacora.error(e);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

	}

}