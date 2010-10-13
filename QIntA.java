final class QIntA {
    public int[] a;

	public QIntA() {
	}

	public QIntA(int x) {
		a = new int[x];
	}

	public QIntA(QIntA b) {
		a = (int[]) b.a.clone();
	}

	public void copy(QIntA b) throws Exception {
		if (a.length != b.a.length)
			throw (new Exception("QIntA not of equal length."));
		for (int i = 0; i < a.length; i++)
			a[i] = b.a[i];
	}

	public int get(int x) {
		return a[x];
	}

	public void set(int x, int y) {
		a[x] = y;
	}

	public void swap(int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
