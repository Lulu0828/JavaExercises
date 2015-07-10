package com.xylu.exercises;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {

	public static void main(String[] args) {

		Thread thread1 = new Thread(new MyThread(1));
		Thread thread2 = new Thread(new MyThread(2));

		thread1.start();
		thread2.start();

	}

}

class MyThread implements Runnable {

	private int m;
	private int n = 0;
	private Lock lock = new ReentrantLock();
	private int num = 1;
	private char c = 'a';

	Condition con1 = lock.newCondition();
	Condition con2 = lock.newCondition();

	MyThread(int m) {
		this.m = m;
	}

	@Override
	public void run() {

		try {
			while (true) {
				if (m == 1) {
					fun1();
					m = 2;
				} else {
					fun2();
					m = 1;
				}
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 打印数字
	private void fun2() {

		lock.lock();
		try {
			while (n != 1) {
				con2.await();
			}

			System.out.println(num++);

			n = 0;
			con1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	// 打印字母
	private void fun1() {

		lock.lock();
		try {

			while (n != 0) {
				con1.await();
			}

			System.out.print(c++);
			if (c == '{') {
				c = 'a';
			}

			n = 1;
			con2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}