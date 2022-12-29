package uminho.dss.trabalhopratico;

import uminho.dss.trabalhopratico.business.F1ManagerLN;
import uminho.dss.trabalhopratico.ui.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        F1ManagerLN f1m = new F1ManagerLN();
        boolean logged= false;
        Scanner scann = new Scanner(System.in);
        Scanner is = new Scanner(System.in);
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

        menu.setHandler(4,()->{
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