import java.util.List;

public class PersonStorage extends Storage<Person>{
    public PersonStorage(List<Person> personsList) {
        super(personsList);
    }
    public void personInfo (Person p) {
        System.out.println("DNI de la persona: " + p.getDni());
    }
}
