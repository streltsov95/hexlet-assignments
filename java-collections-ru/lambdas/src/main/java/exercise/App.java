package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        // Увеличение изображения по горизонтали
        String[][] horizontallyEnlarged = Arrays.stream(image) // Преобразуем исходный двумерный массив в поток подмассивов
                .map(row -> Arrays.stream(row)) //Преобразуем подмассив (строку) в поток
                .flatMap(item -> Stream.of(item, item)) // Дублируем каждый элемент преобразовав элемент в поток из двух элементов
                .toArray(String[][]::new); // Итоговый поток приводим в двумерному массиву

        // Увеличение изображения по вертикали
        String[][] enlargedImage = Arrays.stream(horizontallyEnlarged) // Преобразуем исходный двумерный массив в поток подмассивов
                .flatMap(row -> Stream.of(row, row)) // Дублируем каждую строку преобразовав строку в поток из двух строк
                .toArray(String[][]::new); // Итоговый поток приводим в двумерному массиву

        return enlargedImage;
    }

    public static void main(String[] args) {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        System.out.println(Arrays.deepToString(image));
        String[][] enlargedImage = App.enlargeArrayImage(image);
        System.out.println(Arrays.deepToString(enlargedImage));
    }
}
// END
