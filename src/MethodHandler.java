import java.util.HashMap;
import java.util.Map;

import sun.jvm.hotspot.runtime.ConcurrentLocksPrinter;

public interface MethodHandler {
	void interfaceMethod(int userId);
}

class MethodHandlerImp implements MethodHandler{
	private final Map<Integer, Pair<Integer, Long>> userIdStorage = new  HashMap<>();
	private final int MAX_LOGIN_ATTEMPTS = 5;
	private final int MAX_LOGIN_TIMER_MS = 1000;
	
	private final boolean isAccessTimerOut(int userId) {
		long currentTime = System.currentTimeMillis();
		Pair<Integer, Long> tmpPair = userIdStorage.get(userId);
		
		return currentTime - tmpPair.getAccessTime() > MAX_LOGIN_TIMER_MS;
	}
	
	private final boolean isAccessAttemptsOut(int userId) {
		Pair<Integer, Long> tmpPair = userIdStorage.get(userId);
		
		return tmpPair.getAccessAttempts() > MAX_LOGIN_ATTEMPTS;
	}
	
	@Override
	public void interfaceMethod(int userId) {
		
		long loginTime = System.currentTimeMillis();
		
		Pair<Integer, Long> userData = userIdStorage.getOrDefault(userId, new Pair<>(0, loginTime));
		userIdStorage.put(userId, userData);
		
		int tmpAttemptNumber = userData.getAccessAttempts();
		tmpAttemptNumber++;
		userData.setAccessAttempts(tmpAttemptNumber);
		
		if(!isAccessTimerOut(userId) && isAccessAttemptsOut(userId)){
			System.out.println("User with id: " + userId + " access denied");
			return;
		}
		
		if(isAccessTimerOut(userId)) {
			userIdStorage.get(userId).setAccessTime(System.currentTimeMillis());
			userIdStorage.get(userId).setAccessAttempts(1);
		}
		System.out.println("User with id: " + userId + " access allowed");
	}
}
