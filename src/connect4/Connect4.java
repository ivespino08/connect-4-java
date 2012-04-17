/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import java.util.Scanner;

/**
 *
 * @author jgjpro
 */
public class Connect4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int state = 0;
        int max_players = 2;
        int player = 1;

        Grid grid = new Grid();

        Scanner input = new Scanner(System.in);

        while (state != -1) {
            switch (state) {
                case 0:
                    System.out.println("player " + player + "'s turn");
                    grid.display();
                    int x = input.nextInt();
                    if (x > 0 && x < grid.get_xsize() + 1) {
                        x--;
                        int y = grid.find_y(x);
                        if (y != -1) {
                            if (grid.set_and_check(x, y, player)) {
                                state++;
                            } else {
                                player = changeplayer(player, max_players);
                            }
                        } else {
                            System.out.println("collumn filled");
                        }
                    } else {
                        System.out.println("number must be > 0 < " + (grid.get_xsize() + 1));
                    }

                    break;
                case 1:

                    grid.display();
                    System.out.println("winner is player " + player
                            + "\n\nPlay again?\n"
                            + "press 0 for new game\n"
                            + "press anything else to quit");
                    int choice = input.nextInt();//choice in menu
                    if (choice == 0) {
                        state = 0;
                        grid = new Grid();
                        player = 1;
                    } else {
                        state = -1;
                    }

                    break;
            }
        }

    }

    public static int changeplayer(int player, int max_players) {
        player++;
        if (player > max_players) {
            return 1;
        }
        return player;
    }
}