package flavio.gestioneIncendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import flavio.gestioneIncendi.sensors.ConcreteProbeFactory;
import flavio.gestioneIncendi.sensors.Probe;
import flavio.gestioneIncendi.sensors.ProbeFactory;

@SpringBootApplication
public class GestioneIncedi1Application {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncedi1Application.class, args);
		
		ProbeFactory factory = new ConcreteProbeFactory(null);
		
		Probe probe2 = factory.createProbe(2, 40.7128, -74.0060);
		Probe probe7 = factory.createProbe(7, 24.7801, 20.0032);
		Probe probe13 = factory.createProbe(13, 33.9931, 77.4298);
		
		System.out.println();
		probe2.setSmokeLevel(6);
		
		System.out.println();
		probe7.setSmokeLevel(9);
		
		System.out.println();
		probe13.setSmokeLevel(3);
	}

}
