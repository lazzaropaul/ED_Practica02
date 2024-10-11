import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcio = 1;

    while (opcio != 0) {

        System.out.println("Quin exercici vols comprovar (1 -- 10), prem 0 per sortir");
        opcio = sc.nextInt();

        switch (opcio) {
            case 0 :
                System.out.println("Adeu!"); break;
            case 1 : exerciciUn(); break; // aqui tambe falta algo
            case 2 : exerciciDos(); break; //Falta generalitzar la capsalera del codi amb comodins wtf
            case 4 : exerciciQuatre(); break;
            case 6 : exerciciSis(); break;
            case 7 : exerciciSet(); break;
            case 9 : exercici9(); break;
            case 10: exerciciDeu(); break;
            case 3 , 5, 8:
                System.out.println("Exercici teòric"); break;
            default:
                System.out.println("Sergioo, introdueix un numero vàlid!");
        }
    }

    }


    /////////////////////////Exercici 1 Inici//////////////////////////////

    public static void exerciciUn(){
        //Llista vuida que contindrà tots els jefes de departament
        List<Person> jefesDepartamentos = new ArrayList<>();

        //Llista d'enginyers
        List<Person> l_eng = new ArrayList<>();
        l_eng.add(new Engineer("123456X","Software", "D01"));
        l_eng.add(new Engineer("12345678A", "Informàtic", "D01"));
        l_eng.add(new Engineer("87654321B" , "Jefe", "D01"));
        l_eng.add(new Engineer("47145065F" , "Telecos", "D01"));

        List<Person> list_eng = new ArrayList<>();
        list_eng.add(new Engineer("12345678x", "Informàtic", "D04" ));
        list_eng.add(new Engineer("98765432S" , "Software", "D04"));
        list_eng.add(new Engineer("12332112A" , "Jefe", "D04"));

        //llistat de departaments
        List<Department <Person>> l_dep = new ArrayList<>();
        l_dep.add(new Department<Person>(l_eng,"Mates", "D01"));
        l_dep.add(new Department<Person>(list_eng,"Fisica", "D04"));

        bossOfEachDepartment(jefesDepartamentos , l_dep);
    }
    public static void bossOfEachDepartment (List<Person> objectList,
                                             List< ? extends Department<Person> > departments){
        Iterator<? extends Department<Person>> itDep = departments.iterator();
        Department dep;

        while (itDep.hasNext()){
            dep = itDep.next();
            if (dep.getHead() != null) { //Hi ha un jefe al departament
                objectList.add(dep.getHead());
            }
        }
        infoOfEachBoss(objectList);
    }
    public static void infoOfEachBoss(List <Person> objectList ) {
        Iterator<Person> itEng = objectList.iterator();
        Person obj;
        System.out.println("La nostra llista d'Enginyers conté:");
        while (itEng.hasNext()){
            obj = itEng.next();
            obj.printInfo(); //Metode abstracte de person
        }
    }


    /*
    • Si se desea escribir la lista de ingenieros, ¿se puede utilizar el siguiente método?
        ▪ void printNames(List<Person> lp)

    Sí perquè al rebre una llista de persones simplement la recorreriem i aniriem imprimint
    la informació de cada Person utilitzant el metode abstracte de la clase Person 'printInfo()'.

        public void printNames (List<Person> lp) {
        Iterator<Person> itp = lp.iterator();
        while (itp.hasNext()) {
            itp.next().printInfo();
        }
    }

    • ¿Cómo generalizarías la declaración del método usando comodines?
           Utilitzariem '? super E', ja que necesitem escriure elements de la llista

     */

    /////////////////////////Exercici 1 Final/////////////////////////

    /////////////////////////Exercici 2 Inici//////////////////////////

    public static void exerciciDos() {

        Random random = new Random();
        LinkedList <Integer> src = new LinkedList<>();
        LinkedList <Integer> trg = new LinkedList<>();

        //Afegirem X posicions dins de la llista, amb N nombres aleatoris.
        for (int index = 0; index < random.nextInt(10) + 1 ; index++){
            src.add(index, random.nextInt(20));
        }
        for (int index = 0; index < random.nextInt(10) + 1 ; index++){
            trg.add(index, random.nextInt(20));
        }

        // Mostrar les llistes abans de la modificació
        System.out.println("Llista src abans de modificar: " + src);
        System.out.println("Llista trg abans de modificar: " + trg);

        //Modifiquem llistes
        modifyPrefix(src, trg);

        // Mostrar les llistes desprès de la modificació
        System.out.println("Llista src                     : " + src);
        System.out.println("Llista trg desprès de modificar: " + trg);

    }

    public static <E> void modifyPrefix(LinkedList<E> src, LinkedList<E> tfg) {

        int min = Math.min(src.size(), tfg.size());
        for(int i = 0; i < min; i++){
            tfg.set(i, src.get(i));
        }
    }

    /*
    b) Generaliza la cabecera de la función anterior al máximo utilizando comodines.
    public static <E> void modifyPrefix(LinkedList<? super E> src, LinkedList<? super E> tfg)  {

        Ja que necessitem modificar les llistes utilitzaem el comodí super.
    }

     */

                /////////////////////////Exercici 2 Final/////////////////////////

                     /////////////////////////Exercici 3 Inici////////////////////////

    /*
      La implementació del mètode "equals()" és incorrecte ja que en aquest mètode comparem atributs que
      l'objecte "Object" no implementa.

      En aquest cas, l'objecte "Object" (el qual és el "pare" de tots els objectes en Java), no té un atribut
      anomenat "month", per tant, el que hem d'implementar és una conversió explicita en l'objecte "dt", convertint-lo
      a objecte MyDate, d'aquesta manera, podrem recuperar els atributs de l'objecte "dt" i comprar-los amb els de la classe MyDate.

      Però, abans de fer la conversió explicita, ens hem d'assegurar que l'objecte que passem per parametre, sigui
      l'objecte dessitjat, és a dir, que en aquest cas ens hagin passat un MyDate, per això, abans de realitzar qualsevol conversió explicita,
      comprovem que l'objecte a convertir (Object dt) té els mateixos atributs que l'objecte el qual farem ús per convertir (MyDate)
    */

    /*
     public class MyDate{
         public int month;
         (...)
         @Override
         public boolean equals (Object dt){
             //Comprovem que tenen els mateixos atributs amb el "instanceof", ja que per comparar objectes no podem fer "="
             if(obj instanceof MyDate){
                 MyDate date = (MyDate) dt; //Conversió explicita
                 return (date.month == this.month);
             }
         }
         (...)
      }
     */

    /////////////////////////Exercici 3 Final/////////////////////////

    /////////////////////////Exercici 4 Inici////////////////////////

    public static void exerciciQuatre() {

        //Inicialitzem una llista d'Integers per omplirla
        List<Integer> lista = Arrays.asList(10, 15, 20, 30, 2, 50);
        Iterator<Integer> it_integ =lista.iterator();
        Comparator<Integer> cmp = Integer::compare;
        /*
        els '::' es una referencia a un métode estatic que existeix dins la calsse integer
        */
        boolean allInRange = checkRange(it_integ , cmp, 10 , 50);
        System.out.println("Tots els numeros son dins el range? " + allInRange);
    }

    public static <E> boolean checkRange (Iterator<E> it , Comparator <E> cmp, E min , E max){

        while (it.hasNext()) {
            int comparacioMin = cmp.compare(it.next() , min);
            int comparacioMax = cmp.compare(it.next() , max);

            if (comparacioMin < 0  || comparacioMax > 0) {
                return false;
            }
        }
        return true;
    }

    /////////////////////////Exercici 4 Final/////////////////////////

    /////////////////////////Exercici 5 Inici////////////////////////

    /*  QUE ÉS "Comparable<E>"?:

        Quan definim una classe amb "implement Comparable<E>", el que
        estem definint és com s'han de comparar dos objectes del mateix tipus.

        Quan implementem el "Comparable", dins de la classe hem de fer Overwrite del mètode compareTo:

            @Override
            public int compareTo(Animal pedro) {
                return this.age - other.age;  // Compara els animals per edat
            }

         Però com que en aquest cas la classe Animal és abstracta, haurem d'implementar el "compareTo"
         en les classes filles de "Animal"
    */

    /*  ÚS DEL <E extends Comparable<E>>:

        En el cas dels mètodes, ens trobem amb "<E extends Comparable<E>>", aquesta línia de codi ens
        permet aplicar una restricció als objectes que li passem per parametre al mètode, sent la
        restricció que només li puguem passar objectes que implementin la funció compareTo() i que permeti
        comparar instancies de E. En el cas de "Comparable<? super E>", la restricció passa a involucrar
        classes més generals/superclasses
     */

    /* APARTAT a): ¿A qué método o métodos podemos llamar si tenemos una List<Snake>?
        Podrem cridar a "strongest1" sempre i quan la classe Snake implementi el "Comparable", i per consequencia
        la funció compareTo. En el cas de strongest2, sempre podrem cridar a aquest mètode perquè el mètode permet
        que Snake sigui comparat amb la seva superclase, ja que Snake penja d'Animal i Animal és comparable

       APARTAT b): ¿A qué método o métodos podemos llamar si tenemos una List<Animal>?
        No podem cridar a cap mètode ja que Animal és una classe abstracta
    */


    /////////////////////////Exercici 5 final////////////////////////

    /////////////////////////Exercici 6 Inici////////////////////////
    public static void exerciciSis (){

        List <Integer> listaInts = Arrays.asList(1,1,1,2,3,3,4,5,2,5,2,5,6);
        List <String> listaStrings = Arrays.asList("Hola" , "Hol", "Hol" , "Adeu" , "Adeu");
        debup(listaStrings);
    }

    public static <E> void debup ( List<E> lista ) {

        E aux = null;
        List <E> newList = new ArrayList<>();
        Iterator<E> it = lista.iterator();

        while (it.hasNext()) {

            E newInt = it.next();
            if (aux != newInt) {
                newList.add(newInt);
                aux = newInt;
            } else {
                aux = newInt;
            }
        }
        for(int i = 0; i < newList.size(); i++){
            System.out.println(newList.get(i));
        }
    }

    /////////////////////////Exercici 6 final////////////////////////

    /////////////////////////Exercici 7 Inici////////////////////////


    public static void exerciciSet () {

        List<Integer> list = Arrays.asList(20, 10 , 5 , 13 , 60 , 43, 2, 35);
        Iterator <Integer> it = list.iterator();
        List <String> strings = Arrays.asList("Hola" , "pene", "hol");
        //El orden lexicográfico significa que las cadenas se comparan carácter por carácter,
        //basándose en los valores Unicode de los caracteres.
        Iterator <String> it1 = strings.iterator();

        greaterThan(it , 20);
        greaterThan(it1 , "hola");

    }

    public static <E extends Comparable <? super E>> List<E> greaterThan (Iterator<E> it, E sample) {
        List <E> newList = new ArrayList<>();

        while (it.hasNext()) {
            E aux = it.next();
            if ( aux.compareTo(sample) > 0  ) { //elementos cuyo valor comparado con sample sea mayor que cero
                newList.add(aux);
            }
        }
        for (int i = 0; i < newList.size(); i++) {
            System.out.print(newList.get(i) + " ");
        }

        return newList;
    }

    /////////////////////////Exercici 7 final////////////////////////

    /////////////////////////Exercici 8 Inici////////////////////////
    /*

    1. No habrá problema si pasamos como parámetro de method1 una List<Food>.

       Observem que 'method1' te una restricció genèrica, ens diu
       que la llista que rebrà, ha d'implementar 'Comparable'.
       Per tant, a més de que Food() és una classe abstracte i no es pot instanciar,
       no pdríem pasrar-li una llista de Food(), ja que tampoc implementa 'Comparable'.

       Per tant la conclusió és que NO podríem pasar una List<Food> al metode 1, ja que
       no implementa 'Comparable'


    2. No habrá problema si pasamos como parámetro de method1 y de method2 una List<BigBurger>.

        Ja sabem que el mètode 1 implmenta 'Comparable'. Si passem per paràmetre una List<BigBurguer>
        tambè implementarà 'Comprable' ja que és un subtipus de Burguer el quàl és un subtipus del
        supertipus Meat, que si implementa 'Comparable'.

        Si observem el metode 2, tambè incorpora una restricció genèrica 'Comparable'. Per tant
        sí podriem passar una List<Burguer> sense problema.

        Per tant la conclusió és que no tindriem problema amb cap dels dos mètodes, ja que
        BigBurguer provè de la classe Meat, que sí implementa 'Comprable'.

     */
    /////////////////////////Exercici 8 final////////////////////////

    /////////////////////////Exercici 9 inici////////////////////////

    public static void exercici9 ( ) {
         /*
        • ¿Podemos guardar elementos de tipo Number en un Storage de Integer?
            No
        • ¿Podemos guardar elementos de tipo Integer en un Storage de Number?
            Sí
         */

        //Crearem dos llistes per pasar a Storage
        List <Number> numberList = new ArrayList<>( Arrays.asList(7, 8, 9, 10));
        List <Integer> intList = new ArrayList<>(Arrays.asList(1 ,2 ,3 ,4 ,5));
        //Instanciem dos noves Storage
        Storage <Number> newNumber = new Storage<>(numberList);
        Storage <Integer> newInt = new Storage<>(intList);

        //newNumber.copyTo(newInt);
        newInt.copyTo(newNumber);

    }

        /////////////////////////Exercici 9 final////////////////////////

    /////////////////////////Exercici 10 final////////////////////////
    public static void exerciciDeu () {

        ContactAgenda contactes = new ContactAgenda();

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Benvingut a l'agenda de contactes, tria l'acció a realitzar");
        System.out.println("1 . Afegir contacte");
        int opcio = sc.nextInt();
        int telf = 0;
        String nom = "";

        while(opcio != 0 && !exit){
            switch(opcio){
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("Introdueix el telf");
                    telf = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix el nom");
                    nom = sc.nextLine();
                    contactes.addContact(telf, nom);
                    break;
            }
        }

        List<Contacte> contacteList = new ArrayList<>(
                Arrays.asList(
                        new Contacte(987987987, "Arnau"),
                        new Contacte(947968179, "Pol"),
                        new Contacte(912345678, "Ibai"),
                        new Contacte(987987987, "Arnau")
                ));
        ContactAgenda contactAgenda = new ContactAgenda(contacteList);
        //contactAgenda.getAllContacts(contacteList);
        Contacte cont = contactAgenda.searchContact("Arnau");
        cont.toString();

    }

    /////////////////////////Exercici 10 final////////////////////////
}