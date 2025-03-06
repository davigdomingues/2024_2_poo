public class Animal {
    protected String reino, filo, classe, ordem, familia, genero, especie;
    protected boolean isBorn = false;
    protected int posicaoX = 0, posicaoY = 0;

    Animal (String reino, String filo, String classe, String ordem, String familia, String genero, String especie) {
        this.filo    = filo;
        this.reino   = reino;
        this.ordem   = ordem;
        this.classe  = classe;
        this.genero  = genero;
        this.familia = familia;
        this.especie = especie;
    }

    public void nascer() {
        this.isBorn = true;
    }

    void mover() {
        this.posicaoX += 5;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public String getClasse() {
        return classe;
    }

    public String getEspecie() {
        return especie;
    }

    public String getFamilia() {
        return familia;
    }

    public String getFilo() {
        return filo;
    }

    public String getGenero() {
        return genero;
    }

    public String getOrdem() {
        return ordem;
    }

    public String getReino() {
        return reino;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public void setBorn(boolean isBorn) {
        this.isBorn = isBorn;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public void setFilo(String filo) {
        this.filo = filo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public String informacoes() {
        return "Reino: " + reino + "\n" +
                "Filo: " + filo + "\n" +
                "Classe: " + classe + "\n" +
                "Ordem: " + ordem + "\n" +
                "Família: " + familia + "\n" +
                "Gênero: " + genero + "\n" +
                "Espécie: " + especie + "\n" +
                "Posição X: " + posicaoX + "\n" +
                "Posição Y: " + posicaoY + "\n";
    }
}