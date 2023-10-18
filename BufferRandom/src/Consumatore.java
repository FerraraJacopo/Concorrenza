public class Consumatore extends Thread {
    Sharedbuffer sharedbuffer;
    private int valore;
    private String nome;
    private int limiteInferiore;
    private int limiteSuperiore;

    public Consumatore(Sharedbuffer sharedbuffer, String nome, int limiteInferiore, int limiteSuperiore) {
        this.sharedbuffer = sharedbuffer;
        this.nome = nome;
        this.limiteSuperiore = limiteSuperiore;
        this.limiteInferiore = limiteInferiore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int n = sharedbuffer.getValore();
                if(n >= limiteInferiore && n <= limiteSuperiore) {
                    this.valore = n;
                    System.out.println(nome + " ha acquisito " + valore + " dal buffer");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}