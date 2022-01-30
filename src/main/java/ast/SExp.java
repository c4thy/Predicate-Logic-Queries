package ast;

public abstract class SExp implements ASTNode {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
