package flavio.gestioneIncendi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import flavio.gestioneIncendi.sensors.Probe;

public class Probe_Test {
	
	@Test
    void testSmokeLevelAboveThreshold() {
        Probe sonda = new Probe(4, 40.7128, -74.0060);
        FireAlarmListenere_Test listener = new FireAlarmListenere_Test();
        sonda.addListener(listener);

        sonda.setSmokeLevel(7);

        assertTrue(listener.isFireAlarmTriggered());
    }
	
	@Test
    void testSmokeLevelBelowThreshold() {
        Probe sonda = new Probe(1, 41.8781, -87.6298);
        FireAlarmListenere_Test listener = new FireAlarmListenere_Test();
        sonda.addListener(listener);

        sonda.setSmokeLevel(3);

        assertFalse(listener.isFireAlarmTriggered());
    }
}
