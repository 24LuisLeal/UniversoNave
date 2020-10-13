package universevol2;

public class Asteroid extends Thing{

    

    public Asteroid() {
    }

    public Asteroid(int x, int y, int vx, int vy) {
        super(x, y, vx, vy);
        this.symbol = 'A';
    }
    
}
