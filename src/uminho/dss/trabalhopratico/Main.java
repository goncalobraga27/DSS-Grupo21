package uminho.dss.trabalhopratico;

import uminho.dss.trabalhopratico.business.Circuito;
import uminho.dss.trabalhopratico.business.Corrida;
import uminho.dss.trabalhopratico.business.F1ManagerLN;
import uminho.dss.trabalhopratico.business.SeccaoCircuito;
import uminho.dss.trabalhopratico.ui.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        F1ManagerLN f1m = new F1ManagerLN();
        boolean logged= false;
        Scanner scann = new Scanner(System.in);
        Scanner is = new Scanner(System.in);
        Scanner insertDouble = new Scanner(System.in);
        Menu menu = new Menu(new String[]{
                "Registar-se",
                "Autenticar-se",
                "Adicionar Circuito",
                "Adicionar Piloto",
                "Adicionar Campeonato",
                "Adicionar Carro",
        });

        menu.setPreCondition(1,()-> !logged);
        menu.setPreCondition(2,()-> !logged);
        /*
        menu.setPreCondition(3,()-> logged );
        menu.setPreCondition(4,()-> logged );
        menu.setPreCondition(5,()-> logged );
        menu.setPreCondition(6,()-> logged );
        menu.setPreCondition(7,()-> logged );
        */


        menu.setHandler(1,()->{
            int tom = -1;
            for (int i = 0; tom < 0 || tom > 2; i++) {
                if (i > 0)
                    System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                System.out.println("Selecione o tipo de utilizador que pretende");
                System.out.println("1-> Jogador");
                System.out.println("2-> Administrador");
                System.out.println("0-> Terminar Operação");
                tom = is.nextInt();
                if (tom!=0) {
                    System.out.println("Insira o seu nome de utilizador!");
                    String username = scann.nextLine();
                    System.out.println("Insira a sua password!");
                    String password = scann.nextLine();
                    if (tom==1) {
                        f1m.addJogador(username, password);
                    }
                    else {
                        f1m.addAdministrador(username,password);
                    }
                }
            }
        });

        menu.setHandler(2,()->{
            int tom = -1;
            for (int i = 0; tom < 0 || tom > 2; i++) {
                if (i > 0)
                    System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                System.out.println("Selecione o tipo de utilizador que pretende");
                System.out.println("1-> Jogador");
                System.out.println("2-> Administrador");
                System.out.println("0-> Terminar Operação");
                tom = is.nextInt();
                if (tom!=0) {
                    System.out.println("Insira o seu nome de utilizador!");
                    String username = scann.nextLine();
                    System.out.println("Insira a sua password!");
                    String password = scann.nextLine();
                    if (tom==1) {
                        System.out.println(f1m.validaJogador(username, password));
                    }
                    else {
                        System.out.println(f1m.validaAdministrador(username,password));
                    }
                }
            }
        });

        menu.setHandler(3,()->{
            try {
                System.out.println("Insira a nome do circuito:");
                String nome = scann.nextLine();
                System.out.println("Insira a distância do circuito:");
                double distancia= insertDouble.nextDouble();
                int num_curvas=0;
                int num_chicanes=0;
                int opt=-1;
                ArrayList<SeccaoCircuito> seccoes = new ArrayList<>();
                for (int i = 0; opt !=0; i++) {
                    if (i > 0 && (opt < 0 || opt > 2))
                        System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                    System.out.println("Selecione o tipo de manobra a adicionar ao circuito:");
                    System.out.println("1-> Curva");
                    System.out.println("2-> Chicane");
                    System.out.println("0-> Terminar Operação");
                    opt = is.nextInt();
                    if (opt!=0) {
                        System.out.println("Insira o grau de dificuldade de ultrapassagem (Valor entre 0 e 1):");
                        double gdu = is.nextDouble();
                        SeccaoCircuito s = new SeccaoCircuito(opt,num_curvas+num_chicanes,gdu);
                        if (opt==1)
                            num_curvas++;
                        else
                            num_chicanes++;
                        seccoes.add(s);
                    }
                }
                System.out.println("Insira o número de voltas do circuito:");
                int n_voltas = is.nextInt();
                f1m.addCircuito(nome,distancia,num_curvas,num_chicanes,n_voltas,seccoes);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        });

        menu.setHandler(4,()->{
            try {
                System.out.println("Insira o nome do Piloto a registar");
                String nome = scann.nextLine();
                double chuvaVsSeco= -1;
                for (int i = 0; chuvaVsSeco < 0 || chuvaVsSeco > 1; i++) {
                    if ((i < 0 || i > 1) && i != 0)
                        System.out.println("O valor indicado não é válido!\n");
                    System.out.println("Insira a sua habilidade Chuva vs Tempo Seco (Valor entre 0 e 1)");
                    chuvaVsSeco = is.nextDouble();
                }
                double SegVSAgre= -1;
                for (int i = 0; SegVSAgre < 0 || SegVSAgre > 1; i++) {
                    if ((i < 0 || i > 1) && i != 0)
                        System.out.println("O valor indicado não é válido!\n");
                    System.out.println("Insira a sua habilidade Segurança vs Agressividade (Valor entre 0 e 1)");
                    SegVSAgre = is.nextDouble();
                }
                f1m.addPiloto(nome,chuvaVsSeco,SegVSAgre);
            }
            catch (Exception e) {
                System.out.println("Dados inválidos");
            }
        });
/*
        menu.setHandler(5,()->{
            try {
                System.out.println("Insira a posiçao de x");
                int posx = scann.nextInt();
                System.out.println("Insira a posição de y");
                int posy = scann.nextInt();
                System.out.println("Defina a distância máxima a que pretende encontrar as trotinetes!");
                int dist = scann.nextInt();
            }
            catch (Exception e) {
                System.out.println("Dados inválidos");
            }
        });

        menu.setHandler(6,()->{
            try {
                System.out.println("Insira a posiçao de x");
                int posx = scann.nextInt();
                System.out.println("Insira a posição de y");
                int posy = scann.nextInt();
                System.out.println("Defina a distância máxima a que pretende encontrar as trotinetes!");
                int dist = scann.nextInt();
            }
            catch (Exception e) {
                System.out.println("Dados inválidos");
            }
        });

        menu.setHandler(7,()->{
            try {
                System.out.println("Insira a posiçao de x");
                int posx = scann.nextInt();
                System.out.println("Insira a posição de y");
                int posy = scann.nextInt();
                System.out.println("Defina a distância máxima a que pretende encontrar as trotinetes!");
                int dist = scann.nextInt();
            }
            catch (Exception e) {
                System.out.println("Dados inválidos");
            }
        });

 */

        menu.run();
    }
}