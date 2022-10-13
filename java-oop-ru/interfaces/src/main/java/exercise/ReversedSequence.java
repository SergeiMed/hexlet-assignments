package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{

    private final String string;

    public ReversedSequence(String string) {
        this.string = string;
    }

    private int getIndexFromEnd(int i) {
        return string.length() - 1 - i;
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int index) {
        if ((index < 0) || (index >= string.length())) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return string.charAt(getIndexFromEnd(index));
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        StringBuilder builder = new StringBuilder();
        int index = start + 1;
        while (index < end + 1) {
            builder.append(string.charAt(index));
            index++;
        }
        return builder.reverse();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.string);
        return builder.reverse().toString();
    }
}
// END
