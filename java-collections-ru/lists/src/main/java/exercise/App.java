package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        var lowerCaseWord = word.toLowerCase(); // привожу слово к нижнему регистру
        char[] symbolsArray = symbols.toCharArray(); // создаю массив доступных символов из строки символов
        char[] lettersOfWordArray = lowerCaseWord.toCharArray(); // создаю массив символов из букв слова в нижнем рег-р

        List<Character> symbolsList = new ArrayList<>(); // создаю ArrayList для символов

        for (char symbol : symbolsArray) {
            symbolsList.add(symbol); // добавляю все доступные символы в ArrayList
        }
        for (Character letter : lettersOfWordArray) { // прохожу по массиву букв слова
            if (symbolsList.contains(letter)) { // если символ содержится в списке доступных символов
                symbolsList.remove(letter); // удаляю этот символ из ArrayList для символов
            } else {
                return false; // если буквы нет в массиве символов - вернуть false
            }
        }
        return true; // если вышли из цикла - значит слово можно составить из списка доступных символов
    }
}
//END
