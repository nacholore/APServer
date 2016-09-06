package es.ap.sigapt.dto.base;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vividsolutions.jts.geom.Geometry;

@JsonPropertyOrder({ "id", "type", "properties", "geometry" })
public abstract class GeoJsonFeatureImpl<TGeometry extends Geometry, TProperties extends PropertiesItf>
		implements GeoJsonItf<TGeometry, TProperties> {

	private Long id;
	private TGeometry geometry;
	private String type = FEATURE_TYPE.FEATURE;
	protected TProperties properties;
	

	public GeoJsonFeatureImpl() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TGeometry getGeometry() {
		return geometry;
	}

	public void setGeometry(TGeometry geometry) {
		this.geometry = geometry;
	}
	
	public String getType() {
		return type;
	}

	public TProperties getProperties() {
		return properties;
	}

	public void setProperties(TProperties propeties) {
		this.properties = propeties;
	}

}
