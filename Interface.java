import java.util.Scanner;
// Benjamin Rast
// V1 19/02/2016
// The main interface, linked to the resources class and the secondary class

public class Interface{

    public static void main(String[]args){
        
        
        System.out.println("you have an aching head, arm, and leg. you have no idea what happened. you look ");
        System.out.println("around, you see that your are in the matter converter room, the matter converter looks partially");
        System.out.println("broken, it is charging slowly. you have a key card on you, it says that you are Shawn Marlowe");
        System.out.println("engineer. you should probably start to build. blast door to med bay is locked, ladder to reactor");
        System.out.println("is open. if you want to know what you can do type commands.");

           
        Resources res = new Resources();
        Secondary sec = new Secondary();
        Scanner sc = new Scanner(System.in);
        while((Resources.health)>0){

            if(sc.nextLine()=="look around"){
                //link to secondary class for deciding room and needed description
            } else if(sc.nextLine()=="move west"){
                sec.moveToRoom(4);
            } else if(sc.nextLine()=="move north"){
                sec.moveToRoom(1);
            } else if(sc.nextLine()=="move east"){
                sec.moveToRoom(2);
            } else if(sc.nextLine()=="move south"){
                sec.moveToRoom(3);
            } else if(sc.nextLine()=="use"){

            } else if(sc.nextLine()=="interact"){

            } else if(sc.nextLine()=="upgrade"){

            } else if(sc.nextLine()=="check resources"){
                res.check();
            }
            
            
            
            
            

        }
        
        System.out.println("some death message");   
    
    }





}