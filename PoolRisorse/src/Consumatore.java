public class Consumatore extends Thread{
    private SharedBuffer sharedBuffer;
    private String nome;


    public Consumatore(String nome, SharedBuffer sharedBuffer) {
        this.nome = nome;
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        while(true){
            try{
                int b = sharedBuffer.richiesta(nome);
                Thread.sleep(1000);
                sharedBuffer.rilascio(b, nome);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public String getNome() {
        return nome;
    }
}
