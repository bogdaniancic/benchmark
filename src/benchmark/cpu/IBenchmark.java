package benchmark.cpu;

public interface IBenchmark {
	/**
	 * Name: run Parameters: - input: none - output: none Output: - none
	 * Description - run benchmark
	 */
	void run();

	/**
	 * Name: run Parameters: - input: object - output: none Output: - none
	 * Description - run benchmark - has parameter
	 */
	void run(Object param);

	/**
	 * Name: initialize Parameters: - input: none - output: none Output: - none
	 * Description -
	 */
	void initialize();

	/**
	 * Name: clean Parameters: - input: none - output: none Output: - none
	 * Description -
	 */
	void clean();

	void initialize(int size);

	void warmUp();

	String getResult();

}
