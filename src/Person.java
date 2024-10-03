
public class Person {

    //Atributs
    private String dni;
    //Constructor
    public Person (String dni) {
        this.dni = dni;
    }

    //Utilitzat per obtenir el Dni privat
    public String getDni() {
        return dni;
    }

    //Utilitzat per modificar el Dni per abans fent una validació
    public void setDni(String dni) {
        if (dni != null && dni.matches("\\d{8}[A-Za-z]")) {
            this.dni = dni;
        } else {
            throw new IllegalArgumentException("DNI inválido. Debe tener 8 dígitos seguidos de una letra.");
        }
    }
}
