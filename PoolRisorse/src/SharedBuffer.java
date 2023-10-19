import java.util.Arrays;

public class SharedBuffer {
    private boolean[] risorse;
    private int valoriDisponibili;

    public SharedBuffer() {
        risorse = new boolean[5];
        Arrays.fill(risorse, true);
        valoriDisponibili = risorse.length;
    }

    public int richiesta(String nome) throws InterruptedException {
        synchronized (this) {
            while (valoriDisponibili == 0) {
                wait();
            }
            int posizione = 0;
            while ((posizione < risorse.length) && (!risorse[posizione])) {
                posizione++;
            }
            risorse[posizione] = false;
            valoriDisponibili--;
            System.out.println("thread " + nome + "ha acquisito la risorsa: " + posizione);
            return posizione;
        }
    }


    public void rilascio(int i, String nome) throws InterruptedException {
        synchronized (this) {
            risorse[i] = true;
            valoriDisponibili++;
            System.out.println("thread " + nome + "ha rilasciato la risorsa: " + i);
            notifyAll();
        }
    }
}
