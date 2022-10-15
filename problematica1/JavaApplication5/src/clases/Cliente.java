package clases;
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