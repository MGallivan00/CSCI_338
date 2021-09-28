public class Driver {
    public static void main(String[] args){
        GumballMachine gm = new GumballMachine();

        gm.crank();
        gm.refill();
        gm.insertQuarter();
        gm.refill();
        gm.crank();
        gm.removeQuarter();
        gm.insertQuarter();
        gm.removeQuarter();
        gm.insertQuarter();
        gm.insertQuarter();
        gm.crank();
        gm.insertQuarter();
        gm.removeQuarter();
        gm.crank();
        gm.refill();
        gm.insertQuarter();
        gm.crank();
    }
}
