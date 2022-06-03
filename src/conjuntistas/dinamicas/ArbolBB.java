package conjuntistas.dinamicas;

public class ArbolBB {
    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

   /* public boolean insertar(Comparable elemento){
        boolean exito = true;
        if(this.raiz==null){
            this.raiz=new NodoABB(elemento, null,null);
        }else{
            exito=insertarAux(this.raiz,elemento);
        }
        return exito;
    }
    private boolean insertarAux(NodoABB nodo, Comparable elemento){
        //precondicion: nodo no es nulo.
        boolean exito = true;

        if((elemento.compareTo(nodo.getElemento()))==0){
            //Reportar error: elemento repetido.
            exito = false;
        } else if(elemento.compareTo(nodo.getElemento())<0) {
            //element es menor que nodo.getElemento()
            //si tiene HI baja a la izquierda, sino agrega elemento
            if(nodo.getIzquierdo()!=null){
                exito=insertarAux(nodo.getIzquierdo(),elemento);
            }else{
                nodo.setIzquierdo(new NodoABB(elemento, null,null));
            }
        }else {
            //elemento es mayor que nodo.getElemento()
            //si tiene HD baja a la derecha, sino agrega elemento
            if(nodo.getDerecho()!=null){
                exito = insertarAux(nodo.getDerecho(), elemento);
            }else{
                nodo.setDerecho(new NodoABB(elemento,null,null));
            }
        }
        return exito;
    }*/


    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento, null, null);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB nodo, Comparable elemento) {
        //precondicion: el nodo pasado por parametro no es nulo.
        boolean exito = true;
        if (nodo != null) {
            if (nodo.getElemento().compareTo(elemento) == 0) {
                exito = false;
            } else {
                NodoABB indice = nodo;
                if (indice.getElemento().compareTo(elemento) > 0) {
                    if (indice.getIzquierdo() != null) {
                        exito = insertarAux(indice.getIzquierdo(), elemento);
                    } else {
                        indice.setIzquierdo(new NodoABB(elemento, null, null));
                    }
                } else {
                    if (indice.getDerecho() != null) {
                        exito = insertarAux(indice.getDerecho(), elemento);
                    } else {
                        indice.setDerecho(new NodoABB(elemento, null, null));
                    }
                }
            }
        }
        return exito;
    }

    public boolean eliminar(Comparable elemento) {
        return eliminarAux(this.raiz, null, elemento);
    }

    private boolean eliminarAux(NodoABB nodo, NodoABB padre, Comparable elemento) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getElemento().compareTo(elemento) == 0) {
                if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                    //el nodo es una hoja / Caso 1
                    if (elemento.compareTo(padre.getElemento()) < 0) {
                        padre.setIzquierdo(null);
                    } else {
                        padre.setDerecho(null);
                    }
                } else if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                    //llamo caso 3
                    nodo.setElemento(nodo.getIzquierdo().getElemento());
                    
                } else {
                    //llamo caso 2
                    if (elemento.compareTo(padre.getElemento()) < 0) {
                        if (nodo.getIzquierdo() != null) {
                            padre.setIzquierdo(nodo.getIzquierdo());
                        } else {
                            padre.setIzquierdo(nodo.getDerecho());
                        }
                    } else {
                        if (nodo.getIzquierdo() != null) {
                            padre.setDerecho(nodo.getIzquierdo());
                        } else {
                            padre.setDerecho(nodo.getDerecho());
                        }
                    }
                }
                exito = true;
            } else {
                if (nodo.getElemento().compareTo(elemento) > 0) {
                    exito = eliminarAux(nodo.getIzquierdo(), nodo, elemento);
                } else {
                    exito = eliminarAux(nodo.getDerecho(), nodo, elemento);
                }
            }

        }
        return exito;
    }

    public boolean pertenece(Comparable elemento) {
        return perteneceAux(this.raiz, elemento);
    }

    private boolean perteneceAux(NodoABB nodo, Comparable elementoBuscado) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getElemento().compareTo(elementoBuscado) == 0) {
                exito = true;
            } else {
                if (nodo.getElemento().compareTo(elementoBuscado) > 0) {
                    if (nodo.getIzquierdo() != null) {
                        exito = perteneceAux(nodo.getIzquierdo(), elementoBuscado);
                    }
                } else {
                    if (nodo.getDerecho() != null) {
                        exito = perteneceAux(nodo.getDerecho(), elementoBuscado);
                    }
                }
            }
        }
        return exito;
    }


    public boolean esVacio() {
        return this.raiz == null;
    }
    //public Lista listar(){}
    //public Lista listarRngos(Comparable elemMinimo, Comparable elemMaximo){}
    //public Comparable minimoElem(){}
    //public Comparable maximoElem(){}

    public String toString() {
        return stringAux(this.raiz);
    }

    private String stringAux(NodoABB nodo) {
        String stringAux = "";
        NodoABB izq, der;
        if (nodo != null) {
            izq = nodo.getIzquierdo();
            der = nodo.getDerecho();
            stringAux += nodo.getElemento();
            if (izq != null) {
                stringAux += " HI: " + izq.getElemento();
            } else {
                stringAux += " HI: - ";
            }
            if (der != null) {
                stringAux += " HD: " + der.getElemento();
            } else {
                stringAux += " HD: - ";
            }
            stringAux += "\n";
            stringAux += stringAux(izq);
            stringAux += stringAux(der);
        }
        return stringAux;
    }


}
