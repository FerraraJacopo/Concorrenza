public class Produttore extends Thread{

    private Sharedbuffer sharedbuffer;

    public Produttore(Sharedbuffer sharedbuffer) {
        this.sharedbuffer = sharedbuffer;
    }

    @Override
    public void run() {
        while(true){
            try {
                int n = ((int)(Math.random()*10)+1);
                sharedbuffer.setValore(n);
                System.out.println("Produttore ha messo " + n + " nel buffer");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
