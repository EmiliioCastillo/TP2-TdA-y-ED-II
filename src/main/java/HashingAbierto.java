import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.util.Objects.hash;

public class HashingAbierto {

    public static final int TAMAGNO_TABLA = 10;

 public int funcionHash(int n){
     return n % TAMAGNO_TABLA;
 }

    public void insertarElemento(int n) {
        Stack<Integer>[] tablaHash = new Stack[TAMAGNO_TABLA];
        int indice = funcionHash(n);

        if (tablaHash[indice] == null) {
            tablaHash[indice] = new Stack<>();
        }

        Stack<Integer> lista = tablaHash[indice];
        lista.add(n);
    }


    public int buscarHash(LinkedList<Integer> tablaHash, int n) {
        int indice = funcionHash(n);
        int posicion = -1;

        for (int i = 0; i < tablaHash.size(); i++) {
            int elemento = tablaHash.get((indice + i) % TAMAGNO_TABLA);

            if (elemento == n) {
                posicion = (indice + i) % TAMAGNO_TABLA;
                break; // Se encontró el elemento en la lista enlazada, se sale del bucle
            }
        }

        return posicion; // Retorna la posición del elemento o -1 si no se encontró
    }


    public int eliminarElementoHash(LinkedList<Integer> tablaHash, int n) {
        int estado = buscarHash(tablaHash, n);
        if (estado == -1) {
            return -1; //Quiere decir que no se encontro la posicion
        } else {
            tablaHash.remove(estado);
            return estado;
        }
    }
}
