package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author vinic
 */
public class Pessoa {
    private String nome;
    private String sobrenome;
    private String idade;
    private String CPF;
    private String sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getSexo(){
        return this.sexo;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    /*-----------------*/
    
    
    
    
}
