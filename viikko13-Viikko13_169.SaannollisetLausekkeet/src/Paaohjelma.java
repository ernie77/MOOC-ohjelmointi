
public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia josta kutsut ohjelmoitavia metodeja 
        String mjono = "ma";
        
        System.out.println("" + onViikonpaiva(mjono));
    }
    public static boolean onViikonpaiva(String merkkijono) {
        return merkkijono.matches("(ma|ti|ke|to|pe|la|su)");
    }
    
    public static boolean kaikkiVokaaleja(String merkkijono) {
        return merkkijono.matches("(a|e|i|o|u|y|ä|ö)*");
    }
    
    public static boolean kellonaika(String merkkijono) {
        /*if (!merkkijono.matches("(0|1|2){1}")) {
        return false;
        }*/
        return merkkijono.matches("((0|1){1}([0-9]{1})|(2{1})([0-3]{1})):([0-5]{1})([0-9]{1}):([0-5]{1})([0-9]{1})");
    }
}
