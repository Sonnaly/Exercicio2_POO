package br.ufpb.dcx.amigosecreto;

import java.util.List;

public class TestaSistemaAmigo {
    public static void Main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        //cadastrar
        try {
            sistema.cadastraAmigo("Maria", "maria@hotmail.com");
            sistema.cadastraAmigo("Jose", "jose@hotmail.com");
            System.out.println("cadastrados com sucesso!");
        } catch (AmigoJaExisteException e) {
            System.out.println(e.getMessage());
        }

        //conigurar 
        try {
            sistema.configuraAmigoSecretoDe("jose@hotmail.com", "maria@hotmail.com");
            sistema.configuraAmigoSecretoDe("maria@hotmail.com", "jose@hotmail.com");
            System.out.println("Amigo secreto conigurado!");
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //mensagem anonima
        sistema.enviarMensagemParaAlguem("oi jose", "maria@hotmail.com", "jose@hotmail.com", true
        );

        sistema.enviarMensagemParaTodos("oi todo mundo", "maria@hotmail.com", true);

        //lista de mensagens
        List<Mensagem> anonimas = sistema.pesquisaMensagensAnonimas();
        for(Mensagem msg: anonimas){
            System.out.println(msg.getTextoCompletoAExibir());
        }

        //pesquisa amigo secreto
        try {
            String emailAmigoSecreto = sistema.pesquisaAmigoSecretoDe("jose@hotmail.com");
            if(emailAmigoSecreto.equals("maria@hotmail.com")){
                System.out.println("OK");
            }
        } catch (AmigoNaoSorteadoException | AmigoInexistenteException e) {
            e.getMessage();
        }

                
    }
}
