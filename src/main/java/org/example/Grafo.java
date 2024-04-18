package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Grafo {
    private int[][] matrizAdj;
    private int numVertices;

    public Grafo(int[][] matrizAdj) {
        this.matrizAdj = matrizAdj;
        this.numVertices = matrizAdj.length;
    }

    public List<String> arestasDoGrafo() {
        List<String> arestas = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdj[i][j] != 0) {
                    arestas.add("(" + i + ", " + j + ")");
                }
            }
        }
        return arestas;
    }

    public String tipoDoGrafo() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdj[i][j] != matrizAdj[j][i]) {
                    return "É um dígrafo";
                }
            }
        }
        return "É um grafo não-direcionado";
    }

    public int[] grauDeCadaVertice() {
        int[] graus = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graus[i] += matrizAdj[i][j];
            }
        }
        return graus;
    }

    public boolean verificarConexo() {
        boolean[] visitados = new boolean[numVertices];
        dfs(0, visitados);
        for (boolean visitado : visitados) {
            if (!visitado) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int vertice, boolean[] visitados) {
        visitados[vertice] = true;
        for (int vizinho = 0; vizinho < numVertices; vizinho++) {
            if (matrizAdj[vertice][vizinho] != 0 && !visitados[vizinho]) {
                dfs(vizinho, visitados);
            }
        }
    }

    public boolean verificarCiclico() {
        boolean[] visitados = new boolean[numVertices];
        for (int vertice = 0; vertice < numVertices; vertice++) {
            if (!visitados[vertice]) {
                if (detectarCiclo(vertice, visitados, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectarCiclo(int vertice, boolean[] visitados, int pai) {
        visitados[vertice] = true;
        for (int vizinho = 0; vizinho < numVertices; vizinho++) {
            if (matrizAdj[vertice][vizinho] != 0) {
                if (!visitados[vizinho]) {
                    if (detectarCiclo(vizinho, visitados, vertice)) {
                        return true;
                    }
                } else if (pai != vizinho) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<Integer, List<Integer>> listaDeAdjacencias() {
        Map<Integer, List<Integer>> listaAdj = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            List<Integer> adjacencias = new ArrayList<>();
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdj[i][j] != 0) {
                    adjacencias.add(j);
                }
            }
            listaAdj.put(i, adjacencias);
        }
        return listaAdj;
    }
}
