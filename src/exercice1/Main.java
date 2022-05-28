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
        while (!gameOver(ticTacToe)){
            System.out.println("------------");
            j1.jouer(ticTacToe);
            affichage(ticTacToe);

            if (gagner(ticTacToe, j1.getSymbole())){
                break;
            }

            System.out.println("------------");

            j2.jouer(ticTacToe);
            affichage(ticTacToe);

            if (gagner(ticTacToe, j2.getSymbole())){
                break;
            }
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
//        par ligne
        if (ticTacToe[0][0] !='_' && ticTacToe[0][0]==ticTacToe[0][1] && ticTacToe[0][0]==ticTacToe[0][2]){
            flag = true;
        } else if (ticTacToe[1][0] !='_' && ticTacToe[1][0]==ticTacToe[1][1] && ticTacToe[1][0]==ticTacToe[1][2]){
            flag = true;
        } else if (ticTacToe[2][0] !='_' && ticTacToe[2][0]==ticTacToe[2][1] && ticTacToe[2][0]==ticTacToe[2][2]){
            flag = true;
        }

//        par colonne
        if (ticTacToe[0][0] !='_' && ticTacToe[0][0]==ticTacToe[1][0] && ticTacToe[0][0]==ticTacToe[2][0]){
            flag = true;
        } else if (ticTacToe[0][1] !='_' && ticTacToe[0][1]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[2][1]){
            flag = true;
        } else if (ticTacToe[0][2] !='_' && ticTacToe[0][2]==ticTacToe[1][2] && ticTacToe[2][2]==ticTacToe[0][2]){
            flag = true;
        }

//        par diagonale
        if (ticTacToe[0][0] !='_' && ticTacToe[0][0]==ticTacToe[1][1] && ticTacToe[0][0]==ticTacToe[2][2]){
            flag = true;
        } else if (ticTacToe[2][0] !='_' && ticTacToe[2][0]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[0][2]){
            flag = true;
        }
        return flag;
    }

}
