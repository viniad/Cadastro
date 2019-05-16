package main;


import view.Janela;
import view.ProcuraUsuario;
import view.Sucesso;
import view.Erro;



import controller.Controller;
import java.util.ArrayList;
import model.Pessoa;
/**
 *
 * @author vinic
 */
public class main {
    public static void main(String args[]) {
        Janela janela = new Janela();
        ProcuraUsuario janela2 = new ProcuraUsuario();
        Sucesso sucess = new Sucesso();
        Erro erro = new Erro();
        
        
        Controller controller = new Controller(janela);
        controller.setErro(erro);
        controller.setJanela2(janela2);
        controller.setSucesso(sucess);
        janela.setVisible(true);  
        controller.controla();
        
        //janela2.setVisible(true);
                
        
        
    }
}
