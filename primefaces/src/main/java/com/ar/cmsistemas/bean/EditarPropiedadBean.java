package com.ar.cmsistemas.bean;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.ar.cmsistemas.domain.Ciudad;
import com.ar.cmsistemas.domain.Propiedad;
import com.ar.cmsistemas.domain.TipoDeOperacion;
import com.ar.cmsistemas.domain.TipoDePropiedad;
import com.ar.cmsistemas.helper.CommonHelper;
import com.ar.cmsistemas.helper.SessionHelper;
import com.ar.cmsistemas.service.CiudadBackingService;
import com.ar.cmsistemas.service.PropiedadService;
import com.ar.cmsistemas.service.TipoDeOperaciónService;
import com.ar.cmsistemas.service.TipoDePropiedadService;

@ManagedBean(name = "editarPropiedadBean")
@ViewScoped
public class EditarPropiedadBean {

	private Propiedad propiedad;
	private List<TipoDeOperacion> tiposDeOperacion;
	private List<TipoDePropiedad> tiposDePropiedad;
	private Ciudad ciudad;
	private List<Ciudad> ciudades;
	private String nombreCiudad;
	private MapModel geoModel;
	private String centerGeoMap = "41.850033, -87.6500523";
	private Integer zoom = 2;
	private String direccionBuscada;
	private Date max;

	public String getNombreCiudad() {
		return propiedad.getCiudad().getCiudad();
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}


	@ManagedProperty("#{tipoDeOperacionService}")
	private TipoDeOperaciónService tipoDeOpService;

	@ManagedProperty("#{ciudadBackingService}")
	private CiudadBackingService ciudadBackingService;
	
	@ManagedProperty("#{tipoDePropiedadService}")
	private TipoDePropiedadService tipoDePropiedadService;
	
	private PropiedadService propiedadService;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		String prop = paramMap.get("prop");
		propiedadService = new PropiedadService();
		setPropiedad(propiedadService.getPropiedadById(Integer.parseInt(prop)));		
		tiposDeOperacion = tipoDeOpService.getTipoDeOperaciones();
		ciudades = ciudadBackingService.getCiudades();
		setTiposDePropiedad(tipoDePropiedadService.getTipoDePropiedades());
		geoModel = new DefaultMapModel();
		setMax(CommonHelper.getYesterdayDate());
	}

	public List<TipoDeOperacion> getTiposDeOperacion() {
		return tiposDeOperacion;
	}

	public void setTiposDeOperacion(List<TipoDeOperacion> tiposDeOperacion) {
		this.tiposDeOperacion = tiposDeOperacion;
	}

	public TipoDeOperaciónService getTipoDeOpService() {
		return tipoDeOpService;
	}

	public void setTipoDeOpService(TipoDeOperaciónService tipoDeOpService) {
		this.tipoDeOpService = tipoDeOpService;
	}

	public CiudadBackingService getCiudadBackingService() {
		return ciudadBackingService;
	}


	public void setCiudadBackingService(CiudadBackingService ciudadBackingService) {
		this.ciudadBackingService = ciudadBackingService;
	}

	

	public TipoDePropiedadService getTipoDePropiedadService() {
		return tipoDePropiedadService;
	}

	public void setTipoDePropiedadService(TipoDePropiedadService tipoDePropiedadService) {
		this.tipoDePropiedadService = tipoDePropiedadService;
	}

	public Ciudad getCiudad() {
		return propiedad.getCiudad();
	}


	public void setCiudad(Ciudad ciudad) {
		this.propiedad.setCiudad(ciudad);
		this.nombreCiudad = ciudad.getCiudad();
	}


	public List<Ciudad> getCiudades() {
		return ciudades;
	}


	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public void onGeocode(GeocodeEvent event) {
		geoModel = new DefaultMapModel();
		List<GeocodeResult> results = event.getResults();

		if (results != null && !results.isEmpty()) {
			LatLng center = results.get(0).getLatLng();
			centerGeoMap = center.getLat() + "," + center.getLng();
			zoom = 20;
			
			propiedad.setLatitud(results.get(0).getLatLng().getLat());
			propiedad.setLongitud(results.get(0).getLatLng().getLng());
			RequestContext.getCurrentInstance().update("mainForm:latitud");
			RequestContext.getCurrentInstance().update("mainForm:longitud");
			GeocodeResult result = results.get(0);
			geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
		}
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

	public Integer getZoom() {
		return zoom;
	}

	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}

	public String doUpdate(){
		//guardo en base
		Propiedad p = getPropiedad();
		p.setUpdateUser(SessionHelper.getUserName());
		p.setUpdateDate(Calendar.getInstance().getTime());
		try {
			propiedadService.updatePropiedad(p);
		}catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR, "Error", 
	        		"Ocurrió un error al actualizar la propiedad. Por favor contactarse con sistemas."));
		}
		return "index.xhtml";
	}

	public String getDireccionBuscada() {
		return direccionBuscada;
	}

	public void setDireccionBuscada(String direccionBuscada) {
		this.direccionBuscada = direccionBuscada;
	}

	public List<TipoDePropiedad> getTiposDePropiedad() {
		return tiposDePropiedad;
	}

	public void setTiposDePropiedad(List<TipoDePropiedad> tiposDePropiedad) {
		this.tiposDePropiedad = tiposDePropiedad;
	}
	
	public Date getMax() {
		return max;
	}

	public void setMax(Date max) {
		this.max = max;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
	public void updateNombreCiduad(){
		this.nombreCiudad = this.getCiudad().getCiudad();
	}
}
