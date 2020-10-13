package universevol2;

public class Thing {
    
    public static int num = 0;
    private int id;
    int x;
    private int y;
    private int vx;
    private int vy;
    protected char symbol;

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Thing() {
        num++;
        id = num;
    }

    public Thing(int x, int y, int vx, int vy) {
        this();
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Thing.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    @Override
    public String toString() {
        return "Thing{" + "id=" + id + ", x=" + x + ", y=" + y 
        + ", vx=" + vx + ", vy=" + vy + '}';
    }
    
    /**
     *Recolar los objetos
     */
    public void relocate(){
        if(this.x<0){
            this.x = this.x+10;
        }
        if(this.y<0){
            this.y = this.y+10;
        }
        if(this.x>9){
            this.x = this.x-10;
        }
        if(this.y>9){
            this.y = this.y-10;
        }
    }
    public void move(){
        this.x = this.x + this.vx;
        this.y = this.y + this.vy;
        relocate();
    }
    /**
     * Saber si dos objetos chocan 
     * @param t
     * @return 
     */
    public boolean isCollision(Thing t){
        return (this.x==t.x && this.y==t.y);
    }
}
