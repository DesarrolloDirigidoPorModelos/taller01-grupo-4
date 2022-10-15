/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package problematica2;

import java.sql.Date;
import java.util.*;

// line 2 "model.ump"
// line 45 "model.ump"
public class Supervisor {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Supervisor Attributes
	private String identificacion;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String mail;
	private String telefono;
	private String direccion;

	// Supervisor Associations
	private List<Acto> actos;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public Supervisor(String aIdentificacion, String aNombre, String aApellido, Date aFechaNacimiento, String aMail,
			String aTelefono, String aDireccion) {
		identificacion = aIdentificacion;
		nombre = aNombre;
		apellido = aApellido;
		fechaNacimiento = aFechaNacimiento;
		mail = aMail;
		telefono = aTelefono;
		direccion = aDireccion;
		actos = new ArrayList<Acto>();
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public boolean setIdentificacion(String aIdentificacion) {
		boolean wasSet = false;
		identificacion = aIdentificacion;
		wasSet = true;
		return wasSet;
	}

	public boolean setNombre(String aNombre) {
		boolean wasSet = false;
		nombre = aNombre;
		wasSet = true;
		return wasSet;
	}

	public boolean setApellido(String aApellido) {
		boolean wasSet = false;
		apellido = aApellido;
		wasSet = true;
		return wasSet;
	}

	public boolean setFechaNacimiento(Date aFechaNacimiento) {
		boolean wasSet = false;
		fechaNacimiento = aFechaNacimiento;
		wasSet = true;
		return wasSet;
	}

	public boolean setMail(String aMail) {
		boolean wasSet = false;
		mail = aMail;
		wasSet = true;
		return wasSet;
	}

	public boolean setTelefono(String aTelefono) {
		boolean wasSet = false;
		telefono = aTelefono;
		wasSet = true;
		return wasSet;
	}

	public boolean setDireccion(String aDireccion) {
		boolean wasSet = false;
		direccion = aDireccion;
		wasSet = true;
		return wasSet;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getMail() {
		return mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	/* Code from template association_GetMany */
	public Acto getActo(int index) {
		Acto aActo = actos.get(index);
		return aActo;
	}

	public List<Acto> getActos() {
		List<Acto> newActos = Collections.unmodifiableList(actos);
		return newActos;
	}

	public int numberOfActos() {
		int number = actos.size();
		return number;
	}

	public boolean hasActos() {
		boolean has = actos.size() > 0;
		return has;
	}

	public int indexOfActo(Acto aActo) {
		int index = actos.indexOf(aActo);
		return index;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfActos() {
		return 0;
	}

	/* Code from template association_AddManyToOne */
	public Acto addActo(int aId, Date aFecha, String aNombre, String aDescripcion, String aLugar, double aCostoTotal,
			Patrocinador aPatrocinador, TipoActo aTipoActo) {
		return new Acto(aId, aFecha, aNombre, aDescripcion, aLugar, aCostoTotal, this, aPatrocinador, aTipoActo);
	}

	public boolean addActo(Acto aActo) {
		boolean wasAdded = false;
		if (actos.contains(aActo)) {
			return false;
		}
		Supervisor existingSupervisor = aActo.getSupervisor();
		boolean isNewSupervisor = existingSupervisor != null && !this.equals(existingSupervisor);
		if (isNewSupervisor) {
			aActo.setSupervisor(this);
		} else {
			actos.add(aActo);
		}
		wasAdded = true;
		return wasAdded;
	}

	public boolean removeActo(Acto aActo) {
		boolean wasRemoved = false;
		// Unable to remove aActo, as it must always have a supervisor
		if (!this.equals(aActo.getSupervisor())) {
			actos.remove(aActo);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	public boolean addActoAt(Acto aActo, int index) {
		boolean wasAdded = false;
		if (addActo(aActo)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfActos()) {
				index = numberOfActos() - 1;
			}
			actos.remove(aActo);
			actos.add(index, aActo);
			wasAdded = true;
		}
		return wasAdded;
	}

	public boolean addOrMoveActoAt(Acto aActo, int index) {
		boolean wasAdded = false;
		if (actos.contains(aActo)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfActos()) {
				index = numberOfActos() - 1;
			}
			actos.remove(aActo);
			actos.add(index, aActo);
			wasAdded = true;
		} else {
			wasAdded = addActoAt(aActo, index);
		}
		return wasAdded;
	}

	public void delete() {
		for (int i = actos.size(); i > 0; i--) {
			Acto aActo = actos.get(i - 1);
			aActo.delete();
		}
	}

	public String toString() {
		return super.toString() + "[" + "identificacion" + ":" + getIdentificacion() + "," + "nombre" + ":"
				+ getNombre() + "," + "apellido" + ":" + getApellido() + "," + "mail" + ":" + getMail() + ","
				+ "telefono" + ":" + getTelefono() + "," + "direccion" + ":" + getDireccion() + "]"
				+ System.getProperties().getProperty("line.separator") + "  " + "fechaNacimiento" + "="
				+ (getFechaNacimiento() != null
						? !getFechaNacimiento().equals(this) ? getFechaNacimiento().toString().replaceAll("  ", "    ")
								: "this"
						: "null");
	}
}