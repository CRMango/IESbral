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
       int mode=1;
       int forcefield=0;
       int pThrust=0;
       boolean upgradeCost = true;
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
        food=30;
        robots=0;
        int fuel = 0;
        int reactorlevel=1;
        int reactorstatus=0;
        int[] lng = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
        int starmapP=33;
        int temp2=0;
        Scanner sc = new Scanner(System.in);
        int type=1;
        int[][] visited = new int[5][5];
        for(int i = 4; i!=0; i--){
            for(int j = 4; j!=0; j--){
                visited[i][j]=0;
            }
        }
        //USE TYPE TO DECIDE WHICH ACTIONS REQUIRE A TURN PASS OR NOT.
        System.out.println("you have an aching head, arm, and leg. you have no idea what happened. you look ");
           System.out.println("around, you see that you are in the matter converter room, the matter converter looks partially");
           System.out.println("broken, it is charging slowly. you have a tablet on you, you boot it up. ");
           System.out.println("the tablet asks you if you want to turn on floatdownload©, you do. it tackes you to the log in screen");
           System.out.println("it says that you are Thorburn Dylan Neville,engineer. you log in and learn that you can use this tablet");
           System.out.println("for checking suplies and downloading floatdownload© files. you should be able to get crew logs and");
           System.out.println("blueprints. you should probably start to build. blast door to med bay is locked, ladder to reactor");
           System.out.println("is open. if you want to know what you can do by typing commands, enter 'help'.");
           String input = "helloTEST";
           System.out.println("");

            //START THIS STUFF UP
    while(health>0){
          while(mode==1){  
           type=1;
           
           while(type==1){
               type=0;
               input = sc.nextLine();
               if(input.equalsIgnoreCase("upgrade")){
                  if(position==1){
                      System.out.println("You can upgrade the reactor for:");
                      if(reactorlevel>4){
                          System.out.println(reactorlevel+" medium parts");
                        }
                      if(reactorlevel>2){
                          System.out.println(reactorlevel+" small parts");
                        }
                      if(reactorlevel>9){
                          System.out.println(reactorlevel+" large parts");
                        }
                      System.out.println(((reactorlevel*reactorlevel)/2+reactorlevel) + " energy.");
                      System.out.println("Y/N ?");
                      input=sc.nextLine();
                      if(input.equalsIgnoreCase("y")){
                          upgradeCost=true;
                          if(reactorlevel>2){
                              if(sP<reactorlevel){
                                  upgradeCost=false;
                              }
                              }
                          if(reactorlevel>4){
                            if(mP<reactorlevel){
                                upgradeCost=false;
                                }
                          }
                          if(reactorlevel>9){
                              if(lP<reactorlevel){
                                  upgradeCost=false;
                                  }
                          }
                          
                          if((reactorlevel*reactorlevel/2+1)>energy){
                              upgradeCost=false;
                              }
                          if(upgradeCost==true){
                              energy=energy-(reactorlevel*reactorlevel)/2+1;
                              if(reactorlevel>2){
                                  if(reactorlevel>4){
                                      if(reactorlevel>9){
                                          lP=lP-reactorlevel;
                                          }
                                          mP=mP-reactorlevel;
                                      }
                                      sP=sP-reactorlevel;
                                  }
                                  reactorlevel++;
                              } else {
                                  System.out.println("You don't have the resources to upgrade the reactor.");
                                }
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
                 System.out.println("help, of course");
                 System.out.println("look around, get an overview of the room you are in. keep in mind this will happen automatically on your first visit to any room.");
                 System.out.println("build, gives you the ability to build things in the reactor room.");
                 System.out.println("check situation, finds your resource total, and your wellbeing.");
                 System.out.println("move");
                 System.out.println("listen to log");
                 System.out.println("use, gives you some options such as manning the reactor for a bonus, fixing it, healing and so on.");
                 type=1;
            } else
           if(input.equalsIgnoreCase("look around")){
               if(position==0){
                   System.out.println("you see that you are in the matter converter room, the matter converter looks partially");
                   System.out.println("broken, it is charging slowly.");
                } else if(position==1){
                     System.out.println("the reactor is partially destroyed. there is a blast door to the hangar.");
                } else if(position==2){
                    System.out.println("This is the crew quarters. You can't remember where you slept, for some reason. maybe it'll come back to you soon.");
                } else if(position==3){
                    System.out.println("you have "+ robots + " amount of robots. they are collecting scrap at "+robots*10 + " per turn.");
                } else if(position==4){
                    System.out.println("The control room of the station. The computer is rather small, though the heat venting system is extensive.");
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
                                    
                                    while(temp2==0){
                                    input = sc.nextLine();
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
                            type=1;
                        } else if(mdbyUn==1){
                            position=5;
                            mdbyUn=2;
                            System.out.println("the med bay looks quite intact, the only problem is all of the blood everywhere, and the bodies disfigured beyond recognition, but i ");
                            System.out.println("guess that is similar to the rest of the ship. you can heal here, you can build stimpacks now and you find a crew message and 10 scrap.");
                            lng[1]=1;
                            
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
                                    
                                    while(temp2==0){
                                        input = sc.nextLine();
                                    if(input.equalsIgnoreCase("y")){
                                        mB=mB-4;
                                        mP=mP-15;
                                        shbyUn++;
                                        temp2++;
                                        System.out.println("You have fixed the door to the shuttlebay.");
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
                        type=1;
                           } else if(shbyUn==1){
                                shbyUn=2;
                                position=6;
                                System.out.println("you walk into the shuttle bay, there is 1 husk of a cargo shuttle, there is a shuttle modification and repairing machine (SMRM) it looks relatively intact ");
                            System.out.println("but the matter to energy catalyst has been broken. the bodies in this part of the ship are wearing federation army uniforms.");
                            System.out.println("if you repair the ship you may be able to leave. you find an audio log, 1 medium part and 5 large parts.");
                            mP++;
                            lP=lP+5;
                            lng[3]=1;
                            lng[5]=1;
                            lng[4]=1;  
                            } else if(shbyUn==2){
                                position=6;
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
                            System.out.println("The door is broken, but you will be able to fix it for 5 energy and 2 large batteries.");
                            if(energy>4){
                                if(lB>1){
                                    System.out.println("You have the required materials to fix the door. will you? y/n");
                                    input = sc.nextLine();
                                    if(input.equalsIgnoreCase("y")){
                                        energy=energy-5;
                                        lB=lB-2;
                                        ctrlUn++;
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
                           System.out.println("You have also found a log.");
                           lng[8]=1;
                           rbtcUn=1;
                           lng[10]=1;
                           lng[2]=1;
                           lng[7]=1;
                           lng[9]=1;
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
                            System.out.println("The door to the shuttle bay is locked. You will be able to open it for the cost of 15 medium parts and 4 medium batteries.");
                            if(mB>4){
                                if(mP>14){
                                    System.out.println("It seems you have the resources needed to fix the door. Will you? y/n");
                                    input=sc.nextLine();
                                    if(input.equalsIgnoreCase("y")){
                                        System.out.println("You've fixed the door to the shuttle bay!");
                                        shbyUn++;
                                        mP=mP-15;
                                        mB=mB-4;
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
                            lng[3]=1;
                            lng[5]=1;
                            lng[4]=1;
                        } else if(shbyUn==2){
                            position=6;
                        }
                    } else if(input.equalsIgnoreCase("s")){
                        if(rbtcUn==0){
                            System.out.println("This door seems to be locked. You can't see anything wrong with it, so you can't fix it, but maybe the answer lies further within the station.");
                        } else if(rbtcUn==1){
                            position=3;
                            System.out.println("strangely there are no bodies here, but a lot of blood. there are signs of an explosion.");
                            System.out.println("In addition, there is a crew report and... what seems to be a damage report by the computer.");
                            lng[10]=1;
                            lng[11]=1;
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
                        if(mdbyUn==0){
                            System.out.println("The door is broken, but you can fix it for 20 small parts and 3 small batteries.");
                            if(sP>19){
                                if(sB>2){
                                    System.out.println("You seem to have the required materials. Do you decide to fix the door? y/n");
                                    
                                    while(temp2==0){
                                    input = sc.nextLine();
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
                            type=1;
                            
                        } else if(mdbyUn==1){
                            mdbyUn=2;
                            position=5;
                            System.out.println("the med bay looks quite intact, the only problem is all of the blood everywhere, and the bodies disfigured beyond recognition, but i ");
                            System.out.println("guess that is similar to the rest of the ship. you can heal here, you can build stimpacks now and you find a crew message and 10 scrap.");
                            lng[1]=1;
                            
                        } else {
                            position=5;
                        }
                    } else if(input.equalsIgnoreCase("w")){
                        position=1;
                    } else if(input.equalsIgnoreCase("n")){
                        if(crqrUn==0){
                            System.out.println("The door is broken, but you can fix it for 10 small parts and 2 medium batteries.");
                            if(sP>9){
                               if(mB>1){
                                   System.out.println("You have the required materials. Will you fix the door?");
                                   temp2=0;
                                   while(temp2==0){
                                       input=sc.nextLine();
                                       if(input.equalsIgnoreCase("y")){
                                           System.out.println("You fixed the door!");
                                           sP=sP-10;
                                           mB=mB-2;
                                           crqrUn=1;
                                           temp2=1;
                                           } else if(input.equalsIgnoreCase("n")) {
                                               System.out.println("You decide not to open the door.");
                                               type=1;
                                               temp2=1;
                                               } else {
                                                   System.out.println("Use either y or n for answering.");
                                                   }
                                       
                                       
                                       }
                                   } else {
                                       type=1;
                                       }
                             }   else {
                                 type=1;
                                 }
                        } else if(crqrUn==1){
                            position = 2;
                            crqrUn=2;
                            System.out.println("you enter the place where you and the rest of the crew use to live, all 9 of you,");
                            System.out.println("or was it 10, no it was 10 you're sure now. you search all of the rooms and find the");
                            System.out.println("me 32p wrench. You also find logs.");
                            tool++;
                            lng[6]=1;
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
                    if(ctrlUn==2){
                        System.out.println("A forcefield: 4 medium batteries, and 4 medium parts for a full protection from asteroids.");
                        System.out.println("enter FORCEFIELD");
                    }
                    if(progress>8){
                        System.out.println("Fuel for the ship: 30 energy for 10 canisters.");
                        System.out.println("enter FUEL");
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
                    if(pThrust==1){
                        System.out.println("Since you found the blueprint for the precision thrusters, you can now build them. it will take 20 energy, 6 large batteries and 12 large parts.");
                    }
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
                            if(progress>7){
                                System.out.println("You have already fixed the shuttle. use the leave station command in the shuttlebay to enter your ship.");
                            } else {
                            System.out.println("You seem to have a component made which you haven't fitted on the shuttle yet!");
                            
                        }
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
                                            type=1;
                                        }
                                    } else {
                                        System.out.println("You don't have the required materials yet.");
                                        type=1;
                                    }
                                } else {
                                    System.out.println("You don't have the required materials yet.");
                                    type=1;
                                }
                            } else {
                                System.out.println("You still need the wrench to start repairing the shuttle.");
                                type=1;
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
                                      type=1;
                                    } 
                                } else {
                                    System.out.println("You don't have the required materials yet.");
                                    type=1;
                                }
                            } else {
                                System.out.println("You don't have the required materials yet.");
                                type=1;
                            }
                        }else if(progress==4){
                            if(energy>19){
                                if(mP>3){
                                    mP=mP-4;
                                    energy=energy-20;
                                    progress++;
                                } else {
                                    System.out.println("You don't have the required materials yet.");
                                    type=1;
                                }
                            } else {
                                System.out.println("You don't have the required materials yet.");
                                type=1;
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
                                            type=1;
                                        }
                                    } else {
                                      System.out.println("You don't have the required materials yet.");  
                                      type=1;
                                    } 
                                } else {
                                    System.out.println("You don't have the required materials yet.");
                                    type=1;
                                }
                            } else {
                                System.out.println("You don't have the required materials yet.");
                                type=1;
                            }
                        }
                        
                    } else if(input.equalsIgnoreCase("sprt")){
                        if(energy>2){
                            energy=energy-3;
                            sP=sP+5;
                            System.out.println("You have made 5 small parts.");
                        } else {
                            System.out.println("You do not have enough for this.");
                            type=1;
                        }
                    } else if(input.equalsIgnoreCase("mprt")){
                        if(energy>5){
                            energy=energy-5;
                            mP=mP+3;
                            System.out.println("You have made 3 medium parts.");
                        } else {
                            System.out.println("You do not have enough for this.");
                            type=1;
                        }
                    } else if(input.equalsIgnoreCase("lprt")){
                        if(energy>5){
                            energy=energy-5;
                            lP++;
                            System.out.println("You have made one large part.");
                        } else {
                          System.out.println("You do not have enough for this.");  
                          type=1;
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
                    } else if(input.equalsIgnoreCase("forcefield")){
                        if(mB>3){
                            if(mP>3){
                                if(ctrlUn==2){
                                    mP=mP-4;
                                    mB=mB-4;
                                forcefield=1;
                                System.out.println("As the forcefield hums to life, you start to feel a lot safer.");
                            } else {
                                System.out.println("You don't have the blueprint for this.");
                                type=1;
                            }
                            } else {
                                type=1;
                                System.out.println("You do not have enough for this.");
                            }
                        } else {
                            type=1;
                            System.out.println("You do not have enough for this.");
                        } 
                        
                    } else if(input.equalsIgnoreCase("thrusters")){
                    if(pThrust==1){
                        if(lP>11){
                            if(lB>5){
                                if(energy>19){
                                    pThrust=2;
                                    energy=energy-20;
                                    lB=lB-6;
                                    lP=lP-12;
                                    System.out.println("After installing this thruster, you will be able to catch up with the hurtling test room.");
                                } else {
                                    System.out.println("You don't have enough energy.");
                                    type=1;
                                }
                            } else {
                                System.out.println("You don't have enough large batteries.");
                                type=1;
                            }
                            
                        } else {
                            System.out.println("You don't have enough large parts.");
                            type=1;
                        }
                    } else if(pThrust==2){
                        System.out.println("You have already made and installed the precision thrusters!");
                        type=1;
                    } else {
                        type=1;
                        System.out.println("You still need to find the blueprint for this.");
                    }
                    
                    
                    } else {
                        System.out.println("What? That isn't a thing you can build.");
                        type=1;
                    }
                } else {
                    System.out.println("You must be in the reactor room to build components or resources.");
                    type=1;
                }
            } else if(input.equalsIgnoreCase("check situation")){
                    System.out.println("Health: "+health+"   Energy: "+energy);
                    System.out.println("Food: " +food + "   Scrap: " + scrap);
                    System.out.println("Small/Medium/Large parts:  " + sP + "/" + mP + "/" + lP);
                    System.out.println("Small/Medium/Large batteries:  " +sB + "/"+mB+"/"+lB);
                    System.out.println("Reactor level: "+reactorlevel);
                    if(reactorstatus==0){
                        System.out.println("Reactor status: OPERATIONAL");
                        } else {
                            System.out.println("Reactor status: BROKEN");
                            }
                    if(tool==1){
                        System.out.println("ME-32P Wrench");
                    } 
                    if(robots>1){
                        System.out.println("Robots: "+robots);
            
                    }
                    type=1;
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
                        type=1;
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
                        System.out.println("You don't use a stimpak.");
                        type=1;
                    } else {
                        System.out.println("Use either y or n to answer these questions.");
                        type=1;
                    }
                } else {
                    System.out.println("You have no stimpaks.");
                }
                    type=1;
                } else if(input.equalsIgnoreCase("reactor")){
                    if(reactorstatus==0){
                        System.out.println("Maintaining the reactor this turn has given you 1 extra energy!");
                        energy++;
                    } else {
                        System.out.println("You fixed the reactor.");
                        reactorstatus=0;
                    }
                } else {
                    System.out.println("What? You can't do that.");
                    type=1;
                }
            } else if(input.equalsIgnoreCase("listen")){
                if(logs>0){
                    System.out.println("Enter the corrosponding number:");
                    if(lng[0]==1){
                        System.out.println("#1: the physicist talks to himself in the ME room");
                    }
                    if(lng[1]==1){
                        System.out.println("#2: opening day medical checks");
                    }
                    if(lng[2]==1){
                        System.out.println("#3: armed escort request");
                    }
                    if(lng[3]==1){
                        System.out.println("#4: biologist cowering in the shuttle room");
                    }
                    if(lng[4]==1){
                        System.out.println("#5: Black box of shuttle 341,6954"); //emergency shutdown
                    }
                    if(lng[5]==1){
                        System.out.println("#6: engineer 2 talking"); //female in robotics room
                    }
                    if(lng[6]==1){
                        System.out.println("#7: Captain's log: stardate: exposition ");
                    }
                    if(lng[7]==1){
                        System.out.println("#8: medical log of a psychoanalysis");
                    }
                    if(lng[8]==1){
                        System.out.println("#9: testing parameters");
                    }
                    if(lng[9]==1){
                        System.out.println("#10 distress call");
                    }
                    if(lng[10]==1){
                        System.out.println("#11 Captain of the ss gonna die");
                    }
                    if(lng[11]==1){
                        System.out.println("#12 robot room shutting down");
                    }
                    if(lng[12]==1){
                        System.out.println("#13 engineer 2 messing up");
                    }
                    if(lng[13]==1){
                        System.out.println("#14 a horrible breakthrough");
                    }
                    if(lng[14]==1){
                        System.out.println("#15 Revenge");
                        
                    }
                    input=sc.nextLine();
                    if(input.equalsIgnoreCase("1")){
                        System.out.println("report made by  Bernie Fancy Dalton -physicist: what is he doing out there, does he not know");
                        System.out.println("how dangerous that is. We are orbiting a planet at 10000 km/h and all that is separating us ");
                        System.out.println("from the endless void of space is a few centimeters of titanium. why does he need to blow up ");
                        System.out.println("everything he breaks? why can’t he just smash things:? I mean he is just breaking all of the");
                        System.out.println("doors in the station. Why is he trying to kill us all? I know we did some bad things to him but he ");
                        System.out.println("signed up for this. I should probably try to get to the comms room before he destroys all of the");
                        System.out.println("doors. I have already wiped the blueprints from the matter to energy converter so he can't");
                        System.out.println("build any more explosives, it's the most I can do. I should just head to the comms room.");
                        System.out.println("*end of log*");
                    } else if(input.equalsIgnoreCase("2")){
                        System.out.println("med report 3112-jan-31 *female voice* day 1 medical exams are complete, everyone is healthy and fit.");
                        System.out.println("all ten members of the crew, testing can begin at any moment. the full");
                        System.out.println("body restorer seems to be working perfectly. we should");
                        System.out.println("*audio distortion makes the rest impossible to understand.*");
                    } else if(input.equalsIgnoreCase("3")){
                        System.out.println("Communication to federation made by doctor Teal Reene Burrell: because of the declining ");
                        System.out.println("nature of the sanity of our test subject, Stanley Irving Myles, I am requesting an armed ");
                        System.out.println("transport to a psychiatric care ward where he can receive treatment. Thank you for your cooperation.");
                        System.out.println("End of transmission.");
                    } else if(input.equalsIgnoreCase("4")){
                        System.out.println("Emergency recording of biologist Annabel Colin Lac: *wispering* hello I am Annabel Colin Lac ");
                        System.out.println("and I am recording what might be my last words. There are explosions all around and Stanley");
                        System.out.println("*has killed almost everybody, I don't know who still survives and who is dead, the only thing I ");
                        System.out.println("can do is wait for the shuttle and hope he doesn't find me. If anybody find this tablet I want");
                        System.out.println("them to tell my family i have hid my money, wait, IT’S THE SHUTTLE. I AM SAVED. I CAN");
                        System.out.println("GO HO ul shit. *new voice* one more dead, *sound of metal being crushed*");
                        System.out.println("END OF LOG.");
                    } else if(input.equalsIgnoreCase("5")){
                        System.out.println("fedarmy black box_ 3112-aug-31. *male voice* shuttle 341,6954 has docked with space ");
                        System.out.println("station 23,456 and are ready to receive the transport. we have not received any ");
                        System.out.println("communication from the station. wow , this station is a real shit show isn’t it. What is that? ");
                        System.out.println("There is someone waving. Is that someone running up behind them. well looks like the waving ");
                        System.out.println("person is dead, let's get out of here fast. Shit he just threw something at us. *explosion*");
                        System.out.println("*Recording ended, shuttle 341,6954 has been destroyed");
                    } else if(input.equalsIgnoreCase("6")){
                        System.out.println("Log by 2nd engineer Thorburn Dylan Neville: *sound of walking* I better hurry to the shuttle");
                        System.out.println("bay. I think i might have heard the shuttle docking and I want to get there before it leaves.");
                        System.out.println("*explosion* maybe I shouldn't go to the shuttle room. Let’s go the robot room.");
                    } else if(input.equalsIgnoreCase("7")){
                        System.out.println("Captain's log, date 3112-feb-2:  I hate what the federation has become. Ever since we created ");
                        System.out.println("that damned matter to energy converter nothing good has happened. There is basicly no");
                        System.out.println("economy because nobody works because everybody just replicated whatever they wanted. It was fine for awhile");
                        System.out.println("but because the endless ennui of humanity was not satisfied with infinite objects, we decided we wanted power and control over others.");
                        System.out.println("because we couldn’t do this using money we started using weapons, now the only way for the federation to take control is weapons blueprints.");
                        System.out.println("That is our job and we have to do all of our testing on poor Stanley.");
                    } else if(input.equalsIgnoreCase("8")){
                        System.out.println("the test subject has had no negative physical effects from the body regenerator but");
                        System.out.println("dying and coming back to life seems to have taken a huge toll on his mind. As such I have psychoanalyzed Stanley.");
                        System.out.println("He seems to blame us for what has been done to him, it isn't irrational for him to blame us but");
                        System.out.println("when I reminded him of the fact that he signed up he started to harm himself and seemed angry at himself. I won't remind him again.");
                    } else if(input.equalsIgnoreCase("9")){
                        System.out.println("Communication to federation by communications officer Daniella Wilhelmina Kellogg: in the opening week we have managed to test 10 weapons on the subject.");
                        System.out.println("We are currently grading weapons on 3 characteristics that will help us decide what will be the most effective at scaring the masses, deadliness, painfulness, and scariness.");
                        System.out.println("We are looking for a weapon that will be very painful, not kill instantly so people can experience it then be sent back out into the world and tell about how painful it was,");
                        System.out.println(" and a weapon that has effects that are incredibly frightening so it can be used better to threaten.");
                    } else if(input.equalsIgnoreCase("10")){
                        System.out.println("Communication to all by physicist Bernie Fancy Dalton:meyday meyday meyday, this is Bernie Fancy Dalton on space station 23,456 orbiting the 4th planet of the gonjari system.");
                        System.out.println("A member of our crew has lost their mind and become homicidal. The only remaining members of the crew are the captain and I.");
                        System.out.println(" we are about to attempt to kill the dangerous crew member and need evac from the station.");
                    } else if(input.equalsIgnoreCase("11")){
                        System.out.println("Captain’s log date 3112-aug-31: I believe that Bernie and I are the only remaining crew members on the ship,");
                        System.out.println("we have decided to put the ship into red alert and attempt to kill the test subject.");
                        System.out.println("We have sent a distress signal and are hoping a shuttle will come and save us. If we do not survive, tell my wife i always hated her.");
                    } else if(input.equalsIgnoreCase("12")){
                        System.out.println("!!!!!!!!!!!!!!!!!!!!emergency shutdown!!!!!!!!!!!!!!!!!!!! ");
                        System.out.println(" red alert activated, power conduits 1,2,3,4,5 down, unable to receive response from");
                        System.out.println(" com_512maincore. shutting down robots, threat analysis: robots weaponized, activating robots, initiating robot core overload,");
                        System.out.println(" robots=1, fail safe: robot inside, override self destruct, robots=0, ");
                        System.out.println("damage assessment: robot control undamaged. ");
                    } else if(input.equalsIgnoreCase("13")){
                        System.out.println("Log by 2nd engineer Thorburn Dylan Neville: I think I have found refuge from Stanley, I have a large supply of food and can hopefully wait him out.");
                        System.out.println(" *alarm* ");
                        System.out.println("shit, the computer has decided to destroy the robots. hopefully it won't destroy this one that is in for repair.");
                        System.out.println("probably should  try to detach it from the system-");
                        System.out.println("...... ");
                        System.out.println("... it's gone into meltdown already. ");
                        System.out.println("*Explosion*");
                    } else if(input.equalsIgnoreCase("14")){
                        System.out.println("Science log by head scientist Milburn Hollis Cook: I have finally done it! I have created the universe's best weapon for oppressing people, a radiation gun!");
                        System.out.println("It is perfect for all categories, it is the right amount of deadly because i can change the amount of");
                        System.out.println("radiation that it emits to get the perfect result,");
                        System.out.println(" it's painful it levels lasting effects like black nails and cancer which will hurt of the rest of however long the live. It's scary, seeing people affected by radiation is terrifying.");
                    } else if(input.equalsIgnoreCase("15")){
                        System.out.println("Log by 1st engineer Vern Rian Strange: *test subject speaking* I have done it, I have made them suffer, they have felt what i have felt. ");
                        System.out.println(" I told them it’s their fault they signed up for it and killed each of them, ");
                        System.out.println("and for my magnum opus of revenge I used Milburn’s own weapon against him, over a week I slowly made him feel more and more pain using the evil weapon. ");
                        System.out.println("And now that i am done i am destroying the testing chambers and blowing them off of the station. I am done.");
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
                scrap=50;
                fuel=50;
            } else if(input.equalsIgnoreCase("simulate disaster")){
                disasterchance=disasterchance+100;
            } else if(input.equalsIgnoreCase("leave station")){
                if(position==6){
                    if(progress>7){
                        mode=2;
                        System.out.println("You have left the station and are now on the space ship.");
                        System.out.println("On the star map, you are at 3,3");
                        System.out.println("You can use the move function to move around, and the enter station command to go back to the station as long as you are at 3,3.");
                        System.out.println("Additionally, you can chase after the test chamber, which has broken off of the ship, with [  find test room  ].");
                        type=0;
                    } else {
                        System.out.println("You have not fully built the shuttle.");
                        
                    }
                } else {
                    System.out.println("You are not at the shuttlebay.");
                    
                }
                type=0;
            } else if(input.equalsIgnoreCase("getAllCompletion")){
                progress=8;
                fuel=500;
                lng[0]=1;
                lng[1]=1;
                lng[2]=1;
                lng[3]=1;
                lng[4]=1;
                lng[5]=1;
                lng[6]=1;
                lng[7]=1;
                lng[8]=1;
                lng[9]=1;
                lng[10]=1;
                lng[11]=1;
                lng[12]=1;
                ctrlUn=2;
                crqrUn=2;
                mdbyUn=2;
                rbtcUn=2;
                shbyUn=2;
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("end of turn.");
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
                if(forcefield==0){
                System.out.println("A meteor shower has broken some important components and breached the hull! You manage to put on your suit in time, but the repair takes 3 turns and all your energy.");
                food=food-3;
                energy=0;
                if(food<0){
                    food=0;
                }
            } else {
               System.out.println("A meteor shower makes loud noises all across the ship, but you know your forcefield will protect you.");
                
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
            System.out.println("Gained "+reactorlevel + " energy this turn");
            if(input.equalsIgnoreCase("reactor")){
                System.out.println("(+1 bonus from manning reactor)");
                }
        }
        if(rbtcUn!=0){
            if(robots>0){
                System.out.println("Finally, your " + robots + " robots have gathered " + robots*5 + " scrap this turn.");
                scrap=scrap+robots*5;
            }
        }
        System.out.println("--------------------------------------------");
        
    }
    while(mode==2){
        input = sc.nextLine();
        temp2=1;
        if(input.equalsIgnoreCase("move")){
            while(temp2==1){
            System.out.println("In what direction will you go?");
            System.out.println("You are at "+((starmapP-starmapP%10)/10) +","+starmapP%10+" .");
            temp2=0;
            if((starmapP%10)<5){
                System.out.println("#1: To sector " +(starmapP-starmapP%10)/10+","+(starmapP%10+1));
            }
            if((starmapP%10)>1){
                System.out.println("#2: To sector " +(starmapP-starmapP%10)/10+","+(starmapP%10-1));
            }
            if((starmapP-starmapP%10)<50){
                System.out.println("#3: To sector " +(starmapP+10-starmapP%10)/10+","+starmapP%10);
            }
            if((starmapP-starmapP%10)>10){
                System.out.println("#4: To sector " +(starmapP-10-starmapP%10)/10+","+starmapP%10);
            }
            input = sc.nextLine();
            if(input.equalsIgnoreCase("1")){
                starmapP++;
                fuel--;
                food--;
            } else if(input.equalsIgnoreCase("2")){
                starmapP--;
                fuel--;
                food--;
            } else if(input.equalsIgnoreCase("3")){
                starmapP=starmapP+10;
                fuel--;
                food--;
            } else if(input.equalsIgnoreCase("4")){
                starmapP=starmapP-10;
                fuel--;
                food--;
            } else {
                System.out.println("What? that wasn't a correct answer. Where do you want to go?");
                temp2=1;
            }
           }
            
        } else if(input.equalsIgnoreCase("enter station")){
            if(starmapP==33){
                mode=1;
                System.out.println("You are back in the station.");
            } else {
                System.out.println("You need to be at 3,3 to enter the station.");
            }
        } else if(input.equalsIgnoreCase("find test room")){
          if(pThrust==2){
              System.out.println("Are you sure you want to do this? This will end the game. (y/n)");
              input=sc.nextLine();
              if(input.equalsIgnoreCase("y")){
                  System.out.println(" As you land on the cavernous room that once was apart of your space station  you start ");
                  System.out.println("feeling sick to your stomach. As you enter a sense of familiarity hits you like a brick, you feel ");
                  System.out.println("like the whole world is spinning around you.  your tablet picks up two logs. you open the first one:");
                  System.out.println("");
                        System.out.println("Science log by head scientist Milburn Hollis Cook: I have finally done it! I have created the universes best weapon for oppressing people, a radiation gun!");
                        System.out.println("It is perfect for all categories, it is the right amount of deadly because i can change the amount of");
                        System.out.println("radiation that it emits to get the perfect result,");
                        System.out.println(" it's painful it levels lasting effects like black nails and cancer which will hurt of the rest of however long the live. It's scary, seeing people affected by radiation is terrifying.");
                        System.out.println(".... and then the second.");
                        System.out.println("Log by 1st engineer Vern Rian Strange: *test subject speaking* I have done it, I have made them suffer, they have felt what i have felt. ");
                        System.out.println(" I told them it’s their fault they signed up for it and killed each of them, ");
                        System.out.println("and for my magnum opus of revenge I used Milburn’s own weapon against him, over a week I slowly made him feel more and more pain using the evil weapon. ");
                        System.out.println("And now that i am done i am destroying the testing chambers and blowing them off of the station. I am done.");
                        System.out.println("");
                        System.out.println("you feel a strange connection to what the test subject is saying, your head starts pounding. ");
                        System.out.println("you almost fall over but prop yourself against a table. there is a tray of surgical equipment ");
                        System.out.println("siting on the table below you. you see your reflection in the tray, and you simultaneously ");
                        System.out.println("realize why you have no memory of your past life and why you are so bad at repairing and ");
                        System.out.println("building things. you are not an engineer. you are the test subject.");
                        System.exit(0);
                  }
              if(input.equalsIgnoreCase("n")){
                  System.out.println("You will postpone the trip, for now.");
                  temp2=1;
              }
            } else {
                System.out.println("You try to chase after it, but it is going too fast. you will need to find a blueprint for better thrusters somewhere.");
                fuel--;
            }
        } else {
            System.out.println("What? that wasn't a command.");
            temp2=1;
        }
        fuel--;
        if(fuel<6){
            System.out.println("Urgent reminder! You have critical amounts of fuel left!");
            
        }
        if(fuel<0){
            System.out.println("You have ran out of fuel.");
            System.out.println("GAME OVER.");
            health=0;
            mode=0;
        }
        if(food<6){
            System.out.println("You have a very small amount of food left!");
            }
        if(food<0){
            System.out.println("You are starving. (-10 health per turn)");
            health=health-10;
            }
        if(starmapP==11){
            System.out.println("you warp to a quasar, you are lucky that force field technology is so advanced, if you had been here 1 hundred years earlier you would have died. ");
            System.out.println("you gain experience about how fragile life is.");
        }
        if(starmapP==12){
            System.out.println("you warp to a pylon. there is a large obelisk floating in the air, it is so black that it hurts your eyes,");
            System.out.println("it feels like someone is trying to suck your eyes out with a straw. it is excruciating.");
        }
        if(starmapP==13){
            System.out.println("you land on a planet where the only land is a single island, strangely there are people there. ");
            if(visited[0][2]==0){
            System.out.println("they are all very nice and generous. you gain 30 scrap.");
            scrap=scrap+30;
            visited[0][2]=1;
        }
        }
        if(starmapP==14){
            System.out.println("you land on a planet, every thing is on the cob, you flee for your life. you gain an experience about fearing the unknown.");
        }
        if(starmapP==15){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==21){
            System.out.println("you warp inside of  what looks like a giant cave, you see a exit, it turns out you are in a hole planet, it must have been mined out for its resources.");
            if(visited[1][0]==0){
            System.out.println("you gain 20 scraps and 1 robot.");
            robots++;
            scrap=scrap+20;
            visited[1][0]=1;
        }
        }
        if(starmapP==22){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==23){
            System.out.println("you find a nebula, it smells of raspberries and tastes of rum, you feel happy. you gain a happy experience.");
        }
        if(starmapP==24){
            System.out.println("this beacon is inside a large trap. you start to panic. you scan the cage and learn that it has been abandoned. ");
            if(visited[1][3]==0){
            System.out.println("you warp away gaining 13 scrap.");
            scrap=scrap+13;
            visited[1][3]=1;
        }
        }
        if(starmapP==25){
            System.out.println("you jump to a beacon, it is very near a black hole. you jump away as quick as possible but you still lose 1 year, your generator is now level 1.");
            reactorlevel=1;
        }
        if(starmapP==31){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==32){
            System.out.println("you end up in a normal sector. there is a planet here that is densely populated. wait , you just did a scan, it use to be densely populated.");
            if(visited[2][1]==0){
            System.out.println(" you gain 20 scrap.");
            visited[2][1]=1;
            scrap=scrap+20;
        }
        }
        if(starmapP==33){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==34){
            System.out.println("you find automated gas beacon. ");
            if(visited[2][3]==0){
            System.out.println("It is in disrepair and you manage to just take fuel from it, you gain 10 fuel.");
            fuel=fuel+10;
            visited[2][3]=1;
        }
        }
        if(starmapP==35){
            System.out.println("you warp to a pylon. the planet near it has a utopia, they used the matter to energy converters correctly, there is lots of food, wine and lots of time to relax.");
            if(visited[2][4]==0){
            System.out.println("You gain 50 food.");
            food=food+50;
            visited[2][4]=1;
        }
        }
        if(starmapP==41){
            System.out.println("you find a planet that seems to be at a low level of development, around the level of ancient rome. you fly in and they think you are a god.");
            if(visited[3][0]==0){
            System.out.println("They give you 100 scrap.");
            visited[3][0]=1;
            scrap=scrap+100;
        }
        }
        if(starmapP==42){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==43){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==44){
            System.out.println("there is no planets near this warp, no stars, nothing but infinite blackness. you gain an experience of how desolate the universe is.");
        }
        if(starmapP==45){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==51){
            System.out.println("you jump to a planet made completely of carbon, there are lots of diamonds here and there is an abandoned mining complex here. ");
            if(visited[4][0]==0){
            System.out.println("You gain 10 scrap and 3 large parts.");
            scrap=scrap+10;
            lP=lP+3;
            visited[4][0]=1;
        }
        }
        if(starmapP==52){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==53){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==54){
            System.out.println("There is nothing in this sector.");
        }
        if(starmapP==55){
            System.out.println("You find an abandoned space truck shop. You gain 5 fuel.");
            if(visited[4][4]==0){
            fuel=fuel+5;
            visited[4][4]=1;
        }
            if(pThrust==0){
                System.out.println("In addition, you find a blueprint for better thrusters!");
                pThrust=1;
            }
        }
        System.out.println("You have " + fuel + " Units of fuel left.");
        System.out.println("You have " +food+ " turns of food left.");
        }
}
}
   
}
