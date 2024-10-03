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
            case 3 :
                System.out.println("Exercici teòric"); break;
            case 4 : exerciciQuatre(); break;
            default:
                System.out.println("Sergio introdueix un numero vàlid! saps llegir?");
        }
    }

    }


                /////////////////////////Exercici 1 Inici//////////////////////////////



    //TODO: Ficar tot aquest codi en una funció "GenerarDades"
    public static void dataGenerate () {

    }
    public static void exerciciUn(){
        //Llista vuida que contindrà tots els jefes de departament
        List<Engineer> jefesDepartamentos = new ArrayList<>();

        //Llista d'enginyers
        List<Engineer> l_eng = new ArrayList<Engineer>();
        l_eng.add(new Engineer("123456X","Software", "D01"));
        l_eng.add(new Engineer("12345678A", "Informàtic", "D01"));
        l_eng.add(new Engineer("87654321B" , "Jefe", "D01"));
        l_eng.add(new Engineer("47145065F" , "Telecos", "D01"));

        List<Engineer> list_eng = new ArrayList<Engineer>();
        list_eng.add(new Engineer("12345678x", "Informàtic", "D04" ));
        list_eng.add(new Engineer("98765432S" , "Software", "D04"));
        list_eng.add(new Engineer("12332112A" , "Jefe", "D04"));

        //llistat de departaments
        List<Department> l_dep = new ArrayList<Department>();
        l_dep.add(new Department(l_eng,"Mates", "D01"));
        l_dep.add(new Department(list_eng,"Fisica", "D04"));

        bossOfEachDepartment(jefesDepartamentos , l_dep);
    }


    public static void bossOfEachDepartment (List< ? super Engineer> engineersList,
                                            List<Department> departments){

       Iterator<Department> itDep = departments.iterator();
       Department dep;

       while (itDep.hasNext()){
           dep = itDep.next();
           engineersList.add(dep.getHead());
       }

       infoOfEachBoss();
   }

   /*
   TODO ficar paràmetres dins de la funciÓ
    */
   public static void infoOfEachBoss() {

       Iterator<? super Engineer> itEng = engineersList.iterator();
       Engineer eng;
       System.out.println("La nostra llista d'Enginyers conté:");
       while (itEng.hasNext()){
           eng = itEng.next();
           System.out.println("Jefe Departament " + eng.getIdDepartment() +
                   ", Dni: " + eng.getDni());
       }
   }


             /////////////////////////Exercici 1 Final/////////////////////////



            /////////////////////////Exercici 2 Inici//////////////////////////

    public static void exerciciDos() {

        /* TODO: PREGUNTAR SERGIO QUE ES GENERALITZAR CABECERA */

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
        Podem implementar tots els mètodes de la superclasse Animal, encara que haurem de fer un Overwrite
     */





                    /////////////////////////Exercici 5 final////////////////////////


                    /////////////////////////Exercici 6 Inici////////////////////////
    public static void exerciciSis (){

        List <Integer> list = new ArrayList<>();
    }
    
    public static void debup ( List<Object> lista ) {

    }


}