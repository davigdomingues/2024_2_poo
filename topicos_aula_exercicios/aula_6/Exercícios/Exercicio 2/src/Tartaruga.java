public class Tartaruga extends Animal {
    private String tipoDeCasco;

    Tartaruga (String reino, String filo, String classe, String ordem, String familia, String genero, String especie, String tipoDeCasco) {
        super(reino, filo, classe, ordem, familia, genero, especie);
        this.tipoDeCasco = tipoDeCasco;
    }

    @Override
    void mover() {
        posicaoX += 1;
    }

    public String getTipoDeCasco() {
        return tipoDeCasco;
    }

    public void setTipoDeCasco(String tipoDeCasco) {
        this.tipoDeCasco = tipoDeCasco;
    }
}