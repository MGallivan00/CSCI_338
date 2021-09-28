public class Squatting implements State {
    private Mario m;

    public Squatting(Mario player) {
        m = player;
    }

    public void forward() {
        m.setState(m.getState("c"));
        System.out.println("Crawl forward\n");
    }

    public void backward() {
        m.setState(m.getState("c"));
        System.out.println("Crawl backwards\n");
    }

    public void jump() {
        m.setState(m.getState("m"));
        System.out.println("Super Jump!\n");
    }

    public void squat(){
        m.setState(m.getState("sq")); //state stays the same
        System.out.println("Keep squatting\n");
    }

    public void enemyCollision(){
        m.setState(m.getState("sq")); //state stays the same
        System.out.println("Way to block the enemy attack\n");
    }

    public void itemCollision(){
        m.setState(m.getState("st"));
        System.out.println("Powered Up\n");
    }

    public void blockCollision(){
        m.setState(m.getState("sq")); //state stays the same
        System.out.println("You hit a block but not with your fist [ISSUE]\n");
    }
}
