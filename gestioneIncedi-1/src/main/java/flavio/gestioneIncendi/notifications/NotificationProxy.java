package flavio.gestioneIncendi.notifications;

public class NotificationProxy implements CommunicationStrategy {
	
	private CommunicationStrategy strategy;
	
	public NotificationProxy(CommunicationStrategy strategy) {
        this.strategy = strategy;
    }
	
	@Override
	public void sendNotification(String notification) {
		// TODO Auto-generated method stub
		strategy.sendNotification(notification);
	}

}
