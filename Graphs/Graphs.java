package Graphs;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */
import java.util.ArrayList;
import java.lang.StringBuilder;

class AdjacencyListGraph<E extends Comparable<E>> {
	
    ArrayList<Vertex> verticies;

    public AdjacencyListGraph() {
        verticies = new ArrayList<>();
    }

    private class Vertex {
        E data;
        ArrayList<Vertex> adjacentVerticies;

        public Vertex(E data) {
            adjacentVerticies = new ArrayList<>();
            this.data = data;
        }

        public boolean addAdjacentVertex(Vertex to) {
            for (Vertex v: adjacentVerticies) {
                if (v.data.compareTo(to.data) == 0) {
                    return false; 
                }
            }
            return adjacentVerticies.add(to); 
        }

        public boolean removeAdjacentVertex(E to) {
            for (int i = 0; i < adjacentVerticies.size(); i++) {
                if (adjacentVerticies.get(i).data.compareTo(to) == 0) {
                    adjacentVerticies.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean removeEdge(E from, E to) {
        Vertex fromV = null;
        for (Vertex v: verticies) {
            if (from.compareTo(v.data) == 0) {
                fromV = v;
                break;
            }
        }
        if (fromV == null) return false;
        return fromV.removeAdjacentVertex(to);
    }

    public boolean addEdge(E from, E to) {
        Vertex fromV = null, toV = null;
        for (Vertex v: verticies) {
            if (from.compareTo(v.data) == 0) { 
                fromV = v;
            } else if (to.compareTo(v.data) == 0) {
                toV = v;
            }
            if (fromV != null && toV != null) break;
        }
        if (fromV == null) {
            fromV = new Vertex(from);
            verticies.add(fromV);
        }
        if (toV == null) {
            toV = new Vertex(to);
            verticies.add(toV);
        }
        return fromV.addAdjacentVertex(toV);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v: verticies) {
            sb.append("Vertex: ");
            sb.append(v.data);
            sb.append("\n");
            sb.append("Adjacent verticies: ");
            for (Vertex v2: v.adjacentVerticies) {
                sb.append(v2.data);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class Graphs {
	
	public static void main(String args[]) {
		AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        assert graph.addEdge(1, 2);
        assert graph.addEdge(1, 5);
        assert graph.addEdge(2, 5);
	    assert !graph.addEdge(1, 2);
        assert graph.addEdge(2, 3);
        assert graph.addEdge(3, 4);
        assert graph.addEdge(4, 1);
        assert !graph.addEdge(2, 3);
        System.out.println(graph);
    }
	
}
