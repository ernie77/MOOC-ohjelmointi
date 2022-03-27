public class Main {

    public static void main(String[] args) {
        // Luodaan pieni osa Charles II of Spainin sukupuusta
        // http://en.wikipedia.org/wiki/Charles_II_of_Spain

        Henkilo charles = new Henkilo("Charles II of Spain");
        Henkilo mariana = new Henkilo("Mariana of Austria");
        Henkilo philipIV = new Henkilo("Philip IV of Spain");

        charles.setIsa(philipIV);
        charles.setAiti(mariana);

        Henkilo mariaSpain = new Henkilo("Maria Anna of Spain");
        Henkilo ferdinandIII = new Henkilo("Ferdinand III, Holy Roman Emperor");

        mariana.setIsa(ferdinandIII);
        mariana.setAiti(mariaSpain);

        Henkilo philipIII = new Henkilo("Philip III of Spain");
        Henkilo margaret = new Henkilo("Margaret of Austria");

        philipIV.setIsa(philipIII);
        philipIV.setAiti(margaret);

        mariaSpain.setIsa(philipIII);
        mariaSpain.setAiti(margaret);

        Henkilo ferdinandII = new Henkilo("Ferdinand II, Holy Roman Emperor");
        Henkilo mariaBavaria = new Henkilo("Maria Anna of Bavaria");

        ferdinandIII.setIsa(ferdinandII);
        ferdinandIII.setAiti(mariaBavaria);
        
// voit käyttää allaolevaa koodia ohjelmasi testaamiseen
//        
        Sukututkija darwin = new Sukututkija();
        //darwin.kerroHenkilosta(charles);
        
        
        System.out.println("--");
        darwin.kerroHenkilonSuvusta(charles);
    }
}
