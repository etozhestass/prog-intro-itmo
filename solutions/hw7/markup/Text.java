package hw7.markup;

public class Text implements Mark {
    String txt;

    public Text(String txt) {
        this.txt = txt;
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        sb.append(txt);
    }

    public void toTex(StringBuilder sb) {
        sb.append(txt);
    }
}
