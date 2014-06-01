package qmech.api.chemicals;

public class ElementStack {

    public final ElementBase elem;
    private final int amt;

    public ElementStack(ElementBase elem, int amt) {
        this.elem = elem;
        this.amt = amt;
    }

}
