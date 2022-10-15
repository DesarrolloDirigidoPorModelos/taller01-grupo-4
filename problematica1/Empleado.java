import java.sql.Date;

// line 25 "model.ump"
// line 61 "model.ump"
public class Empleado
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Empleado Attributes
  private String Id;
  private String Nombre;
  private String Apellido;
  private String Cargo;

  //Empleado Associations
  private Turno turno;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Empleado(String aId, String aNombre, String aApellido, String aCargo, Turno aTurno)
  {
    Id = aId;
    Nombre = aNombre;
    Apellido = aApellido;
    Cargo = aCargo;
    if (aTurno == null || aTurno.getEmpleado() != null)
    {
      throw new RuntimeException("Unable to create Empleado due to aTurno. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    turno = aTurno;
  }

  public Empleado(String aId, String aNombre, String aApellido, String aCargo, String aIdForTurno, Date aFechaForTurno, String aEstadoForTurno, Cliente aClienteForTurno, Tematica aTematicaForTurno)
  {
    Id = aId;
    Nombre = aNombre;
    Apellido = aApellido;
    Cargo = aCargo;
    turno = new Turno(aIdForTurno, aFechaForTurno, aEstadoForTurno, this, aClienteForTurno, aTematicaForTurno);
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

  public boolean setApellido(String aApellido)
  {
    boolean wasSet = false;
    Apellido = aApellido;
    wasSet = true;
    return wasSet;
  }

  public boolean setCargo(String aCargo)
  {
    boolean wasSet = false;
    Cargo = aCargo;
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

  public String getApellido()
  {
    return Apellido;
  }

  public String getCargo()
  {
    return Cargo;
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
            "Apellido" + ":" + getApellido()+ "," +
            "Cargo" + ":" + getCargo()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "turno = "+(getTurno()!=null?Integer.toHexString(System.identityHashCode(getTurno())):"null");
  }
}