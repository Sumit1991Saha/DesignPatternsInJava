package singleton.headfirst.dcl;

public class SingletonClient {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton);
		System.out.println(singleton);
	}
}
