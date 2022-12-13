package projeto2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Projeto2 {

    //--------------------------------------
    // Padrão de Projeto Iterator
    private ArrayList<Medico> lista;

    public interface Iterator {

        public abstract boolean temProximo();

        public abstract Object proximo();
    }

    public class ItemIterator implements Iterator {

        private ArrayList<Medico> lista;
        int pos = 0;

        public ItemIterator(ArrayList<Medico> lista) {
            this.lista = lista;
        }

        public Object proximo() {
            Object item = lista.get(pos);
            pos++;

            return item;
        }

        public boolean temProximo() {
            boolean result = true;

            if (this.pos > this.lista.size() - 1) {
                result = false;
            }
            return result;
        }
    }

    static HashMap<String, String> MedicosArray = new HashMap<>();
    static HashMap<String, String> PacientesArray = new HashMap<>();

    public static void cadastrar(Medico medico) {
        MedicosArray.put(medico.nome, medico.crm);
    }

    public static void cadastrarP(Paciente paciente) {
        PacientesArray.put(paciente.nome, paciente.cpf);
    }

    public static void listaMedicos() {
        for (String key : MedicosArray.keySet()) {

            //Capturamos o valor a partir da chave
            String value = MedicosArray.get(key);
            System.out.println(key + " = " + value);
        }
    }

    public void iniciar() {

        //--------------------------------------
        // Padrão de Projeto Iterator
        lista = new ArrayList<>();

        System.out.println("-------------------------");
        //--------------------------------------
        String nome;
        String cod;
        int vs = 1;
        int menu;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Medico m1 = new Medico();
        Paciente p = new Paciente();
        //busca
        String busca;

        do {
            System.out.println("Menu Principal\n\n1 - Cadastrar Medico\n2 - Procurar Medico");
            System.out.println("3 - Cadastrar paciente\n4 - Procurar paciente\n5 - Mostrar medicos\n6 - SAIR");
            System.out.print("Opcao escolhida: ");
            menu = scan.nextInt();

            //----------------------------------------
            if (menu == 1) {
                System.out.print("Nome: ");
                nome = scan.next();
                m1.setNome(nome);

                System.out.print("CRM: ");
                cod = scan2.next();
                m1.setCRM(cod);

                //----------------------------------------
                // TRATAMENTO DE EXCEÇÃO PARA CRM
                try {
                    if (cod.length() != 6) {
                        lista.remove(new Medico(m1.getNome(), m1.getCRM()));
                        throw new Exception("CRM invalido, o medico nao foi cadastrado!!");
                    }
                    lista.add(new Medico(m1.getNome(), m1.getCRM()));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //----------------------------------------

                // padrão de projeto iterator
                cadastrar(m1);
                m1 = new Medico();

                lista.add(m1);
                

            } else if (menu == 2) {
                System.out.println(MedicosArray);
                System.out.println("O que deseja buscar?");
                busca = scan.next();
                if (MedicosArray.containsKey(busca)) {
                    System.out.println("Valor da Chave " + busca
                            + " = " + MedicosArray.get(busca));
                } else {
                    System.err.println("Chave não existe");
                }
            } else if (menu == 3) {
                System.out.print("Nome: ");
                nome = scan.next();
                p.setNome(nome);

                System.out.print("CPF: ");
                cod = scan2.next();
                p.setCRM(cod);

                cadastrarP(p);
                p = new Paciente();

            } else if (menu == 4) {
                System.out.println(PacientesArray);
                System.out.println("O que deseja buscar?");
                busca = scan.next();
                if (PacientesArray.containsKey(busca)) {
                    System.out.println("Valor da Chave " + busca
                            + " = " + PacientesArray.get(busca));
                } else {
                    System.err.println("Chave não existe");
                }

            } else if (menu == 5) {
                Iterator i = new ItemIterator(lista);
                while (i.temProximo()) {
                    System.out.println((Medico) i.proximo());
                }
            } else if (menu == 6) {
                System.out.println("Obrigado por utilizar o sistema.");
                vs = 0;
            } else {
                System.out.println("Erro de número.");
            }
        } while (vs != 0);

    }

    public static void main(String[] args) {

        Projeto2 proj = new Projeto2();
        proj.iniciar();

    }
}
