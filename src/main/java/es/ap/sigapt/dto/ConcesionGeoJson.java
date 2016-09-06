package es.ap.sigapt.dto;

import com.vividsolutions.jts.geom.MultiPolygon;

import es.ap.sigapt.dto.base.GeoJsonFeatureImpl;

public class ConcesionGeoJson extends GeoJsonFeatureImpl<MultiPolygon, ConcesionProperties>{
	
	public ConcesionGeoJson() {
		properties = new ConcesionProperties();		
	}
}
