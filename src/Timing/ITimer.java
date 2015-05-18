package Timing;

public interface ITimer {
	/**
	 * Name: start Parameters: - input: none - output: none Output: - none
	 * Description - method that starts the timer
	 */
	void start();

	/**
	 * Name: pause Parameters: - input: none - output: none Output: - long
	 * Description - method that pauses the timer and returns the time
	 */
	long pause();

	/**
	 * Name: stop Parameters: - input: none - output: none Output: - long
	 * Description - method that stops the timer and returns the time
	 */
	long stop();

	/**
	 * Name: resume Parameters: - input: none - output: none Output: - none
	 * Description - method that resumes the timer
	 */
	void resume();
}
