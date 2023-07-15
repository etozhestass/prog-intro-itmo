package hw2;

public class SumDouble {
	public static void main(String[] args) {
		double sum = 0;
		for (String arg : args) {
			for (int indexStart = 0, indexEnd = 0; indexEnd < arg.length(); indexStart = ++indexEnd) {
				while (indexEnd < arg.length() && !Character.isWhitespace(arg.charAt(indexEnd))) {
					indexEnd++;
				}
				if (indexEnd != indexStart) {
					sum += Double.parseDouble(arg.substring(indexStart, indexEnd));
				}
			}
		}
		System.out.println(sum);
	}
}
