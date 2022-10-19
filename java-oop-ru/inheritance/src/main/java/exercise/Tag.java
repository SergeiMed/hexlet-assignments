package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {

    private String tagName;
    private Map<String, String> tagAttributes;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String getTagName() {
        return tagName;
    }

    public Map<String, String> getTagAttributes() {
        return tagAttributes;
    }

    public String getTag() {
        if (tagAttributes.isEmpty()) {
            return "<" + tagName + ">";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> attribute : tagAttributes.entrySet()) {
            stringBuilder.append(attribute.getKey())
                    .append("=")
                    .append("\"")
                    .append(attribute.getValue())
                    .append("\"")
                    .append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String result = stringBuilder.toString();
        return getTagAttributes().isEmpty() ? "<" + getTagName() + ">" :
                "<" + getTagName() +
                        " " +
                        result +
                        ">";
    }
}
// END
