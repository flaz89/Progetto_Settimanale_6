package flavio.gestioneIncendi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import flavio.gestioneIncendi.sensors.FireAlarmListener;
import flavio.gestioneIncendi.sensors.Probe;

@SpringBootTest
class GestioneIncedi1ApplicationTests {
	
	// test che verifica se i sensori rispondono all'elevata quantità di fumo
	@Test
    void testSmokeLevelAboveThreshold() {
        Probe probe = new Probe(4, 40.7128, -74.0060);
        FireAlarmListener_Test listener = new FireAlarmListener_Test();
        probe.addListener(listener);

        probe.setSmokeLevel(7);

        assertTrue(listener.isFireAlarmTriggered());
    }
	
	
	// test che verifica se i sensori rispondono alla bassa quantità di fumo
	@Test
    void testSmokeLevelBelowThreshold() {
        Probe probe = new Probe(1, 41.8781, -87.6298);
        FireAlarmListener_Test listener = new FireAlarmListener_Test();
        probe.addListener(listener);

        probe.setSmokeLevel(3);

        assertFalse(listener.isFireAlarmTriggered());
    }
	
	
	// test che notifica correttamente la strategia di comunicazione quando viene rilevato un allarme
	@Test
    void testOnFireAlarmNotification() {
        CommunicationStrategy mockCommunicationStrategy = mock(CommunicationStrategy.class);
        ControlCenter controlCenter = new ControlCenter(mockCommunicationStrategy);

        Probe probe = new Probe(3, 35.6895, 139.6917);
        controlCenter.onFireAlarm(probe);

        verify(mockCommunicationStrategy, times(1)).sendNotification(anyString());
    }
	
	
//	// test che verifica se la factory crea correttamente una sonda e se aggiunge un listener alla sonda.
//	@Test
//    void testCreateProbe() {
//        FireAlarmListener mockCommunicationStrategy = mock(FireAlarmListener.class);
//        ConcreteProbeFactory factory = new ConcreteProbeFactory(mockCommunicationStrategy);
//
//        Probe probe = factory.createProbe(17, 37.7749, -122.4194);
//
//        assertNotNull(probe);
//        assertEquals(17, probe.getId());
//        
//        boolean hasCommunicationStrategy = false;
//        for (FireAlarmListener listener : probe.getListeners()) {
//            if (listener instanceof CommunicationStrategy) {
//                hasCommunicationStrategy = true;
//                break;
//            }
//        }
//        assertTrue(hasCommunicationStrategy, "CommunicationStrategy listener not added");
//    }

}
