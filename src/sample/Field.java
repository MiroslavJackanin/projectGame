package sample;

import java.util.Random;

public class Field {
    private Tile[][] tiles;

    //CONSTRUCTOR
    public Field() {
        initField();
    }

    //SETTER & GETTER
    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    //METHOD
    private void initField() {
        tiles = new Tile[4][4];
        for (int i = 0; i<tiles.length; i++){
            for (int j = 0; j<tiles.length; j++){
                tiles[i][j] = new Tile();
            }
        }
    }

    public boolean isWon(){
        int count = 0;
        for (int i = 0; i<tiles.length; i++){
            for (int j = 0; j<tiles.length; j++){
                if(tiles[i][j].isValue())
                    count++;
            }
        }
        return count == 0 || count == 16;
    }

    public void toggleTiles(int index){
        int xcol = index%4;
        int yrow = index/4;

        for (int jrow = 0; jrow<tiles.length; jrow++){
            for (int icol = 0; icol<tiles.length; icol++){
                if (!(xcol == icol && yrow == jrow) && Math.abs(xcol-icol) <= 1 && Math.abs(yrow-jrow) <= 1){
                    tiles[icol][jrow].toggle();
                }
            }
        }
    }

    public void print(){
        for (int j = 0; j<tiles.length; j++){
            for (int i = 0; i<tiles.length; i++){
                System.out.print(tiles[i][j].isValue() ? " X " : " O ");
            }
            System.out.println();
        }
    }

    public void shuffle(){
        Random random = new Random();
        do {
            for (int i = 0; i < 20; i++) {
                toggleTiles(random.nextInt(15));
            }
        }while(isWon());
    }
}
