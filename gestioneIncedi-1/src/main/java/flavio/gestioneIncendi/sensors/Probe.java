package flavio.gestioneIncendi.sensors;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Probe {
	
	private int id;
	private double latitude;
	private double longitude;
	private int smokeLevel;
	private List<FireAlarmListener> listeners = new ArrayList<>();
	
	public Probe(int _id, double _lat, double _long) {
		this.id = _id;
        this.latitude = _lat;
        this.longitude = _long;
	}
	
	// Metodo per aggiungere ascoltatori (Observer) che verranno notificati in caso di allarme
	public void addListener(FireAlarmListener listener) {
        listeners.add(listener);
    }
	
	public void setSmokeLevel(int smokeLevel) {
        this.smokeLevel = smokeLevel;
        if (smokeLevel > 5) {
            notifyListeners();  // Se il livello di fumo è alto, notifica gli ascoltatori
        } else {
        	System.out.println("probe = id[" + getId() + "] * Avarage smoke levels accepted [OK] * ");
        }
    }
	
	// Metodo per allertare gli ascoltatori in caso di allarme
	private void notifyListeners() {
        for (FireAlarmListener listener : listeners) {
            listener.onFireAlarm(this);
        }
    }
}
