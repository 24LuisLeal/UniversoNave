package universevol2;

public class Ship extends Thing {

    public Ship() {
    }

    public Ship(int x, int y, int vx, int vy) {
        super(x, y, vx, vy);
        this.symbol = 'S';
    }
    public void move(char option){
        switch(option){
            case 'w':
                this.setVy(-1);
                break;
                
            case 'a':
                this.setVx(-1);
                break;
                
            case 's':
                this.setVy(1);
                break;
                
            case 'd':
                this.setVx(1);
                break;       
        }
    }
    /**
     * Detiene la velocidad de la nave.
     * Fun fact: si no se usa este método la nave empieza a ir en diagonal 
     * después de 10 movimientos
     */
    public void stop(){
        this.setVx(0);
        this.setVy(0);
    }
    public void shoot(){
        
    }
    @Override
    public boolean isCollision(Thing t){
        return (this.getX()==t.getX() && this.getY()==t.getY()); 
    }
}

