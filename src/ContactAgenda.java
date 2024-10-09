import java.util.Iterator;
import java.util.List;

public class ContactAgenda  {
    private List<Contacte> contacteAgenda;

    public ContactAgenda (List<Contacte> contacteAgenda) {

        this.contacteAgenda = contacteAgenda;
    }

    public void addContact (int telef) {
        //Fer servit métode buscar contacto
    }
    public void getAllContacts (List<Contacte> contactsList) {
        Iterator<Contacte> contacteIt = contactsList.iterator();
        contacteIt.forEachRemaining(System.out::println); //Crida al metode toString de la classe Contacte
    }
    public void searchContact () {
        //Search by name utilizando Listiterator y equals
    }
    public void deleteContact () {

    }
}
