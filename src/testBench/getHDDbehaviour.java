package testBench;

import bench.hdd.*;

public class getHDDbehaviour {
	public static void getWritingSpeed() {
		double writingSpeed = FileWriter.benchScore();
		System.out.println("writing speed: "
				+ String.format("%.2f", writingSpeed) + "MB/sec");

		double readingSpeed = FileReader.rate();
		System.out.println("Reading speed: "
				+ String.format("%.2f", readingSpeed) + "MB/sec");

		String s = "writing speed: " + (int) writingSpeed + "MB/sec"
				+ "\nreading speed: " + (int) readingSpeed + "MB/sec";

		sendEmail(s); // send the email with the wanted content.
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
		String subject = "HDD test";
		String body = s;

		testBench.sendEmail.sendFromGMail(from, pass, to, subject, body);
	}
}
