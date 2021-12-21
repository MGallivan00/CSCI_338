import java.util.*;

public class Cover {


    List<node> nodes;
    int k;  // solution size
    public int[] solution = null;

    public Cover(Graph inputGraph) {
        Hashtable<Integer, node> known = new Hashtable<>();

        int[][] graph = inputGraph.getGraph();

        // add all the nodes
        k = graph.length;

        for (int vertex = 0; vertex < k; vertex++) {
            known.put(vertex, new node(vertex));
        }

        // add all the edges to the existing nodes
        for (int vertex = 0; vertex < k; vertex++) {
            int edge_count = graph[vertex].length;
            node n = known.get(vertex);
            for (int e = 0; e < edge_count; e++) {
                node n2 = known.get(graph[vertex][e]);
                n.edges.add(n2);
            }
        }

        nodes = new ArrayList<>(known.values());
        k = nodes.size();
    }

    public void exactVC() {
        // run a "brute force" check of all permutations of the nodes
        // to ensure a correct result
        //
        // if we find a combination that is already larger than the minimum (k) seen,
        // we can stop checking that combination and move on to the net
        k = nodes.size();
        // array for permutation
        node[] current_permutation = new node[nodes.size()];

        // array to flag if an item is in  current selection
        Boolean[] in_selection = new Boolean[nodes.size()];
        Arrays.fill(in_selection, Boolean.FALSE);

        // build the combinations recursively
        permute_VC(in_selection, current_permutation, 0);
    }

    public void optimalIS() {

        // looking for MAX so k starts at 0 increases
        k = 0;

        // sort most least to most
        nodes.sort(new LeastToMostEdges());

        node[] current_permutation = new node[nodes.size()];
        Boolean[] in_selection = new Boolean[nodes.size()];
        Arrays.fill(in_selection, Boolean.FALSE);
        permute_IS(in_selection, current_permutation, 0);
    }

    public void inexactVC() {
        // at most total graph size, goes down from here
        k = nodes.size();

        // sorts nodes with least edges first
        // can speed up the process
        nodes.sort(new LeastToMostEdges());

        // traverse the graph looking for coverage
        List<node> v = new ArrayList<>(nodes);
        int i = 0;
        while (i < v.size()) {
            node n = v.get(i);

            boolean keep = false;
            for (node e : n.edges) {
                if (!v.contains(e)) {
                    ++i;
                    keep = true;
                    break;
                }
            }
            if (!keep)
                v.remove(n);
        }
        set_solution(v);
    }

    public void inexactIS() {
        k = 0;

        // sort most edges to least
        // can help speed up the process
        nodes.sort(new LeastToMostEdges());

        node[] arr = new node[nodes.size()];
        count_independent_set(nodes.toArray(arr));
    }

    void permute_VC(Boolean[] in_selection, node[] current_permutation, int next_position) {
        // See if all of the positions are filled.
        if (next_position == nodes.size()) {
            // new permutation to try VC on
            count_vertex_cover(current_permutation);
            return;
        }

        // Try options for the next permutation.
        for (int i = 0; i < nodes.size(); i++) {
            if (!in_selection[i]) {
                // add to the current permutation.
                in_selection[i] = true;
                current_permutation[next_position] = nodes.get(i);

                // recursively fill the remaining positions.
                permute_VC(in_selection, current_permutation, next_position + 1);

                // remove the item from the current permutation.
                in_selection[i] = false;
            }
        }
    }

    void permute_IS(Boolean[] in_selection, node[] current_permutation, int next_position) {
        // see if all of the positions are filled.
        if (next_position == nodes.size()) {
            // new permutation to try IS on
            count_independent_set(current_permutation);
            return;
        }

        // try options for the next permutation
        for (int i = 0; i < nodes.size(); i++) {
            if (!in_selection[i]) {
                // add to permutation
                in_selection[i] = true;
                current_permutation[next_position] = nodes.get(i);

                // recursively fill remaining pos
                permute_IS(in_selection, current_permutation, next_position + 1);

                // remove item from permutation.
                in_selection[i] = false;
            }
        }
    }

    void count_vertex_cover(node[] permutation) {
        //copy so we can make changes
        Hashtable<Integer, HashSet<Integer>> traverse = new Hashtable<>();
        //for (node n : permutation) {
        for(int i = 0; i < permutation.length; i++){
            node n = permutation[i];
            traverse.put(n.id, new HashSet<>());
            for (node neighbors : n.edges) {
                HashSet<Integer> a = traverse.get(n.id);
                a.add(neighbors.id);
            }
        }

        // traverse the graph looking for coverage
        int covered = 0;
        List<node> pick = new ArrayList<>();
        //for (node n : permutation) {
        for(int i = 0; i < permutation.length; i++){
            node n = permutation[i];
            if (traverse.get(n.id).size() > 0) {
                covered++;
                // we know there is one smaller, so stop checking this one
                if (covered > k) {
                    break;
                }

                pick.add(n);

                for (node e : n.edges) {
                    HashSet<Integer> a = traverse.get(e.id);
                    a.remove(n.id);
                    traverse.get(e.id).remove(n.id);
                }
            }
        }

        // if covered is smallest replace k
        if (covered < k) {
            k = covered;
            set_solution(pick);
        }
    }

    void count_independent_set(node[] permutation) {
        List<node> selected = new ArrayList<>();
        HashSet<Integer> covered = new HashSet<>();

        //for (node next : permutation) {
        for(int i = 0; i < permutation.length; i++){
            node next = permutation[i];
            if (!covered.contains(next.id)) {
                selected.add(next);

                covered.add(next.id);
                for (node e : next.edges) {
                    covered.add(e.id);
                }
            }
        }
        if (selected.size() > k) {
            k = selected.size();
            set_solution(selected);
        }
    }

    void set_solution(List<node> v) {
        solution = new int[v.size()];
        for (int i = 0; i < v.size(); ++i)
            solution[i] = v.get(i).id;
        Arrays.sort(solution); // for aesthetic
    }
}

class LeastToMostEdges implements Comparator<node> {
    public int compare(node a, node b) {
        return b.edges.size() - a.edges.size();
    }
}

class node {
    public int id;
    public HashSet<node> edges = new HashSet<>();

    public node(int i) {
        id = i;
    }
}
