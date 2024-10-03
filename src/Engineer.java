public class Engineer extends Person {

    /*
   Optimització de memòria, en comptes de guardar l'objecte sencer,
   guardem únicament el id, així el relacionem més tard
    */
    private String IdDepartment;
    private String especialidad; //ROl

    public Engineer() {
        super("");
        this.especialidad = "";
        this.IdDepartment = "";
    }

    public Engineer (String Dni, String especialidad, String IdDepartment){
        super(Dni);
        this.especialidad = especialidad;
        this.IdDepartment = IdDepartment;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getIdDepartment() {
        return IdDepartment;
    }
}