package testBench;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestBenchMain {
	private static Scanner inputStream;

	public static void main(String[] args) throws InterruptedException {

		inputStream = new Scanner(System.in);
		int option = 0;

		/*
		 * would be nice to add a warning" if you press the HDD option then you
		 * are sure that your hard disk has at leat ... cati mega ( undeva pe la
		 * 1GB) free
		 */

		System.out
				.println("(1) CPU benchmark\n(2) HDD benchmark\nEnter your option: ");
		try {
			option = inputStream.nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}

		switch (option) {
		case 1:
			CpuBench c = new CpuBench();
			c.CpuBenchmark();
			break;

		case 2:
			System.out
					.println("For the HDD benchmark to work you have to have at least 1023MB free on partition C. Press 1 if you want to continue or 0 if you want to stop here: ");
			int option2 = 0;
			try {
				option2 = inputStream.nextInt();
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}

			switch (option2) {
			case 1:
				HddBench h = new HddBench();
				h.HddBenchmark();
				break;
			case 0:
				break;
			default:
				System.err.println("Error! Invalid option!");
				return;
			}
			break;

		default:
			System.err.println("Error! Invalid option!");
			return;
		}
	}

}
