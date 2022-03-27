package matopeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import matopeli.Suunta;
import matopeli.domain.Mato;
import matopeli.domain.Omena;
import matopeli.domain.Pala;
import matopeli.gui.Paivitettava;

public class Matopeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private boolean jatkuu;
    private Paivitettava paivitettava;

    private Random r;

    private Mato mato;
    private Omena omena;
    private int omenaX;
    private int omenaY;

    public Matopeli(int leveys, int korkeus) {
        super(1000, null);

        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        this.r = new Random();
        this.mato = new Mato(leveys / 2, korkeus / 2, Suunta.ALAS);
        
        this.omena = newOmena();

        addActionListener(this);
        setInitialDelay(2000);

    }

    private Omena newOmena() {
        omenaX = r.nextInt(leveys);
        omenaY = r.nextInt(korkeus);
        while (omenaX == leveys / 2 && omenaY == korkeus / 2) {
            omenaX = r.nextInt(leveys);
            omenaY = r.nextInt(korkeus);
        }
        return new Omena(omenaX, omenaY);
    }

    public boolean jatkuu() {
        return jatkuu;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.mato.liiku();
        if (mato.osuu(omena)) {
            
            mato.kasva();
            this.setOmena(newOmena());
        }
        if (mato.osuuItseensa()) {
            jatkuu = false;
        }
        if (mato.getPalat().get(mato.getPalat().size() - 1).getX() >= leveys || mato.getPalat().get(mato.getPalat().size() - 1).getX() < 0 || mato.getPalat().get(mato.getPalat().size() - 1).getY() < 0 || mato.getPalat().get(mato.getPalat().size() - 1).getY() >= korkeus) {
            jatkuu = false;
        }
        setDelay(1000 / mato.getPituus());
        paivitettava.paivita();
        if (!jatkuu) {
            //System.exit(0);
            return;
        }

    }

    public Mato getMato() {
        return this.mato;
    }

    public void setMato(Mato mato) {
        this.mato = mato;
    }

    public Omena getOmena() {
        return this.omena;
    }

    public void setOmena(Omena omena) {
        this.omena = omena;
    }
}
