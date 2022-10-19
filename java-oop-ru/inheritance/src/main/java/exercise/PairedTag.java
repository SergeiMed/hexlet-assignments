package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag{

    private String tagText;
    List<Tag> listOfChildren;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagText, List<Tag> listOfChildren) {
        super(tagName, tagAttributes);
        this.tagText = tagText;
        this.listOfChildren = new ArrayList<>(listOfChildren);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getTag());
        stringBuilder.append(tagText);
        for (Tag tag : listOfChildren) {
            stringBuilder.append((new SingleTag(tag.getTagName(), tag.getTagAttributes()).getTag()));

        }
        stringBuilder.append("</")
                .append(getTagName())
                .append(">");
        return stringBuilder.toString();
    }
}
// END
