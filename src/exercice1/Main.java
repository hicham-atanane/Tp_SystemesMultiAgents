package exercice1;

public class Main {
    public static void Affichage(Character[][] ticTacToe){
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

    public static void main(String[] args) {
        Character[][] ticTacToe= new Character[3][3];
        for (int i=0; i<3; i++){
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = '_';
            }
        }
        Affichage(ticTacToe);
    }
}
