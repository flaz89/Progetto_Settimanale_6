package flavio.gestioneIncendi;

import flavio.gestioneIncendi.sensors.FireAlarmListener;
import flavio.gestioneIncendi.sensors.Probe;

public class FireAlarmListenere_Test implements FireAlarmListener {
	
	private boolean fireAlarmTriggered = false;
	
	@Override
	public void onFireAlarm(Probe probe) {
		// TODO Auto-generated method stub
		fireAlarmTriggered = true;
	}
	
	public boolean isFireAlarmTriggered() {
        return fireAlarmTriggered;
    }

}
