// 
// Limit access to method not more than 5 times in a minute per user
//

public class Main {
	public static void main(String[] args) throws InterruptedException {
		//singleUserTenAttemptesFiveSuccessFiveFail();
		//singleUserTwentyAttemptesTenSuccessTenFail();
		multipleUserstwentyAttempts();
	}
	
	public static void singleUserTenAttemptesFiveSuccessFiveFail() throws InterruptedException{
		MethodHandler mh = new MethodHandlerImp();
		
		for(int i = 1; i <= 10; ++i){
			long loginTime = System.currentTimeMillis();
			Thread.sleep(50);
			mh.interfaceMethod(1, loginTime);
			System.out.println(i + " times");
		}	
	}
	
	public static void singleUserTwentyAttemptesTenSuccessTenFail() throws InterruptedException{
		MethodHandler mh = new MethodHandlerImp();
		
		for(int i = 1; i <= 20; ++i){
			long LoginTime = System.currentTimeMillis();
			Thread.sleep(50);
			mh.interfaceMethod(1, LoginTime);
			System.out.println(i + " times");
		}	
	}
	
	public static void multipleUserstwentyAttempts() throws InterruptedException {
		MethodHandler mh = new MethodHandlerImp();
		
		for(int i = 1; i <= 20; ++i){
			long LoginTimeFirstUser = System.currentTimeMillis();
			Thread.sleep(50);
			mh.interfaceMethod(1, LoginTimeFirstUser);
			
			long LoginTimeSecondUser = System.currentTimeMillis();
			Thread.sleep(75);
			mh.interfaceMethod(2, LoginTimeSecondUser);
			
			long LoginTimeThirdUser = System.currentTimeMillis();
			Thread.sleep(100);
			mh.interfaceMethod(3, LoginTimeThirdUser);
			//System.out.println(i + " times");
		}	
	}
}

