
public class Main {

    public static void main(String[] args) {
        // käytä tätä pääohjelmaa luokkiesi testaamiseen!

        Lastiruuma l = new Lastiruuma(1000);
        lisaaMatkalaukutTiiliskivilla(l);
        System.out.println(l);

    }

    public static void lisaaMatkalaukutTiiliskivilla(Lastiruuma lastiruuma) {
        for (int i = 1; i < 100; i++) {
            Tavara t = new Tavara("tiiliskivi", i);
            Matkalaukku m = new Matkalaukku(100);

            m.lisaaTavara(t);
            lastiruuma.lisaaMatkalaukku(m);

        }
    }
}
