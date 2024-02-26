package actsbuscamines;

import Teclat.*;
import java.util.Random;

public class BuscaminesAglioAdrian {

    static final char BANDERETA = 'P';
    static final char TAPAT = 'X';
    static final char BLANCO = '_';

    //Funcion para crear el tablero visible
    static char[][] creaTaulerVisible() {
        int FILAS = Teclat.lligInt("Dime cuantas filas quieres");
        int COL = Teclat.lligInt("Dime cuantas columnas quieres");

        char taulerVisible[][] = new char[FILAS + 1][COL + 1];

        for (int filas = 0; filas < taulerVisible.length; filas++) {
            for (int columnas = 0; columnas < taulerVisible.length; columnas++) {
                taulerVisible[filas][columnas] = TAPAT;

            }
        }
        return taulerVisible;
    }

    //Funcion para crear el tablero de minas
    static boolean[][] creaTaulerMines(char taulerVisible[][], int qMinas) {

        boolean taulerMines[][] = new boolean[taulerVisible.length][taulerVisible[0].length];
        Random random = new Random();

        int cMinas = 0;

        while (cMinas < qMinas) {

            for (int i = 1; i <= taulerVisible.length - 1; i++) {

                for (int j = 1; j <= taulerVisible[0].length - 1; j++) {
                    boolean minas = random.nextBoolean();
                    taulerMines[i][j] = minas;

                    if (minas == true) {
                        cMinas += 1;
                    }
                    if (cMinas == qMinas) {
                        break;
                    }
                }
                if (cMinas == qMinas) {
                    break;
                }

            }

        }
        return taulerMines;
    }

    //Funcion para decir si en esa posicion hay una mina o no
    static boolean minada(boolean taulerMines[][], int posfila, int poscol) {
        boolean haymina = false;
        if (taulerMines[posfila][poscol] == true) {
            haymina = true;
        }
        return haymina;

    }

    //Funcion para decir si la posicion deseada esta fuera del tablero visible o no
    static boolean incorrecta(char taulerVisible[][], int posfila, int poscol) {

        if (posfila > taulerVisible.length - 1 || poscol > taulerVisible[0].length - 1 || posfila < 1 || poscol < 1) {
            return true;
        } else {
            return false;
        }

    }

    //Funcion para decir si la posicion deseada esta fuera del tablero visible o no
    static boolean incorrecta(boolean taulerMines[][], int posfila, int poscol) {
        boolean incorrecta = true;
        if (posfila > taulerMines.length - 1 || poscol > taulerMines[0].length - 1 || posfila < 1 || poscol < 1) {
            incorrecta = true;
        } else {
            incorrecta = false;
        }
        return incorrecta;
    }

    //Funcion para contar las minas que tocan esa posicion
    static int qma(boolean taulerMines[][], int posfila, int poscol) {
        int cMinesadjacents = 0;
        //Izquierda
        if (incorrecta(taulerMines, posfila, poscol - 1) == false) {

            if (taulerMines[posfila][poscol - 1] == true) {
                cMinesadjacents += 1;
            }
        }

        //Derecha
        if (incorrecta(taulerMines, posfila, poscol + 1) == false) {

            if (taulerMines[posfila][poscol + 1] == true) {
                cMinesadjacents += 1;
            }
        }
        //Arriba
        if (incorrecta(taulerMines, posfila - 1, poscol) == false) {

            if (taulerMines[posfila - 1][poscol] == true) {
                cMinesadjacents += 1;
            }
        }

        //Abajo
        if (incorrecta(taulerMines, posfila + 1, poscol) == false) {

            if (taulerMines[posfila + 1][poscol] == true) {
                cMinesadjacents += 1;
            }
        }
        //Izquierda arriba
        if (incorrecta(taulerMines, posfila - 1, poscol - 1) == false) {

            if (taulerMines[posfila - 1][poscol - 1] == true) {
                cMinesadjacents += 1;
            }
        }
        //Izquierda abajo
        if (incorrecta(taulerMines, posfila + 1, poscol - 1) == false) {

            if (taulerMines[posfila + 1][poscol - 1] == true) {
                cMinesadjacents += 1;
            }
        }
        //Derecha arriba
        if (incorrecta(taulerMines, posfila - 1, poscol + 1) == false) {

            if (taulerMines[posfila - 1][poscol + 1] == true) {
                cMinesadjacents += 1;
            }
        }
        //Derecha abajo
        if (incorrecta(taulerMines, posfila + 1, poscol + 1) == false) {

            if (taulerMines[posfila + 1][poscol + 1] == true) {
                cMinesadjacents += 1;
            }
        }
        return cMinesadjacents;
    }

    //Funcion para decir si esa poscicion esta destapada o no
    static boolean destapada(char taulerVisible[][], int posfila, int poscol) {

        if (taulerVisible[posfila][poscol] != TAPAT) {

            return true;
        } else {
            return false;
        }

    }

    //Funcion para contar las casillas destapadas que hay
    static int qDestapades(char[][] taulerVisible) {
        int cDestapades = 0;
        for (int i = 1; i <= taulerVisible.length - 1; i++) {
            for (int j = 1; j <= taulerVisible[0].length - 1; j++) {
                if (taulerVisible[i][j] != TAPAT) {
                    cDestapades += 1;
                }

            }

        }
        return cDestapades;
    }

