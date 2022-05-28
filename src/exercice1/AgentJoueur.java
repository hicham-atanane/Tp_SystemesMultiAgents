package exercice1;

import java.util.Random;

public class AgentJoueur {
    char symbole;

    public void jouer(Character[][] ticTacToe){
        Random rand = new Random();
        int i= rand.nextInt(3);
        int j= rand.nextInt(3);
//      regenerer les indices tant que la case n'est pas vide (!= '_')
        while (ticTacToe[i][j]!='_'){
            i= rand.nextInt(3);
            j= rand.nextInt(3);
        }
        ticTacToe[i][j] = this.symbole;
    }
//  ---------------------------- Constructeur, Getters And Setters -----------------------
    public char getSymbole() {
        return symbole;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }

    public AgentJoueur(char symbole) {
        this.symbole = symbole;
    }
}
