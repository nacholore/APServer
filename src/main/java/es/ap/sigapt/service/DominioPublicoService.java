package es.ap.sigapt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ap.sigapt.dto.ConcesionGeoJson;
import es.ap.sigapt.model.Concesion;
import es.ap.sigapt.repository.DominioPublicoRepository;

@Service
public class DominioPublicoService {
	
    private final DominioPublicoRepository repository;
    
    @Autowired
    DominioPublicoService(DominioPublicoRepository repository) {
        this.repository = repository;
    }
    
    
    public List<ConcesionGeoJson>searchAllByTerm(String searchTerm) {
        List<Concesion> items = repository.searchByTerm(searchTerm);
        return convertToDTOs(items);
    }
    public List<ConcesionGeoJson> searchAllByTermAndBounds(String searchTerm, List<Double> bounds) {
        List<Concesion> items = repository.searchByTermAndBounds(searchTerm, bounds);
        return convertToDTOs(items);
    }


	private List<ConcesionGeoJson> convertToDTOs(List<Concesion> items) {
		List<ConcesionGeoJson> result = new ArrayList<ConcesionGeoJson>();
		for (Concesion temp : items) {
			ConcesionGeoJson tmp = new ConcesionGeoJson();
			tmp.setId(temp.getId());
			tmp.getProperties().setDescription(temp.getDescription());
			tmp.getProperties().setTitular(temp.getTitular());
			tmp.getProperties().setCode(temp.getCode());
			tmp.getProperties().setPort(temp.getPort());
			tmp.getProperties().setExpediente(temp.getExpediente());
			tmp.setGeometry(temp.getGeometry());
			result.add(tmp);
		}
		return result;
	}
    
    
    

}
