import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Env {
    Deque<VarValue> stack = new ArrayDeque<>();

    /**
     * Pushes a new variable onto the stack
     * @param varName   the name of the variable
     * @param value     the value of the variable
     */
    void push(String varName, int value) {
        stack.push(new VarValue(varName, value));
    }

    /**
     * Remove the variable on top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    void pop() {
        stack.pop();
    }

    /**
     * Finds the first variable with a matching name in the
     * stack and returns its value
     * @param name  the name of the variable to find
     * @return      the value of the variable if found, -1 otherwise
     */
    int lookup(String name) {
        for (VarValue m : stack) {
            if(m.varName.equals(name))
                return m.value;
        }
        return -1;
    }

    private static class VarValue {
        public String varName;
        public int value;

        public VarValue(String varName, int value) {
            this.varName = varName;
            this.value = value;
        }
    }
}
