package Graphs;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */
public class FloydWarshall {
    
        private int DistanceMatrix[][];
        private int numberofvertices;
        public static final int INFINITY = 999;
        public FloydWarshall(int numberofvertices)
        {
            DistanceMatrix = new int[numberofvertices + 1][numberofvertices + 1];
            Arrays.fill(DistanceMatrix, 0);
            this.numberofvertices = numberofvertices;
        }
        public void floydwarshall(int AdjacencyMatrix[][])
        {
            for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                {
                    DistanceMatrix[source][destination] = AdjacencyMatrix[source][destination];
                }
            }
            for (int intermediate = 1; intermediate <= numberofvertices; intermediate++)
            {
                for (int source = 1; source <= numberofvertices; source++)
                {
                    for (int destination = 1; destination <= numberofvertices; destination++)
                    {
                        if (DistanceMatrix[source][intermediate] + DistanceMatrix[intermediate][destination]
                             < DistanceMatrix[source][destination])
                            DistanceMatrix[source][destination] = DistanceMatrix[source][intermediate] 
                                + DistanceMatrix[intermediate][destination];
                    }
                }
            }
            for (int source = 1; source <= numberofvertices; source++)
                System.out.print("\t" + source);
            System.out.println();
            for (int source = 1; source <= numberofvertices; source++)
            {
                System.out.print(source + "\t");
                for (int destination = 1; destination <= numberofvertices; destination++)
                {
                    System.out.print(DistanceMatrix[source][destination] + "\t");
                }
                System.out.println();
            }
        }
        public static void main(String... arg)
        {
            int Adjacency_Matrix[][];
            int numberofvertices;
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the number of vertices");
            numberofvertices = scan.nextInt();
            Adjacency_Matrix = new int[numberofvertices + 1][numberofvertices + 1];
            System.out.println("Enter the Weighted Matrix for the graph");
            for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                {
                    Adjacency_Matrix[source][destination] = scan.nextInt();
                    if (source == destination)
                    {
                        Adjacency_Matrix[source][destination] = 0;
                        continue;
                    }
                    if (Adjacency_Matrix[source][destination] == 0)
                    {
                        Adjacency_Matrix[source][destination] = INFINITY;
                    }
                }
            }
            System.out.println("The Transitive Closure of the Graph");
            FloydWarshall floydwarshall = new FloydWarshall(numberofvertices);
            floydwarshall.floydwarshall(Adjacency_Matrix);
            scan.close();
        }
    }
