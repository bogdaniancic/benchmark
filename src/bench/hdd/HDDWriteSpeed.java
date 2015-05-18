package bench.hdd;

import java.io.IOException;
import benchmark.cpu.IBenchmark;

public class HDDWriteSpeed implements IBenchmark {

	public void initialize(int size) {
	}

	public void run() {
		FileWriter writer = new FileWriter();
		try {
			writer.streamWriteFixedBuffer("C:\\example\\write-", ".dat", 0, 10,
					4 * 1024);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run(Object option) {
	}

	public void clean() {
	}

	public String getResult() {
		return null;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		HDDWriteSpeed hd = new HDDWriteSpeed();
		hd.run();
	}

	@Override
	public void warmUp() {
		// TODO Auto-generated method stub

	}
}