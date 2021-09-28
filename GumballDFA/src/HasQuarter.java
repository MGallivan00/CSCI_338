public class HasQuarter implements State{
    private GumballMachine gm;

    public HasQuarter(GumballMachine m) {
        gm = m;
    }

    public void crank(){
        gm.setState(gm.getState("nq"));
        System.out.println("A Gumball!!\n");
    }
    public void insertQuarter(){
        System.out.println("That's too many quarters - One just falls on the floor.\n");
    }
    public void removeQuarter(){
        gm.setState(gm.getState("nq"));
        System.out.println("No Gumball, but you get to keep your money.\n");
    }
}