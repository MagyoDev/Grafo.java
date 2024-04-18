package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] matrizAdj = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };

        Grafo grafo = new Grafo(matrizAdj);
        System.out.println("a) Arestas do grafo: " + grafo.arestasDoGrafo());
        System.out.println("b) " + grafo.tipoDoGrafo());
        System.out.println("c) Grau de cada vértice: " + java.util.Arrays.toString(grafo.grauDeCadaVertice()));
        System.out.println("d) " + (grafo.verificarConexo() ? "O grafo é conexo" : "O grafo é desconexo"));
        System.out.println("e) " + (grafo.verificarCiclico() ? "O grafo é cíclico" : "O grafo é acíclico"));
        System.out.println("f) Lista de adjacências do grafo: " + grafo.listaDeAdjacencias());
    }
}