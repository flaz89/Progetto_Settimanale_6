package flavio.gestioneIncendi.notifications;

import lombok.Getter;

@Getter
public class HttpCommunicationStrategy implements CommunicationStrategy {
	
	private String host;
	
	public HttpCommunicationStrategy(String host) {
        this.host = host;
    }

	@Override
	public void sendNotification(String notification) {
		// TODO Auto-generated method stub
		System.out.println("[* WARNING *] smoke levels too high: " + notification);
		// Qui sarebbe da implementare il codice per effettuare la chiamata HTTP reale
	}

}
