
package projeto2;

//import java.util.ArrayList;
//import java.util.HashMap;

public class Medico extends Administracao {
    
    String nome;
    String crm;

    
    public Medico(){}
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCRM(){
        return this.crm;
    }
    
    public void setCRM(String crm){
        this.crm = crm;
    }
    
    public Medico(String nome, String crm){
      setNome(nome);
      setCRM(crm);
    }
    
    public String toString(){
        return "Medico: "+this.nome+"\nCRM: "+this.crm;
    }
    
}
