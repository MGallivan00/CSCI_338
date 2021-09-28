public class GumballMachine {
    private State nq; //No Quarter
    private State hq; //Has Quarter

    private State currentState;

    public GumballMachine() {
        nq = new NoQuarter(this);
        hq = new HasQuarter(this);
        currentState = nq;
    }

    public void setState(State s) {
        currentState = s;
    }

    public State getState(String st) {
        switch (st) {
            case "nq":
                return nq;
            case "hq":
                return hq;
            default:
                System.out.println("Not a valid state. Remaining the same");
                return currentState;
        }
    }

    public void crank() {
        System.out.println("Turn the Crank!");
        currentState.crank();
    }

    public void insertQuarter() {
        System.out.println("Insert a Quarter");
        currentState.insertQuarter();
    }

    public void removeQuarter() {
        System.out.println("Remove a Quarter");
        currentState.removeQuarter();
    }
}
