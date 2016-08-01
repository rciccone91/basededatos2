package com.ar.cmsistemas.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ar.cmsistemas.domain.TipoDeOperacion;
import com.ar.cmsistemas.service.TipoDeOperaci�nService;
 
 
@FacesConverter("tipoDeOperacionConverter")
public class TipoDeOperacionConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                TipoDeOperaci�nService service = (TipoDeOperaci�nService) fc.getExternalContext().getApplicationMap().get("tipoDeOperacionService");
                return service.getTipoDeOperacionById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversi�n", "No es un tipo de operaci�n v�lida"));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((TipoDeOperacion) object).getId());
        }
        else {
            return null;
        }
    }   

}
