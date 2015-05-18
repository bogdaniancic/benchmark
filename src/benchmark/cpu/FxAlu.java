package benchmark.cpu;

public class FxAlu {
	private int[] a = { 1, 15, 23, 421, 13, 42, 123, 32, 324, 35, 125, 324,
			215, 234, 32432, 234, 342 };
	int operations1, operations2;
	int loops1, loops2;

	public void run1() {
		arithmetics();
	}

	public void run2() {
		arrays();
	}

	void arithmetics() {
		operations1++; // int i=0;
		for (int i = 0; i < a.length; i++) {
			loops1++;
			operations1 += 2; // i<a.length & i++
			if (a[i] % 2 == 0) {
				if (a[i] > 100) {
					a[i] <<= a[i];
					operations1 += 3;
				} else if (a[i] > 50) {
					a[i] /= 3;
					operations1 += 4;
				}
			} else if (a[i] % 5 == 0) {
				if (a[i] % 3 == 0) {
					a[i] *= 2;
					operations1 += 4;
				}
			} else {
				a[i] *= 2;
				a[i] -= 3;
				a[i] += 4;
				a[i] %= 2;
				operations1 += 7;
			}

		}
	}

	void arrays() {
		operations2++; // for int i=0;
		for (int i = 0; i < a.length - 1; i++) {
			operations2 += 3; // i< a.length -1 & i++ & j=i+1
			loops2++;
			for (int j = i + 1; j < a.length; j++) {
				a[i] = a[j];
				operations2 += 3;
				loops2++;
			}
			operations2++; // j<a.length false
		}
		operations2++; // i<a.length -1 false
	}

	public int operationsArithmetics() {
		return operations1;
	}

	public int loopsArithmetics() {
		return loops1;
	}

	public int operationsArrays() {
		return operations2;
	}

	public int loopsArrays() {
		return loops2;
	}
}
