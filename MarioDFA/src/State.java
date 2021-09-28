public interface State {
    public void forward();
    public void backward();
    public void jump();
    public void squat();

    public void enemyCollision();
    public void itemCollision();
    public void blockCollision();

    //public void Midair();
    //public void Running();
    //public void PoweredUp();
    //public void Dead();
}
