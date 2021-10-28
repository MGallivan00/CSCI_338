import java.util.HashMap;

/**
 *
 * @author yaw
 */
public class Proj2 {

    public static void main(String[] args) {
        String[] states = new String[]{"S1", "S2"};
        char[] alphabet = new char[]{'0', '1'};
        HashMap<String, HashMap<Character, String>> transitions = new HashMap<>(); // state -> (character -> state)

        HashMap<Character, String> s1Transitions = new HashMap<>();
        s1Transitions.put('0', "S2"); // a 0 from S1 goes to S2.
        s1Transitions.put('1', "S1"); // a 1 from S1 stays at S1.
        transitions.put("S1", s1Transitions);

        HashMap<Character, String> s2Transitions = new HashMap<>();
        s2Transitions.put('0', "S1");
        s2Transitions.put('1', "S2");
        transitions.put("S2", s2Transitions);

        String startState = "S1";
        String[] acceptStates = new String[]{"S1"};
        String[] accept = new String[]{};
        String[] acpt = new String[]{"S1", "S2"};

        String[] states2 = new String[]{"T1", "T2"};
        HashMap<String, HashMap<Character, String>> transitions2 = new HashMap<>(); // state -> (character -> state)

        HashMap<Character, String> t1Transitions = new HashMap<>();
        t1Transitions.put('0', "T2"); // a 0 from T1 goes to T2.
        t1Transitions.put('1', "T1"); // a 1 from T1 stays at T1.
        transitions2.put("T1", t1Transitions);

        HashMap<Character, String> t2Transitions = new HashMap<>();
        t2Transitions.put('0', "T1");
        t2Transitions.put('1', "T2");
        transitions2.put("T2", t2Transitions);

        String startState2 = "T1";
        String[] acceptStates2 = new String[]{"T1"};

        DFA dfa = new DFA(states, alphabet, transitions, startState, acceptStates);
        DFA dfa2 = new DFA(states2, alphabet, transitions2, startState2, acceptStates2);
        DFA dfa3 = new DFA(states, alphabet, transitions, startState, acceptStates);
        DFA emptydfa = new DFA(states, alphabet, transitions, startState, accept);
        DFA alldfa = new DFA(states, alphabet, transitions, startState, acpt);

        if (dfa.isValid()) {
            String string = "00110011010";
            System.out.println(string + ": " + DFAToolBox.aDFA(dfa, string));

            string = "0011001101";
            System.out.println(string + ": " + DFAToolBox.aDFA(dfa, string));

            System.out.println("\nDFA (dfa) accepts only the empty string: " + DFAToolBox.eDFA(dfa));
            System.out.println("DFA (emptydfa) accepts only the empty string: " + DFAToolBox.eDFA(emptydfa));
            System.out.println("DFA (alldfa) accepts only the empty string: " + DFAToolBox.eDFA(alldfa));

            System.out.println("\nDFA (dfa) accepts all string: " + DFAToolBox.allDFA(dfa));
            System.out.println("DFA (emptydfa) accepts all string: " + DFAToolBox.allDFA(emptydfa));
            System.out.println("DFA (alldfa) accepts all string: " + DFAToolBox.allDFA(alldfa));

            System.out.println("\nDFA (dfa) is infinite in size: " + DFAToolBox.infDFA(dfa));
            System.out.println("DFA (emptydfa) is infinite in size: " + DFAToolBox.infDFA(emptydfa));
            System.out.println("DFA (alldfa) is infinite in size: " + DFAToolBox.infDFA(alldfa));

            System.out.println("\nDFA L(dfa) equals L(dfa2): " + DFAToolBox.eqDFA(dfa, dfa2));
            System.out.println("DFA L(emptydfa) equals L(dfa): " + DFAToolBox.eqDFA(emptydfa, dfa));
            System.out.println("DFA L(emptydfa) equals L(alldfa): " + DFAToolBox.eqDFA(emptydfa, alldfa));
            System.out.println("DFA L(dfa) equals L(dfa3): " + DFAToolBox.eqDFA(dfa, dfa3));
        }
    }
}