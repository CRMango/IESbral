import java.util.Scanner;
import java.util.Random;
// Benjamin Rast
// V1 19/02/2016
// The main interface, linked to the resources class and the secondary class

public class Interface{

    public static void main(String[]args){
        
        int disasterchance=-10;
        System.out.println("you have an aching head, arm, and leg. you have no idea what happened. you look ");
        System.out.println("around, you see that your are in the matter converter room, the matter converter looks partially");
        System.out.println("broken, it is charging slowly. you have a key card on you, it says that you are Thorburn Dylan Neville,");
        System.out.println("engineer. you should probably start to build. blast door to med bay is locked, ladder to reactor");
        System.out.println("is open. if you want to know what you can do type commands.");

           
        Resources res = new Resources();
        Secondary sec = new Secondary();
        Scanner sc = new Scanner(System.in);
        Random rg = new Random();
        String v = "temp";
        String s = "vr";
        while((Resources.health)>0){
            v = sc.nextLine();
            if(v.equalsIgnoreCase("look around")){
                //link to secondary class for deciding room and needed description
            } else if(v.equalsIgnoreCase("move west")){
                sec.moveToRoom(4);
            } else if(v.equalsIgnoreCase("move north")){
                sec.moveToRoom(1);
            } else if(v.equalsIgnoreCase("move east")){
                sec.moveToRoom(2);
            } else if(v.equalsIgnoreCase("move south")){
                sec.moveToRoom(3);
            } else if(v.equalsIgnoreCase("use")){
                System.out.println("What do you want to use?");
                System.out.println("You have :");
                if(Resources.sPak>0){
                    System.out.println("Stimpaks  ");
                }
                if(Secondary.position==1){
                        System.out.println("The Reactor");
                    }    
                if(Resources.tool==1){
                    
                }
                }
                    s=sc.nextLine();
                    if(s.equalsIgnoreCase("Stimpaks")){
                        res.transaction(10,-1);
                        System.out.println("You feel much better as the painkillers and nanomachines enter your bloodstream.");
                    }
                    if(v.equalsIgnoreCase("The Reactor")){
                        if(Secondary.reactorstatus==1){
                            System.out.println("Fix reactor");
                            Secondary.reactorstatus=0;
                        } else {
                            System.out.println("Use reactor");
                            res.transaction(2,1);
                        
                    
                    }
                }
            } else if(v.equalsIgnoreCase("upgrade")){
                if(Secondary.position==1){
                    if(Resources.energy>Secondary.reactorlevel*5){
                        res.transaction(1,Secondary.reactorlevel*5);
                        Secondary.reactorlevel++;
                    }
                }
                }
            } else if(v.equalsIgnoreCase("check resources")){
                res.check();
                sec.lookAround();
            }
            //start end of turn sequence
            if(Secondary.reactorstatus==0){
                res.transaction(2,Secondary.reactorlevel);
            } else {
                System.out.println("(the reactor isn't working, you don't get any energy this turn.)");
            }
            if(Resources.food>0){
                Resources.food--;
                
            } else {
                res.transaction(1,10);
                System.out.println("You are starving!");
            }
            
            
            
            disasterchance=disasterchance+5;
            if(rg.nextInt(100)>=disasterchance){
                //reactor failure (reactor downgrade), asteroid (lose some resources fixing it)
                sec.disaster(rg.nextInt(2));
            }
            
            
            
            System.out.println("some death message");

        }
        
        
    
   
