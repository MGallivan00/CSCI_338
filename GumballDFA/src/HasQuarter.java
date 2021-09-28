public class HasQuarter implements State {
    private GumballMachine gm;

    public HasQuarter(GumballMachine m) {
        gm = m;
    }

    public void crank() {
        gm.numGum--;
        System.out.println("A Gumball!!\n");
        if(gm.numGum != 0){
            gm.setState(gm.getState("nq"));
        } else{
            gm.setState(gm.getState("e"));
            System.out.println("The machine is Empty now :(\n");
        }
    }

    public void insertQuarter() {
        System.out.println("That's too many quarters - One just falls on the floor.\n");
    }

    public void removeQuarter() {
        gm.setState(gm.getState("nq"));
        System.out.println("No Gumball, but you get to keep your money.\n");
    }

    public void refill() {
        System.out.println("You can't refill until the machine is empty.\n");
    }
}