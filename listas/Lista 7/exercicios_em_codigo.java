import java.util.Scanner;

public class Main {
    private static MusicasFavoritas musicasFavoritas = new MusicasFavoritas();
    private static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
	    int opcao;
	    String userName;
	    System.out.println("Bem-vindo ao sistema de adicionamento de musicas e de usuarios\nOpcoes:\n");
	    
	    do{
	        System.out.println("(1) Adicionar usuario");
	        System.out.println("(2) Buscar usuario");
	        System.out.println("(3) Editar musica do usuario cadastrado");
	        System.out.println("(4) Sair");
	        System.out.print("\nEscolha uma opção: ");
	        opcao = sc.nextInt();
	        sc.nextLine();
	        
	        switch (opcao) {
	            case 1:
	            System.out.print("Nome do usuario: ");
	            userName = sc.nextLine();
	            System.out.print("Nome da musica favorita: ");
	            String musicName = sc.nextLine();
	            musicasFavoritas.addUser(userName, musicName);
	            break;
	            
	        case 2:
	            System.out.print("Nome do usuario: ");
	            userName = sc.nextLine();
	            musicasFavoritas.verifyFavoriteMusicByUserName(userName);
	            break;
	            
	        case 3:
	            System.out.print("Nome do usuario: ");
	            userName = sc.nextLine();
	            musicasFavoritas.modifyFavoriteMusicByUserName(userName);
	            break;
	            
	        case 4:
	            System.out.println("Saindo...");
	            break;
	        }
	    } while (opcao != 4);
	}
}

public class Pessoa {
    private String nome;
    private String musicaFavorita;

    public Pessoa(String nome, String musicaFavorita) {
        this.nome = nome;
        this.musicaFavorita = musicaFavorita;
    }

    public String getNome() {
        return nome;
    }

    public String getMusicaFavorita() {
        return musicaFavorita;
    }

    public void setMusicaFavorita(String musicaFavorita) {
        this.musicaFavorita = musicaFavorita;
    }

    @Override
    public String toString() {
        return nome + " tem como música favorita: " + musicaFavorita;
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class MusicasFavoritas {
    private HashMap<String, Pessoa> usuario;
    private Scanner sc;
    
    public MusicasFavoritas(){
        this.usuario = new HashMap<>();
    }
    
    public void addUser(String userName, String musicName){
        if (!usuario.containsKey(userName)){
            usuario.put(userName, new Pessoa(userName, musicName));
            System.out.println("Usuario " + userName + " com musica favorita " + musicName + " cadastrado com sucesso!\n");
        }
        
        else 
            System.out.println("Usuario ja cadastrado...\n");
    }
    
    public void verifyFavoriteMusicByUserName(String userName){
        Pessoa pessoa = usuario.get(userName); // obtém o objeto associado à chave String "userName".
        
        if (pessoa != null)
            System.out.println(pessoa);
            
        else
            System.out.println("Pessoa nao encontrada...\n");
    }
    
    public void modifyFavoriteMusicByUserName(String userName){
        Pessoa pessoa = usuario.get(userName);
        
        if (pessoa != null){
            System.out.print("Informe a nova musica favorita: ");
            String newFavoriteMusic = sc.nextLine();
            pessoa.setMusicaFavorita(newFavoriteMusic);
            System.out.println("Música favorita de " + userName + " atualizada para: " + newFavoriteMusic + " com sucesso!\n");
        }
        
        else
            System.out.println("Pessoa nao encontrada...\n");
    }
}