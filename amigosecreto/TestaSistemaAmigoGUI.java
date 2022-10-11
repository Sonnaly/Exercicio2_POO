package br.ufpb.dcx.amigosecreto;

import javax.swing.*;
import java.util.List;

public class TestaSistemaAmigoGUI {
    public static void main(String args[]){
        int msgMax = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade máxima de mensagens que o sistema suporta"));

        SistemaAmigo sistema = new SistemaAmigo(msgMax);

        int  amgMax = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade máxima de amigos participando da brincadeira"));

        for(int k =0; k<msgMax; k++){
            String nome = JOptionPane.showInputDialog("Digite o nome da pessoa a ser cadastrada");
            String email = JOptionPane.showInputDialog("Digite o email da pessoa a ser cadastrada");
            try{
                sistema.cadastraAmigo(nome, email);
                JOptionPane.showMessageDialog(null, "Amigo cadastrado!");
            }catch(AmigoJaExisteException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

        for(int k=0; k<msgMax; k++){
            String emailDaPessoa = JOptionPane.showInputDialog("Digite o email:");
            String emailAmigoSecreto = JOptionPane.showInputDialog("Digite o email do amigo secreto:");
            try {
                sistema.configuraAmigoSecretoDe(emailDaPessoa, emailAmigoSecreto);
            } catch (AmigoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }


        String texto = JOptionPane.showInputDialog("digite o texto a ser enviado.");
        String emailRemetente = JOptionPane.showInputDialog("Digite seu email.");
        String msgehAnonima = JOptionPane.showInputDialog("A mensagem é anonima? digite 's' para sim e 'n' para não");

        boolean msgAnonima = false;
        if(msgehAnonima.equals("s")){
            msgAnonima = true;
        }


        sistema.enviarMensagemParaTodos(texto, emailRemetente, msgAnonima);
    }
    
}
