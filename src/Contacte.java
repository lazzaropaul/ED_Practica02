import java.util.Objects;

public class Contacte {
    private int telf;
    private String nom;

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

    public void setNom(int telf) {
        if(telf >= 900000000 && telf <= 999999999){
            this.telf = telf;
        } else {
            System.out.println("No s'ha pogut establir el numero de telefon");
        }
    }

}
