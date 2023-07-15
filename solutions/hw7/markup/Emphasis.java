package hw7.markup;

import java.util.List;

public class Emphasis extends AbstractMark {

    public Emphasis(List<Mark> list) {
        super(list);
    }

    @Override
    protected String getMarkdownTag() {
        return "*";
    }

    @Override
    protected String getTexTagImpl() {
        return "emph";
    }
}
