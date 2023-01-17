public class Main {

    public static void main(String args[]) {

        CheckersGame game = new CheckersGame();

        while (!game.isOver()) {
            game.performTurn();
            game.endTurn();
        }
    }
}
