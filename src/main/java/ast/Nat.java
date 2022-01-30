package ast;

public class Nat extends NExp {
    public int value;

    public Nat(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" = '"+value+"'";
    }
}
