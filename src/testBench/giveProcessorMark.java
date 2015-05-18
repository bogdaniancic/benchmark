package testBench;

public class giveProcessorMark {
	public static void giveMark(int tr, int p, int f, int pr, int score) {
		String s = "";
		if (tr + p + f + pr == 16) {
			System.out.println("your processor behaves like an dual core");
			s = "the processor behaves like an dual core";
		} else if (tr + p + f + pr == 24) {
			System.out.println("your processor behaves like an i3");
			s = "the processor behaves like an i3";
		} else if (tr + p + f + pr == 32) {
			System.out.println("your processor behaves like an i5");
			s = "the processor behaves like an i5";
		} else if (tr + p + f + pr == 40) {
			System.out
					.println("you've got a lot of money.\n your processor behaves like an i7");
			s = "the processor behaves like an i7";
		} else if (tr + p + f + pr > 32) {
			System.out
					.println("your processor behaves somewhere between a good i5 and a weak i7");
			s = "the processor behaves somewhere between a good i5 and a weak i7";
		} else if (tr + p + f + pr > 24) {
			System.out
					.println("your processor is somewhere between a good i3 and a weak i5");
			s = "the processor behaves somewhere between a good i3 and a weak i5";
		} else if (tr + p + f + pr > 16) {
			System.out
					.println("your processor is somewhere between a good dual core and a weak i3");
			s = "the processor is somewhere between a good dual core and a weak i3";
		} else {
			System.out.println("error");
			s = "error";
		}

		s = s + "\nscore: " + score;
		sendEmail(s); // send the email with the wanted content.
	}

	public int fxAluMark(int i, int j) {
		if (i + j == 20)
			return 10;
		else if (i + j == 16)
			return 8;
		else if (i + j == 12)
			return 6;
		else if (i + j == 8)
			return 4;
		else if (i == 10 || i == 8 && j == 8 || j == 10)
			return 8;
		else if (i == 8 || i == 6 && j == 6 || j == 8)
			return 6;
		else
			return 4;
	}

	public int giveMarkPi(int Sum) {
		// System.out.println("suma: " + Sum);
		if (Sum > 1200)
			return 4;
		else if (Sum > 850)
			return 6;
		else if (Sum > 650)
			return 8;
		else
			return 10;
	}

	public int getThreadMark(long a, long b, long c, long d) {
		// System.out.println("b: " + b + " c: " + c + " d: " + d);
		if (a > 4400000 && c > 1500000)
			return 4;
		else if (a > 3300000)
			return 6;
		else if (b < 1400000 && a < 3000000 && a > 2700000)
			return 8;
		else
			return 10;

	}

	public int giveMarkPrime(float Sum) {
		// System.out.println("Sum = " + Sum);
		if (Sum > 100 && Sum < 150)
			return 6;
		else if (Sum > 150 && Sum < 260)
			return 8;
		else if (Sum >= 230)
			return 10;
		else
			return 4;
	}

	public int printTimefx1(int i) {
		if (i < 35)
			return 4;
		else if (i < 80)
			return 6;
		else if (i < 100)
			return 8;
		else
			return 10;

	}

	public int printTimefx2(int j) {
		if (j < 3000)
			return 4;
		else if (j < 4000)
			return 6;
		else if (j < 5000)
			return 8;
		else
			return 10;
	}

	/*
	 * send email with the HDD data the sender and the receiver are preset, so
	 * the user doesn't have to enter any information the subjects says if the
	 * email contains data for the CPU or the HDD the body contains the info
	 */
	public static void sendEmail(String s) {
		String from = "stats.sender2";
		String pass = "minions1234";
		String[] to = { "statsreceiver@gmail.com" }; // list of recipient email
														// addresses
		String subject = "Processor test";

		s = s + "\n" + System.getenv("PROCESSOR_IDENTIFIER");
		s = s + "\n" + System.getenv("PROCESSOR_ARCHITECTURE");
		s = s + "\n" + System.getenv("NUMBER_OF_PROCESSORS");
		String body = s;

		testBench.sendEmail.sendFromGMail(from, pass, to, subject, body);
	}
}
