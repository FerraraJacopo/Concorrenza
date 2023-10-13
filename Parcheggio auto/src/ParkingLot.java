public class ParkingLot {
    private int postiDisponibili;

    public ParkingLot(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public void entra(int numeroVeicolo) throws InterruptedException {
        synchronized (this) {
            while (postiDisponibili == 0) {
                wait();
            }
            System.out.println("Macchina " + numeroVeicolo + " è entrata nel parcheggio");
            notifyAll();
            postiDisponibili--;
        }
        Thread.sleep(1000);
        esci(numeroVeicolo);
    }

    public void esci(int numeroVeicolo) {
        synchronized (this) {
            postiDisponibili++;
            System.out.println("Macchina " + numeroVeicolo + " è uscita dal parcheggio");
            notifyAll();
        }

    }
}
