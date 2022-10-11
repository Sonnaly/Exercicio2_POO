package br.ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SistemaAmigo {
    private List<Amigo> amigos;
    private List<Mensagem> mensagens;

    private  int msgMax;
    private static final int DEFAULT_MSG_MAX = 1000;

    public SistemaAmigo(int msgMax){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
        this.msgMax = msgMax;
    }

    public SistemaAmigo(){

        this(DEFAULT_MSG_MAX);
    }



    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
        for(Amigo a: amigos){
            if(a.getEmail().equals(emailAmigo)){
                return a;
            }
        }
        throw new AmigoInexistenteException("Não foi encontrado no sistema ");
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        for(Amigo a: this.amigos){
            if(a.getEmail().equals(emailAmigo)){
                throw new AmigoJaExisteException("email já cadastrado no sistema");

            }
                
        }
        Amigo amigoNovo = new Amigo(nomeAmigo, emailAmigo); 
        amigos.add(amigoNovo);
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public void enviarMensagemParaTodos(String texto, String remetente, boolean ehAnonima) {
        MensagemParaTodos msg = new MensagemParaTodos(texto, remetente, ehAnonima);
        this.mensagens.add(msg);
    }

    public void enviarMensagemParaAlguem(String texto, String remetente, String destinatario, boolean ehAnonima) {
        MensagemParaAlguem msg = new MensagemParaAlguem(texto, remetente, destinatario, ehAnonima);
        this.mensagens.add(msg);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> msgAnonimas = new ArrayList<>();
        for(Mensagem msg: this.mensagens){
            if(msg.ehAnonima()){
                msgAnonimas.add(msg);
            }
        }
        return msgAnonimas;

    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for(Amigo a: this.amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                String amigoSorteado = a.getEmailAmigoSorteado();
                if(amigoSorteado == null){
                    throw new AmigoNaoSorteadoException("Nenhum amigo foi sorteado ainda para a pessoa: "+ emailDaPessoa);
                }else{
                    return amigoSorteado;
                }
            }
        }
        throw new AmigoInexistenteException("Não foi encntrada no sistema a pessoa de email: "+emailDaPessoa);
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws  AmigoInexistenteException{
        for(Amigo a: this.amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                a.setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("Não existe pessoa cadastrada com o email" + emailDaPessoa);
    }
}
