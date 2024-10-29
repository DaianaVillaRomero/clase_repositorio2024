package py.edu.facitec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

//Aplicar la arquitrctura rest
//Representational state transfer
//Solicitudes sin alm. de estado
@RestController
@RequestMapping("/api")
//api afecta a todos los metodos de las clases.
public class SuscritoController {

	// Autowired de suscrito repository
	@Autowired
	private SuscritoRepository suscritoRepository;

	@GetMapping("/suscritos")

	public ResponseEntity<List<Suscrito>> getSuscritos() {

		List<Suscrito> suscritos = new ArrayList<>();

		suscritos = suscritoRepository.findAll();

		return new ResponseEntity<List<Suscrito>>(suscritos, HttpStatus.OK);
	}

	@PostMapping("/suscrito") // JSON ---> JAVA
	public ResponseEntity<Suscrito> guardarSuscrito(@RequestBody Suscrito suscrito) {

		suscritoRepository.save(suscrito);

		return new ResponseEntity<Suscrito>(suscrito, HttpStatus.OK);

	}

	// api/suscrito/{id}
	// buscar un suscrito por id

	@GetMapping("/suscritos/{codigo}") // recibir por parametro el valor
	public ResponseEntity<Suscrito> getOneSuscrito(@PathVariable Long codigo) {

		Optional<Suscrito> suscrito = suscritoRepository.findById(codigo);

		if (suscrito.isPresent()) {
			return new ResponseEntity<Suscrito>(suscrito.get(), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	// api/suscritos/codigo
	// eliminar un suscrito por codigo DELETE

	@DeleteMapping("/suscrito/{codigo}") // recibir por parametro el valor
	public ResponseEntity<Suscrito> eliminarOneSuscrito(@PathVariable Long codigo) {

		Optional<Suscrito> suscrito = suscritoRepository.findById(codigo);

		// comparar si se encontro
		if (suscrito.isPresent()) {
			// eliminar un suscrrito
			suscritoRepository.deleteById(codigo);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
