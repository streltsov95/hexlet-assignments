package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image) // Преобразуем исходный двумерный массив в поток подмассивов
                .map(row -> Arrays.stream(row) // Преобразуем подмассив (строку) в поток элементов
                        .flatMap(item -> Stream.of(item, item)) // Каждый элемент преобразуем в поток из двух элементов
                                                                // и выпрямляем потоки в один
                        .toArray(String[]::new)) // Преобразуем поток элементов обратно в поток подмассивов (строк)
                .flatMap(row -> Stream.of(row, row)) // Каждый подмассив преобразуем в поток из двух подмассивов
                                                     // и выпрямляем потоки в один
                .toArray(String[][]::new); // Преобразуем поток подмассивов в двумерный массив
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
