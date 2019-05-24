package controller;

import java.awt.event.ActionEvent;

import view.Janela;
import view.ProcuraUsuario;
import view.Sucesso;
import view.Erro;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Pessoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author vinic
 */
public class Controller implements ActionListener {

    private Janela janela;
    private ProcuraUsuario janela2;
    private Sucesso success;
    private Erro erro;

    public Controller(Janela view) {
        this.janela = view;
    }

    public void setSucesso(Sucesso success) {
        this.success = success;
    }

    public void setErro(Erro erro) {
        this.erro = erro;
    }

    public void setJanela2(ProcuraUsuario janela2) {
        this.janela2 = janela2;
    }

    public void controla() {
        janela.getCadastra().addActionListener(this);
        janela2.getProcuraCPF().addActionListener(this);
        janela.getAbreUsuarios().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == janela.getCadastra()) {
            Pessoa pessoa = new Pessoa();
            if (janela.getNome().getText() == ""
                    || janela.getSobrenome().getText() == ""
                    || janela.getIdade().getText() == ""
                    || janela.getCPF().getText() == ""
                    || janela.getButtonMasc().isSelected() == false && janela.getButtonFem().isSelected() == false) {

                erro.setVisible(true);

            } else {
                pessoa.setNome(janela.getNome().getText());
                pessoa.setSobrenome(janela.getSobrenome().getText());
                pessoa.setCPF(janela.getCPF().getText());
                pessoa.setIdade(janela.getIdade().getText());
                success.setVisible(true);
                janela.getCPF().setText("");
                janela.getNome().setText("");
                janela.getSobrenome().setText("");
                janela.getIdade().setText("");
            }

            //success.setVisible(true);
            if (janela.getButtonMasc().isSelected()) {
                pessoa.setSexo("Masculino");
            } else if (janela.getButtonFem().isSelected()) {
                pessoa.setSexo("Feminino");
            }

            try {
                FileWriter arquivo = new FileWriter(pessoa.getCPF() + ".txt");
                PrintWriter escreve = new PrintWriter(arquivo);
                escreve.println(pessoa.getNome());
                escreve.println(pessoa.getSobrenome());
                escreve.println(pessoa.getIdade());
                escreve.println(pessoa.getCPF());
                escreve.println(pessoa.getSexo());
                arquivo.close();
            } catch (Exception ex) {
            }
            /*String nome;
             nome = janela.getNome().getText();
             String sobrenome;
             sobrenome = janela.getSobrenome().getText();
             String idade;
             idade = janela.getIdade().getText();
             String CPF;
             CPF = janela.getCPF().getText();*/

        } else if (e.getSource() == janela2.getProcuraCPF()) {
            String str;
            String txt;
            String arq = janela2.getBuscaCPF().getText() + ".txt";
            janela2.getMostraDados().setLineWrap(true);
            //janela2.getBuscaCPF().setText("");
            try {
                FileReader arquivo = new FileReader(arq);
                BufferedReader br = new BufferedReader(arquivo);
                while ((str = br.readLine()) != null) {
                    janela2.getMostraDados().append(str);
                    janela2.getMostraDados().append("\n");
                    //janela2.getMostraDados().setText(janela2.getMostraDados().getText() + "" + str);
                }

            } catch (Exception ex) {
                janela2.getMostraDados().setText("Usuário não encontrado");
            }
        } else if (e.getSource() == janela.getAbreUsuarios()) {
            janela2.setVisible(true);
        }
    }

}
