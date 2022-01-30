package ast;

public abstract class Formula implements ASTNode {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
