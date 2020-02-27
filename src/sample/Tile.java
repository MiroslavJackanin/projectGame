package sample;

public class Tile {
    private boolean value;

    //CONSTRUCTOR
    public Tile() {
        this.value = false;
    }

    //GETTER
    public boolean isValue() {
        return value;
    }

    //METHOD
    public void toggle(){
        value = !value;
    }
}
