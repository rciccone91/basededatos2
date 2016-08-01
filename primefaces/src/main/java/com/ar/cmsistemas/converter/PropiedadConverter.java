package com.ar.cmsistemas.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ar.cmsistemas.domain.Propiedad;
import com.ar.cmsistemas.domain.TipoDePropiedad;
import com.ar.cmsistemas.service.PropiedadBackingService;

@FacesConverter("propiedadConverter")
public class PropiedadConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	PropiedadBackingService service = (PropiedadBackingService) fc.getExternalContext().getApplicationMap().get("propiedadBackingService");
//                return service.getPropiedades().get(Integer.parseInt(value)-1);
            	return service.getPropiedadById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es una propiedad valida"));
            }
        }
        else {
            return null;
        }
    }

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
        if(object != null) {
            String s =  String.valueOf(((Propiedad) object).getId());
            return s;
        }
        else {
            return null;
        }
	}
}
