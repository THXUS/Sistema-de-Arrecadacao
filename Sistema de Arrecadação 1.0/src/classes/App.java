package classes;

public class App {

    public static void main(String[] args) throws Exception {
        Tributo s[] = new Tributo[6];
        s[0] = new Iptu(500, "25/01/2000", "15/01/2000");
        s[1] = new Iptu(500, "15/01/2000", "15/01/2000");

        s[2] = new Iptu(352, "02/04/2022", "01/03/2021");

        s[2].fazerAcordo(70);
        s[2].pagar();
    }

}
