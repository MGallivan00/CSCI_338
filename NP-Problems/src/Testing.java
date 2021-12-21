import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class Testing {
    public int[][] rando(int n, int max) {
        Dictionary<Integer, HashSet<Integer>> gen = new Hashtable<>();

        for (int i = 0; i < n; i++)
            gen.put(i, new HashSet<>());

        var rand = new Random();

        // connect the nodes
        for (int i = 0; i < n; i++)
            for (int e = 0; e < max; e++) {
                int adjacent = rand.nextInt(n);
                HashSet<Integer> a = gen.get(i);
                a.add(adjacent);
                a = gen.get(adjacent);
                a.add(i);
            }

        // convert to array
        int[][] graph = new int[n][];

        for (int i = 0; i < n; i++) {
            int edge_count = gen.get(i).size();
            graph[i] = new int[edge_count];

            int j = 0;
            for (int edge : gen.get(i))
                graph[i][j++] = edge;
        }
        return graph;
    }

    public int[][] ring(int n) {
        int[][] gen = new int[n][];

        for (int i = 0; i < n; i++)
            gen[i] = new int[2];

        // connect the nodes
        for (int i = 0; i < n; i++)
            for (int e = 0; e < 2; e++) {
                gen[i][0] = i - 1;
                gen[i][1] = i + 1;
            }
        // fix the ends
        gen[0][0] = n - 1;
        gen[n - 1][1] = 0;

        return gen;
    }

    public int[][] star(int n) {
        int[][] gen = new int[n][];

        gen[0] = new int[n - 1];
        for (int i = 1; i < n; i++) {
            gen[i] = new int[1];
            gen[0][i - 1] = i;
            gen[i][0] = 0;
        }
        return gen;
    }

    public void timing(Graph G, int range) {
        try {
            int[][] s = new int[4][];
            long t0, t1, t2, t3, t4;
            BufferedWriter sw = new BufferedWriter(new FileWriter("timing.txt"));
            {
                sw.write("\tVC\tIS\n");
                for (int i = 1; i <= range; i++) {
                    G.replace(rando(i, i / 2));
                    //G.replace(ring(i));
                    //G.replace(star(i));

                    t0 = System.currentTimeMillis();
                    GraphToolBox.exactVC(G);            //s[0] =
                    t1 = System.currentTimeMillis();
                    GraphToolBox.optimalIS(G);          //s[1] =
                    t2 = System.currentTimeMillis();
                    GraphToolBox.inexactVC(G);          //s[2] =
                    t3 = System.currentTimeMillis();
                    GraphToolBox.inexactIS(G);          //s[3] =
                    t4 = System.currentTimeMillis();

//                    int s1 = s[0].length;
//                    int s2 = s[1].length;
//                    int s3 = s[2].length;
//                    int s4 = s[3].length;
                    //System.out.println("Round " + i + ": " + (t2-t1) + "\tVC: " /*+ s1 + "\t" + s3 + "\tIS: " /*+ s2 + "\t" + s4*/);
                    sw.write(i + "\t" + (t1 - t0) + "\t" + (t2 - t1) + "\t" + (t3 - t2) + "\t" + (t4 - t3) + "\n");
                }
            }
            sw.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
