package repaso;
//EJERCICIO 2, INCISO 2 DE TDA - APUNTE REPASO
public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha (int dia, int mes, int anio){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

    //Observadores
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    //Modificadores

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    //Propios de la clase
    public String toString(Fecha objeto){
       return "Dia: "+objeto.getDia()+" mes: "+objeto.getMes()+" anio: "+objeto.getAnio();
    }

    public boolean equals(Fecha objeto){
        return (this.dia == objeto.dia && this.mes == objeto.mes && this.anio == objeto.anio );
    }


}
