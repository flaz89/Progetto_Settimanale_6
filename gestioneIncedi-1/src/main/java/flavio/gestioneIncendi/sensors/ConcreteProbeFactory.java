package flavio.gestioneIncendi.sensors;

import flavio.gestioneIncendi.notifications.CommunicationStrategy;
import flavio.gestioneIncendi.notifications.HttpCommunicationStrategy;
import flavio.gestioneIncendi.notifications.NotificationProxy;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConcreteProbeFactory implements ProbeFactory {
	CommunicationStrategy communicationStrategy;

	@Override
	public Probe createProbe(int id, double latitude, double longitude) {
		// TODO Auto-generated method stub
		Probe probe = new Probe(id, latitude, longitude);
        ControlCenter controlCenter = new ControlCenter(new NotificationProxy(new HttpCommunicationStrategy("http://host")));
        probe.addListener(controlCenter);
        return probe;
	}

}
