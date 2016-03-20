import java.util.Scanner;
import java.util.Random;
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
                      int disasterchance=-15;
                      Random rg = new Random();
      health=100;
        energy=1;
        sP=0;mP=0;lP=0;sB=0;mB=0;lB=0;sPak=1;scrap=0;
        logs=0;
        tool=0;
        food=20;
        robots=0;
        int reactorlevel=1;
        int reactorstatus=1;
        int[] lng = { 0,0,0,0,0,0,0,0,0,0,0 };
        int temp2=0;
        Scanner sc = new Scanner(System.in);
        int type=1;
        //USE TYPE TO DECIDE WHICH ACTIONS REQUIRE A TURN PASS OR NOT.
        System.out.println("you have an aching head, arm, and leg. you have no idea what happened. you look ");
           System.out.println("around, you see that you are in the matter converter room, the matter converter looks partially");
           System.out.println("broken, it is charging slowly. you have a tablet on you, you boot it up. ");
           System.out.println("the tablet asks you if you want to turn on floatdownload©, you do. it tackes you to the log in screen");
           System.out.println("it says that you are Thorburn Dylan Neville,engineer. you log in and learn that you can use this tablet");
           System.out.println("for checking suplies and downloading floatdownload© files. you should be able to get crew logs and");
           System.out.println("blueprints. you should probably start to build. blast door to med bay is locked, ladder to reactor");
           System.out.println("is open. if you want to know what you can do by typing commands, enter 'help'.");
           String input;
        while(health>0){
            //START THIS STUFF UP
            
            
           type=1;
           
           while(type==1){
               type=0;
               input = sc.nextLine();
               if(input.equalsIgnoreCase("upgrade")){
                  if(position==1){
                      System.out.println("You can upgrade the reactor for:");
                      if(reactorlevel>4){
                          System.out.println(5+" medium parts");
                        }
                      if(reactorlevel>2){
                          System.out.println(5+"small parts");
                        }
                      if(reactorlevel>9){
                          System.out.println(5+"large parts");
                        }
                      System.out.println("and "+(reactorlevel^2/2) + "energy.");
                      System.out.println("Y/N ?");
                      input=sc.nextLine();
                      if(input.equalsIgnoreCase("y")){
                          
                        } else if(input.equalsIgnoreCase("n")){
                            System.out.println("You decide not to upgrade the reactor.");
                            type=1;
                        } else {
                         System.out.println("What? use y/n to answer.");
                         type=1;
                        }
                    } else {
                        System.out.println("You need to be in the reactor room to upgrade the reactor.");
                        type=1;
                    }
                   
            }else if(input.equalsIgnoreCase("help")){
               System.out.println("The available commands are:");
                 System.out.println("upgrade, use for upgrading the reactor");
                 System.out.println("generate food, use to sustain yourself, used in the med room");
                 System.out.println("check situation, finds your resource total, your log completion, and your wellbeing.");
                 System.out.println("move west / move east / move north / move south");
                 System.out.println("listen to log, only usable for the log in the room you found it in");
                 System.out.println("use, gives you some options such as manning the reactor for a bonus, fixing it, healing and so on.");
                 System.out.println("Try to use this and check situation as sparingly as possible, as the time it takes for the character to read the manual");
                 System.out.println("or gather his resources takes a full turn!");
            } else
           if(input.equalsIgnoreCase("look around")){
               if(position==0){
                   System.out.println("you see that you are in the matter converter room, the matter converter looks partially");
                   System.out.println("broken, it is charging slowly.");
                } else if(position==1){
                     System.out.println("the reactor is partially destroyed. the blast door to the hanger is locked.");
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
            } else
           if(input.equalsIgnoreCase("move")){
               if(position==0){
                   System.out.println("You can go to the Medical bay (e), or the Reactor Room (n) from here.");
                   input = sc.nextLine();
                   if(input.equalsIgnoreCase("n")){
                       position=1;
                       if(engFirst==1){
                          engFirst=0;
                          System.out.println("the reactor is partially destroyed. the blast door to the hanger is locked. you find 10 scrap and  crew report #1.");
                          scrap=scrap+10;
                          logs=1;
                          lng[0]=1;
                        } 
                    } else if(input.equalsIgnoreCase("e")){
                        if(mdbyUn==0){
                            System.out.println("The door is broken, but you can fix it for 20 small parts and 3 small batteries.");
                            if(sP>19){
                                if(sB>2){
                                    System.out.println("You seem to have the required materials. Do you decide to fix the door? y/n");
                                    input = sc.nextLine();
                                    while(temp2==0){
                                    
                                    if(input.equalsIgnoreCase("y")){
                                        sB=sB-3;
                                        sP=sP-20;
                                        mdbyUn++;
                                        temp2++;
                                    } else if(input.equalsIgnoreCase("n")){
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
                    
                    input = sc.nextLine();
                        if(input.equalsIgnoreCase("s")){
                            position=0;
                        } else if(input.equalsIgnoreCase("e")){
                            if(shbyUn==0){
                                System.out.println("The door is broken, but you can fix it for 15 medium parts and 4 medium batteries.");
                            if(mP>14){
                                if(mB>3){
                                    System.out.println("You seem to have the required materials. Do you decide to fix the door? y/n");
                                    input = sc.nextLine();
                                    while(temp2==0){
                                        
                                    if(input.equalsIgnoreCase("y")){
                                        sB=mB-4;
                                        sP=mP-14;
                                        shbyUn++;
                                        temp2++;
                                    } else if(input.equalsIgnoreCase("n")){
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
                            System.out.println("guess that is similar to the rest of the ship. you can heal here, you can build stimpacks here, you find 2 crew messages and 10 scrap.");
                            lng[1]=1;
                            lng[2]=1;
                            } else if(mdbyUn==2){
                                position=5;
                            }
                        } else {
                            System.out.println("What? You have to use s or e to move from here.");
                            type=1;
                        }
                        
                   
                } else if(position==2){
                    System.out.println("You can move to the shuttle bay (s), or the control room (n).");
                    input = sc.nextLine();
                    if(input.equalsIgnoreCase("s")){
                        position=6;
                    }else if(input.equalsIgnoreCase("n")){
                        if(ctrlUn==0){
                            System.out.println("The door is broken, but you will be able to fix it for 5 energy and 2 medium batteries.");
                            if(energy>4){
                                if(mB>1){
                                    System.out.println("You have the required materials to fix the door. will you? y/n");
                                    input = sc.nextLine();
                                    if(input.equalsIgnoreCase("y")){
                                        energy=energy-5;
                                        mB=mB-2;
                                        crqrUn++;
                                        System.out.println("You've unlocked this door! You are now able to go into the control room.");
                                    } else if(input.equalsIgnoreCase("n")){
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
                           rbtcUn=1;
                        } else if(ctrlUn==2){
                            position=4;
                        }
                    } else {
                        System.out.println("What? use s or n for moving from here.");
                        type=1;
                    }
                    
                } else if(position==3){
                    System.out.println("You can move to the medbay (n) from here.");
                    input = sc.nextLine();
                    if(input.equalsIgnoreCase("n")){
                        position=5;
                    } else {
                        System.out.println("Huh? You can only use n to move from here.");
                        type=1;
                    }
                } else if(position==4){
                    System.out.println("You can move to the crew quarters (s) from here.");
                    input = sc.nextLine();
                                        if(input.equalsIgnoreCase("s")){
                        position=2;
                    } else {
                        System.out.println("What now? You can only use s to move from here.");
                        type=1;
                    }
                } else if(position==5){
                    System.out.println("You can move to the robotics room (s), the shuttle bay (n), or the matter to energy converter room (w).");
                    input = sc.nextLine();
                    if(input.equalsIgnoreCase("n")){
                        if(shbyUn==0){
                            System.out.println("The door to the shuttle bay is locked. You will be able to open it for the cost of 5 energy and 2 medium batteries.");
                            if(energy>4){
                                if(mB>1){
                                    System.out.println("It seems you have the resources needed to fix the door. Will you? y/n");
                                    
                                    if(input.equalsIgnoreCase("y")){
                                        System.out.println("You've fixed the door to the shuttle bay!");
                                        shbyUn++;
                                        energy=energy-5;
                                        mB=mB-2;
                                    } else if(input.equalsIgnoreCase("n")){
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
                            System.out.println("if you repair the ship you may be able to leave. you find an audio log, 1 medium part and 5 large parts.");
                            mP++;
                            lP=lP+5;
                        } else if(rbtcUn==2){
                            position=6;
                        }
                    } else if(input.equalsIgnoreCase("s")){
                        if(rbtcUn==0){
                            System.out.println("This door seems to be locked. You can't see anything wrong with it, so you can't fix it, but maybe the answer lies further within the station.");
                        } else if(rbtcUn==1){
                            position=3;
                            System.out.println("strangely there are no bodies here, but a lot of blood. there are signs of an explosion.");
                            System.out.println("In addition, there is a crew report and... what seems to be a damage report by the computer.");
                            lng[5]=1;
                            lng[6]=1;
                            rbtcUn=2;
                        } else if(rbtcUn==2){
                            position=3;
                        }
                    } else if(input.equalsIgnoreCase("w")){
                        position=0;
                    } else {
                        System.out.println("What did you mean by that? You can only use w, e and n to move away from here.");
                    }
                } else if(position==6){
                    System.out.println("You can move to the medbay (s), the reactor room (w), or the crew quarters (n).");
                    input = sc.nextLine();
                    if(input.equalsIgnoreCase("s")){
                        
                    } else if(input.equalsIgnoreCase("w")){
                        
                    } else if(input.equalsIgnoreCase("n")){
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
            } else
            if(input.equalsIgnoreCase("build")){
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
                    input = sc.nextLine();
                    if(input.equalsIgnoreCase("nextcomponent")){
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
                        
                    } else if(input.equalsIgnoreCase("sprt")){
                        if(energy>2){
                            energy=energy-3;
                            sP=sP+5;
                            System.out.println("You have made 5 small parts.");
                        } else {
                            System.out.println("You do not have enough for this.");
                        }
                    } else if(input.equalsIgnoreCase("mprt")){
                        if(energy>5){
                            energy=energy-5;
                            mP=mP+3;
                            System.out.println("You have made 3 medium parts.");
                        } else {
                            System.out.println("You do not have enough for this.");
                        }
                    } else if(input.equalsIgnoreCase("lprt")){
                        if(energy>5){
                            energy=energy-5;
                            lP++;
                            System.out.println("You have made one large part.");
                        } else {
                          System.out.println("You do not have enough for this.");  
                        } 
                    } else if(input.equalsIgnoreCase("sbty")){
                        if(energy>0){
                            if(sP>2){
                                energy--;
                                sP=sP-3;
                                sB=sB+5;
                                System.out.println("You have made 5 small batteries.");
                            } else {
                                System.out.println("You do not have enough for this.");
                                type=1;
                            }
                        } else {
                            System.out.println("You do not have enough for this.");
                            type=1;
                        }
                    } else if(input.equalsIgnoreCase("mbty")){
                        if(energy>2){
                            if(sB>0){
                                if(mP>0){
                                    energy=energy-3;
                                    sB--;
                                    mP--;
                                    mB=mB+5;
                                    System.out.println("You have made 5 medium batteries.");
                                } else {
                                    System.out.println("You do not have enough for this.");
                                    type=1;
                                }
                            } else {
                                System.out.println("You do not have enough for this.");
                                type=1;
                            }
                        } else {
                            System.out.println("You do not have enough for this.");
                            type=1;
                        }
                    } else if(input.equalsIgnoreCase("lbty")){
                        if(energy>9){
                            if(mB>0){
                                if(mP>2){
                                    mB--;
                                    energy=energy-10;
                                    mP=mP-3;
                                    lB=lB+3;
                                    System.out.println("You have made 3 large batteries.");
                                } else {
                                 System.out.println("You do not have enough for this."); 
                                 type=1;
                                }
                            } else {
                                System.out.println("You do not have enough for this.");
                                type=1;
                            }
                        } else {
                            System.out.println("You do not have enough for this.");
                            type=1;
                        }
                    } else if(input.equalsIgnoreCase("rbtc")){
                        if(crqrUn!=0){
                            if(lB>0){
                                if(sP>20){
                                    if(mB>1){
                                        robots++;
                                    } else {
                                        System.out.println("You do not have enough for this.");
                                        type=1;
                                    }
                                } else {
                                    System.out.println("You do not have enough for this.");
                                    type=1;
                                }
                            } else {
                                System.out.println("You do not have enough for this.");
                                type=1;
                            }
                        } else {
                            System.out.println("You do not have access to the blueprints, they will be in the robotics room.");
                            type=1;
                        }
                   } else if(input.equalsIgnoreCase("food")){
                        if(energy>4){
                            energy=energy-5;
                            food=food+8;
                            System.out.println("(-5 energy, +8 food.)");
                        } else {
                            System.out.println("You do not have enough for this.");
                            type=1;
                        }
                    } else if(input.equalsIgnoreCase("mdpk")){
                        if(mdbyUn!=0){
                        if(energy>2){
                            energy=energy-3;
                            sPak++;
                            System.out.println("(-3 energy, +1 medpak.)");
                        } else {
                            System.out.println("You do not have enough for this.");
                            type=1;
                        }
                    } else {
                        System.out.println("You do not have access to the blueprints, they will be in the medical bay.");
                        type=1;
                    }
                    }
                } else {
                    System.out.println("You must be in the reactor room to build components or resources.");
                    type=1;
                }
            } else if(input.equalsIgnoreCase("check situation")){
                    System.out.println("Health: "+health+"   Energy: "+energy);
                    System.out.println("Small/Medium/Large parts:  " + sP + "/" + mP + "/" + lP);
                    System.out.println("Logs: " +logs);
                    System.out.println("Extended inventory:");
                    if(tool==1){
                        System.out.println("ME-32P Wrench");
                    } 
                    if(robots>1){
                        System.out.println("Robots: "+robots);
            
                    }
            } else if(input.equalsIgnoreCase("use")){
                System.out.println("What do you want to use?");
                System.out.println("You have:");
                if(sPak>0){
                    System.out.println("Stimpaks");
                    System.out.println("enter stimpak");
                }
                if(position==1){
                    System.out.println("The reactor");
                    System.out.println("enter reactor");
                }
                if(position==6){
                    if(tool==1){
                        if(progress%2==1){
                    System.out.println("fixing the shuttle");
                    System.out.println("enter shuttle");
                }
                }
                }
                if(position==0){
                    System.out.println("the matter to energy converter");
                    System.out.println("enter converter");
                }
                 input = sc.nextLine();
                if(input.equalsIgnoreCase("converter")){
                    System.out.println("All your scrap has been converted into energy at a rate of 1 scrap to 2 energy.");
                    System.out.println("This means you have consumed "+scrap+" scrap and produced " +scrap*2 +" energy.");
                    energy=energy+scrap*2;
                    scrap=0;
                } else if(input.equalsIgnoreCase("shuttle")){
                    if(progress%2==1){
                        System.out.println("The part has been attached.");
                        progress++;
                    } else {
                        System.out.println("You either still need to find the wrench or need to make a part for the shuttle at the reactor room.");
                    }
                } else if(input.equalsIgnoreCase("stimpak")){
                    if(sPak>0){
                    System.out.println("This will consume a stimpak and restore your health by 50. are you sure you want to do this? y/n");
                    input = sc.nextLine();
                    if(input.equalsIgnoreCase("y")){
                        System.out.println("(+50 health, -1 stimpak.)");
                        sPak--;
                        health=health+50;
                        if(health>100){
                            health=100;
                        }
                        
                    } else if(input.equalsIgnoreCase("n")){
                        
                    } else {
                        System.out.println("Use either y or n to answer these questions.");
                        
                    }
                } else {
                    System.out.println("You have no stimpaks.");
                }
                    type=1;
                } 
            } else if(input.equalsIgnoreCase("listen")){
                if(logs>0){
                    System.out.println("Enter the corrosponding number:");
                    if(lng[0]==1){
                        System.out.println("#1: Log 1");
                    }
                    if(lng[1]==1){
                        System.out.println("#2: med report 3112-jan-31");
                    }
                    if(lng[2]==1){
                        System.out.println("#3: med report 3112-aug-28");
                    }
                    if(lng[3]==1){
                        System.out.println("#4: fedarmy black bo_ 3112-aug-31");
                    }
                    if(lng[4]==1){
                        System.out.println("#5: crew report_5"); //emergency shutdown
                    }
                    if(lng[5]==1){
                        System.out.println("#6: crew report_6"); //female in robotics room
                    }
                    if(lng[6]==1){
                        System.out.println("");
                    }
                    input=sc.nextLine();
                    if(input.equalsIgnoreCase("1")){
                        System.out.println("what is that, oh god he is trying to get in… *explosion* what is he doing out there, what was that?");
                        System.out.println("*scraping*");
                        System.out.println("OH SHIT, OH SHIT, OH SHIT.");
                        System.out.println("*The report ends to the sound of a door opening.*");
                    } else if(input.equalsIgnoreCase("2")){
                        System.out.println("med report 3112-jan-31 *female voice* day 1 medical exams are complete, everyone is healthy and fit.");
                        System.out.println("all ten members of the crew, testing can begin at any moment. the full");
                        System.out.println("body restorer seems to be working perfectly. we should");
                        System.out.println("*audio distortion makes the rest impossible to understand.*");
                    } else if(input.equalsIgnoreCase("3")){
                        System.out.println("med report 3112-aug-28 *female voice* the test subject has had no negative effects from the body regenerator but dieing and coming");
                        System.out.println(" back to life seems to have taken a toll on his mind. he seems to be raving about how we have put him through hell and he");
                        System.out.println(" is going to put us through the same. he is secured to the table but a transport wont be here for 3 days, it's not like the glory days of the federation anymore.");
                        System.out.println("End of transmission.");
                    } else if(input.equalsIgnoreCase("4")){
                        System.out.println("fedarmy black bo_ 3112-aug-31. *male voice* shuttle 341 has docked with space station_r2 and are ready to receive the transport.");
                        System.out.println("we have not received any communication from the station.");
                        System.out.println("*a loud, undistinguishable noise causes the man to drop the log recorder*");
                        System.out.println("what is that running at us? oh god he is covered in blood, open fire!");
                        System.out.println("*after several seconds of the unmistakeable sound of laser blasts* ");
                        System.out.println("i think we got him.");
                        System.out.println("*Another voice, a robot's this time:*");
                        System.out.println("shuttle has sustained high damage. unable to function. shutting down.");
                        System.out.println("END OF LOG.");
                    } else if(input.equalsIgnoreCase("5")){
                        System.out.println("*new female voice * i think i have found refuge from John, hopefully I can wait till the shuttle shows up tomorrow, he should be unable to enter.");
                    } else if(input.equalsIgnoreCase("6")){
                        System.out.println("!!!!!!!!!!!!!!!!!!!!emergency shutdown!!!!!!!!!!!!!!!!!!!! ");
                        System.out.println(" red alert activated, power conduits 1,2,3,4,5 down, unable to receive response from");
                        System.out.println(" com_512maincore. shutting down robots, threat analysis: robots weaponized, activating robots, initiating robot core overload,");
                        System.out.println(" robots=1, fail safe: robot inside, override self destruct, robots=0, ");
                        System.out.println("damage assessment: robot control undamaged. ");
                    } else {
                        System.out.println("huh? there is no log numbered that.");
                    }
                } else {
                    System.out.println("You have no logs.");
                    
                }
                type=1;
            } else if(input.equalsIgnoreCase("bypass")){
                System.out.println("for the purpose of this presentation, this code has added 50 of every resource, and 1000 energy.");
                energy=1000;
                mP=50;
                lP=50;
                sP=50;
                sB=50;
                mB=50;
                lB=50;
                sPak=50;
                food=50;
                robots=50;
                type=1;
            } else if(input.equalsIgnoreCase("simulate disaster")){
                disasterchance=disasterchance+100;
            } else if(input.equalsIgnoreCase("leave station")){
                if(position==6){
                    if(progress==9){
                        //YOUVE COMPLETED THE GAME CONGRATS UNTIL I FIX THIS IN THE MORNING
                        System.out.println("YOUVE COMPLETED THE GAME CONGRATS UNTIL I FIX THIS IN THE MORNING");
                    }
                } else {
                    System.out.println("You are not at the shuttlebay.");
                    type=1;
                }
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        food--;
        if(food>0){
            if(food<3){
                System.out.println("Urgent reminder! You have a very small amount of food left.");
            }
        } else {
            System.out.println("You are starving! the first time you recieve this message you will start losing 10 health a turn, ");
            System.out.println("meaning at full health you have 10 turns to make some food!");
            health=health-10;
        }
        disasterchance=disasterchance+5;
        if(rg.nextInt(150)<disasterchance){
            if(rg.nextInt(3)==2){
                System.out.println("A meteor shower has broken some important components and breached the hull! You manage to put on your suit in time, but the repair takes 3 turns and all your energy.");
                food=food-3;
                energy=0;
                if(food<0){
                    food=0;
                }
                disasterchance=-15;
            } else {
                System.out.println("The reactor has broken down! You need to interact with it to fix it, or it wont make any energy per turn.");
                System.out.println("In addition, the reactor's level has dropped by 1.");
                reactorlevel--;
                reactorstatus=1;
                if(reactorlevel<1){
                    reactorlevel=1;
                }
                disasterchance=0;
            }
        }
        if(reactorstatus==0){
            energy=energy+reactorlevel;
        }
        if(rbtcUn!=0){
            if(robots>0){
                System.out.println("Finally, your " + robots + " robots have gathered " + robots*10 + " scrap this turn.");
            }
        }
    }
      
    }
}
