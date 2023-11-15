package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> childs;

    PairedTag(String name, Map<String, String> attribute, String tagBody, List<Tag> childs) {
        super(name, attribute);
        this.tagBody = tagBody;
        this.childs = childs;
    }

    public String getTagBody() {
        return tagBody;
    }

    public List<Tag> getChilds() {
        return childs;
    }

    public String stringifyChilds() {
        StringBuilder stringChilds = new StringBuilder();
        childs.forEach(item -> stringChilds.append(item.toString()));
        return stringChilds.toString();
    }

    @Override
    public String toString() {
        return "%s%s%s</%s>".formatted(super.toString(), tagBody, stringifyChilds(), getName());
    }
}
// END
