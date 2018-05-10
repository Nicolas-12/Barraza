
package controller;

import dao.PersonalDao;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.PersonalModel;

/**
 *
 * @author Valentin
 */
@Named(value = "personaController")
@SessionScoped
public class PersonalController implements Serializable {
     PersonalModel model = new PersonalModel();
     
      public void guardar() throws Exception{
        PersonalDao dao;
        try {
            dao = new PersonalDao();
            dao.guardar(model);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registrado con Exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al guardar"));  
            throw e;
        }
}

    public PersonalModel getModel() {
        return model;
    }

    public void setModel(PersonalModel model) {
        this.model = model;
    }
     
}
