/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package problematica2;

import java.sql.Date;

// line 26 "model.ump"
// line 59 "model.ump"
public class Patrocinador {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Patrocinador Attributes
	private String identificacion;
	private String nombre;
	private String mail;
	private String telefono;
	private String direccion;

	// Patrocinador Associations
	private Acto acto;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public Patrocinador(String aIdentificacion, String aNombre, String aMail, String aTelefono, String aDireccion,
			Acto aActo) {
		identificacion = aIdentificacion;
		nombre = aNombre;
		mail = aMail;
		telefono = aTelefono;
		direccion = aDireccion;
//		if (aActo == null || aActo.getPatrocinador() != null) {
//			throw new RuntimeException(
//					"Unable to create Patrocinador due to aActo. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
//		}
		acto = aActo;
	}

	public Patrocinador(String aIdentificacion, String aNombre, String aMail, String aTelefono, String aDireccion,
			int aIdForActo, Date aFechaForActo, String aNombreForActo, String aDescripcionForActo, String aLugarForActo,
			double aCostoTotalForActo, Supervisor aSupervisorForActo, TipoActo aTipoActoForActo) {
		identificacion = aIdentificacion;
		nombre = aNombre;
		mail = aMail;
		telefono = aTelefono;
		direccion = aDireccion;
		acto = new Acto(aIdForActo, aFechaForActo, aNombreForActo, aDescripcionForActo, aLugarForActo,
				aCostoTotalForActo, aSupervisorForActo, this, aTipoActoForActo);
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

	public String getMail() {
		return mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	/* Code from template association_GetOne */
	public Acto getActo() {
		return acto;
	}

	public void delete() {
		Acto existingActo = acto;
		acto = null;
		if (existingActo != null) {
			existingActo.delete();
		}
	}

	public String toString() {
		return super.toString() + "[" + "identificacion" + ":" + getIdentificacion() + "," + "nombre" + ":"
				+ getNombre() + "," + "mail" + ":" + getMail() + "," + "telefono" + ":" + getTelefono() + ","
				+ "direccion" + ":" + getDireccion() + "]" + System.getProperties().getProperty("line.separator") + "  "
				+ "acto = " + (getActo() != null ? Integer.toHexString(System.identityHashCode(getActo())) : "null");
	}
}