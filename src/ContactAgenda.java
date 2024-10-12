import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ContactAgenda  {
    private List<Contacte> contacteAgenda;

    public ContactAgenda () {
        contacteAgenda = new ArrayList<Contacte>();
    }

    public ContactAgenda (List<Contacte> contacteAgenda) {
        this.contacteAgenda = contacteAgenda;
    }

    public void addContact (int telf, String name) {
        //Fer servit métode buscar contacto
        if(!searchContact(name)){
            Contacte newContact = new Contacte(telf,name);
            contacteAgenda.add(newContact);
            System.out.println(newContact);
        } else {
            System.out.println("El contacte ja existeix, no es pot afegir");
        }
    }

    public void getAllContacts () {
        Iterator<Contacte> contacteIt = this.contacteAgenda.iterator();
        contacteIt.forEachRemaining(System.out::println); //Automàticament, crida al mètode toString de la classe Contacte
    }

    public boolean searchContact (String nom) {
        ListIterator<Contacte> listIt = contacteAgenda.listIterator();
        boolean contactFound = false;
        Contacte aux = new Contacte();

        while(listIt.hasNext() && !contactFound){
            aux = listIt.next();
            if(aux.getNom().equals(nom)){
                contactFound = true;
                System.out.println(aux);
            }
        }

        return contactFound;
    }
    public void deleteContact (String nom) {
        ListIterator<Contacte> listIt = contacteAgenda.listIterator();
        boolean contactFound = false;

        while(listIt.hasNext() && !contactFound){
            if(listIt.next().getNom().equals(nom)){
                contactFound = true;
                listIt.remove();
                System.out.println("Contacte eliminat amb exit");
            }
        }

        if(!contactFound){
            System.out.println("Contacte no trobat");
        }

    }
}
