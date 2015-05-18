package Timing;

public class Timer implements ITimer {
	private long startTime;
	private long storedTime;
	private boolean isON = false;
	private boolean isPaused = false;

	public void start() {
		if (isON) {
			return;
		}

		isON = true;
		isPaused = false;

		storedTime = 0;
		startTime = System.nanoTime();
		return;
	}

	public long pause() {
		if (!isON || isPaused) {
			return 0;
		}
		isPaused = true;

		storedTime += System.nanoTime() - startTime;

		return storedTime;
	}

	public long stop() {
		if (!isON) {
			return 0;
		}
		isON = false;

		storedTime += System.nanoTime() - startTime;
		return storedTime;
	}

	public void resume() {
		if (!isPaused || !isON) {
			return;
		}

		isPaused = false;
		startTime = System.nanoTime();
	}

}
