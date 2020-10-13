package universevol2;

public class Planet extends Thing {

    public Planet() {
    }

    public Planet(int x, int y, int vx, int vy) {
        super(x, y, vx, vy);
        this.symbol = 'P';
    }
    
}
