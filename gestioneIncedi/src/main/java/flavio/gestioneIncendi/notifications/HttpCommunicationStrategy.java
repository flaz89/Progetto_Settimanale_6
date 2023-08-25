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
		System.out.println("Sending HTTP notification: " + notification);
	}

}
