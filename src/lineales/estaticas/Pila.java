package lineales.estaticas;

/*
 *@author Antezana de la Rivera, Alejandro. FAI-2945.
 */

public class Pila {
    //ATRIBUTOS DE LA CLASE PILA
    private static final int TAMANIO = 10;
    private int tope;
    private Object[] arreglo;

    //CONSTRUCTOR QUE CREA UNA PILA VACIA
    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    //Metodos de la clase
    public boolean apilar(Object nuevoElemento) {
        //Devuelve True si el elemento se agrego correctamente a la pila. False en caso contrario.
        boolean exito;
        if (this.tope + 1 >= this.TAMANIO) {
            //error pila llena
            exito = false;
        } else {
            this.tope++;
            this.arreglo[tope] = nuevoElemento;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito;
        if (this.tope == -1) {
            //error pila vacia
            exito = false;
        } else {
            this.arreglo[tope] = null;
            this.tope--;
            exito = true;
        }
        return exito;
    }


    public Object obtenerTope() {
        Object elemento;
        if (this.tope == -1) {
            //error pila sin elementos (vacia)
            elemento = null;
        } else {
            elemento = this.arreglo[this.tope];
        }
        return elemento;
    }

    public boolean esVacia() {
        return this.tope == -1;
    }

    public void vaciar() {
        Object[] aux = new Object[this.arreglo.length - 1];
        System.arraycopy(aux, 0, this.arreglo, 0, aux.length - 1);
        this.tope = -1;
    }

    public Pila clone() {
        Pila clon = new Pila();
        System.arraycopy(this.arreglo, 0, clon.arreglo, 0, 10);
        clon.tope = this.tope;
        return clon;
    }

    @Override
    public String toString() {
        String out = "";
        int i = 0;
        if (this.tope == -1) {
            out = "pila Vacia";
        } else {
            while (i <= this.tope) {
                out = out + " " + arreglo[i];
                i++;
            }
        }
        return "Pila{" +
                "arreglo=" + out +
                '}';
    }
}
