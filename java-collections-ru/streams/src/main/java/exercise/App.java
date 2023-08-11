package exercise;

import java.util.List;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emailsList) {
        return emailsList.stream()
                .map(email -> email.split("@"))
                .filter(email -> email[1].equals("gmail.com")
                        || email[1].equals("yandex.ru")
                        || email[1].equals("hotmail.com"))
                .count();
    }
}
// END
