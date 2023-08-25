package flavio.gestioneIncendi.sensors;

import flavio.gestioneIncendi.notifications.HttpCommunicationStrategy;
import flavio.gestioneIncendi.notifications.NotificationProxy;

public class ConcreteProbeFactory implements ProbeFactory {

	@Override
	public Probe createProbe(int id, double latitude, double longitude) {
		// TODO Auto-generated method stub
		Probe probe = new Probe(id, latitude, longitude);
        ControlCenter controlCenter = new ControlCenter(new NotificationProxy(new HttpCommunicationStrategy("http://host")));
        probe.addListener(controlCenter);
        return probe;
	}

}
