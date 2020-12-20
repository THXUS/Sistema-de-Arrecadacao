package classes;

public class App {

    public static void main(String[] args) throws Exception {
        Tributo s[] = new Tributo[6];
        s[0] = new Iptu(500, "25/01/2000", "15/01/2000");
        s[1] = new Iptu(500, "15/01/2000", "15/01/2000");

        // s.fazerAcordo(25);

        s[0].pagar();
        s[1].pagar();
    }

}
