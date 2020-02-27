package sample;

public class Game {
    private Field field;
    private State state;

    public Game() {
        this.field = new Field();
        this.state = State.READY;
    }

    public Field getField() {
        return field;
    }

    public void start(){
        if (state==State.READY) {
            state = State.RUNNING;
        }
        field.shuffle();
    }

    public void reset(){
        if (state != State.READY) {
            state = State.READY;
            this.field = null;
        }
    }

    public void end(){
        if (state == State.RUNNING) {
            state = State.OVER;
            this.field = null;
        }
    }

    public void move(int index){
        if (state == State.RUNNING){
            field.toggleTiles(index);

            if (field.isWon()){
                System.out.println("You won");
                end();
            }
        }
    }
}
