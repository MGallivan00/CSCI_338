public class Crawling implements State {
    private Mario m;

    public Crawling(Mario player) {
        m = player;
    }

    /*This class assumes you are crawling forward
      It does not affect the state machine but it does affect the printout
      Can be fixed with an if statement that either
          looks at a flag marking forward or backward or that
          track the past command
     */
    public void forward() {
        //m.setState(m.getState("c")); //state stays the same
        System.out.println("Continue crawling forward\n");
    }

    public void backward() {
        m.setState(m.getState("sq"));
        System.out.println("Stop crawling\n");
    }

    public void jump() {
        m.setState(m.getState("m"));
        System.out.println("Back Flip!\n");
    }

    public void squat(){
        m.setState(m.getState("sq"));
        System.out.println("Stop crawling\n");
    }

    public void enemyCollision(){
        m.setState(m.getState("sq"));
        System.out.println("Way to block the enemy attack\n");
    }

    public void itemCollision(){
        //m.setState(m.getState("c")); //state stays the same
        System.out.println("Powered Up\n");
    }

    public void blockCollision(){
        m.setState(m.getState("sq"));
        System.out.println("You hit a block but not with your fist [ISSUE]\n");
    }
}
