package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ejb.PersonaFacade;
import entity.Persona;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PersonaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Persona persona;
	
	@EJB
	private PersonaFacade personaFacade;
	
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String direccion;
	private String telefono;
	
	
	private Date fecha;
	
	public PersonaBean() {
		
	}
	
	@PostConstruct
    public void init(){
        
		System.out.println("***PersonaBean INICIALIZADO***");
		
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public void crearPersona() {
		
		fecha = new Date();
		
		System.out.println(">>>>>>>>>>>>>	"+nombre);
		System.out.println(">>>>>>>>>>>>>	"+apellido);
		System.out.println(">>>>>>>>>>>>>	"+correo);
		System.out.println(">>>>>>>>>>>>>	"+fecha);
		
		try {
			persona = new Persona(cedula, nombre, apellido, correo, direccion, telefono);
			
			personaFacade.create(persona);
			System.out.println(">>>>>>>>>>>>>	"+persona.getId());
			
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "menu.xhtml");
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "persona.xhtml");
		}			
		
	}
	
	
}
