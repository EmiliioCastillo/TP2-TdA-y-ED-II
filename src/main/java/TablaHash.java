import java.util.Arrays;
import java.util.LinkedList;

public class TablaHash {

    private static final int TAMAGNO_TABLA = 10;
    int dato;
    int estado; //0 = vacio, 1 = activo, 2 = ocupado
    TablaHash[] elementos;


    public int funcionHash(int n) {
        return (n % TAMAGNO_TABLA);
    }

    public int sondeoLineal(int[] tablaHash, int n) {
        int indice = funcionHash(n);

        while (tablaHash[indice] != 0) {
            indice = (indice + 1) % TAMAGNO_TABLA; // Avanza a la siguiente posición

            // Si se ha recorrido toda la tabla sin encontrar una posición vacía, sale del bucle
            if (indice != n % TAMAGNO_TABLA) {
                continue;
            }
            break;
        }
        return indice;
    }

    public int sondeoCuadratico(int[] tablaHash, int n) {
        int indice = funcionHash(n);

            if(!esPrimo(tablaHash.length)){
                throw new IllegalArgumentException("El tamaño de la tabla no es un número primo.");
            }
            for (int i = 0; i < TAMAGNO_TABLA; i++) {
                int incremento = (int) Math.pow(i, 2); // Cálculo del incremento cuadrático
                indice = (indice + incremento) % TAMAGNO_TABLA; // Calcular la nueva posición

                if (tablaHash[indice] == 0) {
                    break; // Si se encuentra una posición vacía, se sale del bucle
                }
            }
            return indice;
        }

    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }






    public void insertaHash(TablaHash[] h, int n) {
        boolean i = false;
        int j = funcionHash(n);
        do {
            if (h[j].estado == 0 || h[j].estado == 1) {
                // Trabajo Práctico
                h[j].dato = n;
                h[j].estado = 2;
                i = true;
            } else {
                j++;
            }
        } while (j < TAMAGNO_TABLA && !i);
        if (i) {
            System.out.print("Elemento insertado con Éxito! \n");
        } else {
            System.out.print("Tabla llena!!! \\n");
        }
    }

    public int buscaHash(TablaHash[] h, int n) {
//h es la tabla hash
//n es el valor buscado
// y debe devolver el valor mismo que busca n si lo encuentra y -1 si no
        // encuentra nada

        //Guardamos la posicion del modulo que se hizo en la funcion
        int posicion = funcionHash(n);

        //Mientras la posicion sea menor al tamaño de la tabla
        while (posicion < TAMAGNO_TABLA) {

            if (h[posicion].estado == 0) {
                return -1;
                //Si el dato de la posicion tiene la misma clave que el valor buscado
            } else if (h[posicion].dato == n) {
                //Si el estado es eliminado no retorna nada
                if (h[posicion].estado == 1) {
                    return -1;
                }
                //sino devuelve el valor mismo que busca n
                return posicion;
            }
            //Para que salga del bucle lo incrementamos
            return posicion++;
        }
        return -1;

    }


    public int eliminaHash(TablaHash[] h, int n) {
        int i = buscaHash(h, n);
        if (i == -1) {
            return -1;
        } else {
            h[i].estado = 1;
            System.out.print("Elemento Borrado! \n");
            return 1;
        }
    }
}

