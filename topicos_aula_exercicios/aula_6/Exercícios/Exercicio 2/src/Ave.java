public class Ave extends Animal {
    private String tipoDaPena;

    Ave (String reino, String filo, String classe, String ordem, String familia, String genero, String especie, String tipoDaPena) {
        super(reino, filo, classe, ordem, familia, genero, especie);
        this.tipoDaPena = tipoDaPena;
    }

    @Override
    void mover() {
        super.mover();
        this.posicaoY++;
    }

    public String getTipoDaPena() {
        return tipoDaPena;
    }

    public void setTipoDaPena(String tipoDaPena) {
        this.tipoDaPena = tipoDaPena;
    }
}
