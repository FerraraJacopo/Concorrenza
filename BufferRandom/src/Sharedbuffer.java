public class Sharedbuffer {
    static final int dimensioneBuffer = 1;
    private int numeroValori = 0;
    private int valore;

    public synchronized int getValore() throws InterruptedException {
        while (numeroValori == 0) {
            wait();
        }
        numeroValori--;
        notifyAll();
        return valore;
    }

    public synchronized void setValore(int valore) throws InterruptedException {
        while (numeroValori == dimensioneBuffer) {
            wait();
        }
        this.valore = valore;
        numeroValori++;
        notifyAll();
    }
}
