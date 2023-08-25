package flavio.gestioneIncendi.sensors;

import flavio.gestioneIncendi.notifications.CommunicationStrategy;

// Observer che riceve notifiche di allarme
public class ControlCenter implements FireAlarmListener {
	
	private CommunicationStrategy communicationStrategy;
	
	public ControlCenter(CommunicationStrategy _communicationStrategy) {
        this.communicationStrategy = _communicationStrategy;
    }
	
	@Override
	public void onFireAlarm(Probe probe) {
		// TODO Auto-generated method stub
		 String notification = "\nid sonda = " + probe.getId() + "\nlatitude = " + probe.getLatitude() + "\nlongitude = " + probe.getLongitude() + "\nsmoke level = " + probe.getSmokeLevel();
	     communicationStrategy.sendNotification(notification);
	}

}
