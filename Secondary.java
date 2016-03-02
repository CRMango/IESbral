
/**
 * Write a description of class Secondary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Secondary
{
   static int position;
   int crqrUn;
   int ctrlUn; 
   int mdbyUn;
   int shbyUn;
   int rbtcUn;
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
                crqr=2; //set to 2 so no more intro look around
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
               if(crqr!=0){
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
        System.out.println("charging slowly. The blast door to med bay is locked, and the ladder to reactor is open");
    } else if(position==1){
        
    } else if(position==2){
        
    } else if(position==3){
        
    } else if(position==4){
        
    } else if(position==5){
        
    } else if(position==6){
        
    }
    
    
    
    
}
public void disaster(int b){
    if(b==1){ //reactor failure
    Interface.reactorlevel--;
    }
    if(b==2){
       
    
    }
    }
    }
