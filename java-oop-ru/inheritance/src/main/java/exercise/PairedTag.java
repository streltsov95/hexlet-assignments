package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
class PairedTag extends Tag {
    private static final String  TAG_FORMAT = "%s%s%s</%s>";
    private final String tagBody;
    private final List<Tag> childs;

    PairedTag(String name, Map<String, String> attribute, String tagBody, List<Tag> childs) {
        super(name, attribute);
        this.tagBody = tagBody;
        this.childs = childs;
    }

    public String stringifyChilds() {
        StringBuilder stringChilds = new StringBuilder();
        childs.forEach(item -> stringChilds.append(item.toString()));
        return stringChilds.toString();
    }

    @Override
    public String toString() {
        return String.format(TAG_FORMAT, super.toString(), tagBody, stringifyChilds(), getName());
    }
}
// END
