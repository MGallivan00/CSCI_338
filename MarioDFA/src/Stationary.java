public class Stationary implements State {
    private Mario m;

    public Stationary(Mario player) {
        m = player;
    }

    public void forward() {
        m.setState(m.getState("r"));
        System.out.println("Run Forward\n");
    }

    public void backward() {
        m.setState(m.getState("r"));
        System.out.println("Run Backwards\n");
    }

    public void jump() {
        m.setState(m.getState("m"));
        System.out.println("Jump\n");
    }

    public void squat(){
        m.setState(m.getState("sq"));
        System.out.println("Crouch Down\n");
    }

    public void enemyCollision(){
        m.setState(m.getState("d"));
        System.out.println("An enemy hit you and you died :(\n");
    }

    public void itemCollision(){
        //m.setState(m.getState("st")); //state stays the same
        System.out.println("Powered Up!\n");
    }

    public void blockCollision(){
        //m.setState(m.getState("st")); //state stays the same
        System.out.println("You got hit with a block, but they don't move so that's an issue.\n");
    }
}
