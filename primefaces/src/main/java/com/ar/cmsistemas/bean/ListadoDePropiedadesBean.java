package com.ar.cmsistemas.bean;


import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.ar.cmsistemas.domain.Propiedad;
import com.ar.cmsistemas.helper.Constants;
import com.ar.cmsistemas.service.PropiedadService;

@ManagedBean(name = "listadoDePropiedadesBean", eager = true)
@ViewScoped
public class ListadoDePropiedadesBean {
	
	private Boolean primerIngreso = true;
	private List<Propiedad> propiedades;
	private List<StreamedContent> imagenes;
	private StreamedContent imagen;
	private Propiedad seleccionada;
	private MapModel revGeoModel;
	private Integer zoom = 2;
	private String centerRevGeoMap = "41.850033, -87.6500523";
	// @ManagedProperty("#{propiedadService}")
	private PropiedadService service = new PropiedadService();
	
	@PostConstruct
	public void init() {
		if (!FacesContext.getCurrentInstance().isPostback()) {
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
			String op = paramMap.get("op");
			if(Integer.valueOf(op) == Constants.ALQUILER){
				propiedades = service.getPropiedadesByOperacion(Constants.ALQUILER);
			}
			else
			{
				propiedades = service.getPropiedadesByOperacion(Constants.VENTA);
			}
		}
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	public List<StreamedContent> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<StreamedContent> imagenes) {
		this.imagenes = imagenes;
	}

	public StreamedContent getImagen() {
		return imagen;
	}

	public void setImagen(StreamedContent imagen) {
		this.imagen = imagen;
	}

	public PropiedadService getService() {
		return service;
	}

	public void setService(PropiedadService service) {
		this.service = service;
	}

	public Propiedad getSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(Propiedad seleccionada) {
		this.seleccionada = seleccionada;
	}
	public void onReverseGeocode(ReverseGeocodeEvent event) {
        List<String> addresses = event.getAddresses();
        LatLng coord = event.getLatlng();
         
        if (addresses != null && !addresses.isEmpty()) {
            centerRevGeoMap = coord.getLat() + "," + coord.getLng();
            zoom = 30;
            revGeoModel.addOverlay(new Marker(coord, addresses.get(0)));
        }
    }
	
    public MapModel getRevGeoModel() {
        return revGeoModel;
    }

    public String getCenterRevGeoMap() {
        return centerRevGeoMap;
    }

	public Integer getZoom() {
		return zoom;
	}

	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}
	
	public String irADetalles(Propiedad p){
		seleccionada = p;
	    return "detallePropiedad.xhtml?faces-redirect=true&includeViewParams=true";
	}

	public String editarProp(Propiedad p){
	    return "editarPropiedad.xhtml?prop="+p.getId().toString();
	}

	
	public Boolean getPrimerIngreso() {
		return primerIngreso;
	}

	public void setPrimerIngreso(Boolean primerIngreso) {
		this.primerIngreso = primerIngreso;
	}
	
}
