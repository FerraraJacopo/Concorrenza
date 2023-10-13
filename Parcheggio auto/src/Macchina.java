public class Macchina extends Thread{
    private static final ParkingLot parkingLot = new ParkingLot(5);
    private int numeroVeicolo;

    public Macchina(int numeroVeicolo){
        this.numeroVeicolo = numeroVeicolo;
    }

    @Override
    public void run() {
        while (true){
            try {
                guida();
                parkingLot.entra(numeroVeicolo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void guida() throws InterruptedException {
        System.out.println("Macchina " + numeroVeicolo + " sta guidando");
        Thread.sleep(2000);
    }
}
