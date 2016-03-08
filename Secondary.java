
/**
 * Write a description of class Secondary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Secondary{

   static int position;
   int crqrUn;
   int ctrlUn; 
   int mdbyUn;
   int shbyUn;
   int rbtcUn;
   int engFrst=1;
  static int reactorlevel=1;
        static int reactorstatus=0;
   /* matter to energy (0) links to reactor room north, med bay east
    * reactor room (1) links to matter to energy south, shuttle bay east
    * crew quarters (2) links to shuttle bay south, control room north
    * robotics room (3) links to med bay north
    * control room (4) links to crew quarters south
    * med bay (5) links to matter to energy room west, shuttle bay north, robot room south
    * shuttlebay (6) links to reactor room west, crew quarters north, med bay south
    */

   public Secondary(){
       
       position = 0;
       crqrUn=0;
       ctrlUn=0;
       shbyUn=0;
       rbtcUn=0;
       mdbyUn=0;
    }
   public void unlockRoom(int i){
       if(i==0){
           crqrUn=1;
           
           
        } else if(i==1) {
            ctrlUn=1;
            
        } else if(i==2) {
            shbyUn=1;
        } else if(i==3) {
            rbtcUn=1;
        } else {
            mdbyUn=1;
        }
        
    }
   public void moveToRoom(int drctn){
        if(drctn==1){
           if(position==0){
               position=1;
            } else if(position==2){
               if(ctrlUn!=0){
                position=4;
                ctrlUn=2;
               }
            } else if(position==3){
               if(mdbyUn!=0){
                mdbyUn=2;
                position=5;
               }
            } else if(position==5){
               if(shbyUn!=0){
                position=6;
                shbyUn=2;
               }
            } else if(position==6){
               if(crqrUn!=0){
                position=2;
                crqrUn=2; //set to 2 so no more intro look around
               }
            } else {
                System.out.println("You can't go that way.");
        }
       //north
        if(drctn==2){
           if(position==0){
              if(mdbyUn!=0){
               mdbyUn=2;
               position=5;
              }
            } else if(position==1){
               if(shbyUn!=0){
                position=6;
                shbyUn=2;
               }
            } else {
                System.out.println("You can't go that way.");
            }
        }
        //east
        if(drctn==3){
           if(position==1){
               position=0;
            } else if(position==2){
               if(shbyUn!=0){
                position=6;
                shbyUn=2;
               }
            } else if(position==4){
               if(crqrUn!=0){
                crqrUn=2;
                position=2;
               }
            } else if(position==6){
               if(mdbyUn!=0){
                position=5;
                mdbyUn=2;
               }
            } else if(position==5){
               if(rbtcUn!=0){
                position=3;
                rbtcUn=2;
               }
            }
        }
        //south
        if(drctn==4){
           if(position==5){
               position=0;
            } else if(position==6){
               position=1;
            } else {
                System.out.println("You can't go that way.");
            }
        }
        //west
}
}
public void lookAround(){
    if(position==0){
        System.out.println("You are in the matter converter room, the matter converter looks partially broken, and it is ");
        System.out.println("charging slowly. The blast door to the east leading to the med bay is locked, and the north ladder to the reactor is open.");
    } else if(position==1){
       if(reactorstatus==1){
          if(engFrst==1){
             System.out.println("the reactor is partially destroyed. the blast door to the hanger is locked. you find 10 scrap and crew report #4.");
       } else {
          
          
       }
        
          
       }
          
       } else if(position==2){
        if(crqrUn==1){
           System.out.println("you enter the place where you and the rest of the crew use to live, all 9 of you,");
           System.out.println("or was it 10, no it was 10 you're sure now. you search all of the rooms and find the");
           System.out.println("me 32p wrench.you also find logs: ///");
        }
    } else if(position==3){
        if(rbtcUn==1){
           System.out.println("strangely there are no bodies here, but a lot of blood. there are signs of an explosion you activate the room. you have (robot number) amount");
           System.out.println("of robots. they are collecting scrap at (scrap rate) per turn. you find 12 scrap, you find crew log");
        } else {
           System.out.println("you have "+ Resources.robots " amount of robots. they are collecting scrap at "+Resources.robots*10"per turn.");
        }
    } else if(position==4){
        System.out.println("you enter the control room, it is actually pristeen. no bodies, no blood, it creeps you out. you see the main computer, the cerebral cortex as it’s called");
        System.out.println(", it has a 512 bit 20 core processor that runs at 3 terahertz with 2 petabytes of ram 3 yottabyte of storage and a gtx 96016 graphics card. surprisingly the computer is very small,");
        System.out.println(" the problem is the computer runs at 1700 c and can melt titanium, it uses the it uses the body of the space station and the huge point on the top of the space station as a heat sink. you reboot the computer");
        System.out.println("and change to green alert. if you have repaired the robot bay door the room is open now. ");
    } else if(position==5){
        if(mdbyUn==1){
           
           System.out.println("the med bay looks quite intact, the only problem is all of the blood everywhere, and the bodies disfigured beyond recognition, but i ");
        System.out.println("guess that is similar to the rest of the ship. you can heal here, you can build stimpacks here, you find crew message T&T and 10 scrap.");
           
        } else {
           System.out.println("the med bay looks intact, basicly prestine. all machines work.");
        }
    } else if(position==6){
        if(shbyUn==1){
           System.out.println("you walk into the shuttle bay, there is 1 husk of a cargo shuttle, there is a shuttle modification and repairing machine (SMRM) it looks relatively intact ");
           System.out.println("but the matter to energy catalyst has been broken. the bodies in this part of the ship are wearing federation army uniforms.")
         System.out.println("if you repair the ship you may be able to leave. you find crew report T, you find 1 medium part and 5 large parts.");
           
        } else {
           System.out.println("there is the cargo shuttle here. you can modify the shuttle using the SMRM.");
        }
    }
    
    
    
    
}
public void disaster(int b){
    if(b==1){ //reactor failure
        reactorlevel--;
    }
    if(b==2){
       
    
    }
