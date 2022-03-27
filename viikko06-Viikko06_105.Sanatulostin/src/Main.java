public class Main {

    public static void main(String[] args) {
        Sanatulostin tulostin = new Sanatulostin("Saippuakauppias");

        tulostin.sanaporras(5);
        System.out.println("");
        tulostin.laskevaSanaporras(2);
        System.out.println("");

        tulostin.sanapyramidi(10);
    }
}
