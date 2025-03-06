public class Peixe extends Animal {
    private String tipo;

    Peixe (String reino, String filo, String classe, String ordem, String familia, String genero, String especie, String tipo) {
        super(reino, filo, classe, ordem, familia, genero, especie);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
