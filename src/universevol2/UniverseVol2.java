package universevol2;

import java.util.Scanner;

public class UniverseVol2 {

    public static Thing [] myThings = new Thing[100];
    
    public static int x = 10, y = 10;
    
    public static char [][] universeCanvas = new char [x][y];
    
    /**
     * Se pinta el universo
     */
    public static void createEmpty(){
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                universeCanvas[j][i] = '.';
            }
        }
    }
    /**
     * Muestra el universo
     */
    public static void show(){
        createEmpty();
        
        int index = 0;
        //Mientras haya cosas en el universo
        while(myThings[index]!=null){
            //para las cosas que estoy agregando
            Thing myThing = myThings[index];
            //agregarla en la foto del universo
            universeCanvas [myThings[index].getX()]
                           [myThings[index].getY()] = myThing.getSymbol();
            //buscar la siguiente cosa
            index++;
        }
        //Imprime los elementos
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(universeCanvas[j][i]+" ");
            }
            System.out.println("");
        }
    }
    /**
     * Crea los aasteroides.
     */
    public static void createAsteroids(){
        for (int i = 0; i < 5; i++) {
            myThings[i] = new Asteroid((int)(Math.random()*x),
                                        (int)(Math.random()*y),
                                        (int)(Math.random()*5)-2,
                                        (int)(Math.random()*5)-2);
            myThings[i].setSymbol((char)(i+49));
        }
    }
    /**
     * Crea los planetas.
     */
    public static void createPlanets(){
        for (int i = 5; i < 7; i++) {
            myThings[i] = new Planet ((int)(Math.random()*x),
                                      (int)(Math.random()*y),0,0);
        }
    }
    /**
     * Crea la nave.
     */
    public static void createShip(){
        myThings[7] = new Ship ((int)(Math.random()*x),
                                (int)(Math.random()*y),0,0);
    }
    /**
     * Se crean los objetos
     */
    public static void create(){
        createAsteroids();
        createPlanets();
        createShip();
    }
    

    /**
     * Mover todas las cosas del universo de acuerdo a su velocidad.
     */
    public static void move(){
        int index = 0;
        //Mientras haya cosas en el universo
        while(myThings[index]!=null){
            //para las cosas que estoy revisando
            Thing myThing = myThings[index];
            //El unvierso mueve las cosas
            myThing.move();
            //buscar la siguiente cosa
            index++;
        }
        
        gameOver();
        
    }
    //Ver video 1:16
    /**
     * Si un asteroide choca con un asteroide se termina el juego
     * Actualmente solo muestra un mensaje si los dos objetos están en la misma 
     * posición
     */
    public static void gameOver(){
        
        //isCollision: Verificar si dos objetos están en la misma posición
        
        if(((Asteroid)myThings[0]).isCollision(myThings[7])){
            System.out.println("El asteroide "+myThings[0]+ 
                    
                    "choco con "+myThings[7]);
            
            
            //Aquí estoy intentando decir que la nave valga "x" que es la 
            //condición que rompe el ciclo en el main
            
        }else if(((Asteroid)myThings[1]).isCollision(myThings[7])){
            System.out.println("El asteroide "+myThings[1]+ 
                    "choco con "+myThings[7]);
            
        }else if(((Asteroid)myThings[2]).isCollision(myThings[7])){
            System.out.println("El asteroide "+myThings[2]+
                    "choco con "+myThings[7]);
            
        }else if(((Asteroid)myThings[3]).isCollision(myThings[7])){
            System.out.println("El asteroide "+myThings[3]+ 
                    "choco con "+myThings[7]);
            
        }else if(((Asteroid)myThings[4]).isCollision(myThings[7])){
            System.out.println("El asteroide "+myThings[4]+
                    "choco con "+myThings[7]);
            
        }
    }

    /**
     * Pregunta al jugador si quiere disparar
     * Sigue en proceso este método
     */
    public static void askToShoot(){
        String shoot;//Opción Si o No para disparar
        Scanner sc = new Scanner(System.in);
        System.out.print("SHOOT? (Y/N)");
        shoot= sc.next();
        
        if("Y".equals(shoot)){
            System.out.println("BOOM!");
        }else if("N".equals(shoot)){
            System.out.println("Ok. Continue.");
        }else{
            System.out.println("End Game.");
        }
        
    }
    
    public static void positions(){
        for (int i = 0; i < 8; i++) {
            System.out.println(myThings[i]);
        }
    }
    public static void main(String[] args) {
        create();
        show();

        //Juego
        String option = "x";
        
        do{
            Scanner sc = new Scanner (System.in);
            System.out.print(">");
            option = sc.next();
            if(option.charAt(0)=='w'||
               option.charAt(0)=='a'||
               option.charAt(0)=='s'||
               option.charAt(0)=='d'){
                
                ((Ship)myThings[7]).move(option.charAt(0));
                //Mueve los objetos del universo.
                move();
                ((Ship)myThings[7]).stop();
                //Muestra el universo cambiante.
                show();
                positions();
            }
            //askToShoot();
        }while(!"x".equals(option));
    }
    
}
