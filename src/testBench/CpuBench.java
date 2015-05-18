package testBench;

import benchmark.cpu.CPUDigitsOfPi;
import benchmark.cpu.CPUThreadedRoots;
import benchmark.cpu.FxAlu;
import benchmark.cpu.Prime;
import Timing.Timer;

public class CpuBench {
	private static Timer t = new Timer();
	private static CPUDigitsOfPi b = new CPUDigitsOfPi();
	private static FxAlu f = new FxAlu();
	private static CPUThreadedRoots thrRoot = new CPUThreadedRoots();
	private static giveProcessorMark mark = new giveProcessorMark();

	public void CpuBenchmark() throws InterruptedException {
		int prime = PrimeTest();
		int thread = ThreadsTest();
		int pi = PiTest();
		int fx = FxAlu();

		// System.out.println("thread: " + thread + "  prime: " + prime +
		// " fx: "
		// + fx + " pi: " + pi);
		int score = (thread + prime + fx + pi) / 4;
		System.out.println("your processor score is: " + score);

		giveProcessorMark.giveMark(prime, thread, pi, fx, score);

	}

	/*
	 * cpu benchmark to find the first n prime numbers does an initial warm up (
	 * for the rest of the operation a warm up would be pointless (the processor
	 * is already working\ at a good level
	 */
	public static int PrimeTest() {

		Prime prime = new Prime();
		int[] L = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 }; // from 1 to
																	// 1024
																	// prime
																	// numbers
		long[] c = new long[11];
		long[] time = new long[11];

		prime.initialize(1000000000);
		prime.warmup(); // does the warmup

		for (int i = 0; i < L.length; i++) {
			t.start();
			prime.run(L[i]);
			time[i] = t.stop();

			c[i] = prime.getCount(); // remembers the crash points
			prime.clean();
		}

		float Sum = 0;

		for (int i = 0; i < c.length; i++) {
			Sum = ((c[i] / L[i]) * (float) 1 / ((float) time[i]) * 1000000000);
		}

		return mark.giveMarkPrime(Sum);

	}

	/*
	 * computes the test for threads it tests for 1 , 2, 4 and 8 threads
	 */
	public static int ThreadsTest() throws InterruptedException {
		Integer[] obj = { 10000, 1 };
		long a = 0, b = 0, c = 0, d = 0;

		t.start(); // starts the timer
		thrRoot.run(obj);
		a = t.stop(); // remembers when the timer stoped

		Integer[] obj2 = { 10000, 2 };
		t.start();
		thrRoot.run(obj2);
		b = t.stop();

		Integer[] obj3 = { 10000, 4 };
		t.start();
		thrRoot.run(obj3);
		c = t.stop();

		Integer[] obj4 = { 10000, 8 };
		t.start();
		thrRoot.run(obj4);
		d = t.stop();

		/*
		 * computes the score taking into account the values for 1, 2, 4 and 8
		 */
		return mark.getThreadMark(a, b, c, d);
	}

	/*
	 * it checks to see how the processor reacts to arithmetics operations and
	 * for several loops taking into account the score for the two arithmetics
	 * it generates a overall score
	 */
	public static int FxAlu() {
		t.start();
		f.run1(); // make first set of operations (arithmetics)
		long first = t.stop(); // get time

		int op1 = f.operationsArithmetics();
		int loop1 = f.loopsArithmetics();
		int i = (int) (op1 * loop1 / (first / 1000));

		int a = mark.printTimefx1(i);

		t.start();
		f.run2();
		long second = t.stop();

		int op2 = f.operationsArrays();
		int loop2 = f.loopsArrays();

		int j = (int) (op2 * loop2 / (second / 1000));
		int b = mark.printTimefx2(j);

		return mark.fxAluMark(a, b);
	}

	/*
	 * computes up to the first 10000 digits of pi has steps at 50 100 500 1000
	 * 2500 5000 10000 makes a sum using the times obtained from the steps the
	 * sum is used to give a general mark for the processor
	 */
	public static int PiTest() {
		int[] k = { 50, 100, 500, 1000, 2500, 5000, 10000 };
		int Sum = 0;

		t.start();
		t.pause();
		for (int i = 0; i < k.length; i++) {
			b.initialize(k[i]);
			t.resume();
			b.run();
			Sum += t.pause() / 1000000;
		}
		t.stop();

		return mark.giveMarkPi(Sum);

	}
}
