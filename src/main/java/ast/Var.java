package ast;

public class Var extends NExp {
    public String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" = '"+name+"'";
    }
}
