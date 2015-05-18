package bench.hdd;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import Timing.Timer;

public class FileReader {
	private Timer timer = new Timer();

	// private double benchScore;

	public void streamReadFixedSize(String fileName, int minBufSize,
			int maxBufSize) throws IOException {
		// System.out.println("Stream read benchmark");
		int currentBufferSize = minBufSize;

		// int counter = 0;

		while (currentBufferSize <= maxBufSize) {
			readWithBufferSize(fileName, currentBufferSize);
			currentBufferSize *= 2;
			// counter++;
		}

		// benchScore /= counter;
		// System.out.println("File read score : " + String.format("%.2f",
		// benchScore) + " MB/sec");
	}


	private void readWithBufferSize(String fileName, int myBufferSize)
			throws IOException {
		if (!(new File(fileName).exists()))
			throw new IOException("Benchmark file " + fileName
					+ " was not found");

		final BufferedInputStream inputStream = new BufferedInputStream(
				new FileInputStream(new File(fileName)), myBufferSize);
		byte[] buffer = new byte[myBufferSize];
		int read;

		timer.start();
		long totalbytes = 0;
		while ((read = inputStream.read(buffer)) != -1) {
			totalbytes += read;
		}

		if (read == -1) {
			printStats(fileName, totalbytes, myBufferSize);
		} else {
			System.out.println("Error reading " + fileName);
		}
		inputStream.close();
	}

	public void compareWithBufferSize(String fileName1, String fileName2,
			int myBufferSize) throws IOException {
		final BufferedInputStream inputStream1 = new BufferedInputStream(
				new FileInputStream(new File(fileName1)), myBufferSize);
		byte[] buff1 = new byte[myBufferSize];
		final BufferedInputStream inputStream2 = new BufferedInputStream(
				new FileInputStream(new File(fileName2)), myBufferSize);
		byte[] buff2 = new byte[myBufferSize];
		int read1;

		// System.out.println("File compare benchmark");

		timer.start();
		long totalBytes = 0;
		while ((read1 = inputStream1.read(buff1)) != -1) {
			totalBytes += 2 * read1;
			int read2 = inputStream2.read(buff2);

			if (read1 != read2)
				break;
			if (!Arrays.equals(buff1, buff2))
				break;
		}

		if (read1 == -1)
			printStats(fileName1, totalBytes, myBufferSize);
		else
			System.out.println("Files are not equal");

		inputStream1.close();
		inputStream2.close();
	}


	static double rate;

	private void printStats(String fileName, long totalBytes, int myBufferSize) {
		// NumberFormat nf = new DecimalFormat("#.00");
		final long time = timer.stop();
		double mseconds = time / 1000000d;
		double megabytes = totalBytes / 1024 / 1024;
		rate = (megabytes) / mseconds * 1000;

		/*
		 * System.out.println("Done reading " + totalBytes +
		 * " bytes from file: " + fileName + " in " + nf.format(mseconds) +
		 * " ms (" + nf.format(rate) + "MB/sec)" + " with a buffer size of " +
		 * myBufferSize / 1024 + " kB");
		 */
		// actual score (MBps)
		// benchScore += rate;

		rate();
	}


	public static double rate() {
		return rate;
	}

}