package com.ar.cmsistemas.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ar.cmsistemas.domain.Ciudad;
import com.ar.cmsistemas.domain.TipoDePropiedad;
import com.ar.cmsistemas.service.TipoDePropiedadService;

@FacesConverter("tipoDePropiedadConverter")
public class TipoDePropiedadConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	TipoDePropiedadService service = (TipoDePropiedadService) fc.getExternalContext().getApplicationMap().get("tipoDePropiedadService");
                return service.getTipoDePropiedadById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un tipo de propiedad válida"));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((TipoDePropiedad) object).getId());
        }
        else {
            return null;
        }
    }   

}
