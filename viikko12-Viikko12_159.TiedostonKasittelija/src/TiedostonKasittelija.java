
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TiedostonKasittelija {

    public ArrayList<String> lue(String tiedosto) throws FileNotFoundException {
        File data = new File(tiedosto);
        Scanner lukija = new Scanner(data);
        ArrayList<String> tieto = new ArrayList<>();
        while (lukija.hasNextLine()) {
            tieto.add(lukija.nextLine());
        }
        return tieto;
    }

    public void tallenna(String tiedosto, String teksti) throws IOException {
        FileWriter kirjoittaja = new FileWriter(tiedosto);
        kirjoittaja.write(teksti);
        kirjoittaja.close();
    }

    public void tallenna(String tiedosto, ArrayList<String> tekstit) throws IOException {
        FileWriter kirjoittaja = new FileWriter(tiedosto);
        for (String s : tekstit) {
            kirjoittaja.write(s + "\n");
        }
        kirjoittaja.close();
    }
}
