
public class Pair<FIRST, SECOND> {
	public FIRST accessAttempts;
	public SECOND firstAccessTime;
	
	public Pair(FIRST accessAttempts, SECOND firstAccessTime) {
		assert accessAttempts != null;
		assert firstAccessTime != null;
		
		this.accessAttempts = accessAttempts;
		this.firstAccessTime = firstAccessTime;
	}
	
	public void setAccessAttempts(FIRST accessAttempts) {this.accessAttempts = accessAttempts;}
	public void setAccessTime(SECOND firstAccessTime) {this.firstAccessTime = firstAccessTime;}
	public final FIRST getAccessAttempts() {return accessAttempts;}
	public final SECOND getAccessTime() {return firstAccessTime;}
}
