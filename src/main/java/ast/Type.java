package ast;

public class Type extends SExp {
    public enum Kind {
        DAY,
        PRODUCT,
        SALE
    }

    public Kind kind;

    public static Type DAY() {
        return new Type(Kind.DAY);
    }

    public static Type PRODUCT() {
        return new Type(Kind.PRODUCT);
    }

    public static Type SALE() {
        return new Type(Kind.SALE);
    }

    private Type(Kind value) {
        this.kind = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" = '"+ kind +"'";
    }
}
