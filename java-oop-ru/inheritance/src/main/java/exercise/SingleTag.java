package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    SingleTag(String name, Map<String, String> attribute) {
        super(name, attribute);
    }

    public String getName() {
        return super.getName();
    }
    public Map<String, String> getAttributes() {
        return super.getAttributes();
    }

    @Override
    public String toString() {
        return super.toString();
//        return "<%s%s>".formatted(getName(), stringifyAttributes());


//        return super.getAttributes().keySet().stream()
//                .map(key -> key + "=\"" + super.getAttributes().get(key) + "\"")
//                .collect(Collectors.joining(" ", "<" + super.getName() + " ", ">"));
    }
}
// END
