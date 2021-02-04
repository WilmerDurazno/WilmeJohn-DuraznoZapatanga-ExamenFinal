package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ejb.RestauranteFacade;
import entity.Restaurante;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class RestauranteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String nombre;
	private String direccion;
	private String telefono;
	private String aforo;
	
	@EJB
	private RestauranteFacade restauranteFacade;
	
	private Restaurante restaurante;
	
	public RestauranteBean() {
		
	}
	
	@PostConstruct
    public void init(){
        
		System.out.println("***RestauranteBean INICIALIZADO***");
		
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public String getAforo() {
		return aforo;
	}

	public void setAforo(String aforo) {
		this.aforo = aforo;
	}

	public void crearRestaurante() {
		
		try {
			restaurante = new Restaurante(nombre, direccion, telefono, Integer.valueOf(aforo));
			
			restauranteFacade.create(restaurante);
			
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "menu.xhtml");
		} catch (Exception e) {
			System.out.println(">>>>>>>> ERROR "+e.getMessage());
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "restaurante.xhtml");
		}
		
	}
	
}
