package exercice1;
import static exercice2.AgentArbitre.*;

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

        int tour = 1;
        AgentJoueur j = partie(tour, ticTacToe, j1, j2);
        while (!resultat(ticTacToe, j)) {
            j = partie(tour, ticTacToe, j1, j2);
            affichage(ticTacToe);
            if (j == j1) {tour = 2;}
            else {tour = 1;}
            resultat(ticTacToe, j);
        }
    }
}
