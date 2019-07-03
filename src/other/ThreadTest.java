package other;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

	private static Integer n1 = 0;

	private static Integer n2 = 0;

	private static Integer n3 = 0;

	private static AtomicInteger integer1 = new AtomicInteger();

	private static Lock lock = new ReentrantLock();

	private static Object obj = new Object();

	public static void main(String[] args) throws InterruptedException {
		final int[] a = { 0 };

		for (int i = 0; i < 1000; i++) {
			new Thread() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					a[0]++;
					synchronized (obj) {
						n1++;
					}

					lock.lock();
					n2++;
					lock.unlock();

					n3++;
					integer1.getAndIncrement();
				}
			}.start();
		}

		Thread.sleep(5000);

		System.out.println("a:" + a[0]);
		System.out.println("n1:" + n1);
		System.out.println("n2:" + n2);
		System.out.println("n3:" + n3);
		System.out.println("integer:" + integer1.get());
	}
}
