/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author yaw
 */
public class GraphToolBox {

    final public static int tooBig = 10;

    // return an array containing the vertex numbers of an optimal VC.
    public static int[] exactVC(Graph inputGraph) {
        Cover c = new Cover(inputGraph);
        if(c.nodes.size() < tooBig) {
            c.exactVC();
        }
        return c.solution;
    }

    // return (in polynomial time) an array containing the vertex numbers of a VC.
    public static int[] inexactVC(Graph inputGraph) {
        Cover c = new Cover(inputGraph);
        c.inexactVC();
        return c.solution;
    }

    // return an array containing the vertex numbers of an optimal IS.
    public static int[] optimalIS(Graph inputGraph) {
        Cover c = new Cover(inputGraph);
        if(c.nodes.size() < tooBig) {
            c.optimalIS();
        }
        return c.solution;
    }

    // return (in polynomial time) an array containing the vertex numbers of a IS.
    public static int[] inexactIS(Graph inputGraph) {
        Cover c = new Cover(inputGraph);
        c.inexactIS();
        return c.solution;
    }
}