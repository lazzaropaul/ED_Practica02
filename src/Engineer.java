public class Engineer extends Person {

    /*
   Optimització de memòria, en comptes de guardar l'objecte sencer,
   guardem únicament el id, així el relacionem més tard
    */
    private String IdDepartment;

    public Engineer (String Dni, String especialidad, String IdDepartment){
        super(Dni, especialidad);
        this.IdDepartment = IdDepartment;
    }

    @Override
    public void printInfo() {
        System.out.print("Especialidad: " + getEspecialidad() +
                            ", DNI: " + getDni() +
                            ", Departament:  " + getIdDepartment() + "\n")  ;
    }


    public String getIdDepartment() {
        return IdDepartment;
    }
}