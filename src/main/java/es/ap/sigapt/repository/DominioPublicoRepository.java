package es.ap.sigapt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import es.ap.sigapt.model.Concesion;

public interface DominioPublicoRepository extends CrudRepository<Concesion, Long> {

	@Query(value="SELECT c.id, c.titular, c.description, c.port, c.code,  c.the_geom " + 
			"FROM Concesion c WHERE c.titular ~* :searchTerm OR c.description ~* :searchTerm", nativeQuery=true)
    public List<Concesion> searchByTerm(@Param("searchTerm") String searchTerm);
	
	@Query(value="SELECT c.id, c.titular, c.description, c.port, c.code,  c.the_geom FROM Concesion c WHERE " + 
			"c.the_geom && ST_MakeEnvelope(:bounds, 4326) AND (c.titular ~* :searchTerm OR c.description ~* :searchTerm)", nativeQuery=true)
    public List<Concesion> searchByTermAndBounds(@Param("searchTerm") String searchTerm, @Param("bounds") List<Double> bounds);
}
