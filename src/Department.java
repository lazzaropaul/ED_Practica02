import java.util.Iterator;
import java.util.List;

//Volem crear una classe que fabriqui departaments
public class Department {
    private List<Engineer> engineersList;
    private String nameOfDepartment;
    private String IdDepartment;
    public Department (List<Engineer> engineersList,
                       String nameOfDepartment, String IdDepartment){

         this.nameOfDepartment = nameOfDepartment;
         this.IdDepartment = IdDepartment;
         this.engineersList = engineersList;

    }

    public Department() {
        this.nameOfDepartment = "";
        this.IdDepartment = "";
        this.engineersList = null;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }
    public String getIdDepartment() {
        return IdDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }
    public void setIdDepartment(String idDepartment) {
        this.IdDepartment = idDepartment;
    }
    /*public void setJefeDepartment(Engineer jefeDepartment) {
        this.jefeDepartment = jefeDepartment;
    }*/

    public void addEngineers(List<Engineer> l_eng){
        this.engineersList.addAll(l_eng);  //Funció que trespassa tots els obj d'una llista a un altre
    }

    /**
     * Retorna un Engineer buit quan no hi ha un jefe de dept.
     * @return Engineer jefe del Dept.
     */
    public Engineer getHead() {
        Iterator<Engineer> it = engineersList.iterator();
        Engineer jefeDept = new Engineer();

        boolean jefeFound = false;
        while (it.hasNext() && !jefeFound) {
            jefeDept = it.next();
            if(jefeDept.getEspecialidad().equals("Jefe")){
                jefeFound = true;
            }
        }
        return jefeDept;
    }

}
