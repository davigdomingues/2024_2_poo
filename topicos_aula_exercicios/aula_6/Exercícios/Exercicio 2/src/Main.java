public class Main {
    public static void main(String[] args) {
        // Criando instâncias de cada tipo de animal
        Ave ave = new Ave("Animalia", "Chordata", "Aves", "Passeriformes", "Fringillidae", "Carduelis", "Pintassilgo", "Pena macia");
        Cachorro cachorro = new Cachorro("Animalia", "Chordata", "Mammalia", "Carnivora", "Canidae", "Canis", "Labrador", "Pelagem curta");
        Peixe peixe = new Peixe("Animalia", "Chordata", "Actinopterygii", "Perciformes", "Cichlidae", "Cichla", "Tucunaré", "Carnívoro");
        Tartaruga tartaruga = new Tartaruga("Animalia", "Chordata", "Reptilia", "Testudines", "Testudinidae", "Testudo", "Tartaruga-gigante", "Casco de carapaça");

        // Nascendo os animais
        ave.nascer();
        cachorro.nascer();
        peixe.nascer();
        tartaruga.nascer();

        // Movendo os animais
        ave.mover();
        cachorro.mover();
        tartaruga.mover();

        // Exibindo informações dos animais após o movimento
        exibirInformacoes(ave);
        exibirInformacoes(cachorro);
        exibirInformacoes(peixe);
        exibirInformacoes(tartaruga);

        // Alterando atributos do ave
        ave.setClasse("Aves Alteradas");
        ave.setFamilia("Fringillidae Alterada");
        ave.setTipoDaPena("Pena dura");

        // Alterando atributos do cachorro
        cachorro.setPelagem("Pelagem longa");
        cachorro.setPosicaoX(10);
        cachorro.setPosicaoY(20);

        // Alterando atributos do peixe
        peixe.setTipo("Herbívoro");

        // Alterando atributos da tartaruga
        tartaruga.setTipoDeCasco("Casco de madeira");

        // Exibindo informações atualizadas dos animais
        System.out.println("Informações atualizadas:");
        exibirInformacoes(ave);
        exibirInformacoes(cachorro);
        exibirInformacoes(peixe);
        exibirInformacoes(tartaruga);
    }

    public static void exibirInformacoes(Animal animal) {
        System.out.println(animal.informacoes());
        switch (animal) {
            case Ave ave -> System.out.println("Tipo da Pena: " + ave.getTipoDaPena());
            case Cachorro cachorro -> System.out.println("Pelagem: " + cachorro.getPelagem());
            case Peixe peixe -> System.out.println("Tipo: " + peixe.getTipo());
            case Tartaruga tartaruga -> System.out.println("Tipo de Casco: " + tartaruga.getTipoDeCasco());
            default -> {
            }
        }

        /*mesmo que:
        if (animal instanceof Ave) {
            Ave ave = (Ave) animal;
            System.out.println("Tipo da Pena: " + ave.getTipoDaPena());
        } else if (animal instanceof Cachorro) {
            Cachorro cachorro = (Cachorro) animal;
            System.out.println("Pelagem: " + cachorro.getPelagem());
        } else if (animal instanceof Peixe) {
            Peixe peixe = (Peixe) animal;
            System.out.println("Tipo: " + peixe.getTipo());
        } else if (animal instanceof Tartaruga) {
            Tartaruga tartaruga = (Tartaruga) animal;
            System.out.println("Tipo de Casco: " + tartaruga.getTipoDeCasco());
        }
         */
        System.out.println("------------------------------------------------");
    }
}
