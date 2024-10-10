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
        Contacte newContact = new Contacte();
        if(searchContact(name).equals(newContact)){
            System.out.println("El contacte ja existeix");
        } else {
            newContact.setTelf(telf);
            newContact.setNom(name);
            contacteAgenda.add(newContact);
            System.out.println(newContact);
        }
    }

    public void getAllContacts (List<Contacte> contactsList) {
        Iterator<Contacte> contacteIt = contactsList.iterator();
        contacteIt.forEachRemaining(System.out::println); //Crida al metode toString de la classe Contacte
    }

    public Contacte searchContact (String nom) {
        ListIterator<Contacte> listIt = contacteAgenda.listIterator();
        boolean contactFound = false;
        Contacte aux = new Contacte();

        while(listIt.hasNext() && !contactFound){
            aux = listIt.next();
            if(aux.getNom().equals(nom)){
                contactFound = true;
            }
        }

        if(!contactFound){
            System.out.println("Contacte no trobat, es retornarà un contacte buit");
        }

        return contactFound ? aux : new Contacte(); //Si no es troba el contacte, retornem un buit, en cas contrari, retornem el contacte trobat (TERNARIA)
    }
    public void deleteContact (String nom) {
        ListIterator<Contacte> listIt = contacteAgenda.listIterator();
        boolean contactFound = false;

        while(listIt.hasNext() && !contactFound){
            if(listIt.next().getNom().equals(nom)){
                contactFound = true;
                listIt.remove();
            }
        }

        if(!contactFound){
            System.out.println("Contacte no trobat, es retornarà un contacte buit");
        }

    }
}
