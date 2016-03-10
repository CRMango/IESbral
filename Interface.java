import java.util.Scanner;
import java.util.Random;
// Benjamin Rast
// V1 19/02/2016
// The main interface, linked to the resources class and the secondary class

public class Interface{

    public static void main(String[]args){
        int x = 0;
        //this is the shuttle status
        int disasterchance=-10;
        System.out.println("you have an aching head, arm, and leg. you have no idea what happened. you look ");
        System.out.println("around, you see that your are in the matter converter room, the matter converter looks partially");
        System.out.println("broken, it is charging slowly. you have a tablet on you, you boot it up. ");
        System.out.println("the tablet asks you if you want to turn on floatdownload©, you do. it tackes you to the log in screen");
        System.out.println("it says that you are Thorburn Dylan Neville,engineer. you log in and learn that you can use this tablet");
        System.out.println("for checking suplies and downloading floatdownload© files. you should be able to get crew logs and");
        System.out.println("blueprints. you should probably start to build. blast door to med bay is locked, ladder to reactor");
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
                sec.lookAround();
            } else if(v.equalsIgnoreCase("move west")){
                sec.moveToRoom(4);
            } else if(v.equalsIgnoreCase("move north")){
                sec.moveToRoom(1);
            } else if(v.equalsIgnoreCase("move east")){
                sec.moveToRoom(2);
            } else if(v.equalsIgnoreCase("move south")){
                sec.moveToRoom(3);
            } else if(v.equalsIgnoreCase("add to shuttle")){
                System.out.println("According to the instruction manual, you need to build a replacement for the ");
                if(x==1){
                    System.out.print("supply system first.");
                } else if(x==3){
                    System.out.print("jump computer next.");
                } else if(x==5){
                    System.out.print("rotational thrusters next.");
                } else if(x==7){
                    System.out.print("cockpit screen next.");
                } else if(x==9){
                    System.out.print("reactor core, and then after you fix the door you can leave this nightmare.");
                } else if(x%2==0){
                    System.out.print("... actually, first you should put the last replacement you made on the shuttle with the wrench.");
                } else if(x%2==1){
                    System.out.println("All the replacements cost 15 jigawatts. Do you want to continue?  y/n");
                    temp = sc.nextLine();
                    if(temp.equalsIgnoreCase("y")){
                        x++;
                        res.transaction(2,-15);
                    } else {
                        
                    }
                }
                
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
                    System.out.println("The ME-32P Wrench. (just type wrench)");
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
                    if(s.equalsIgnoreCase("wrench"){
                        
                        if(sec.position==6){
                            if(x%2==1){
                                if(x==0){
                                System.out.println("You tighten the screws on the engine, you are the first step closer to getting this ship fixed!");
                                } else {
                                 System.out.println("The newly added part gets put on with the wrench, you are one step closer to getting this ship fixed!");
                                 
                                }
                                x++;
                            } else {
                                System.out.println("Unfortunately, the ME32-P Wrench is only the size needed to fix the shuttle in the hanger, and the robotics door.");
                            }
                        }
                    }
                }
             else if(v.equalsIgnoreCase("upgrade")){
                if(Secondary.position==1){
                    if(Resources.energy>Secondary.reactorlevel*5){
                        res.transaction(2,Secondary.reactorlevel*5);
                        Secondary.reactorlevel++;
                    }
                }
                }
             else if(v.equalsIgnoreCase("check situation")){
                res.check();
                sec.lookAround();
             else if(v.equalsIgnoreCase("listen to log")){
                 sec.readLog(sec.Position);
             }
             else if(v.equalsIgnoreCase("generate food")){
                 if(sec.position==5){
                     
                 if(Resources.energy<4){
                     res.transaction(1,-4);
                     res.transaction(11,7);
                     System.out.println("This should last you for a while.");
                 } else {
                     System.out.println("You still need more energy for the generation!");
                 }
                 } else {
                     System.out.println("You need to be in the medbay for this to work.");
                 }
             }
             else if(v.equalsIgnoreCase("help")){
                 System.out.println("The available commands are:");
                 System.out.println("upgrade, use for upgrading the reactor");
                 System.out.println("generate food, use to sustain yourself, used in the med room");
                 System.out.println("check situation, finds your resource total, your log completion, and your wellbeing.");
                 System.out.println("move west / move east / move north / move south");
                 System.out.println("listen to log, only usable for the log in the room you found it in");
                 System.out.println("use, gives you some options such as manning the reactor for a bonus, fixing it, healing and so on.");
                 System.out.println("Try to use this and check situation as sparingly as possible, as the time it takes for the character to read the manual");
                 System.out.println("Or gather his resources takes a full turn!");
                 
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
            if(rg.nextInt(100)<=disasterchance){
                //reactor failure (reactor downgrade), asteroid (lose some resources fixing it)
                sec.disaster(rg.nextInt(3));
            }
        }
            
            
            System.out.println("some death message");

        }
    }
}
        
        
    
   
