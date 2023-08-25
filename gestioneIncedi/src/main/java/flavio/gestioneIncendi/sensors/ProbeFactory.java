package flavio.gestioneIncendi.sensors;

//Factory per creare le sonde
public interface ProbeFactory {
	Probe createProbe(int id, double latitude, double longitude);
}
