public class Cachorro extends Animal {
    private String pelagem;

    Cachorro (String reino, String filo, String classe, String ordem, String familia, String genero, String especie, String pelagem) {
        super(reino, filo, classe, ordem, familia, genero, especie);
        this.pelagem = pelagem;
    }

    @Override
    void mover() {
        super.mover();
        posicaoX += 3;
        posicaoY += 10;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }
}
