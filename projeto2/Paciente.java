
package projeto2;

public class Paciente extends Administracao {
    String nome;
    String cpf;
    
    public Paciente(){}
    
    public String getNome(){
    return this.nome;
    }
    
    public void setNome(String nome){
    this.nome = nome;
    }
    
    public String getCPF(){
    return this.cpf;
    }
    
    public void setCRM(String cpf){
    this.cpf = cpf;
    }
    
    public Paciente(String nome, String crm){
      setNome(nome);
      setCRM(crm);
    }
    
    
}
