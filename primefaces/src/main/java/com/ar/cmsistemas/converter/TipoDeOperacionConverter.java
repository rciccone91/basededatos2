package com.ar.cmsistemas.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ar.cmsistemas.domain.TipoDeOperacion;
import com.ar.cmsistemas.service.TipoDeOperaciónService;
 
 
@FacesConverter("tipoDeOperacionConverter")
public class TipoDeOperacionConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                TipoDeOperaciónService service = (TipoDeOperaciónService) fc.getExternalContext().getApplicationMap().get("tipoDeOperacionService");
                return service.getTipoDeOperacionById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un tipo de operación válida"));
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
