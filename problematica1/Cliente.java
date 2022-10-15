import java.sql.Date;
import java.util.*;

// line 2 "model.ump"
// line 48 "model.ump"
public class Cliente
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cliente Attributes
  private String Identificacion;
  private String Nombre;
  private String Apellido;
  private Date FechaNacimiento;
  private String Email;
  private String Telefono;
  private String Direccion;

  //Cliente Associations
  private List<Turno> turnos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cliente(String aIdentificacion, String aNombre, String aApellido, Date aFechaNacimiento, String aEmail, String aTelefono, String aDireccion)
  {
    Identificacion = aIdentificacion;
    Nombre = aNombre;
    Apellido = aApellido;
    FechaNacimiento = aFechaNacimiento;
    Email = aEmail;
    Telefono = aTelefono;
    Direccion = aDireccion;
    turnos = new ArrayList<Turno>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdentificacion(String aIdentificacion)
  {
    boolean wasSet = false;
    Identificacion = aIdentificacion;
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

  public boolean setFechaNacimiento(Date aFechaNacimiento)
  {
    boolean wasSet = false;
    FechaNacimiento = aFechaNacimiento;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    Email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setTelefono(String aTelefono)
  {
    boolean wasSet = false;
    Telefono = aTelefono;
    wasSet = true;
    return wasSet;
  }

  public boolean setDireccion(String aDireccion)
  {
    boolean wasSet = false;
    Direccion = aDireccion;
    wasSet = true;
    return wasSet;
  }

  public String getIdentificacion()
  {
    return Identificacion;
  }

  public String getNombre()
  {
    return Nombre;
  }

  public String getApellido()
  {
    return Apellido;
  }

  public Date getFechaNacimiento()
  {
    return FechaNacimiento;
  }

  public String getEmail()
  {
    return Email;
  }

  public String getTelefono()
  {
    return Telefono;
  }

  public String getDireccion()
  {
    return Direccion;
  }
  /* Code from template association_GetMany */
  public Turno getTurno(int index)
  {
    Turno aTurno = turnos.get(index);
    return aTurno;
  }

  public List<Turno> getTurnos()
  {
    List<Turno> newTurnos = Collections.unmodifiableList(turnos);
    return newTurnos;
  }

  public int numberOfTurnos()
  {
    int number = turnos.size();
    return number;
  }

  public boolean hasTurnos()
  {
    boolean has = turnos.size() > 0;
    return has;
  }

  public int indexOfTurno(Turno aTurno)
  {
    int index = turnos.indexOf(aTurno);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTurnos()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Turno addTurno(String aId, Date aFecha, String aEstado, Empleado aEmpleado, Tematica aTematica)
  {
    return new Turno(aId, aFecha, aEstado, aEmpleado, this, aTematica);
  }

  public boolean addTurno(Turno aTurno)
  {
    boolean wasAdded = false;
    if (turnos.contains(aTurno)) { return false; }
    Cliente existingCliente = aTurno.getCliente();
    boolean isNewCliente = existingCliente != null && !this.equals(existingCliente);
    if (isNewCliente)
    {
      aTurno.setCliente(this);
    }
    else
    {
      turnos.add(aTurno);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTurno(Turno aTurno)
  {
    boolean wasRemoved = false;
    //Unable to remove aTurno, as it must always have a cliente
    if (!this.equals(aTurno.getCliente()))
    {
      turnos.remove(aTurno);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTurnoAt(Turno aTurno, int index)
  {  
    boolean wasAdded = false;
    if(addTurno(aTurno))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTurnos()) { index = numberOfTurnos() - 1; }
      turnos.remove(aTurno);
      turnos.add(index, aTurno);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTurnoAt(Turno aTurno, int index)
  {
    boolean wasAdded = false;
    if(turnos.contains(aTurno))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTurnos()) { index = numberOfTurnos() - 1; }
      turnos.remove(aTurno);
      turnos.add(index, aTurno);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTurnoAt(aTurno, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=turnos.size(); i > 0; i--)
    {
      Turno aTurno = turnos.get(i - 1);
      aTurno.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "Identificacion" + ":" + getIdentificacion()+ "," +
            "Nombre" + ":" + getNombre()+ "," +
            "Apellido" + ":" + getApellido()+ "," +
            "Email" + ":" + getEmail()+ "," +
            "Telefono" + ":" + getTelefono()+ "," +
            "Direccion" + ":" + getDireccion()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "FechaNacimiento" + "=" + (getFechaNacimiento() != null ? !getFechaNacimiento().equals(this)  ? getFechaNacimiento().toString().replaceAll("  ","    ") : "this" : "null");
  }
}