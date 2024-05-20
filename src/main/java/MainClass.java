package main.java;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
//		ThreadOne thread1 = new ThreadOne();
//		ThreadTwo thread2 = new ThreadTwo();
//		thread1.start();
//		thread2.show();
//		int a = 5;
//		int b = 6;
//		System.out.println(sum(5,6));
		
		/*
		 * Race condition in thread
		 */
		Runnable runObj1 = ()->{
			for(int i=0;i<5000;i++) {
				increment();
			}
		};
		Runnable runObj2 = ()->{
			for(int i=0;i<5000;i++) {
				increment();
			}
		};
		
		Thread t1 = new Thread(runObj1);
		Thread t2 = new Thread(runObj2);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("count - "+count);
	}
	
	static int count;
	public synchronized static void increment() {
		count++;
	}
	
	public static int sum(int a, int b) {
		System.out.println("in int");
		return a+b;
	}
	
	public static long sum(long a, long b) {
		System.out.println("in long");
		return a+b;
	}
	
	public static int sum(short a, short b) {
		System.out.println("in short");
		return (short) a+b;
	}

}
