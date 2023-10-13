public class Cliente extends Thread{
    @Override
    public void run() {
        System.out.println("C: Ordino una pizza!");
        Pizzaiolo pizzaiolo = new Pizzaiolo();
        pizzaiolo.start();
        synchronized (pizzaiolo){
            try {
                pizzaiolo.wait();
                System.out.println("C: Ho ricevuto la pizza!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
