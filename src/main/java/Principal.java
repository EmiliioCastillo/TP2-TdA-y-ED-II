import java.util.Scanner;

public class Principal {
public static void main(String[] args){

    TablaHash tablaHash = new TablaHash();
    TablaHash[] h = new TablaHash[15];
    Scanner scanner = new Scanner(System.in);

    for(int i = 0; i < h.length; i++){
        h[i] = new TablaHash();
        h[i].estado = 0;
    }


    tablaHash.insertaHash(h, 11);
    tablaHash.insertaHash(h, 12);
    tablaHash.insertaHash(h, 10);

}



}
