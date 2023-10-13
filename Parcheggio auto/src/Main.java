public class Main {
    public static void main(String[] args) {
        Macchina[]listaMacchine = new Macchina[10];
        for (int i = 0; i < listaMacchine.length; i++) {
            listaMacchine[i]=new Macchina(i+1);
            listaMacchine[i].start();
        }
    }
}