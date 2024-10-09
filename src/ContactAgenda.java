import java.util.Iterator;
import java.util.List;

public class ContactAgenda {

    private List<Contacte> contacteAgenda;

    public ContactAgenda (List<Contacte> contacteAgenda) {
        this.contacteAgenda = contacteAgenda;
    }

    public void addContact (int telef) {
        //Fer servit métode buscar contacto
    }
    public void getAllContacts (List<Contacte> contactsList) {
        //utilitza ListIterator
        Iterator<Contacte> contacteIt = contactsList.iterator();
        contacteIt.forEachRemaining(System.out::print);

    }
    public void searchContact () {
        //Search by name utilizando Listiterator y equals
    }
    public void deleteContact () {

    }
}
