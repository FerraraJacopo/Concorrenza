import java.util.ArrayList;

public class SalaAttesa {
    private ArrayList<String> listaThread;
    private int postiCaneOccupati = 0;
    private int postiGattoOccupati = 0;


    public SalaAttesa() {
        listaThread = new ArrayList<>();
    }

    public void esci(int posto, String tipo, int numero) {
        synchronized (this){
            listaThread.remove(posto);
            switch (tipo) {
                case "Cane":
                    postiCaneOccupati--;
                    System.out.println("Cane " + numero + " è uscito dalla sala d'attesa -- posti cane occupati: " + postiCaneOccupati);
                    break;
                case "Gatto":
                    postiGattoOccupati--;
                    System.out.println("Gatto " + numero + " è uscito dalla sala d'attesa  -- posti gatto occupati: " + postiGattoOccupati);
                    break;
            }
            notifyAll();
        }
    }


    public int entra(String tipo, int n) throws InterruptedException {
        synchronized (this) {
            switch (tipo) {
                case "Gatto":
                    while (postiGattoOccupati > 0 || postiCaneOccupati > 0) {
                        wait();
                    }
                    break;
                case "Cane":
                    while (postiGattoOccupati > 0 || postiCaneOccupati == 4) {
                        wait();
                    }
                    break;
            }
            listaThread.add(tipo);
            switch (tipo) {
                case "Cane":
                    postiCaneOccupati++;
                    System.out.println("Cane " + n + " è entrato nella sala d'attesa -- posti cane occupati: " + postiCaneOccupati);
                    break;
                case "Gatto":
                    postiGattoOccupati++;
                    System.out.println("Gatto " + n + " è entrato nella sala d'attesa -- posti gatto occupati: " + postiGattoOccupati);
                    break;
            }
            return listaThread.size()-1;
        }
    }
}
