import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Contacte {
    private int telf;
    private String nom;

    public Contacte(int telf, String nom){
        this.nom = nom;
        this.telf = telf;
    }
    @Override
    public String toString() {
        return "Contacte{" +
                "telf=" + telf +
                ", nom='" + nom + '\'' +
                '}';
    }//Permet sense geters imprimir la informacio del cotnacte a altres classes
    @Override
    public boolean equals (Object obj) {
        if(obj instanceof Contacte){
            Contacte cont = (Contacte) obj;
            return this.telf == cont.telf &&
                    this.nom == cont.nom;
        }
        return false;
    }

    public int getTelf(){
        return this.telf;
    }
    public String getNom(){
        return this.nom;
    }
    public void setTelf(int telf) {
        if(telf >= 900000000 && telf <= 999999999){
            this.telf = telf;
        } else {
            System.out.println("No s'ha pogut establir el numero de telefon");
        }
    }
    public void setNom(String nom) {
        if(nom.length() >= 2){
            this.nom = nom;
        } else {
            System.out.println("No s'ha pogut establir el nom del contacte");
        }
    }

}
