import java.io.BufferedWriter;
import java.io.FileWriter;

class Proj3 {
    public static void main(String[] args) {
        int[][] s = new int[4][];
        Graph G  = new Graph("graph.txt");
        Graph G1 = new Graph("graph1.txt");
        Graph G2 = new Graph("graph2.txt");
        Graph G3 = new Graph("graph3.txt");
        Graph G4 = new Graph("graph4.txt");

//        run(s, G,"G-output.txt");
//        run(s, G1,"G1-output.txt");
//        run(s, G2,"G2-output.txt");
//        run(s, G3,"G3-output.txt");
//        run(s, G4,"G4-output.txt");

        Testing testing = new Testing();
        testing.timing(G, 100);

    }

    static void run(int[][] s, Graph G, String outFile){
        s[0] = GraphToolBox.exactVC(G);
        s[1] = GraphToolBox.inexactVC(G);
        s[2] = GraphToolBox.optimalIS(G);
        s[3] = GraphToolBox.inexactIS(G);

        for (int i = 0; i < 4; i++) {
            print(s, G, outFile);
        }
    }

    static void print(int[][] s, Graph graph, String outFile) {
        try {
            int[][] g = graph.getGraph();
            BufferedWriter sw = new BufferedWriter(new FileWriter(outFile));
            sw.write("Total Nodes: " + g.length);
            for (int i = 0; i < s.length; i++) {
                switch (i) {
                    case 0:
                        sw.write("\n\nExact Vertex Cover: ");
                        break;
                    case 1:
                        sw.write("\nInexact Vertex Cover: ");
                        break;
                    case 2:
                        sw.write("\nOptimal Independent Set: ");
                        break;
                    case 3:
                        sw.write("\nInexact Independent Set: ");
                        break;
                }
                if (s[i] != null) {
                    sw.write(s[i].length + "\n");
                    for (int j = 0; j < s[i].length; j++) {
                        sw.write(s[i][j] + " ");
                        if(j%25 == 0 && j > 1){
                            sw.write("\n");
                        }
                    }
                }
                sw.write("\n");
            }
            sw.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}