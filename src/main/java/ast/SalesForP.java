package ast;

public class SalesForP extends NExp {
    public NExp product;

    public SalesForP(NExp product) {
        this.product = product;
    }
}
