package exercise;
//import java.util.stream.Collectors;

// BEGIN
class ReversedSequence implements CharSequence {
    private String string;

    ReversedSequence(String text) {
        if (!text.isEmpty()) {
            var reversedSequence = new StringBuilder();
            for (int i = text.length() - 1; i >= 0; i--) {
                reversedSequence.append(text.charAt(i));
            }
            this.string = reversedSequence.toString();
        } else {
            this.string = text;
        }
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int index) {
        return string.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return string.subSequence(start, end);
    }

    @Override
    public String toString() {
        return string;
    }
}
// END
