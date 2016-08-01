package com.ar.cmsistemas.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.spi.ServiceRegistry;

import org.primefaces.context.RequestContext;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.ar.cmsistemas.domain.Ciudad;
import com.ar.cmsistemas.domain.Propiedad;
import com.ar.cmsistemas.domain.TipoDeOperacion;
import com.ar.cmsistemas.domain.TipoDePropiedad;
import com.ar.cmsistemas.domain.Usuario;
import com.ar.cmsistemas.helper.CommonHelper;
import com.ar.cmsistemas.helper.SessionHelper;
import com.ar.cmsistemas.service.CiudadBackingService;
import com.ar.cmsistemas.service.PropiedadService;
import com.ar.cmsistemas.service.TipoDeOperaciónService;
import com.ar.cmsistemas.service.TipoDePropiedadService;

@ManagedBean(name = "altaPropiedadBean")
public class AltaPropiedadBean {
	
	private String direccion;
	private String desc;
	private Integer ambientes;
	private Integer banios;
	private Integer superficieCubierta;
	private Integer superficieTotal;
	private Integer habitaciones;
	private Date fechaDeConstruccion;
	private Double latitud; 
	private Double longitud;
	private Integer precio;
	private TipoDeOperacion tipoDeOperacion;
	private TipoDePropiedad tipoDePropiedad;
	private Boolean activo;
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
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}


	//prueba
	private String toString;


	@ManagedProperty("#{tipoDeOperacionService}")
	private TipoDeOperaciónService tipoDeOpService;

	@ManagedProperty("#{ciudadBackingService}")
	private CiudadBackingService ciudadBackingService;
	
	@ManagedProperty("#{tipoDePropiedadService}")
	private TipoDePropiedadService tipoDePropiedadService;
	
	private PropiedadService propiedadService;

	@PostConstruct
	public void init() {
			tiposDeOperacion = tipoDeOpService.getTipoDeOperaciones();
			ciudades = ciudadBackingService.getCiudades();
			setTiposDePropiedad(tipoDePropiedadService.getTipoDePropiedades());
			geoModel = new DefaultMapModel();
			propiedadService = new PropiedadService();
			setMax(CommonHelper.getYesterdayDate());
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getAmbientes() {
		return ambientes;
	}
	public void setAmbientes(Integer ambientes) {
		this.ambientes = ambientes;
	}
	public Integer getBanios() {
		return banios;
	}
	public void setBanios(Integer banios) {
		this.banios = banios;
	}
	public Integer getSuperficieCubierta() {
		return superficieCubierta;
	}
	public void setSuperficieCubierta(Integer superficieCubierta) {
		this.superficieCubierta = superficieCubierta;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public TipoDeOperacion getTipoDeOperacion() {
		return tipoDeOperacion;
	}
	public void setTipoDeOperacion(TipoDeOperacion tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}
	public TipoDePropiedad getTipoDePropiedad() {
		return tipoDePropiedad;
	}
	public void setTipoDePropiedad(TipoDePropiedad tipoDePropiedad) {
		this.tipoDePropiedad = tipoDePropiedad;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getSuperficieTotal() {
		return superficieTotal;
	}


	public void setSuperficieTotal(Integer superficieTotal) {
		this.superficieTotal = superficieTotal;
	}


	public Integer getHabitaciones() {
		return habitaciones;
	}


	public void setHabitaciones(Integer habitaciones) {
		this.habitaciones = habitaciones;
	}


	public Date getFechaDeConstruccion() {
		return fechaDeConstruccion;
	}


	public void setFechaDeConstruccion(Date fechaDeConstruccion) {
		this.fechaDeConstruccion = fechaDeConstruccion;
	}


	public Double getLatitud() {
		return latitud;
	}


	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}


	public Double getLongitud() {
		return longitud;
	}


	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}


	public String getToString() {
		return "AltaPropiedadBean [direccion=" + direccion + ", desc=" + desc + ", ambientes=" + ambientes + ", banios="
				+ banios + ", superficieCubierta=" + superficieCubierta + ", superficieTotal=" + superficieTotal
				+ ", habitaciones=" + habitaciones + ", fechaDeConstruccion=" + fechaDeConstruccion + ", latitud="
				+ latitud + ", longitud=" + longitud + ", precio=" + precio + ", tipoDeOperacion=" + tipoDeOperacion
				+ ", tipoDePropiedad=" + tipoDePropiedad + ", activo=" + activo + ", tiposDeOperacion="
				+ tiposDeOperacion + ", tiposDePropiedad=" + tiposDePropiedad + ", ciudad=" + ciudad + "]";
		
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
		return ciudad;
	}


	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
		this.nombreCiudad = ciudad.getCiudad();
	}


	public List<Ciudad> getCiudades() {
		return ciudades;
	}


	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public void onGeocode(GeocodeEvent event) {
		List<GeocodeResult> results = event.getResults();
		if(geoModel.getMarkers().size() > 0 ) geoModel = new DefaultMapModel();
		if (results != null && !results.isEmpty()) {
			LatLng center = results.get(0).getLatLng();
			centerGeoMap = center.getLat() + "," + center.getLng();
			zoom = 20;
			
			setLatitud(results.get(0).getLatLng().getLat());
			setLongitud(results.get(0).getLatLng().getLng());
			System.out.println(latitud);
			System.out.println(longitud);
			RequestContext.getCurrentInstance().update("mainForm:latitud");
			RequestContext.getCurrentInstance().update("mainForm:longitud");
			
			GeocodeResult result = results.get(0);
			geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
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

	public String doSave(){
		//guardo en base
		System.out.println(this.getToString());
		Propiedad p = getPropiedad();
		try {
			propiedadService.savePropiedad(p);
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR, "Error", 
	        		"Ocurrió un error al guardar la propiedad. Por favor contactarse con sistemas."));
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
	
	private Propiedad getPropiedad(){
		Propiedad p = new Propiedad();
		p.setDireccion(direccion);
		p.setDesc(desc);
		p.setActivo(activo);
		p.setAmbientes(ambientes);
		p.setBanios(banios);
		p.setCiudad(ciudad);
		p.setFechaDeConstruccion(fechaDeConstruccion);
		p.setHabitaciones(habitaciones);
		p.setLatitud(latitud);
		p.setLongitud(longitud);
		p.setPrecio(precio);
		p.setSuperficieCubierta(superficieCubierta);
		p.setSuperficieTotal(superficieTotal);
		p.setTipoDeOperacion(tipoDeOperacion);
		p.setTipoDePropiedad(tipoDePropiedad);
		p.setCreateUser(SessionHelper.getUserName());
		p.setCreateDate(Calendar.getInstance().getTime());
		
		return p;
	}

	public Date getMax() {
		return max;
	}

	public void setMax(Date max) {
		this.max = max;
	}
}
