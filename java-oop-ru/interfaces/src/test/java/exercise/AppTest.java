package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;


class AppTest {

    @Test
    void testBuildApartmentsList1() {
        List<Home> apartments = new ArrayList<>(List.of(
            new Flat(41, 3, 10),
            new Cottage(125.5, 2),
            new Flat(80, 10, 2),
            new Cottage(150, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
            "Квартира площадью 44.0 метров на 10 этаже",
            "Квартира площадью 90.0 метров на 2 этаже",
            "2 этажный коттедж площадью 125.5 метров"
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testBuildApartmentsList2() {
        List<Home> apartments = new ArrayList<>(List.of(
            new Cottage(100, 1),
            new Flat(190, 10, 2),
            new Flat(180, 30, 5),
            new Cottage(250, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
            "1 этажный коттедж площадью 100.0 метров",
            "Квартира площадью 200.0 метров на 2 этаже",
            "Квартира площадью 210.0 метров на 5 этаже",
            "3 этажный коттедж площадью 250.0 метров"
        ));

        List<String> result = App.buildApartmentsList(apartments, 4);
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void testBuildApartmentsList3() {
        List<Home> apartments = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        List<String> result = App.buildApartmentsList(apartments, 10);
        assertThat(result).isEqualTo(expected);
    }

    // BEGIN
    @Test
    public void emptyStringTest() {
        String expected = "";
        CharSequence actual = new ReversedSequence("");
        assertThat(expected).isEqualTo(actual.toString());
    }

    @Test
    public void generalFunctionality() {
        String expected = "fedcba";
        CharSequence actual = new ReversedSequence("abcdef");
        assertThat(expected).isEqualTo(actual.toString());
    }

    @Test
    public void lengthTest() {
        int expected = 6;
        CharSequence actual = new ReversedSequence("abcdef");
        assertThat(expected).isEqualTo(actual.length());
    }

    @Test
    public void charAtTest() {
        char expected = 'b';
        CharSequence actual = new ReversedSequence("abcdef");
        assertThat(expected).isEqualTo(actual.charAt(4));
    }

    @Test
    public void negativeIndexTest() {
        CharSequence actual = new ReversedSequence("abcdef");
        var thrown = catchThrowable(
                () -> actual.charAt(-3)
        );
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void notExistIndexTest() {
        CharSequence actual = new ReversedSequence("abcdef");
        var thrown = catchThrowable(
                () -> actual.charAt(7)
        );
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void subSequenceTest() {
        String expected = "edc";
        CharSequence actual = new ReversedSequence("abcdef");
        assertThat(expected).isEqualTo(actual.subSequence(1, 4).toString());
    }

    @Test
    public void subSequenceTestException1() {
        CharSequence actual = new ReversedSequence("abcdef");
        var thrown = catchThrowable(
                () -> actual.subSequence(3, 2)
        );
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void subSequenceTestException2() {
        CharSequence actual = new ReversedSequence("abcdef");
        var thrown = catchThrowable(
                () -> actual.subSequence(-2, 3)
        );
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void subSequenceTestException3() {
        CharSequence actual = new ReversedSequence("abcdef");
        var thrown = catchThrowable(
                () -> actual.subSequence(2, 7)
        );
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }
    // END
}
