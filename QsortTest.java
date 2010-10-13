import java.io.*;
import java.lang.management.*;

class QsortTest {
	static final int size = 1000;

	static final int first = 0;

	static final int firstM = 3;

	static final int lastM = 40;

	/* Get user time in nanoseconds. */
	static long getUserTime() {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported() ? bean
				.getCurrentThreadUserTime() : 0L;
	}

	static void readSequence(QIntA a) throws IOException {
		String tempStr;
		for (int i = 0; (i + 1) < size; i = i + 10) {
			tempStr = get.readLine();
			for (int j = 0; j <= 63; j = j + 7)
				a.set(i + (j / 7), Integer.parseInt(tempStr.substring(j, j + 7)
						.trim()));
		}
	}

	static void writeSequence(QIntA a) {
		System.out.print("  ");
		for (int i = 0; i < size; i++) {
			for (int j = 10; j <= 10000; j = j * 10) {
				if (a.get(i) < j)
					System.out.print(" ");
			}
			System.out.print(a.get(i) + "  ");
			if ((i + 1) % 10 == 0) {
				System.out.print("\n  ");
				System.out.flush();
			}
		}
	}

	static QIntA a = new QIntA(size);

	static BufferedReader get = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) throws Exception {
		int m;
		readSequence(a);
		if (args.length != 0) { // check command line flag "-p"
			if ((!args[0].equals("-p")) || (args.length > 1))
				System.out.println("Usage: java Qsort [-p] < random");
			else { // flag "-p"
				QIntA a2 = new QIntA(a); // copies the array
				m = firstM;
				System.out.print("m = " + m);
				System.out.print(", quicksort:\n");
				System.out.flush();
				Qsort.quickSort(a, first, size - 1, m);
				writeSequence(a);
				m = 10;
				System.out.print("m = " + m);
				System.out.print(", quicksort + insertionsort:\n");
				System.out.flush();
				Qsort.quickSort(a2, first, size - 1, m);
				Qsort.insertionSort(a2, first, size - 1);
				writeSequence(a2);
			}
		} else { // no flag "-p"
			final int iter = 2000;
			long start, diff, t = (long) 0;
			QIntA a2 = new QIntA(a);
			for (int i = firstM; i <= lastM; i++) {
				m = i;
				t = (long) 0;
				for (int j = 1; j <= iter; j++) {
					a2.copy(a); // copies the array
					start = getUserTime();
					Qsort.quickSort(a2, first, size - 1, m);
					if (m != firstM)
						Qsort.insertionSort(a2, first, size - 1);
					diff = getUserTime() - start;
					t = t + diff;
				}
				System.out.print("m = ");
				if (m < 10)
					System.out.print(" ");
				System.out.print(m + "   time used: ");
				System.out.print((float) t / (1000000 * iter) + " ms\n");
				System.out.flush();
			}
		}
	}
}
