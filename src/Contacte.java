
public class Contacte {
    private int telf;
    private String nom;

    public Contacte(){
        this.telf = 0;
        this.nom = "";
    }

    public Contacte(int telf, String nom){
        this.nom = nom;
        this.telf = telf;
    }

    @Override
    public String toString() {
        return "\nContacte {\n" +
                "\ttelf = " + telf + ",\n" +
                "\tnom = '" + nom + '\'' +
                "\n}";
    }//Permet sense geters imprimir la informacio del contacte a altres classes

    @Override

    public boolean equals (Object obj) {
        if(obj instanceof Contacte cont){
            return this.telf == cont.telf &&
                    this.nom == cont.nom;
        }
        return false;
    }

    public String getNom(){
        return this.nom;
    }

    //Encara que és una bona pràctica, algun getter i els setters no són necessaris en aquesta pràctica

}
