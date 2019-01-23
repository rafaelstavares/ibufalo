/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import animal.Animal;
import animal.AnimalRn;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author rafael
 */
@FacesConverter("converterAnimal")
public class ConverterAnimal implements Converter {

   private AnimalRn rn = new AnimalRn();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Animal animal = null;
        try {
            animal = rn.carregar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return animal;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof Animal) {
            if (((Animal) o).getId() != null) {
                resultado = ((Animal) o).getId().toString();
            }
        }
        return resultado;
    }
}