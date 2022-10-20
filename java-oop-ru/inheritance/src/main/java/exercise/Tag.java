package exercise;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
public abstract class Tag {

    private final String tagName;
    private final Map<String, String> tagAttributes;

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
        Set<String> keys = getTagAttributes().keySet();
        return keys.stream()
                .map(key -> String.format(" %s=\"%s\"", key, getTagAttributes().get(key)))
                .collect(Collectors.joining(""));
    }
}
// END
