package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> tagAttributes) {
        super(tagName, tagAttributes);
    }

    public String toString() {
        return String.format("<%s%s>", getTagName(), getTag());
    }
}
// END
