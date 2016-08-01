package com.ar.cmsistemas.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ar.cmsistemas.domain.Ciudad;
import com.ar.cmsistemas.service.CiudadBackingService;

@FacesConverter("ciudadConverter")
public class CiudadConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	CiudadBackingService service = (CiudadBackingService) fc.getExternalContext().getApplicationMap().get("ciudadBackingService");
                return service.getCiudadById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es una ciudad válida"));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Ciudad) object).getId());
        }
        else {
            return null;
        }
    }   

}