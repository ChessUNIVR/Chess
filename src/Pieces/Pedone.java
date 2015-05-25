package Pieces;

/**
 * @author Emil Tomellini Matteo Brentegani
 *
 */
public class Pedone extends Pezzo {

    private boolean firstMove;
	
    /**
     * @param x
     * @param y
     */
	
    public Pedone(int x, int y, Color c, String type) {
	super(x, y, c, type);
        firstMove=true;
    }
    
    public void setFirstMove() {
        firstMove = false;
    }
    public boolean getFirstMove() {
        return firstMove;
    }   
}
