
public abstract class Person {

    private String dni;
    private String especialidad;

    public Person (String dni , String especialidad) {
        this.dni = dni;
        this.especialidad = especialidad;
    }

    public Person () {
        this.dni = "";
        this.especialidad = "";
    }

    //Mètode per poder obtindere atributs de les subclases
    public abstract void printInfo();

    //Utilitzat per obtenir el Dni privat
    public String getDni() {
        return dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

}
