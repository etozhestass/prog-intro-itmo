package hw7.markup;

import java.util.List;

public class Paragraph implements Mark {
    List<Mark> list;

    public Paragraph(List<Mark> list) {
        this.list = list;
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        for (Mark mark : list) {
            mark.toMarkdown(sb);
        }
    }

    @Override
    public void toTex(StringBuilder sb) {
        for (Mark mark : list) {
            mark.toTex(sb);
        }
    }

}
