
import matopeli.Matopeli;

public class Matoaly {

    public String annaSiirto(Matopeli matopeli) {
        // vaihtoehtoja ovat: YLOS, ALAS, VASEN, OIKEA
        int[][] pelialue = matopeli.annaAlusta();
        while (matopeli.matoY() < matopeli.omenaY()) {
            return "YLOS";
        }
        while (matopeli.matoY() > matopeli.omenaY()) {
            return "ALAS";
        }
        while (matopeli.matoX() < matopeli.omenaX()) {
            return "OIKEA";
        }
        while (matopeli.matoX() > matopeli.omenaX()) {
            return "VASEN";
        }

        while (matopeli.matoX() == pelialue.length) {
            return "ALAS";
        }
        while (matopeli.matoY() == pelialue[0].length - 1) {
            return "VASEN";
        }

        // voit käyttää allaolevaa tulostusta pelialueen tulostamiseen konsoliin
//        for (int y = pelialue[0].length - 1; y >= 0; y--) {
//            for (int x = 0; x < pelialue.length; x++) {
//                if(pelialue[x][y] >= 0) {
//                    System.out.print(" ");
//                }
//                System.out.print(pelialue[x][y]);
//            }
//
//            System.out.println("");
//        }
//        System.out.println("");
        return "YLOS";

    }
}
