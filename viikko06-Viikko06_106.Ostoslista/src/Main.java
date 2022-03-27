public class Main {

    public static void main(String[] args) {
        // testaa luokkasi toimintaa täällä!

        Ostoslista lista = new Ostoslista();
        lista.lisaa("porkkana");
        lista.lisaa("porkkana");
        lista.lisaa("nauris");
        lista.lisaa("porkkana");
        lista.lisaa("satsuma");
//
        System.out.println(lista);
//
        lista.poista("porkkana");
//
        System.out.println(lista);
    }
}
