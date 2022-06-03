package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Nodo;

public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elementoNuevo, Object elementoPadre) {
        boolean exito = true;

        if (this.raiz == null) {
            //caso en el que el arbol esta vacio
            this.raiz = new NodoGen(elementoNuevo, null, null);
        } else {
            //caso en el que el arbol no esta vacio. Busca el padre
            NodoGen nPadre = obtenerNodo(this.raiz, elementoPadre);
            if (nPadre != null) {
                NodoGen nuevo = new NodoGen(elementoNuevo, null, null);
                NodoGen hi = nPadre.getHijoIzquierdo();
                if (hi == null) {
                    nPadre.setHijoIzquierdo(nuevo);
                } else {
                    while (hi.getHermanoDerecho() != null) {
                        hi = hi.getHermanoDerecho();
                    }
                    hi.setHermanoDerecho(nuevo);
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoGen obtenerNodo(NodoGen nodo, Object buscado) {
        NodoGen resultado = null;
        if (nodo != null) {
            if (nodo.getElemento().equals(buscado)) {
                resultado = nodo;
            } else {
                resultado = obtenerNodo(nodo.getHijoIzquierdo(), buscado);
                if (resultado == null) {
                    resultado = obtenerNodo(nodo.getHermanoDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean pertenece(Object elemento) {
        boolean exito = false;
        NodoGen aux = obtenerNodo(this.raiz, elemento);
        if (aux != null) {
            exito = true;
        }
        return exito;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Object padre(Object elemento) {
        //devuelve el elemeto del nodo padre del elemento ingresado
        Object elementoBuscado;
        elementoBuscado = padreAux(elemento, this.raiz);
        return elementoBuscado;
    }

    private Object padreAux(Object elem, NodoGen nodoActual) {
        Object elementoPadre = null;
        if (nodoActual != null) {
            NodoGen nodoSiguiente = nodoActual.getHijoIzquierdo();
            while (nodoSiguiente != null && !nodoSiguiente.getElemento().equals(elem)) {
                nodoSiguiente = nodoSiguiente.getHermanoDerecho();
            }
            if (nodoSiguiente != null) {
                elementoPadre = nodoActual.getElemento();
            } else {
                elementoPadre = padreAux(elem, nodoActual.getHijoIzquierdo());
                if (elementoPadre == null) {
                    elementoPadre = padreAux(elem, nodoActual.getHermanoDerecho());
                }
            }
        }
        return elementoPadre;
    }

    /*public int altura() {

    }*/

    private int alturaAux(NodoGen nodo) {
        int alturaHijoI, alturaHermanoD, alturaMax = 0;

        if (nodo != null) {
            alturaHermanoD = 0;
            alturaHijoI = 0;
            NodoGen hijo = nodo.getHijoIzquierdo();


        }
        return alturaMax;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public Lista listarPreorden() {
        Lista salida = new Lista();
        listarPreordenAux(this.raiz, salida);
        return salida;
    }

    private void listarPreordenAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            //visita del nodo
            lista.insertar(nodo.getElemento(), lista.longitud() + 1);
            //llamados recursivos con los otros hijos de n
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                listarPreordenAux(hijo, lista);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarInorden() {
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
    }

    private void listarInordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            //llamado recursivo con el primer hijo de n.
            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }
            //visita del nodo n
            ls.insertar(n.getElemento(), ls.longitud() + 1);
            //llamados recursivos con los otros hijos de n
            if (n.getHermanoDerecho() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            //visita del nodo n
            s += n.getElemento().toString() + "-> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElemento().toString() + " | ";
                hijo = hijo.getHermanoDerecho();
            }
            //
            //
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }

    public boolean sonFrontera(Lista unaLista) {
        boolean exito;
        if (unaLista.esVacia() || this.esVacio()) {
            exito = false;
        } else {
            exito = sonFronteraAux(this.raiz, unaLista);
        }
        return exito;
    }

    private boolean sonFronteraAux(NodoGen nodo, Lista unaLista) {
        boolean exito = false;
        if (!unaLista.esVacia()) {
            if (nodo != null) {
                if (nodo.getHijoIzquierdo() != null) {
                    NodoGen siguiente = nodo.getHijoIzquierdo();
                    while (siguiente != null) {
                        sonFronteraAux(siguiente, unaLista);
                        siguiente = siguiente.getHermanoDerecho();
                    }
                } else {
                    int pos = unaLista.localizar(nodo.getElemento());
                    if (pos != -1) {
                        unaLista.eliminar(pos);
                    }
                }
            }
        }
        if (unaLista.esVacia()) {
            exito = true;
        }
        return exito;
    }

}
