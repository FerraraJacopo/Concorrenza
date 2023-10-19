public class Main {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();
        for (int i = 0; i < 5; i++) {
            new Consumatore("thread " + i, sharedBuffer).start();
        }
    }
}