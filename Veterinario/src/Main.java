public class Main {
    public static void main(String[] args) {
        SalaAttesa salaAttesa = new SalaAttesa();
        String tipo;
        int numCane = 0;
        int numGatto = 0;
        for (int i = 0; i < 10; i++) {
            int n = (int)(Math.random()*10)+1;
            if(n <= 5){
                tipo = "Cane";
                numCane++;
            }else{
                tipo = "Gatto";
                numGatto++;
            }
            new Animale(tipo, salaAttesa, i).start();
        }
    }
}