package exercise;

// BEGIN
public class InputTag implements TagInterface {
    private String type;
    private String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String render() {
        StringBuilder sb = new StringBuilder("<input type=\"");
        sb.append(type);
        sb.append("\" value=\"");
        sb.append(value);
        sb.append("\">");
        return sb.toString();
    }
}
// END
