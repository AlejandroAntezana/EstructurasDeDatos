package lineales.estaticas;

public class Cola {

    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;

    public Cola() {
        this.arreglo = new Object[TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object elem) {
        boolean exito;
        if ((this.fin + 1) % TAMANIO == this.frente) {
            //Error de cola llena
            exito = false;
        } else {
            //se agrega el elemento y se aactualiza el final
            this.arreglo[this.fin] = elem;
            this.fin = (this.fin + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }


    public boolean sacar() {
        boolean exito = true;
        if (esVacia()) {
            exito = false;
        } else {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object element;
        if (this.fin == this.frente) {
            //la pila esta vacia
            element = null;
        } else {
            element = this.arreglo[this.frente];
        }
        return element;
    }

    public boolean esVacia() {
        return (frente == 0 && fin == 0);
    }

    public void vaciar() {
        //puedo sobreescribir el arreglo original, copiando uno vacio.
        Object[] vacio = new Object[TAMANIO];
        System.arraycopy(this.arreglo,0,vacio,0, TAMANIO);
        this.frente = 0;
        this.fin = 0;
    }


    public Cola Clone() {
        Cola clon = new Cola();
        System.arraycopy(this.arreglo, 0, clon.arreglo, 0, TAMANIO);
        return clon;
    }


    @Override
    public String toString() {
        String out = "";
        if (this.frente == this.fin) {
            out = "[]";
        } else {
            int i = this.frente;
            out = "[ ";
            while ((i % TAMANIO) != this.fin) {
                if (((i + 1) % TAMANIO) == this.fin) {
                    out += arreglo[i];
                } else {
                    out += arreglo[i] + " , ";
                }
                i++;
            }
            out += " ]";
        }
        return out;
    }
}
