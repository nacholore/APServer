package es.ap.sigapt.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ap.sigapt.dto.ConcesionGeoJson;
import es.ap.sigapt.service.DominioPublicoService;

@RestController
public class SearchController {

	private final DominioPublicoService service;

	@Autowired
	public SearchController(DominioPublicoService service) {
		this.service = service;
	}

	@RequestMapping("/greeting")
	public List<ConcesionGeoJson> greeting(@RequestParam(name = "text") String searchTerm, 
			@RequestParam(name = "bounds") List<Double> bounds,
			@RequestParam(name = "layers", required = false) Set<String> layers) {
		
		List<ConcesionGeoJson> results;
		if (bounds != null)
			results = service.searchAllByTermAndBounds(searchTerm.replace(" ", "|"), bounds);
		else
			results = service.searchAllByTerm(searchTerm.replace(" ", "|"));
		
		return results;
	}

	@RequestMapping("/hola")
	public String greeting() {

		return "Adios";
	}

}
