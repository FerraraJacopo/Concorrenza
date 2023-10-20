public class Animale extends Thread{
    private String tipo;
    private SalaAttesa salaAttesa;
    private int numero;

    public Animale(String tipo, SalaAttesa salaAttesa, int numero) {
        this.tipo = tipo;
        this.salaAttesa = salaAttesa;
        this.numero = numero;
    }

    @Override
    public void run() {
        while(true){
            try {
                int posto = salaAttesa.entra(tipo, numero);
                int randomTime = (int)(Math.random()*1000);
                Thread.sleep(randomTime);
                salaAttesa.esci(posto, tipo, numero);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
