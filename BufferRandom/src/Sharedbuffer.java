public class Sharedbuffer {
    static final int dimensioneBuffer = 1;
    private int numeroValori = 0;
    private int[]valore;

    public Sharedbuffer() {
        valore = new int[dimensioneBuffer];
    }

    public synchronized int getValore() throws InterruptedException {
        if (numeroValori == 0) {
            wait();
        }
        int v1 = valore[0];
        numeroValori--;
        notify();
        return v1;
    }

    public synchronized void setValore(int n) throws InterruptedException {
        while (numeroValori == dimensioneBuffer) {
            wait();
        }
        valore[0] = n;
        numeroValori++;
        notify();
    }
}
