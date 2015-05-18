package bench.hdd;

import java.io.IOException;

public class HDDReadSpeed implements IBenchmark {
	public void run() {
		FileReader reader = new FileReader();

		try {
			reader.compareWithBufferSize("C:\\example\\write-8.dat",
					"C:\\example\\write-8.dat", 4 * 1024 * 1024);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run(Object option) {
	}

	public void clean() {
	}

	public void run(int size) {
	}

	public void initialize() {
	}

	@Override
	public void initialize(int size) {
		// TODO Auto-generated method stub

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