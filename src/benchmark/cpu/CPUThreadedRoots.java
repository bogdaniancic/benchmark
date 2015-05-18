package benchmark.cpu;

public class CPUThreadedRoots implements IBenchmark {

	private double result;

	public void initialize(int size) {
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException(
				"Method not implemented. Use run(Object) instead");
	}

	@Override
	public void run(Object option) {
		Integer[] param = (Integer[]) option;
		int nThreads = param[1];

		// param1 = size (n)
		// param2 = number of threads

		Thread[] threads = new Thread[nThreads];

		// e.g. 1 to 10,000 on 4 threads = 2500 jobs per thread
		final int jobPerThread = param[0] / param[1]; /**/

		// create a thread for each runnable and start it
		for (int i = 0; i < nThreads; ++i) {
			SquareRootTask p = new SquareRootTask(i * jobPerThread, (i + 1)
					* jobPerThread - 1);
			threads[i] = new Thread(p);
			threads[i].start();
		}
		// join threads
		for (int i = 0; i < nThreads; ++i) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void clean() {
		// only implement if needed
	}

	public String getResult() {
		return String.valueOf(result);
	}

	class SquareRootTask implements Runnable {

		private int from, to;

		public SquareRootTask(int from, int to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public void run() {
			// compute Newtonian square root on each number from 'from' to 'to'
			for (int i = from; i <= to; i++)
				result = getNewtonian(i);
		}

		private double getNewtonian(double x) {
			double EPSILON = 1e-4; // 1e-5 not enough -> sqrt(1) won't be
									// computed properly
			double s = x;

			while (Math.abs(s * s - x) > EPSILON)
				s = (x / s + s) / 2;

			return s;
		}

	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void warmUp() {
		// TODO Auto-generated method stub

	}
}
