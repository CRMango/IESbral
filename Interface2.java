import java.util.Scanner;
/**
 * Write a description of class Interface2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Interface2
{
    public static void main(String[]args){
       int health,food,energy,sP,mP,lP,sB,mB,lB,sPak,scrap,tool,robots;
       int logs;
       int position=0;
       int crqrUn=0;
       int ctrlUn=0;
       int mdbyUn=0;
       int shbyUn=0;
       int rbtcUn=0;
       int engFirst=1;
       int progress=0;
        /* matter to energy (0) links to reactor room north, med bay east
           * reactor room (1) links to matter to energy south, shuttle bay east
             * crew quarters (2) links to shuttle bay south, control room north
               * robotics room (3) links to med bay north
                 * control room (4) links to crew quarters south
                   * med bay (5) links to matter to energy room west, shuttle bay north, robot room south
                     * shuttlebay (6) links to reactor room west, crew quarters north, med bay south
                       */

      health=100;
        energy=1;
        sP=0;mP=0;lP=0;sB=0;mB=0;lB=0;sPak=1;scrap=0;
        logs=0;
        tool=0;
        food=20;
        robots=0;
        int reactorlevel=1;
        int reactorstatus=1;
        int temp2=0;
        Scanner sc = new Scanner(System.in);
        int type=1;
        //USE TYPE TO DECIDE WHICH ACTIONS REQUIRE A TURN PASS OR NOT.
        System.out.println("you have an aching head, arm, and leg. you have no idea what happened. you look ");
           System.out.println("around, you see that your are in the matter converter room, the matter converter looks partially");
           System.out.println("broken, it is charging slowly. you have a tablet on you, you boot it up. ");
           System.out.println("the tablet asks you if you want to turn on floatdownload©, you do. it tackes you to the log in screen");
           System.out.println("it says that you are Thorburn Dylan Neville,engineer. you log in and learn that you can use this tablet");
           System.out.println("for checking suplies and downloading floatdownload© files. you should be able to get crew logs and");
           System.out.println("blueprints. you should probably start to build. blast door to med bay is locked, ladder to reactor");
           System.out.println("is open. if you want to know what you can do by typing commands, enter 'help'.");
        while(health>0){
            //START THIS STUFF UP
            
            
           
           while(type==1){
               type=0;
           if(sc.nextLine().equalsIgnoreCase("help")){
               System.out.println("The available commands are:");
                 System.out.println("upgrade, use for upgrading the reactor");
                 System.out.println("generate food, use to sustain yourself, used in the med room");
                 System.out.println("check situation, finds your resource total, your log completion, and your wellbeing.");
                 System.out.println("move west / move east / move north / move south");
                 System.out.println("listen to log, only usable for the log in the room you found it in");
                 System.out.println("use, gives you some options such as manning the reactor for a bonus, fixing it, healing and so on.");
                 System.out.println("Try to use this and check situation as sparingly as possible, as the time it takes for the character to read the manual");
                 System.out.println("or gather his resources takes a full turn!");
            }
           if(sc.nextLine().equalsIgnoreCase("look around")){
               if(position==0){
                   
                } else if(position==1){
                     System.out.println("the reactor is partially destroyed. the blast door to the hanger is locked. you find 10 scrap and crew report #4.");
                } else if(position==2){
                    
                } else if(position==3){
                    System.out.println("you have "+ robots + " amount of robots. they are collecting scrap at "+robots*10 + " per turn.");
                } else if(position==4){
                    
                } else if(position==5){
                    System.out.println("the med bay looks intact, basicly prestine. all machines work.");
                } else if(position==6){
                    System.out.println("there is the cargo shuttle here. you can modify the shuttle using the SMRM.");
                } else {
                    System.out.println("Where are you? (no room past #6)");
                    
                }
                    type=1;
            }
           if(sc.nextLine().equalsIgnoreCase("move")){
               if(position==0){
                   System.out.println("You can go to the Medical bay (e), or the Reactor Room (n) from here.");
                   
                   if(sc.nextLine().equalsIgnoreCase("n")){
                       position=1;
                       if(engFirst==1){
                          engFirst=0;
                          System.out.println("the reactor is partially destroyed. the blast door to the hanger is locked. you find 10 scrap and  crew report #1.");
                          scrap=scrap+10;
                        } 
                    } else if(sc.nextLine().equalsIgnoreCase("e")){
                        if(mdbyUn==0){
                            System.out.println("The door is broken, but you can fix it for 20 small parts and 3 small batteries.");
                            if(sP>19){
                                if(sB>2){
                                    System.out.println("You seem to have the required materials. Do you decide to fix the door? y/n");
                                    
                                    while(temp2==0){
                                    if(sc.nextLine().equalsIgnoreCase("y")){
                                        sB=sB-3;
                                        sP=sP-20;
                                        mdbyUn++;
                                        temp2++;
                                    } else if(sc.nextLine().equalsIgnoreCase("n")){
                                        System.out.println("You decide not to fix the door.");
                                        temp2++;
                                        type=1;
                                    } else {
                                        System.out.println("Please use y or n to answer.");
                                        type=1;
                                    }
                                }
                                temp2=0;
                            }
                            }
                        } else if(mdbyUn==1){
                            position=5;
                            mdbyUn=2;
                        } else if(mdbyUn==2){
                            position=5;
                        }
                    } else {
                        System.out.println("What? use e or n for moving from here.");
                        type=1;
                    }
                } else if(position==1){
                    System.out.println("You can go to the matter to energy converter (s), or the shuttle bay (e).");
                    
                    
                        if(sc.nextLine().equalsIgnoreCase("s")){
                            position=0;
                        } else if(sc.nextLine().equalsIgnoreCase("e")){
                            if(shbyUn==0){
                                System.out.println("The door is broken, but you can fix it for 15 medium parts and 4 medium batteries.");
                            if(mP>14){
                                if(mB>3){
                                    System.out.println("You seem to have the required materials. Do you decide to fix the door? y/n");
                                    
                                    while(temp2==0){
                                    if(sc.nextLine().equalsIgnoreCase("y")){
                                        sB=mB-4;
                                        sP=mP-14;
                                        shbyUn++;
                                        temp2++;
                                    } else if(sc.nextLine().equalsIgnoreCase("n")){
                                        System.out.println("You decide not to fix the door.");
                                        temp2++;
                                        type=1;
                                    } else {
                                        System.out.println("Please use y or n to answer.");
                                        type=1;
                                    }
                                }
                                temp2=0;
                            }
                        }
                           } else if(mdbyUn==1){
                                mdbyUn=2;
                                position=5;
                                System.out.println("the med bay looks quite intact, the only problem is all of the blood everywhere, and the bodies disfigured beyond recognition, but i ");
                            System.out.println("guess that is similar to the rest of the ship. you can heal here, you can build stimpacks here, you find crew message T&T and 10 scrap.");
                            } else if(mdbyUn==2){
                                position=5;
                            }
                        } else {
                            System.out.println("What? You have to use s or e to move from here.");
                            type=1;
                        }
                        
                   
                } else if(position==2){
                    System.out.println("You can move to the shuttle bay (s), or the control room (n).");
                    
                    if(sc.nextLine().equalsIgnoreCase("s")){
                        position=6;
                    }else if(sc.nextLine().equalsIgnoreCase("n")){
                        if(ctrlUn==0){
                            System.out.println("The door is broken, but you will be able to fix it for 5 energy and 2 medium batteries.");
                            if(energy>4){
                                if(mB>1){
                                    System.out.println("You have the required materials to fix the door. will you? y/n");
                                    
                                    if(sc.nextLine().equalsIgnoreCase("y")){
                                        energy=energy-5;
                                        mB=mB-2;
                                        crqrUn++;
                                        System.out.println("You've unlocked this door! You are now able to go into the control room.");
                                    } else if(sc.nextLine().equalsIgnoreCase("n")){
                                        type=1;
                                        System.out.println("You decide not to fix the door at the time.");
                                    } else {
                                        System.out.println("You will need to use y or n for your answers.");
                                        type=1;
                                    }
                                } else {
                                    type=1;
                                }
                            } else {
                                type=1;
                            }
                        } else if(ctrlUn==1){
                            position=4;
                            ctrlUn=2;
                            System.out.println("you enter the control room, it is actually pristeen. no bodies, no blood, it creeps you out. you see the main computer, the cerebral cortex as it’s called");
                           System.out.println(", it has a 512 bit 20 core processor that runs at 3 terahertz with 2 petabytes of ram 3 yottabyte of storage and a gtx 96016 graphics card. surprisingly the computer is very small,");
                            System.out.println(" the problem is the computer runs at 1700 c and can melt titanium, it uses the it uses the body of the space station and the huge point on the top of the space station as a heat sink. you reboot the computer");
                           System.out.println("and change to green alert. if you have repaired the robot bay door the room is open now. ");
                        } else if(ctrlUn==2){
                            position=4;
                        }
                    } else {
                        System.out.println("What? use s or n for moving from here.");
                        type=1;
                    }
                    
                } else if(position==3){
                    System.out.println("You can move to the medbay (n) from here.");
                   
                    if(sc.nextLine().equalsIgnoreCase("n")){
                        position=5;
                    } else {
                        System.out.println("Huh? You can only use n to move from here.");
                        type=1;
                    }
                } else if(position==4){
                    System.out.println("You can move to the crew quarters (s) from here.");
                                        if(sc.nextLine().equalsIgnoreCase("s")){
                        position=2;
                    } else {
                        System.out.println("What now? You can only use s to move from here.");
                        type=1;
                    }
                } else if(position==5){
                    System.out.println("You can move to the robotics room (s), the shuttle bay (n), or the matter to energy converter room (w).");
                    
                    if(sc.nextLine().equalsIgnoreCase("n")){
                        if(shbyUn==0){
                            System.out.println("The door to the shuttle bay is locked. You will be able to open it for the cost of 5 energy and 2 medium batteries.");
                            if(energy>4){
                                if(mB>1){
                                    System.out.println("It seems you have the resources needed to fix the door. Will you? y/n");
                                    
                                    if(sc.nextLine().equalsIgnoreCase("y")){
                                        System.out.println("You've fixed the door to the shuttle bay!");
                                        shbyUn++;
                                        energy=energy-5;
                                        mB=mB-2;
                                    } else if(sc.nextLine().equalsIgnoreCase("n")){
                                        System.out.println("You've decided not to fix the door at this time.");
                                        type=1;
                                    } else {
                                        System.out.println("What? you need to use y or n to answer.");
                                        type=1;
                                    }
                                } else {
                                    type=1;
                                }
                            } else {
                                type=1;
                            }
                        } else if(shbyUn==1){
                            position=6;
                            shbyUn=2;
                            System.out.println("you walk into the shuttle bay, there is 1 husk of a cargo shuttle, there is a shuttle modification and repairing machine (SMRM) it looks relatively intact ");
                            System.out.println("but the matter to energy catalyst has been broken. the bodies in this part of the ship are wearing federation army uniforms.");
                            System.out.println("if you repair the ship you may be able to leave. you find crew report T, you find 1 medium part and 5 large parts.");
                            mP++;
                            lP=lP+5;
                        } else if(rbtcUn==2){
                            position=6;
                        }
                    } else if(sc.nextLine().equalsIgnoreCase("s")){
                        if(rbtcUn==0){
                            System.out.println("This door seems to be locked. You can't see anything wrong with it, so you can't fix it, but maybe the answer lies further within the station.");
                        } else if(rbtcUn==1){
                            position=3;
                            System.out.println("strangely there are no bodies here, but a lot of blood. there are signs of an explosion.");
                            rbtcUn=2;
                        } else if(rbtcUn==2){
                            position=3;
                        }
                    } else if(sc.nextLine().equalsIgnoreCase("w")){
                        position=0;
                    } else {
                        System.out.println("What did you mean by that? You can only use w, e and n to move away from here.");
                    }
                } else if(position==6){
                    System.out.println("You can move to the medbay (s), the reactor room (w), or the crew quarters (n).");
                    
                    if(sc.nextLine().equalsIgnoreCase("s")){
                        
                    } else if(sc.nextLine().equalsIgnoreCase("w")){
                        
                    } else if(sc.nextLine().equalsIgnoreCase("n")){
                        if(crqrUn==0){
                            
                        } else if(crqrUn==1){
                            position = 2;
                            crqrUn=2;
                            System.out.println("you enter the place where you and the rest of the crew use to live, all 9 of you,");
                            System.out.println("or was it 10, no it was 10 you're sure now. you search all of the rooms and find the");
                            System.out.println("me 32p wrench.you also find logs: ///");
                            tool++;
                        } else {
                            position = 2;
                        }
                    }
                }
            }
            if(sc.nextLine().equalsIgnoreCase("build")){
                if(position==1){
                    System.out.println("what would you like to build?");
                    System.out.println("You can build:");
                    if(mdbyUn!=0){
                        System.out.println("Food: 5 energy for 8 food.");
                        System.out.println("enter FOOD");
                        System.out.println("Med packs: 3 energy for 1.");
                        System.out.println("enter MDPK");
                    }
                    if(rbtcUn!=0){
                        System.out.println("Robots: 1 large battery, 2 medium batteries, and 20 small parts for 1 robot.");
                        System.out.println("enter RBTC");
                    }
                    System.out.println("Small parts: 3 energy for 5.");
                    System.out.println("enter SPRT");
                    System.out.println("Medium parts: 5 energy for 3.");
                    System.out.println("enter MPRT");
                    System.out.println("Large parts: 5 energy for 1.");
                    System.out.println("enter LPRT");
                    System.out.println("Small batteries: 1 energy and 3 small parts for 5.");
                    System.out.println("enter SBTY");
                    System.out.println("Medium batteries: 3 energy, 1 medium part and 1 small battery for 5.");
                    System.out.println("enter MBTY");
                    System.out.println("Large batteries: 1 medium battery, 10 energy, 3 medium parts for 3.");
                    System.out.println("enter LBTY");
                    if(tool==1){
                        System.out.println("Since you have the wrench, you are now able to build working components for the shuttle.");
                        if(progress==0){
                            System.out.println("The next component you need will be the supply system. It will require 5 large parts, 4 energy, and 3 medium batteries.");
                        }
                        if(progress==2){
                            System.out.println("The next component you need will be the rotational thrusters, the ones on the ship seem damaged beyond repair so it will require more resources to make them.");
                            System.out.println("You will need 6 large batteries, 12 medium parts and 1 large part.");
                        }
                        if(progress==4){
                            System.out.println("This'll be an easy one, just need to fix the cockpit glass. 20 energy and 4 medium parts should do.");
                        }
                        if(progress==6){
                            System.out.println("This is by far the hardest one you'll need to fix. The reactor core, while not badly damaged, cannot be repaired and requires a replacement.");
                            System.out.println("The full component will cost a whopping 15 medium parts, 5 medium batteries and 6 large parts, with 20 energy needed for welding.");
                        }
                        if(progress%2==1){
                            System.out.println("You seem to have a component made which you haven't fitted on the shuttle yet!");
                        }
                        System.out.println("enter NEXTCOMPONENT");
                    }
                    
                    if(sc.nextLine().equalsIgnoreCase("nextcomponent")){
                        if(progress==0){
                            if(tool==1){
                                if(lP>4){
                                    if(mB>2){
                                        if(energy>3){
                                            energy=energy-4;
                                            lP=lP-5;
                                            mB=mB-3;
                                            progress++;
                                            
                                        } else {
                                            System.out.println("You don't have the required materials yet.");
                                        }
                                    } else {
                                        System.out.println("You don't have the required materials yet.");
                                    }
                                } else {
                                    System.out.println("You don't have the required materials yet.");
                                }
                            } else {
                                System.out.println("You still need the wrench to start repairing the shuttle.");
                            }
                        } else if(progress==2){
                            if(lB>5){
                                if(mP>11){
                                    if(lP>0){
                                        lP--;
                                        mP=mP-12;
                                        lB=lB-6;
                                        progress++;
                                    } else {
                                      System.out.println("You don't have the required materials yet.");  
                                    } 
                                } else {
                                    System.out.println("You don't have the required materials yet.");
                                }
                            } else {
                                System.out.println("You don't have the required materials yet.");
                            }
                        }else if(progress==4){
                            if(energy>19){
                                if(mP>3){
                                    mP=mP-4;
                                    energy=energy-20;
                                    progress++;
                                } else {
                                    System.out.println("You don't have the required materials yet.");
                                }
                            } else {
                                System.out.println("You don't have the required materials yet.");
                            }
                        }else if(progress==6){
                            if(energy>19){
                                if(mB>4){
                                    if(lP>5){
                                        if(mP>14){
                                            mP=mP-15;
                                            lP=lP-6;
                                            mB=mB-5;
                                            energy=energy-20;
                                            progress++;
                                        } else {
                                            System.out.println("You don't have the required materials yet.");
                                        }
                                    } else {
                                      System.out.println("You don't have the required materials yet.");  
                                    } 
                                } else {
                                    System.out.println("You don't have the required materials yet.");
                                }
                            } else {
                                System.out.println("You don't have the required materials yet.");
                            }
                        }
                        
                    } else if(sc.nextLine().equalsIgnoreCase("sprt")){
                        if(energy>2){
                            
                        } else {
                            System.out.println("You do not have enough for this.");
                        }
                    } else if(sc.nextLine().equalsIgnoreCase("mprt")){
                        if(energy>5){
                            
                        } else {
                            System.out.println("You do not have enough for this.");
                        }
                    } else if(sc.nextLine().equalsIgnoreCase("lprt")){
                        if(energy>5){
                            
                        } else {
                          System.out.println("You do not have enough for this.");  
                        } 
                    } else if(sc.nextLine().equalsIgnoreCase("sbty")){
                        if(energy>0){
                            if(sP>2){
                                
                            } else {
                                System.out.println("You do not have enough for this.");
                            }
                        } else {
                            System.out.println("You do not have enough for this.");
                        }
                    } else if(sc.nextLine().equalsIgnoreCase("mbty")){
                        if(energy>2){
                            if(sB>0){
                                if(mP>0){
                                    
                                } else {
                                    System.out.println("You do not have enough for this.");
                                }
                            } else {
                                System.out.println("You do not have enough for this.");
                            }
                        } else {
                            System.out.println("You do not have enough for this.");
                        }
                    } else if(sc.nextLine().equalsIgnoreCase("lbty")){
                        if(energy>9){
                            if(mB>0){
                                if(mP>2){
                                    
                                } else {
                                 System.out.println("You do not have enough for this.");   
                                }
                            } else {
                                System.out.println("You do not have enough for this.");
                            }
                        } else {
                            System.out.println("You do not have enough for this.");
                        }
                    } else if(sc.nextLine().equalsIgnoreCase("rbtc")){
                        if(crqrUn!=0){
                            if(lB>0){
                                if(sP>20){
                                    if(mB>1){
                                        
                                    } else {
                                        System.out.println("You do not have enough for this.");
                                    }
                                } else {
                                    System.out.println("You do not have enough for this.");
                                }
                            } else {
                                System.out.println("You do not have enough for this.");
                            }
                        } else {
                            System.out.println("You do not have access to the blueprints, they will be in the robotics room.");
                        }
                   } else if(sc.nextLine().equalsIgnoreCase("food")){
                        if(energy>4){
                            energy=energy-5;
                            food=food+8;
                            System.out.println("(-5 energy, +8 food.)");
                        } else {
                            System.out.println("You do not have enough for this.");
                        }
                    } else if(sc.nextLine().equalsIgnoreCase("mdpk")){
                        if(mdbyUn!=0){
                        if(energy>2){
                            energy=energy-3;
                            sPak++;
                            System.out.println("(-3 energy, +1 medpak.)");
                        } else {
                            System.out.println("You do not have enough for this.");
                        }
                    } else {
                        System.out.println("You do not have access to the blueprints, they will be in the medical bay.");
                    }
                    }
                } else {
                    System.out.println("You must be in the reactor room to build components or resources.");
                }
            }
        }
    }
      
    }
}
