public class Running implements State {
    private Mario m;

    public Running(Mario player) {
        m = player;
    }

    /*This class assumes you are running forward
      It does not affect the state machine but it does affect the printout
      Can be fixed with an if statement that either
          looks at a flag marking forward or backward or that
          track the past command
     */
    public void forward() {
        //m.setState(m.getState("r")); //state stays the same
        System.out.println("Continue running forwards\n");
    }

    public void backward() {
        m.setState(m.getState("st"));
        System.out.println("Stopped running\n");
    }

    public void jump() {
        m.setState(m.getState("m"));
        System.out.println("Jump\n");
    }

    public void squat(){
        m.setState(m.getState("c"));
        System.out.println("Crouch Down and continue crawling forwards\n");
    }

    public void enemyCollision(){
        m.setState(m.getState("d"));
        System.out.println("You ran into an enemy and died :(\n");
    }

    public void itemCollision(){
        //m.setState(m.getState("r")); //state stays the same
        System.out.println("Powered Up!\n");
    }

    public void blockCollision(){
        m.setState(m.getState("st"));
        System.out.println("You hit a block but not with your fist [ISSUE]\n");
    }
}
