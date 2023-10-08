package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("\""))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .filter(s -> s.contains("X_FORWARDED_"))
                .map(s -> s.replaceAll("X_FORWARDED_", ""))
                .peek(System.out::println)
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        String s = "[foo:bar]\n" +
                "environment=\"X_FORWARDED_var1=111\"\n" +
                "\n" +
                "[bar:baz]\n" +
                "environment=\"key2=true,X_FORWARDED_var2=123\"\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make prepare'\n" +
                "\n" +
                "[baz:foo]\n" +
                "key3=\"value3\"\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make prepare'\n" +
                "\n" +
                "[program:prepare]\n" +
                "environment=\"key5=value5,X_FORWARDED_var3=value,key6=value6\"\n" +
                "\n" +
                "[program:start]\n" +
                "environment=\"pwd=/temp,user=tirion\"\n" +
                "\n" +
                "[program:options]\n" +
                "environment=\"X_FORWARDED_mail=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en\"\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make environment'\n" +
                "\n" +
                "[empty]\n" +
                "command=\"X_FORWARDED_HOME=/ cd ~\"";
        System.out.println(getForwardedVariables(s));
    }
}
//END
