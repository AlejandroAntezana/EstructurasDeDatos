package test.jerarquicas;

import jerarquicas.ArbolBin;

public class TestArbolBin {
    public static void main(String[] args) {
        ArbolBin arbol1 = new ArbolBin();

        arbol1.insertar('A',null,'a');
        arbol1.insertar('B','A','I');
        arbol1.insertar('C','A','D');
        arbol1.insertar('D','B','I');
        arbol1.insertar('E','C','I');
        arbol1.insertar('F','C','D');
        arbol1.insertar('G','E','I');
        arbol1.insertar('H','E','D');

        System.out.println(arbol1.toString());

        System.out.println(arbol1.altura());

        System.out.println(arbol1.nivel('B'));




    }
}
