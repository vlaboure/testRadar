package fr.projetRadar;

import java.util.TimerTask;

public class RemindTask extends TimerTask{
	private Vehicule[] vehicules;
	private Radar radar;
	private static int i=0;
	
    public RemindTask(Vehicule[] vehicules, Radar radar) {
    	this.vehicules = vehicules;
    	this.radar = radar;
    	System.out.println("Trouver la touche...\n");
    	System.out.println("tapez une touche");
    	//run();
    }
    
    @Override
    public void run() {
    		//Timer timer2 = new Timer();
    		i++;
    		System.out.println("Bravo !!!");
    		for(Vehicule vehicule: vehicules) {
        		radar.flasher(vehicule);    
        		try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		if(i == 5) {
    			System.exit(0);
   			}

 
    }
}

