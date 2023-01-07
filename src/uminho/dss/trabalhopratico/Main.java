package uminho.dss.trabalhopratico;

import uminho.dss.trabalhopratico.Campeonato.Campeonato;
import uminho.dss.trabalhopratico.Campeonato.Circuito;
import uminho.dss.trabalhopratico.Campeonato.SeccaoCircuito;
import uminho.dss.trabalhopratico.business.*;
import uminho.dss.trabalhopratico.ui.Menu;

import java.util.*;

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
                "Jogar",
        });

        menu.setPreCondition(1,()-> !menu.isPlayer && !menu.isAdmin);
        menu.setPreCondition(2,()-> !menu.isPlayer && !menu.isAdmin);
        menu.setPreCondition(3,()-> menu.isAdmin);
        menu.setPreCondition(4,()-> menu.isAdmin);
        menu.setPreCondition(5,()-> menu.isAdmin);
        menu.setPreCondition(6,()-> menu.isAdmin);
        menu.setPreCondition(7,()-> menu.isPlayer);


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
                        if(f1m.validaJogador(username, password)){
                            menu.isPlayer=true;
                            menu.username=username;
                        }
                    }
                    else {
                        if(f1m.validaAdministrador(username,password)){
                            menu.isAdmin=true;
                        }

                    }
                }
            }
        });

        menu.setHandler(3,()->{
            try {
                System.out.println("Insira a nome do circuito:");
                String nome = scann.nextLine();
                System.out.println("Insira a distância do circuito:");
                double distancia= is.nextDouble();
                int num_curvas=0;
                int num_chicanes=0;
                int opt=-1;
                ArrayList<SeccaoCircuito> seccoes = new ArrayList<>();
                for (int i = 0; opt !=0; i++) {
                    if (i > 0 && (opt < 0 || opt > 2))
                        System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                    else {
                        System.out.println("Selecione o tipo de manobra a adicionar ao circuito:");
                        System.out.println("1-> Curva");
                        System.out.println("2-> Chicane");
                        System.out.println("0-> Terminar Operação");
                        opt = is.nextInt();
                        if (opt != 0) {
                            System.out.println("Insira o grau de dificuldade de ultrapassagem (Valor entre 0 e 1):");
                            double gdu = is.nextDouble();
                            SeccaoCircuito s = new SeccaoCircuito(opt, num_curvas + num_chicanes, gdu);
                            if (opt == 1)
                                num_curvas++;
                            else
                                num_chicanes++;
                            seccoes.add(s);
                        }
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

        menu.setHandler(5,()->{
            try {
                System.out.println("Insira o nome do campeonato a registar");
                String nome = scann.nextLine();
                int opt=-1;
                ArrayList<String> circuitos = new ArrayList<>();
                for (int i = 0; opt !=0; i++) {
                    if (i > 0 && (opt < 0 || opt > 2))
                        System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                    System.out.println("1-> Adicionar um novo Circuito ao Campeonato");
                    System.out.println("0-> Terminar Operação");
                    opt = is.nextInt();
                    if (opt==1) {
                        Collection<Circuito> circ= f1m.getCircuitos();
                        for (Circuito m : circ) {
                            System.out.println(circ.toString());
                        }
                        System.out.println("Insira o nome do Circuito a Adicionar:");
                        String nomeCirc = scann.nextLine();
                        if (circ.stream().map(Circuito::getNome_circuito).toList().contains(nomeCirc))
                            circuitos.add(nomeCirc);
                        else {
                            System.out.println("O circuito não é válido");
                        }
                    }
                }
                f1m.addCampeonato(nome,circuitos);
                f1m.getCampeonato(nome);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        });

        menu.setHandler(6,()->{
            try {
                System.out.println("Insira a marca do carro a registar");
                String marca = scann.nextLine();
                System.out.println("Insira o modelo do Carro a registar");
                String modelo = scann.nextLine();
                int opt=-1;
                for (int i = 0; opt<0 || opt>4; i++) {
                    if (i > 0)
                        System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                    else {
                        System.out.println("Selecione a categoria do carro a adicionar:");
                        System.out.println("1-> Classe 1");
                        System.out.println("2-> Classe 2");
                        System.out.println("3-> Classe Grand Turismo");
                        System.out.println("4-> Stock Cars");
                        System.out.println("0-> Terminar Operação");
                        opt = is.nextInt();
                        int cilindrada = 0;
                        if (opt==2 || opt==3) {
                                while (!f1m.validacilindrada(opt,cilindrada)) {
                                    System.out.println("Insira a cilindrada do carro:");
                                    cilindrada = is.nextInt();
                                }
                        }
                        System.out.println("Insira a potência do motor de combustão do carro:");
                        int potenciaMC = is.nextInt();
                        double taxa=0;
                        double fiabilidade=0;
                        if (opt == 3) {
                            System.out.println("Insira a taxa de degradação do carro:");
                            taxa = is.nextDouble();
                            System.out.println("Insira a fiabilidade do carro:");
                            fiabilidade=is.nextDouble();
                        }
                        if(opt==4){
                            System.out.println("Insira a fiabilidade do carro:");
                            fiabilidade=is.nextDouble();
                        }
                        if (opt ==1 || opt==2 || opt==3) {

                            int opt1= -1;
                            for (int j = 0; opt1<1 || opt1>2; j++) {
                                if (j > 0)
                                    System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                                else {
                                    System.out.println("Selecione o tipo de veículo a adicionar:");
                                    System.out.println("1-> Combustão");
                                    System.out.println("2-> Híbrido");
                                    opt1 = is.nextInt();
                                }
                                if (opt1==2) {
                                    System.out.println("Insira a potência do motor elétrico do carro:");
                                    int potenciaME = is.nextInt();

                                    if (opt == 3) {
                                        f1m.addCarroGTHbr(marca,modelo,cilindrada,potenciaMC,taxa,potenciaME);
                                    }
                                    else if (opt==1) {
                                        f1m.addCarroC1Hbr(marca,modelo,potenciaMC,potenciaME);
                                    }
                                    else
                                        f1m.addCarroC2Hbr(marca,modelo,cilindrada,potenciaMC,potenciaME);
                                }
                                else {

                                    if (opt == 3) {
                                        f1m.addCarroGT(marca,modelo,cilindrada,potenciaMC,taxa);
                                    }
                                    else if (opt==1) {
                                        f1m.addCarroC1(marca,modelo,potenciaMC);
                                    }
                                    else if (opt==2) {
                                        f1m.addCarroC2(marca, modelo, cilindrada, potenciaMC);
                                    }
                                }
                            }
                        }
                        else if (opt==4){
                            f1m.addCarroSC(marca,modelo,cilindrada,potenciaMC,fiabilidade);
                        }



                    }
                }
            }
            catch (Exception e) {
                System.out.println("Dados inválidos");
            }
        });
        menu.setHandler(7,()->{
            try {
                Collection<Campeonato> champ= f1m.getCampeonatos();
                for (Campeonato c : champ) {
                    System.out.println(c.toString());
                }
                System.out.println("Escolha um campeonato:");
                String nomeChamp= scann.nextLine();
                System.out.println("Os pilotos disponíveis são:");
                Collection<Piloto> plts=f1m.getPilotos();
                for(Piloto p :plts){
                    System.out.println(p.toString());
                }
                System.out.println("Escolha um piloto:");
                String nomePiloto= scann.nextLine();
                System.out.println("Os carros disponiveis são:");
                Collection<Carro> cars=f1m.getCarros();
                for(Carro c:cars){
                    System.out.println(c.toString());
                }
                System.out.println("Escolha um carro:");
                String marcaModelo= scann.nextLine();
                f1m.simula(marcaModelo,nomePiloto,menu.username,nomeChamp);
            }
            catch (Exception e) {
                System.out.println("Dados inválidos");
            }
        });
        menu.run();
    }
}