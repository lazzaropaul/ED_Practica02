import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
