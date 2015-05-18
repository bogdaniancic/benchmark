package benchmark.cpu;

public class CPU_benchmark implements IBenchmark {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.print("");
		}
	}

	public void run(Object param) {

	}

	public void initialize() {

	}

	public void clean() {

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