    //Funcion para mostrar el tablero
    static void mostraTauler(char taulerVisible[][], boolean taulerMines[][], boolean mostrarminas) {

        System.out.print("  ");
        for (int columnas = 1; columnas <= taulerVisible.length - 1; columnas++) {

            System.out.print(columnas + " ");
        }
        System.out.println("");

        for (int filas = 1; filas <= taulerMines.length - 1; filas++) {
            System.out.print(filas);
            System.out.print("|");
            for (int columnas = 1; columnas <= taulerMines[0].length - 1; columnas++) {

                if (mostrarminas == true) {
                    for (int i = 1; i <= taulerMines.length - 1; i++) {
                        for (int j = 1; j <= taulerMines[0].length - 1; j++) {

                            if (taulerMines[i][j] == true) {
                                taulerVisible[i][j] = 'Q';

                            }
                        }
                    }
                }
                System.out.print(taulerVisible[filas][columnas] + "|");

            }
            System.out.print(filas);
            System.out.println(" ");

        }
        System.out.print("  ");
        for (int i = 1; i <= taulerVisible.length - 1; i++) {

            System.out.print(i + " ");
        }
        System.out.println("");

    }

    //Funcion para decir si hemos picado sobre una mina o no
    static boolean pica(char taulerVisible[][], boolean taulerMines[][], int posfila, int poscol) {
        boolean picar = false;
        if (taulerMines[posfila][poscol] != true) {
            destapa(taulerVisible, taulerMines, posfila, poscol);

        } else {
            picar = true;
        }
        return picar;

    }

    //Funcion recursiva para el tablero visible
    static void destapa(char taulerVisible[][], boolean taulerMines[][], int posfila, int poscol) {

        if (incorrecta(taulerVisible, posfila, poscol) == true) {
            return;

        }
        if (incorrecta(taulerMines, posfila, poscol) == true) {
            return;
        }

        if (destapada(taulerVisible, posfila, poscol) == true) {
            return;
        }
        if (qma(taulerMines, posfila, poscol) > 0) {
            taulerVisible[posfila][poscol] = (char) (qma(taulerMines, posfila, poscol) + '0'); // Convertir el número de minas a un carácter
            return;
        }

        // Marcar la celda de esa posicion como destapada
        taulerVisible[posfila][poscol] = BLANCO;

        //Recorrer casillas adyacentes
        //Izquierda
        destapa(taulerVisible, taulerMines, posfila, poscol - 1);
        //Derecha
        destapa(taulerVisible, taulerMines, posfila, poscol + 1);
        //Arriba
        destapa(taulerVisible, taulerMines, posfila - 1, poscol);
        //Abajo
        destapa(taulerVisible, taulerMines, posfila + 1, poscol);
        //Izquierda arriba
        destapa(taulerVisible, taulerMines, posfila - 1, poscol - 1);
        //Izquierda abajo
        destapa(taulerVisible, taulerMines, posfila + 1, poscol - 1);
        //Derecha arriba
        destapa(taulerVisible, taulerMines, posfila - 1, poscol + 1);
        //Derecha abajo
        destapa(taulerVisible, taulerMines, posfila + 1, poscol + 1);

        if (incorrecta(taulerVisible, posfila, poscol) == false && taulerVisible[posfila][poscol] != BLANCO) {
            destapa(taulerVisible, taulerMines, posfila, poscol);
        }

    }

    public static void main(String[] args) {
        boolean repetirjuego = true;
        while (repetirjuego == true) {
            char repetir = 0;
            repetirjuego = false;
            char taulerV[][] = creaTaulerVisible();

            int qMinas = Teclat.lligInt("Dime cuantas minas quieres esconder en el tablero");
            boolean taulerM[][] = creaTaulerMines(taulerV, qMinas);

            boolean mostrarminas = false;
            mostraTauler(taulerV, taulerM, mostrarminas);

            while (mostrarminas != true) {
                int opcion = Teclat.lligOpcio("MENU", "Picar", "Posar bandereta");
                switch (opcion) {
                    case 1:
                        int posfilapicar = Teclat.lligInt("Dime en que fila quieres picar");
                        int poscolpicar = Teclat.lligInt("Dime en que columna quieres picar");
                        pica(taulerV, taulerM, posfilapicar, poscolpicar);

                        if (minada(taulerM, posfilapicar, poscolpicar) == true) {
                            mostrarminas = true;
                            mostraTauler(taulerV, taulerM, mostrarminas);
                            System.out.println("Has perdido");
                            repetir = Teclat.lligChar("Quieres jugar otra vez?(S/N)");

                        } else {
                            destapa(taulerV, taulerM, posfilapicar, poscolpicar);
                            mostraTauler(taulerV, taulerM, mostrarminas);

                        }
                        if (qDestapades(taulerV) == (taulerV.length - 1) * (taulerV[0].length - 1) - qMinas) {
                            System.out.println("Has ganado");
                            mostrarminas = true;
                            repetir = Teclat.lligChar("Quieres jugar otra vez?(S/N)");
                        }
                        if (repetir == 'S' || repetir == 's') {
                            repetirjuego = true;
                        }
                        break;
                    case 2:

                        int posfilabandereta = Teclat.lligInt("Dime en que fila quieres poner una bandereta");
                        int poscolbandereta = Teclat.lligInt("Dime en que columna quieres poner una bandereta");

                        if (taulerV[posfilabandereta][poscolbandereta] == BANDERETA) {
                            taulerV[posfilabandereta][poscolbandereta] = TAPAT;
                        } else {
                            taulerV[posfilabandereta][poscolbandereta] = BANDERETA;
                        }
                        mostraTauler(taulerV, taulerM, mostrarminas);
                        break;

                }
            }
        }
    }
}
