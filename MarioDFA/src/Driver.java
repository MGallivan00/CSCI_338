public class Driver {
    public static void main(String[] args){
        Mario m = new Mario();

        m.forward();
        m.forward();
        m.backward();
        m.backward();
        m.jump();
        m.jump();
        m.squat();
        m.squat();
        m.forward();
        m.itemCollision();
        m.enemyCollision();
        m.jump();
        m.blockCollision();
        m.jump();
        m.forward();
        m.blockCollision();
        m.jump();
        m.enemyCollision();
        m.backward();
        m.enemyCollision();
        m.jump();
    }
}
