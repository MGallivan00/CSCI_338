public class NoQuarter implements State{
    private GumballMachine gm;

    public NoQuarter(GumballMachine m) {
        gm = m;
    }

    public void crank(){
        System.out.println("You need a quarter for anything to happen.\n");
    }
    public void insertQuarter(){
        gm.setState(gm.getState("hq"));
        System.out.println("Money $$\n");
    }
    public void removeQuarter(){
        System.out.println("You can't remove a quarter when there isn't even one there\n");
    }
}
