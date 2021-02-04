package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class NavegarBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public NavegarBean() {
		
	}
	
	@PostConstruct
    public void init(){
        
		System.out.println("***NavegarBean INICIALIZADO***");
		
    }
	
	public void redirectPersona() {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "persona.xhtml");
	}
	
	public void redirectRestaurante() {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "restaurante.xhtml");
	}
	
	public void redirectReserva() {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "reserva.xhtml");
	}
	
}
