public class Main {
    public static void main(String[] args) {
        Sharedbuffer sharedbuffer = new Sharedbuffer();
        new Produttore(sharedbuffer).start();
        new Consumatore(sharedbuffer, "c1", 1, 5).start();
        new Consumatore(sharedbuffer, "c2", 6, 10).start();
    }
}