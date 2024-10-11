import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//Volem crear una classe que fabriqui departaments
public class Department<E> {
    private List<Person> objectList;
    private String nameOfDepartment;
    private String IdDepartment;
    public Department (List<Person> objectList,
                       String nameOfDepartment, String IdDepartment){

         this.nameOfDepartment = nameOfDepartment;
         this.IdDepartment = IdDepartment;
         this.objectList = objectList;

    }
//
//    public Department() {
//        this.nameOfDepartment = "";
//        this.IdDepartment = "";
//        this.engineersList = null;
//    }
//
//    public String getNameOfDepartment() {
//        return nameOfDepartment;
//    }
//    public String getIdDepartment() {
//        return IdDepartment;
//    }
//
//    public void setNameOfDepartment(String nameOfDepartment) {
//        this.nameOfDepartment = nameOfDepartment;
//    }
//    public void setIdDepartment(String idDepartment) {
//        this.IdDepartment = idDepartment;
//    }
//    /*public void setJefeDepartment(Engineer jefeDepartment) {
//        this.jefeDepartment = jefeDepartment;
//    }*/
//
//    public void addEngineers(List<Engineer> l_eng){
//        this.engineersList.addAll(l_eng);  //Funció que trespassa tots els obj d'una llista a un altre
//    }

    /**
     * Retorna un Engineer buit quan no hi ha un jefe de dept.
     * @return Engineer jefe del Dept.
     */

    public Person getHead() {

        Iterator<? extends Person> it = objectList.iterator();
        Person jefeDept = null;

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
