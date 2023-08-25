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
		 String notification = "idsonda=" + probe.getId() + "&lat=" + probe.getLatitude() + "&lon=" + probe.getLongitude() + "&smokelevel=" + probe.getSmokeLevel();
	     communicationStrategy.sendNotification(notification);
	}

}
