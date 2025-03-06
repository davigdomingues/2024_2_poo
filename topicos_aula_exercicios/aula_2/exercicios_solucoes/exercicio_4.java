public class VolumeEsfera {
   
    public static void main(String[] args){
        double volume = 0.0, raio = 0.0;
        // obs: diferentes valores de pi vão gerar diferentes valores nos volumes!
       
        for (int i = 0; i < 41; i++){
            System.out.print("Volume de raio " + (0.5*i) + " cm: ");
            volume = (4*(Math.PI*raio*raio*raio))/3; // Math.PI é um método que informa o valor "exato" da constante Pi.
            System.out.println(volume);
            raio += 0.5;
            System.out.println("");
        }
    }
}