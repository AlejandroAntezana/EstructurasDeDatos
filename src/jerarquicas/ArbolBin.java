package jerarquicas;

import lineales.dinamicas.Lista;

public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = true;

        if (this.raiz == null) {
            //si el arbol esta vacio, pone elem Nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            //si arbol no esta vacio, busca el padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);

            //si padre existe y lugar no esta ocupado lo pone, sino da error
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else if (lugar == 'D' && nPadre.getDerecho() == null) {
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        //metodo PRIVADO que busca un elemento y devuelve el nodo que
        //lo contiene. Si no se encuentra buscado devuelve null

        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si el buscado es n lo devuelve
                resultado = n;
            } else {
                //no es el buscado: busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //Si no lo encontro en el izquierdo, lo busca en el HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public String toString() {
        return stringAux(this.raiz);
    }

    private String stringAux(NodoArbol nodo) {
        String stringAux = "";
        NodoArbol izq, der;
        if (nodo != null) {
            izq = nodo.getIzquierdo();
            der = nodo.getDerecho();
            stringAux += nodo.getElem();
            if (izq != null) {
                stringAux += " HI: " + izq.getElem();
            } else {
                stringAux += " HI: - ";
            }
            if (der != null) {
                stringAux += " HD: " + der.getElem();
            } else {
                stringAux += " HD: - ";
            }
            stringAux += "\n";
            stringAux += stringAux(izq);
            stringAux += stringAux(der);
        }
        return stringAux;
    }

    public int altura() {
        int altura;
        if (this.raiz == null) {
            altura = -1;
        } else {
            altura = alturaAux(this.raiz);
        }
        return altura;
    }

    private int alturaAux(NodoArbol nodo) {
        NodoArbol izq, der;
        int altI, altD, alturaMax = 0;

        if (nodo != null) {
            izq = nodo.getIzquierdo();
            der = nodo.getDerecho();
            altI = 0;
            altD = 0;
            if (izq != null) {
                altI += 1;
            }
            if (der != null) {
                altD += 1;
            }
            altI += alturaAux(izq);
            altD += alturaAux(der);
            if (altI >= altD) {
                alturaMax = altI;
            } else {
                alturaMax = altD;
            }
        }
        return alturaMax;
    }

    public int nivel(Object elemento) {
        return nivelAux(this.raiz, elemento, -1);
    }

    private int nivelAux(NodoArbol nodo, Object elementoBuscado, int nivelActual) {
        int nivel = nivelActual;
        if (nodo != null) {
            if (nodo.getElem() == elementoBuscado) {
                nivel=0;
            } else {
                nivel = nivelAux(nodo.getIzquierdo(), elementoBuscado, nivel);
                if (nivelActual == -1) {
                    nivel = nivelAux(nodo.getDerecho(), elementoBuscado, nivel);
                }
            }
        }
        return nivel;
    }

    public Lista listarPreorden() {
        //retorna una lista con los elementos del arbol en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        //Metodo recursivo PRIVADO porque su parametro es de tipo nodoArbol

        if (nodo != null) {
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); //(1)

            //recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzquierdo(), lis); //(2)
            listarPreordenAux(nodo.getDerecho(), lis); //(3)
        }
    }


}
