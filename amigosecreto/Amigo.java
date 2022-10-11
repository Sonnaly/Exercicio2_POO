package br.ufpb.dcx.amigosecreto;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nome, String email){
        this.nome=nome;
        this.email=email;
        this.emailAmigoSorteado=null;
    }
    

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }
    
    public String getEmailAmigoSorteado() {
        return this.emailAmigoSorteado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
    }
}
