package Pieces;

/**
 * @author Emil Tomellini Matteo Brentegani
 *
 */
public class Re extends Pezzo {

/**
 * @param x
 * @param y
 */

    private boolean scacco;
	
    public Re(int x, int y, Color c, String type) {
	super(x, y, c, type);
	scacco = false;
	// TODO Auto-generated constructor stub
    }
    
    public void setScacco() {
        if (scacco)
            scacco = false;
        else
            scacco = true;
    }
    
    public boolean getScacco() {
        return scacco;
    }
}

