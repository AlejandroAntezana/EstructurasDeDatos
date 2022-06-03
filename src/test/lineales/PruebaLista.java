package test.lineales;
import lineales.estaticas.Cola;
//import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

public class PruebaLista {
    public static void main(String[] args) {

        Cola c1 = new Cola();
        Cola c2;

        c1.poner(1);
        c1.poner(2);
        c1.poner(3);
        c1.poner(8);
        c1.poner(7);
        c1.poner(9);

        c2 = c1.Clone();

        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }

    public static Lista concatenar(Lista lista1, Lista lista2) {
        Cola colaAux = new Cola();
        Lista listaNueva;
        int longitud = lista2.longitud();
        int iter = 1;

        /*como siempre empieza con la lista1, a la listaNueva le
        paso el clon de lista1*/
        listaNueva = lista1.clone();

        while (iter <= longitud) {
            //lleno la cola con los elementos de la lista
            colaAux.poner(lista2.recuperar(iter));
            iter++;
        }

        iter = lista1.longitud()+1;
        while (!colaAux.esVacia()) {
            listaNueva.insertar(colaAux.obtenerFrente(), iter);
            colaAux.sacar();
            iter++;
        }

        return listaNueva;
    }

    public static boolean comprobar(Lista unaLista){
        boolean exito=false;
        Lista unaListaClon = unaLista.clone();
        Cola colaAux = new Cola();
        Cola colaAux2 = new Cola();
        Pila pilaAux = new Pila();
        int finCadena = unaLista.localizar(0);
        int longitudCadena = finCadena-1;
        int posicion=1;
        while (posicion<finCadena){
            colaAux.poner(unaLista.recuperar(posicion));
            pilaAux.apilar(unaLista.recuperar(posicion));
            posicion++;
        }
        posicion=1;
        while(posicion<=finCadena){
            unaListaClon.eliminar(1);
        }

    return exito;
    }


}
