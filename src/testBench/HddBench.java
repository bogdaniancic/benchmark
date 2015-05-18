package testBench;

import java.io.File;

import bench.hdd.HDDReadSpeed;
import bench.hdd.HDDWriteSpeed;
import testBench.getHDDbehaviour;

public class HddBench {
	public void HddBenchmark() {
		/*
		 * writes files with size from 1MB up to 512MB writes on partition C a
		 * total of 1023MB if the writing benchmark won't work the reading won't
		 * work either
		 */
		HDDWriteSpeed wr = new HDDWriteSpeed();
		wr.run();

		/*
		 * the reading benchmark is based on the writing benchmark. it computes
		 * the reading speed for the largest file wrote at the writing\ test
		 */
		HDDReadSpeed rs = new HDDReadSpeed();
		rs.run();

		/*
		 * the benchmark automatically deletes the files that it wrote used C as
		 * partition where to write because everyone has partition C and there
		 * aren't a lot of idiots who fill up to 100%\ partition C
		 */
		deleteDirectory(new File("C:\\example"));

		getHDDbehaviour.getWritingSpeed();
	}

	public static boolean deleteDirectory(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return (path.delete());
	}
}
