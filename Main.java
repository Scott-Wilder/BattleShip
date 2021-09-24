package battleship;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BattleShip battleShip = new BattleShip();
        gameMenu(battleShip);
    }

    /**
     * Outputs the sea and allows user to add coordinates for each ship.
     *
     * @param battleShip BattleShip to be played
     */
    static void gameMenu(BattleShip battleShip) {
        battleShip.printBoard();
        battleShip.setAircraftCarrier();
        battleShip.printBoard();
        /*
        battleShip.setBattleship();
        battleShip.printBoard();
        battleShip.setSubmarine();
        battleShip.printBoard();
        battleShip.setCruiser();
        battleShip.printBoard();
        battleShip.setDestroyer();
        battleShip.printBoard();
*/
    }

    /**
     * User inputs the ship's coordinates.
     *
     * @return returns the coordinates
     */
    static String[] shipInput() {
        Scanner scanner = new Scanner(System.in);
        return new String[]{scanner.next(), scanner.next()};
    }

    /**
     * BattleShip is the class to play the game Battleships
     */
    static class BattleShip {
        private char[][] gameBoard;
        private int i1;
        private int j1;
        private int i2;
        private int j2;
        private char sea = '~';
        private final String ALPHABET = "ABCDEFGHIJ";
        private String ship;
        private String cells;

        /**
         * Constructor creates the default 10x10 board by calling the method createBoard.
         * Prints Welcome statement
         */
        BattleShip() {
            System.out.print("Welcome to WildMan's BattleShip:\n");
            createBoard();
        }

        void createBoard() {
            this.gameBoard = new char[10][10];
            for (char[] row : this.gameBoard) {
                Arrays.fill(row, sea);
            }
        }

        void printBoard() {
            // Prints the top row of numbers
            System.out.print(" ");
            for (int j = 1; j <= gameBoard.length; j++) {
                System.out.print(" " + j);
            }
            System.out.println();
            // Prints each row. The rows are labelled A to J.
            char letter = 'A';
            for (char[] row : gameBoard) {
                System.out.print(letter++ + " ");
                for (int j = 0; j < gameBoard.length; j++) {
                    System.out.print(row[j] + " ");
                }
                System.out.println();
            }
        }

        /**
         * Adds the coordinates for the Aircraft Carrier to the gameBoard.
         */
        void setAircraftCarrier() {
            ship = "Aircraft Carrier";
            cells = "5";
            setShip();
        }

        /**
         * Adds the coordinates for the Battleship to the gameBoard.
         */
        void setBattleship() {
            ship = "Battleship";
            cells = "4";
            setShip();
        }

        /**
         * Adds the coordinates for the Submarine to the gameBoard.
         */
        void setSubmarine() {
            ship = "Submarine";
            cells = "3";
            setShip();
        }

        /**
         * Adds the coordinates for the Cruiser to the gameBoard.
         */
        void setCruiser() {
            ship = "Cruiser";
            cells = "3";
            setShip();
        }

        /**
         * Adds the coordinates for the Destroyer to the gameBoard.
         */
        void setDestroyer() {
            ship = "Destroyer";
            cells = "2";
            setShip();
        }

        private void setShip() {
            System.out.printf("Enter the coordinates of the %s (%s cells): ", ship, cells);
            boolean state = false;
            while (state != true) {
                // Scan user input
                String[] coordinates = shipInput();
                System.out.println(coordinates[0].charAt(0));
                state = true;
            }
            /**
             * Adds the ship denoted by 'O' to the sea
             */


        }
        private void addShipToBoard() {
            for (int i = i1; i <= i2; i++) {
                for (int j = j1; j <= j2; j++) {
                    gameBoard[i][j] = 'O';
                }
            }
        }
    }
}
