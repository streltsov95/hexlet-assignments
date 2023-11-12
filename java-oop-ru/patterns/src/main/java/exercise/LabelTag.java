package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tagValue;
    private TagInterface tagInterface;

    public LabelTag(String tagValue, TagInterface tagInterface) {
        this.tagValue = tagValue;
        this.tagInterface = tagInterface;
    }

    public String render() {
        StringBuilder sb = new StringBuilder("<label>");
        sb.append(tagValue);
        sb.append(tagInterface.render());
        sb.append("</label>");
        return sb.toString();
    }
}
// END
