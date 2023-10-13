public class Pizzaiolo extends Thread{
    private boolean pizzaPronta = false;

    @Override
    public void run() {
        try {
            System.out.println("P: Pizza in preparazione...");
            sleep(5000);
            synchronized (this){
                pizzaPronta();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pizzaPronta(){
        System.out.println("P: Pizza pronta!");
        pizzaPronta = true;
        notify();
    }
}
