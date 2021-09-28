public class MidAir implements State {
    private Mario m;

    public MidAir(Mario player) {
        m = player;
    }

    public void forward() {
        m.setState(m.getState("r"));
        System.out.println("You land and run forward\n");
    }

    public void backward() {
        m.setState(m.getState("r"));
        System.out.println("You land and run backwards\n");
    }

    public void jump() {
        //m.setState(m.getState("m"));  //state stays the same
        System.out.println("Double jump!\n");
    }

    public void squat(){
        m.setState(m.getState("st"));
        System.out.println("Ground Pound!\n");
    }

    public void enemyCollision(){
        //m.setState(m.getState("m"));  //state stays the same
        System.out.println("Kill the enemy and bounce back into the air\n");
    }

    public void itemCollision(){
        m.setState(m.getState("st"));
        System.out.println("Land and power up\n");
    }

    public void blockCollision(){
        m.setState(m.getState("st"));
        System.out.println("Collect a coin from a block\n");
    }
}
