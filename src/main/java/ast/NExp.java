package ast;

public abstract class NExp implements ASTNode {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
