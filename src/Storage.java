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
        System.out.println("Nou item afeigit a la llista");
    }
    public  void getItems (List <T> list) {
        //Retorna la llista d'elements de la clase storage
        System.out.println("La teva llista és: ");
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.print(itemsList.get(i) + " ");
        }
    }
    public void copyTo (Storage <? super T> otherStorage) {

    }

}
