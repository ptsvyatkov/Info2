public class StackAsList<T> implements Stack<T> {

    private LinkedList <T>list = new LinkedList<>();

    @Override
    public void push(T t) {
        list.add(t);
    }

    @Override
    public T pop() throws UnderflowException {
        try {
            T pop = list.current();
            list.remove();
            return pop;
        }catch (UnderflowException uex) {
            uex.printStackTrace();
            return null;
        }
    }

    @Override
    public T top() throws UnderflowException {
        try {
            return list.current();
        } catch (UnderflowException uex) {
            uex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void empty() {
        list.reset();
    }
}