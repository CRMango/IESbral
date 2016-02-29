//
//
//


public class Resources{
        
    static int health,food,energy,sP,mP,lP,sB,mB,lB,sPak,scrap,tool,robots;
    static int logs;
    
    
    public Resources(){

        health=100;
        energy=1;
        sP=0;mP=0;lP=0;sB=0;mB=0;lB=0;sPak=1;scrap=0;
        logs=0;
        tool=0;
        food=20;
        robots=0;

        }
    public void transaction(int a,int b){
        
        if(a==1){
            health=health+b;
        } else if (a==2){
            energy=energy+b;
        } else if (a==3){
            scrap=scrap+b;
        } else if (a==4){
            sP=sP+b;
        } else if (a==5){
            mP=mP+b;
        } else if (a==6){
            lP=lP+b;
        } else if (a==7){
            sB=sB+b;
        } else if (a==8){
            mB=mB+b;
        } else if (a==9){
            lB=lB+b;
        } else if (a==10){
            sPak=sPak+b;
        } else {
            food=food+b;
        }
        }

    public void check(){
        System.out.println("Health: "+health+"   Energy: "+energy);
        System.out.println("Small/Medium/Large parts:  " + sP + "/" + mP + "/" + lP);
        System.out.println("Logs: " +logs);
        System.out.println("Extended inventory:");
        if(tool==1){
            System.out.println("ME-32P Wrench");
        } else {
            System.out.println("Nothing.");
}       if(robots>1){
            System.out.println("Robots: "+robots);
}
}


}