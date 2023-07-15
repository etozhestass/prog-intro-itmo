package hw7.markup;

import java.util.List;

public class Strong extends AbstractMark {

    public Strong(List<Mark> list) {
        super(list);
    }
    @Override
    protected String getTexTagImpl() {
        return "textbf";
    }
    @Override
    protected String getMarkdownTag() {
        return "__";
    }
}
