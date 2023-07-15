package hw7.markup;

import java.util.List;

public abstract class AbstractMark implements Mark {
    protected List<Mark> list;

    public AbstractMark(List<Mark> list) {
        this.list = list;
    }

    public void toMarkdown(StringBuilder sb) {
        sb.append(getMarkdownTag());
        for (Mark mark : list) {
            mark.toMarkdown(sb);
        }
        sb.append(getMarkdownTag());
    }

    public void toTex(StringBuilder sb) {
        sb.append(getTexTagLeft());
        for (Mark mark : list) {
            mark.toTex(sb);
        }
        sb.append(getTexTagRight());
    }

    protected abstract String getMarkdownTag();

    protected String getTexTagLeft() {
        return '\\' +  getTexTagImpl() + '{';
    }
    protected abstract String getTexTagImpl();
    protected String getTexTagRight() {
        return "}";
    }
}
