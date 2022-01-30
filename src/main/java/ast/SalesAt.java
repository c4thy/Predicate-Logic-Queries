package ast;

public class SalesAt extends NExp {
    public NExp product;
    public NExp day;

    public SalesAt(NExp product, NExp day) {
        this.product = product;
        this.day = day;
    }
}
