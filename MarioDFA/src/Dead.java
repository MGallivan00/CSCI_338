public class Dead implements State {
    private Mario m;

    public Dead(Mario player) {
        m = player;
    }

    //state never changes
    public void forward() {
        //m.setState(m.getState("d"));
        GameOver();
    }

    public void backward() {
        //m.setState(m.getState("d"));
        GameOver();
    }

    public void jump() {
        //m.setState(m.getState("d"));
        GameOver();
    }

    public void squat(){
        //m.setState(m.getState("d"));
        GameOver();
    }

    public void enemyCollision(){
        //m.setState(m.getState("d"));
        GameOver();
    }

    public void itemCollision(){
        //m.setState(m.getState("d"));
        GameOver();
    }

    public void blockCollision(){
        //m.setState(m.getState("d"));
        GameOver();
    }

    private void GameOver(){
        System.out.println("You have already died ... ");
        System.out.println("Game Over\n");
    }
}
