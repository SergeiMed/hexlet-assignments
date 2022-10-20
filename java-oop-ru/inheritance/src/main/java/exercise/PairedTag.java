package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private final String tagText;
    List<Tag> listOfChildren;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagText, List<Tag> listOfChildren) {
        super(tagName, tagAttributes);
        this.tagText = tagText;
        this.listOfChildren = new ArrayList<>(listOfChildren);
    }

    public String toString() {
        String tagChildren = listOfChildren.stream()
                .map(attribute -> new SingleTag(attribute.getTagName(), attribute.getTagAttributes()).toString())
                .collect(Collectors.joining(""));
        return String.format("<%s%s>%s%s</%s>", getTagName(), getTag(), tagText, tagChildren, getTagName());
    }
}
// END
