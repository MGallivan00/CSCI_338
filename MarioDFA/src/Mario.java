public class Mario {
    private State stationary;
    private State midAir;
    private State running;
    private State squatting;
    private State crawling;
    private State dead;

    private State currentState;

    public Mario() {
        stationary = new Stationary(this);
        midAir = new MidAir(this);
        running = new Running(this);
        squatting = new Squatting(this);
        crawling = new Crawling(this);
        dead = new Dead(this);
        currentState = stationary;
    }

    public void setState(State s) {
        currentState = s;
    }

    public State getState(String st) {
        switch (st) {
            case "st":
                return stationary;
            case "m":
                return midAir;
            case "r":
                return running;
            case "sq":
                return squatting;
            case "c":
                return crawling;
            case "d":
                return dead;
            default:
                System.out.println("Not a valid state. Remaining the same");
                return currentState;
        }
    }

    public void forward() {
        System.out.println("Run Forwards");
        currentState.forward();
    }

    public void backward() {
        System.out.println("Run Backwards");
        currentState.backward();
    }

    public void jump() {
        System.out.println("Jump");
        currentState.jump();
    }

    public void squat() {
        System.out.println("Squat");
        currentState.squat();
    }
    public void enemyCollision() {
        System.out.println("Collide with Enemy");
        currentState.enemyCollision();
    }
    public void itemCollision() {
        System.out.println("Collect item");
        currentState.itemCollision();
    }
    public void blockCollision() {
        System.out.println("Hit block");
        currentState.blockCollision();
    }

}
