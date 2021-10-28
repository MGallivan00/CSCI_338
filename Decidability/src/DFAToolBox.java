import java.util.*;

/**
 *
 * @author yaw
 */
public class DFAToolBox {

    // A_DFA. Does a given DFA accept a given string?
    public static boolean aDFA(DFA dfa, String w) {
        String currentState = dfa.getStartState();
        for (char character : w.toCharArray()) {
            currentState = dfa.getTransitions().get(currentState).get(character);
        }
        return Arrays.asList(dfa.getAcceptStates()).contains(currentState);
    }

    // E_DFA. Is the language of a given DFA empty?
    public static boolean eDFA(DFA dfa) {
        int size = dfa.getAcceptStates().length;
        if (size != 0) {
            return false;
        } else {
            return true; // no accept states
        }
    }

    // EQ_DFA. Are the languages of two given DFAs identical?
    public static boolean eqDFA(DFA dfa1, DFA dfa2) {
        char[] alphabet = dfa1.getAlphabet();

        String[] state1 = dfa1.getStates();
        String[] state2 = dfa2.getStates();
        String[] accept1 = dfa1.getAcceptStates();
        String[] accept2 = dfa2.getAcceptStates();

        String[] states = new String[state1.length + state2.length];
        String[] acceptStates;
        String startState = dfa1.getStartState() + dfa2.getStartState();
        HashMap<String, HashMap<Character, String>> transitions = new HashMap<>();
        HashMap<Character, String> t = new HashMap<>();

        HashMap<String, HashMap<Character, String>> t1 = dfa1.getTransitions();
        HashMap<String, HashMap<Character, String>> t2 = dfa2.getTransitions();
        for(int i = 0; i < state1.length; i++) {
            for (int k = 0; k < state2.length; k++) {
                for (int j = 0; j < alphabet.length; j++) {
                    //transition
                    String s = t1.get(state1[i]).get(alphabet[j]); //ie. s1, '0', to s1 and s is s1
                    String r = t2.get(state2[k]).get(alphabet[j]);
                    t.put(alphabet[j], s + r);
                }
                transitions.put(state1[i] + state2[k], t);
            }
        }

        for(int i = 0; i < state1.length; i++){
            for(int j = 0; j < state2.length; j++){
                states[i+j] = state1[i] + state2[j];
            }
        }

        List<String> acceptlist = new ArrayList<String>();

        for(int i = 0; i < state1.length; i++) {
            if (!Arrays.asList(accept1).contains(state1[i]) && Arrays.asList(accept2).contains(state1[i])) {
                acceptlist.add(state1[i]);
            }
        }
        for(int i = 0; i < state2.length; i++) {
            if (!Arrays.asList(accept2).contains(state2[i]) && Arrays.asList(accept1).contains(state2[i])) {
                acceptlist.add(state2[i]);
            }
        }

        acceptStates = acceptlist.toArray(new String[0]);

        //this DFA should be (A and B-complement) union (A-complement and B)
        //the complement has opposite accept states
        DFA dfa = new DFA(states, alphabet, transitions, startState, acceptStates);
        return eDFA(dfa);
    }

    // INFINITE_DFA. Is the language of a given DFA infinite in size?
    public static boolean infDFA(DFA dfa) {
        if(eDFA(dfa)){
            return false;
        }
        Random r = new Random();
        char[] alphabet = dfa.getAlphabet();
        StringBuilder w = new StringBuilder();
        // check for loops
        for (int i=0; i < dfa.getStates().length + 2; i++) {
            w.append(alphabet[r.nextInt(2)]);
        }
        String ws = w.toString();
        return aDFA(dfa, ws);

    }

    // ALL_DFA. Does the language of a given DFA include every possible string over its alphabet?
    public static boolean allDFA(DFA dfa) {
        //every state is an accept state
        return Arrays.asList(dfa.getAcceptStates()).containsAll(Arrays.asList(dfa.getStates()));
    }
}