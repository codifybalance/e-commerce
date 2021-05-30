package eticaret.core;

import eticaret.Google.GoogleManager;

public class GoogleManagerAdapter implements GoogleService{

	@Override
	public void registerToSystem(String message) {
		GoogleManager manager = new GoogleManager();
		manager.authentication(message);
	}

}
