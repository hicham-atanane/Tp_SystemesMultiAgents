package exercice1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Character[][] ticTacToe= new Character[3][3];
        for (int i=0; i<3; i++){
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = '_';
            }
        }

        AgentJoueur j1 = new AgentJoueur('X');
        AgentJoueur j2 = new AgentJoueur('O');
        int counter = 0;
        while (!gameOver(ticTacToe) && counter < 10){
            System.out.println("------------");
            j1.jouer(ticTacToe);
            affichage(ticTacToe);

            if (gagner(ticTacToe, j1.getSymbole())){
                System.out.println("------------");
                affichage(ticTacToe);
                System.out.println(j1.getSymbole()+" a gagné");
                break;
            }

            counter ++;
            if (counter == 9){
                System.out.println("Match nulle");
                break;
            }
            j2.jouer(ticTacToe);
            System.out.println("------------");
            affichage(ticTacToe);

            if (gagner(ticTacToe, j2.getSymbole())){
                System.out.println("------------");
                affichage(ticTacToe);
                System.out.println(j2.getSymbole()+" a gagné");
                break;
            }
            counter ++;
        }
    }
//--------------------Methods--------------------------------------
    public static void affichage(Character[][] ticTacToe){
        System.out.println(" |0|1|2|");
        for (int i = 0; i < 3; i++) {
            System.out.print(i);
            System.out.print('|');
            for (int j = 0; j < 3; j++) {
                System.out.print(ticTacToe[i][j]);
                System.out.print('|');
            }
            System.out.println();
        }
    }
//------------------------------------------------------------------
    public static boolean gameOver(Character[][] ticTacToe){
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToe[i][j]=='_'){
                    flag = false;
                    break;
                }
            }
            if (!flag){break;}
        }
        return flag;
    }
//------------------------------------------------------------------
    public static boolean gagner(Character[][] ticTacToe, char symbole){
        boolean flag = false;
        char similaire;
        int counter1;
        int counter2;
//  par ligne
        for (int i = 0; i < 3; i++) {
            counter1 = 0;
            similaire = ticTacToe[i][0];
            if (similaire!='_'){
                for (int j = 1; j < 3; j++) {
                    if (ticTacToe[i][j]!=similaire){ break;}
                    counter1 ++;
                }
            }
            if (counter1 == 2){ flag = true; break;}
        }
//  par colonne
        for (int i = 0; i < 3; i++) {
            counter1 = 0;
            similaire = ticTacToe[0][i];
            if (similaire!='_'){
                for (int j = 1; j < 3; j++) {
                    if (ticTacToe[j][i]!=similaire){ break;}
                    counter1 ++;
                }
            }
            if (counter1 == 2){ flag = true; break;}
        }
//  par diagonale
        for (int i = 0; i < 3; i++) {
            similaire = ticTacToe[i][i];
            counter1 = 0;
            counter2 = 0;
            if (similaire!='_'){
                for (int j = 1; j < 3; j++) {
                    if (ticTacToe[j][j]!=similaire){ break;}
                    counter1 ++;
                }
                for (int j = 1; j < 3; j++) {
                    if (ticTacToe[j][2-j]!=similaire){ break;}
                    counter2 ++;
                }
            }
            if (counter1 == 2 || counter2 == 2){ flag = true; break;}
        }
        return flag;
    }
}
