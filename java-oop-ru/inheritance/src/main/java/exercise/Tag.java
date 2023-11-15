package exercise;

import java.util.Map;
import java.util.Set;

// BEGIN
class Tag {
    private static final String  TAG_FORMAT = "<%s%s>";
    private final String name;
    private final Map<String, String> attributes;

    Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String stringifyAttributes() {
        Set<Map.Entry<String, String>> itemAttributes = attributes.entrySet();
        StringBuilder stringAttributes = new StringBuilder();

        itemAttributes.forEach(item -> {
            stringAttributes.append(" ");
            stringAttributes.append(item.getKey());
            stringAttributes.append("=\"");
            stringAttributes.append(item.getValue());
            stringAttributes.append("\"");
        });

        return stringAttributes.toString();

    }

    public String toString() {
        return String.format(TAG_FORMAT, name, stringifyAttributes());
    }
}
// END
