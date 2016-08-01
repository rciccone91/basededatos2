package com.ar.cmsistemas.bean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.ar.cmsistemas.domain.Propiedad;
import com.ar.cmsistemas.service.PropiedadService;

@ManagedBean (name = "detallePropiedadBean")
@ViewScoped
public class DetallePropiedadBean {
	
	private Propiedad propiedad;
	private List<StreamedContent> imagenes;
	private StreamedContent imagen;
	private MapModel geoModel;
	private Integer zoom = 2;
	private String centerGeoMap = "41.850033, -87.6500523";
	// @ManagedProperty("#{propiedadService}")
	private PropiedadService service = new PropiedadService();
	
	@PostConstruct
	public void init(){
		setGeoModel(new DefaultMapModel());
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		String prop = paramMap.get("prop");
		propiedad = service.getPropiedadById(Integer.parseInt(prop));
	}
	
	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
	public String getDireccion(){
		return propiedad.getDireccion();
	}

	public void putPropiedad(Propiedad p){
		propiedad = p;
	}

	public List<StreamedContent> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<StreamedContent> imagenes) {
		this.imagenes = imagenes;
	}

	public Integer getZoom() {
		return zoom;
	}

	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}

	public PropiedadService getService() {
		return service;
	}

	public void setService(PropiedadService service) {
		this.service = service;
	}
	
	 public void onReverseGeocode(ReverseGeocodeEvent event) {
	        List<String> addresses = event.getAddresses();
	        LatLng coord = event.getLatlng();
	         
	        if (addresses != null && !addresses.isEmpty()) {
	            centerGeoMap = coord.getLat() + "," + coord.getLng();
	            geoModel.addOverlay(new Marker(coord, addresses.get(0)));
	            zoom=10;
	        }
	 }

	public MapModel getGeoModel() {
		return geoModel;
	}

	public void setGeoModel(MapModel geoModel) {
		this.geoModel = geoModel;
	}

	public String getCenterGeoMap() {
		return centerGeoMap;
	}

	public void setCenterGeoMap(String centerGeoMap) {
		this.centerGeoMap = centerGeoMap;
	}
}
