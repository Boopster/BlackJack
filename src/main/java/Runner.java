import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Game game = new Game(0,0);

        System.out.println("---------");
        System.out.println("Blackjack");
        System.out.println("---------");
        System.out.println("Please enter your name: ");

        String playerName = scanner.next();

        String play = "y";

        do {
            Player player1 = new Player(playerName);
            Player player2 = new Player("Dealer");
            game.startGame(player1, player2);

//        int total1 = player1.getTotalPlayerHand();
//        int total1a = player1.getOtherTotalPlayerHand();
//        int total2 = player2.getTotalPlayerHand();
            System.out.println(String.format("------------------"));
            System.out.println(String.format("The Dealer's hand:"));
            System.out.println(String.format("------------------"));
            System.out.println(player2.showCard(0));
            System.out.println("????? of ?????");
            System.out.println(String.format("----------------"));
            System.out.println(String.format("%s's hand:", player1.getName()));
            System.out.println(String.format("----------------"));

            for (int i = 0; i < player1.countNoCardsPlayerHand(); i++) {
                System.out.println(player1.showCard(i));
            }
            int total1 = player1.getTotalPlayerHand();
            int total1a = player1.getOtherTotalPlayerHand();
            if (total1a != 21) {

                total1 = player1.getTotalPlayerHand();

                System.out.println(String.format("%s's Total: %s", player1.getName(), total1));
                System.out.println(String.format("%s, would you like to twist? (y/n)", player1.getName()));

                String twist = scanner.next();

                do {
                    if (twist.equals("y")) {
                        System.out.println(String.format("----------------"));
                        System.out.println(String.format("%s's hand:", player1.getName()));
                        System.out.println(String.format("----------------"));
                        game.playerTwist(player1);
                        for (int i = 0; i < player1.countNoCardsPlayerHand(); i++) {
                            System.out.println(player1.showCard(i));
                        }

                        total1 = player1.getTotalPlayerHand();
                        System.out.println(String.format("%s's Total: %s", player1.getName(), player1.getStringPlayerHand()));
                        if (total1 < 21) {
                            System.out.println(String.format("%s, would you like to twist? (y/n)", player1.getName()));
                            twist = scanner.next();
                        } else {
                            twist = "n";
                        }
                    }
                } while (twist.equals("y"));

            } else {
                System.out.println(String.format("%s's Total: 21 - BLACKJACK!!!!!", player1.getName()));
            }
            int total2 = player2.getTotalPlayerHand();
            int total2a = player2.getOtherTotalPlayerHand();
            do {
                game.dealerTwist(player2);
                total2 = player2.getTotalPlayerHand();
            } while (total2 < 16);

            System.out.println(String.format("------------------"));
            System.out.println(String.format("The Dealer's hand:"));
            System.out.println(String.format("------------------"));

            for (int i = 0; i < player2.countNoCardsPlayerHand(); i++) {
                System.out.println(player2.showCard(i));
            }
            total2 = player2.getTotalPlayerHand();
            System.out.println(String.format("The Dealer's Total: %s", player2.getStringPlayerHand()));
            System.out.println(String.format("-------------------------"));
            System.out.println(game.getResult(player1, player2));
            System.out.println(String.format("-------------------------"));
            System.out.println(String.format("%s's Total Games Won: %s",player1.getName(),game.getPlayer1Total()));
            System.out.println(String.format("The Dealer's Total Games Won: %s",game.getPlayer2Total()));
            System.out.println(String.format("Would you like to play again? (y/n)"));
            play = scanner.next();

        } while (play.equals("y"));
    }
}



