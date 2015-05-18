package benchmark.cpu;

public class Prime implements IBenchmark {
	private long Sum;
	private int L;
	private long n;
	private long c;
	private int i;

	public boolean isPrime(long k) {
		for (int j = 2; j <= Math.sqrt(k) && j % 2 != 0 && j % 3 != 0
				&& j % 5 != 0; j++)
			if (k % j == 0)
				return false;

		return true;
	}

	public void reachCount(long k) throws StackOverflowError { // k starts as 2
		try {
			// System.out.println("reach count");
			if (k <= n) {
				i = 0;
				k = findNextLPrimes(k, i);

				c++;
				// System.out.println(c + "\n");
				reachCount(k);
			}
		} catch (StackOverflowError e) {
			c++;
			// System.out.println(c + "\n");
		}
	}

	public long findNextLPrimes(long k, int i) {

		if (k < n && i < L) {
			if (isPrime(k) == true) {
				Sum += k;
				i++;
			}
			k++;
			findNextLPrimes(k, i);
		}

		return k;
	}

	public long getCount() {
		// System.out.println("here" + c);
		return c;
	}

	public long getSum() {
		return Sum;
	}

	public void run() {
		reachCount(2);

	}

	public void run(Object param) {
		this.L = (Integer) param;
		reachCount(2);

	}

	public void clean() {
		Sum = 0;
		L = 0;
		c = 0;
	}

	public void warmup() {
		run();
	}

	public void initialize() {

	}

	@Override
	public void initialize(int size) {
		this.n = size;
		// System.out.println("initialize"+ n);

	}

	@Override
	public void warmUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
}
