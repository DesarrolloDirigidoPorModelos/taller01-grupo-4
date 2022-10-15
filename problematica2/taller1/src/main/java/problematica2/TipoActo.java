/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package problematica2;

import java.sql.Date;

// line 35 "model.ump"
// line 64 "model.ump"
public class TipoActo {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// TipoActo Attributes
	private String id;
	private String nombre;

	// TipoActo Associations
	private Acto acto;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public TipoActo(String aId, String aNombre, Acto aActo) {
		id = aId;
		nombre = aNombre;
//		if (aActo == null || aActo.getTipoActo() != null) {
//			throw new RuntimeException(
//					"Unable to create TipoActo due to aActo. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
//		}
		acto = aActo;
	}

	public TipoActo(String aId, String aNombre, int aIdForActo, Date aFechaForActo, String aNombreForActo,
			String aDescripcionForActo, String aLugarForActo, double aCostoTotalForActo, Supervisor aSupervisorForActo,
			Patrocinador aPatrocinadorForActo) {
		id = aId;
		nombre = aNombre;
		acto = new Acto(aIdForActo, aFechaForActo, aNombreForActo, aDescripcionForActo, aLugarForActo,
				aCostoTotalForActo, aSupervisorForActo, aPatrocinadorForActo, this);
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public boolean setId(String aId) {
		boolean wasSet = false;
		id = aId;
		wasSet = true;
		return wasSet;
	}

	public boolean setNombre(String aNombre) {
		boolean wasSet = false;
		nombre = aNombre;
		wasSet = true;
		return wasSet;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
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
		return super.toString() + "[" + "id" + ":" + getId() + "," + "nombre" + ":" + getNombre() + "]"
				+ System.getProperties().getProperty("line.separator") + "  " + "acto = "
				+ (getActo() != null ? Integer.toHexString(System.identityHashCode(getActo())) : "null");
	}
}