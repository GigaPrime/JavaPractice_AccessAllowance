// 
// Limit access to method not more than 5 times in a second per user
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
			mh.interfaceMethod(1);
			System.out.println(i + " times");
			Thread.sleep(50);
		}	
	}
	
	public static void singleUserTwentyAttemptesTenSuccessTenFail() throws InterruptedException{
		MethodHandler mh = new MethodHandlerImp();
		
		for(int i = 1; i <= 20; ++i){
			mh.interfaceMethod(1);
			System.out.println(i + " times");
			Thread.sleep(50);
		}	
	}
	
	public static void multipleUserstwentyAttempts() throws InterruptedException {
		MethodHandler mh = new MethodHandlerImp();
		
		for(int i = 1; i <= 20; ++i){
			mh.interfaceMethod(1);
			mh.interfaceMethod(2);
			mh.interfaceMethod(3);
			Thread.sleep(100);
		}	
	}
}

