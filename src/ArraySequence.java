public class ArraySequence<T> implements Sequence<T> {
	private T[] array;
	public ArraySequence(T[] a) { array = a; }
	public Iterator<T> begin() { return new ArrayIterator<T>(array,0); }
	public Iterator<T> end() { return new ArrayIterator<T>(array, array.length); }

	public String toString() {
		String str = "";
		for(T t : array) {
			str = str + t + " ";
		}
		return str;
	}

	class ArrayIterator<T> implements Iterator<T> {
		private T[] array;
		private int pos;
		public ArrayIterator(T[] a, int p) { array = a; pos = p; }
		public T get() { return array[pos]; }
		public void set(T x) { array[pos] = x; }
		public void advance() { ++pos; }
		public ArrayIterator<T> clone() { return new ArrayIterator<T>(array,pos); }
		public boolean equals(Iterator<T> other) {
			ArrayIterator<T> i = (ArrayIterator<T>) other;
			return pos == i.pos;
		}

		public String toString() {
			return array[pos] + " @ " + pos;
		}
	}
}

