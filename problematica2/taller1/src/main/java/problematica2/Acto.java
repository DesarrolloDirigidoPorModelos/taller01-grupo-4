/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package problematica2;

import java.sql.Date;

// line 13 "model.ump"
// line 50 "model.ump"
public class Acto {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Acto Attributes
	private int id;
	private Date fecha;
	private String nombre;
	private String descripcion;
	private String lugar;
	private double costoTotal;

	// Acto Associations
	private Supervisor supervisor;
	private Patrocinador patrocinador;
	private TipoActo tipoActo;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public Acto(int aId, Date aFecha, String aNombre, String aDescripcion, String aLugar, double aCostoTotal,
			Supervisor aSupervisor, Patrocinador aPatrocinador, TipoActo aTipoActo) {
		id = aId;
		fecha = aFecha;
		nombre = aNombre;
		descripcion = aDescripcion;
		lugar = aLugar;
		costoTotal = aCostoTotal;
		boolean didAddSupervisor = setSupervisor(aSupervisor);
		if (!didAddSupervisor) {
			throw new RuntimeException(
					"Unable to create acto due to supervisor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
		if (aPatrocinador == null || aPatrocinador.getActo() != null) {
			throw new RuntimeException(
					"Unable to create Acto due to aPatrocinador. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
		patrocinador = aPatrocinador;
//		if (aTipoActo == null || aTipoActo.getActo() != null) {
//			throw new RuntimeException(
//					"Unable to create Acto due to aTipoActo. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
//		}
		tipoActo = aTipoActo;
	}

	public Acto(int aId, Date aFecha, String aNombre, String aDescripcion, String aLugar, double aCostoTotal,
			Supervisor aSupervisor, String aIdentificacionForPatrocinador, String aNombreForPatrocinador,
			String aMailForPatrocinador, String aTelefonoForPatrocinador, String aDireccionForPatrocinador,
			String aIdForTipoActo, String aNombreForTipoActo) {
		id = aId;
		fecha = aFecha;
		nombre = aNombre;
		descripcion = aDescripcion;
		lugar = aLugar;
		costoTotal = aCostoTotal;
		boolean didAddSupervisor = setSupervisor(aSupervisor);
		if (!didAddSupervisor) {
			throw new RuntimeException(
					"Unable to create acto due to supervisor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
		patrocinador = new Patrocinador(aIdentificacionForPatrocinador, aNombreForPatrocinador, aMailForPatrocinador,
				aTelefonoForPatrocinador, aDireccionForPatrocinador, this);
		tipoActo = new TipoActo(aIdForTipoActo, aNombreForTipoActo, this);
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public boolean setId(int aId) {
		boolean wasSet = false;
		id = aId;
		wasSet = true;
		return wasSet;
	}

	public boolean setFecha(Date aFecha) {
		boolean wasSet = false;
		fecha = aFecha;
		wasSet = true;
		return wasSet;
	}

	public boolean setNombre(String aNombre) {
		boolean wasSet = false;
		nombre = aNombre;
		wasSet = true;
		return wasSet;
	}

	public boolean setDescripcion(String aDescripcion) {
		boolean wasSet = false;
		descripcion = aDescripcion;
		wasSet = true;
		return wasSet;
	}

	public boolean setLugar(String aLugar) {
		boolean wasSet = false;
		lugar = aLugar;
		wasSet = true;
		return wasSet;
	}

	public boolean setCostoTotal(double aCostoTotal) {
		boolean wasSet = false;
		costoTotal = aCostoTotal;
		wasSet = true;
		return wasSet;
	}

	public int getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	/* Code from template association_GetOne */
	public Supervisor getSupervisor() {
		return supervisor;
	}

	/* Code from template association_GetOne */
	public Patrocinador getPatrocinador() {
		return patrocinador;
	}

	/* Code from template association_GetOne */
	public TipoActo getTipoActo() {
		return tipoActo;
	}

	/* Code from template association_SetOneToMany */
	public boolean setSupervisor(Supervisor aSupervisor) {
		boolean wasSet = false;
		if (aSupervisor == null) {
			return wasSet;
		}

		Supervisor existingSupervisor = supervisor;
		supervisor = aSupervisor;
		if (existingSupervisor != null && !existingSupervisor.equals(aSupervisor)) {
			existingSupervisor.removeActo(this);
		}
		supervisor.addActo(this);
		wasSet = true;
		return wasSet;
	}

	public void delete() {
		Supervisor placeholderSupervisor = supervisor;
		this.supervisor = null;
		if (placeholderSupervisor != null) {
			placeholderSupervisor.removeActo(this);
		}
		Patrocinador existingPatrocinador = patrocinador;
		patrocinador = null;
		if (existingPatrocinador != null) {
			existingPatrocinador.delete();
		}
		TipoActo existingTipoActo = tipoActo;
		tipoActo = null;
		if (existingTipoActo != null) {
			existingTipoActo.delete();
		}
	}

	public String toString() {
		return super.toString() + "[" + "id" + ":" + getId() + "," + "nombre" + ":" + getNombre() + "," + "descripcion"
				+ ":" + getDescripcion() + "," + "lugar" + ":" + getLugar() + "," + "costoTotal" + ":" + getCostoTotal()
				+ "]" + System.getProperties().getProperty("line.separator") + "  " + "fecha" + "="
				+ (getFecha() != null
						? !getFecha().equals(this) ? getFecha().toString().replaceAll("  ", "    ") : "this"
						: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "supervisor = "
				+ (getSupervisor() != null ? Integer.toHexString(System.identityHashCode(getSupervisor())) : "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "patrocinador = "
				+ (getPatrocinador() != null ? Integer.toHexString(System.identityHashCode(getPatrocinador())) : "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "tipoActo = "
				+ (getTipoActo() != null ? Integer.toHexString(System.identityHashCode(getTipoActo())) : "null");
	}
}