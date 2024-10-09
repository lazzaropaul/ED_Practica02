import java.util.List;

public class Storage<T> {

    //Atribut que guardi elements de la nostra classe storage
    private List <T> itemsList;

    public Storage (List <T> itemsList) {
        this.itemsList = itemsList;
    }

    public void addItem (T item) {
        //Métode que afegirà un nou element dins la nostra llista de storage
        itemsList.add(item);
        System.out.println("Nou item afeigit a la llista correctement");
    }
    public List<T> getItems () {
        //Retorna la llista d'elements de la clase storage
        System.out.println("Tots els elements de la llista:");
        return itemsList;
    }
    public void copyTo (Storage <? super T> otherStorage) {
        //otherStorage.setItemsList(this.itemsList);
        List <? super T> otherList = otherStorage.getItemsList();
        otherList.addAll(this.itemsList);
    }
    public List<T> getItemsList() {
        return itemsList;
    }
}
