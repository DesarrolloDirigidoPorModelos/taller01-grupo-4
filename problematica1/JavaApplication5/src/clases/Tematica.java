package clases;
import java.sql.Date;

// line 35 "model.ump"
// line 67 "model.ump"
public class Tematica
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tematica Attributes
  private String Id;
  private String Nombre;
  private String Activo;

  //Tematica Associations
  private Turno turno;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tematica(String aId, String aNombre, String aActivo, Turno aTurno)
  {
    Id = aId;
    Nombre = aNombre;
    Activo = aActivo;
//    if (aTurno == null || aTurno.getTematica() != null)
//    {
//      throw new RuntimeException("Unable to create Tematica due to aTurno. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
//    }
    turno = aTurno;
  }

  public Tematica(String aId, String aNombre, String aActivo, String aIdForTurno, Date aFechaForTurno, String aEstadoForTurno, Empleado aEmpleadoForTurno, Cliente aClienteForTurno)
  {
    Id = aId;
    Nombre = aNombre;
    Activo = aActivo;
    turno = new Turno(aIdForTurno, aFechaForTurno, aEstadoForTurno, aEmpleadoForTurno, aClienteForTurno, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    Id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setNombre(String aNombre)
  {
    boolean wasSet = false;
    Nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setActivo(String aActivo)
  {
    boolean wasSet = false;
    Activo = aActivo;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return Id;
  }

  public String getNombre()
  {
    return Nombre;
  }

  public String getActivo()
  {
    return Activo;
  }
  /* Code from template association_GetOne */
  public Turno getTurno()
  {
    return turno;
  }

  public void delete()
  {
    Turno existingTurno = turno;
    turno = null;
    if (existingTurno != null)
    {
      existingTurno.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "Id" + ":" + getId()+ "," +
            "Nombre" + ":" + getNombre()+ "," +
            "Activo" + ":" + getActivo()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "turno = "+(getTurno()!=null?Integer.toHexString(System.identityHashCode(getTurno())):"null");
  }
}