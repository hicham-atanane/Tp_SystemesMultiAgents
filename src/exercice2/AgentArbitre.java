package exercice2;

import exercice1.AgentJoueur;

public class AgentArbitre {
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
        int counter;
//  par ligne
        for (int i = 0; i < 3; i++) {
            counter = 0;
            similaire = ticTacToe[i][0];
            if (similaire!='_'){
                for (int j = 1; j < 3; j++) {
                    if (ticTacToe[i][j]!=similaire){ break;}
                    counter ++;
                }
            }
            if (counter == 2){ flag = true; break;}
        }
//  par colonne
        for (int i = 0; i < 3; i++) {
            counter = 0;
            similaire = ticTacToe[0][i];
            if (similaire!='_'){
                for (int j = 1; j < 3; j++) {
                    if (ticTacToe[j][i]!=similaire){ break;}
                    counter ++;
                }
            }
            if (counter == 2){ flag = true; break;}
        }
//  par diagonale
        if (ticTacToe[1][1]!='_' && ticTacToe[2][0]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[0][2]){flag=true;}
        else if (ticTacToe[1][1]!='_' && ticTacToe[0][0]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[2][2]){flag=true;}

        return flag;
    }
    public static AgentJoueur partie(int tour, Character[][] ticTacToe, AgentJoueur j1, AgentJoueur j2){
        AgentJoueur j=j1;
        if (tour == 1){
            j = j1;
        } else if (tour == 2){
            j = j2;
        }
        j.jouer(ticTacToe);
        affichage(ticTacToe);
        return j;
    }
    public static boolean resultat(Character[][] ticTacToe, AgentJoueur j){
        boolean flag = false;
        System.out.println("------------");
        affichage(ticTacToe);
        if (gagner(ticTacToe, j.getSymbole())) {
            System.out.println(j.getSymbole() + " a gagné");
            flag = true;
        }
        else if (gameOver(ticTacToe)) {
            System.out.println("Match nulle");
            flag = true;
        }
        return flag;
    }
}
