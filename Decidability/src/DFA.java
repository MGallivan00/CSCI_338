import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author yaw
 */
public class DFA {
    private String[] states;
    private char[] alphabet;
    private HashMap<String, HashMap<Character, String>> transitions;   //state -> (character -> state)
    private String startState;
    private String[] acceptStates;

    public DFA(String[] states, char[] alphabet, HashMap<String, HashMap<Character, String>> transitions, String startState, String[] acceptStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.startState = startState;
        this.acceptStates = acceptStates;
    }

    public boolean isValid() {
        if (!Arrays.asList(states).contains(startState)) {
            System.out.println("Invalid start state.");
            return false;
        }

        if (!Arrays.asList(states).containsAll(Arrays.asList(acceptStates))) {
            System.out.println("Invalid accept state(s).");
            return false;
        }

        for (String state : states) {
            HashMap<Character, String> stateTransitions = transitions.get(state);
            for (char character: alphabet) {
                if (!stateTransitions.containsKey(character)) {
                    System.out.println("Invalid transition: " + state + " does not handle " + character + ".");
                    return false;
                }

                if (!Arrays.asList(states).contains(stateTransitions.get(character))) {
                    System.out.println("Invalid transition: " + stateTransitions.get(character) + " does not exist.");
                    return false;
                }

                if (stateTransitions.keySet().size() > alphabet.length) {
                    System.out.println("Invalid transition: More transition symbols than alphabet characters.");
                    return false;
                }
            }
        }

        if (transitions.keySet().size() > states.length) {
            System.out.println("Invalid transition: More transition states than declared states.");
            return false;
        }

        return true;
    }

    public String[] getStates() {
        return states;
    }

    public char[] getAlphabet() {
        return alphabet;
    }
    public HashMap<String, HashMap<Character, String>> getTransitions() {
        return transitions;
    }

    public String getStartState() {
        return startState;
    }

    public String[] getAcceptStates() {
        return acceptStates;
    }
}