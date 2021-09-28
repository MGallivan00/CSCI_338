public class Empty implements State {
    private GumballMachine gm;

    public Empty(GumballMachine m) {
        gm = m;
    }

    public void crank(){
        System.out.println("There are no gumballs left.\n");
    }
    public void insertQuarter(){
        System.out.println("You've given money but there are no gumballs left.\n");
    }
    public void removeQuarter(){
        System.out.println("You've removed your money, probably because the machine is empty.\n");
    }

    public void refill(){
        gm.numGum = 2;
        gm.setState(gm.getState("nq"));
        System.out.println("The machine has gumballs now!\n");
    }
}
