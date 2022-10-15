import java.sql.Date;

// line 15 "model.ump"
// line 54 "model.ump"
public class Turno
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Turno Attributes
  private String Id;
  private Date Fecha;
  private String Estado;

  //Turno Associations
  private Empleado empleado;
  private Cliente cliente;
  private Tematica tematica;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Turno(String aId, Date aFecha, String aEstado, Empleado aEmpleado, Cliente aCliente, Tematica aTematica)
  {
    Id = aId;
    Fecha = aFecha;
    Estado = aEstado;
    if (aEmpleado == null || aEmpleado.getTurno() != null)
    {
      throw new RuntimeException("Unable to create Turno due to aEmpleado. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    empleado = aEmpleado;
    boolean didAddCliente = setCliente(aCliente);
    if (!didAddCliente)
    {
      throw new RuntimeException("Unable to create turno due to cliente. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aTematica == null || aTematica.getTurno() != null)
    {
      throw new RuntimeException("Unable to create Turno due to aTematica. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    tematica = aTematica;
  }

  public Turno(String aId, Date aFecha, String aEstado, String aIdForEmpleado, String aNombreForEmpleado, String aApellidoForEmpleado, String aCargoForEmpleado, Cliente aCliente, String aIdForTematica, String aNombreForTematica, String aActivoForTematica)
  {
    Id = aId;
    Fecha = aFecha;
    Estado = aEstado;
    empleado = new Empleado(aIdForEmpleado, aNombreForEmpleado, aApellidoForEmpleado, aCargoForEmpleado, this);
    boolean didAddCliente = setCliente(aCliente);
    if (!didAddCliente)
    {
      throw new RuntimeException("Unable to create turno due to cliente. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    tematica = new Tematica(aIdForTematica, aNombreForTematica, aActivoForTematica, this);
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

  public boolean setFecha(Date aFecha)
  {
    boolean wasSet = false;
    Fecha = aFecha;
    wasSet = true;
    return wasSet;
  }

  public boolean setEstado(String aEstado)
  {
    boolean wasSet = false;
    Estado = aEstado;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return Id;
  }

  public Date getFecha()
  {
    return Fecha;
  }

  public String getEstado()
  {
    return Estado;
  }
  /* Code from template association_GetOne */
  public Empleado getEmpleado()
  {
    return empleado;
  }
  /* Code from template association_GetOne */
  public Cliente getCliente()
  {
    return cliente;
  }
  /* Code from template association_GetOne */
  public Tematica getTematica()
  {
    return tematica;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCliente(Cliente aCliente)
  {
    boolean wasSet = false;
    if (aCliente == null)
    {
      return wasSet;
    }

    Cliente existingCliente = cliente;
    cliente = aCliente;
    if (existingCliente != null && !existingCliente.equals(aCliente))
    {
      existingCliente.removeTurno(this);
    }
    cliente.addTurno(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Empleado existingEmpleado = empleado;
    empleado = null;
    if (existingEmpleado != null)
    {
      existingEmpleado.delete();
    }
    Cliente placeholderCliente = cliente;
    this.cliente = null;
    if(placeholderCliente != null)
    {
      placeholderCliente.removeTurno(this);
    }
    Tematica existingTematica = tematica;
    tematica = null;
    if (existingTematica != null)
    {
      existingTematica.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "Id" + ":" + getId()+ "," +
            "Estado" + ":" + getEstado()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "Fecha" + "=" + (getFecha() != null ? !getFecha().equals(this)  ? getFecha().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "empleado = "+(getEmpleado()!=null?Integer.toHexString(System.identityHashCode(getEmpleado())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "cliente = "+(getCliente()!=null?Integer.toHexString(System.identityHashCode(getCliente())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "tematica = "+(getTematica()!=null?Integer.toHexString(System.identityHashCode(getTematica())):"null");
  }
}
