package flavio.gestioneIncendi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import flavio.gestioneIncendi.notifications.CommunicationStrategy;
import flavio.gestioneIncendi.sensors.ConcreteProbeFactory;
import flavio.gestioneIncendi.sensors.ControlCenter;
import flavio.gestioneIncendi.sensors.Probe;

@SpringBootTest
class GestioneIncedi1ApplicationTests {
	
	// test che verifica se i sensori rispondono all'elevata quantità di fumo
	@Test
    void testSmokeLevelAboveThreshold() throws Exception {
        Probe probe = new Probe(4, 40.7128, -74.0060);
        FireAlarmListener_Test listener = new FireAlarmListener_Test();
        probe.addListener(listener);

        probe.setSmokeLevel(7);

        assertTrue(listener.isFireAlarmTriggered());
    }
	
	
	// test che verifica se i sensori rispondono alla bassa quantità di fumo
	@Test
    void testSmokeLevelBelowThreshold() throws Exception {
        Probe probe = new Probe(1, 41.8781, -87.6298);
        FireAlarmListener_Test listener = new FireAlarmListener_Test();
        probe.addListener(listener);

        probe.setSmokeLevel(3);

        assertFalse(listener.isFireAlarmTriggered());
    }
	
	
	// test che notifica correttamente la strategia di comunicazione quando viene rilevato un allarme
	@Test
    void testOnFireAlarmNotification() throws Exception {
        CommunicationStrategy mockCommunicationStrategy = mock(CommunicationStrategy.class);
        ControlCenter controlCenter = new ControlCenter(mockCommunicationStrategy);

        Probe probe = new Probe(3, 35.6895, 139.6917);
        controlCenter.onFireAlarm(probe);

        verify(mockCommunicationStrategy, times(1)).sendNotification(anyString());
    }
	
	// Test che verifica che la sonda non venga creata con valori di latitudine o longitudine non validi.
	@Test
	void testInvalidCoordinates() throws Exception {
		CommunicationStrategy mockCommunicationStrategy = mock(CommunicationStrategy.class);
	    ConcreteProbeFactory factory = new ConcreteProbeFactory(mockCommunicationStrategy);

	    assertThrows(IllegalArgumentException.class, () -> factory.createProbe(17, 91.0, 0.0));
	    assertThrows(IllegalArgumentException.class, () -> factory.createProbe(17, 0.0, 181.0));
	}

}
