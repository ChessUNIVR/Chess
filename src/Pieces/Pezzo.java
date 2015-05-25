package Pieces;

/**
 * @author Emil Tomellini Matteo Brentegani
 *
 */
public abstract class Pezzo {

    private int x;
    private int y;
    private Color color;
    private String type;
	
    public Pezzo(int x, int y, Color c, String type) {
    	this.x = x;
    	this.y = y;
	color = c;
        this.type = type;
    }	
    
    public Pezzo() { }
    
    public String getType() {
        return type;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Color getColor() {
        return color;
    }
}
