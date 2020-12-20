package classes;

public class App {

    public static void main(String[] args) throws Exception {
        Tributo t;
        t = new Iptu(500, "25/01/2000", "15/01/2000");
        // t.fazerAcordo(70f);
        t.pagar();
    }

}
