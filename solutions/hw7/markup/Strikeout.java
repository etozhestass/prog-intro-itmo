package hw7.markup;

import java.util.List;

public class Strikeout extends AbstractMark {
    String txt;

    public Strikeout(List<Mark> list) {
        super(list);
    }

    @Override
    protected String getTexTagImpl() {
        return "textst";
    }

    @Override
    protected String getMarkdownTag() {
        return "~";
    }
}
