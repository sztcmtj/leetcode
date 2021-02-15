import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author mutianjie
 * @Date 2021/2/14 2:42 下午
 * @Version 1.0
 **/
public class MyStack2 {
    // 普通栈
    private final LinkedList<Integer> stackData = new LinkedList<>();
    // 取最小值的栈
    private final LinkedList<Integer> stackMin = new LinkedList<>();
    @Test
    public void test() {
        push(3);
        push(4);
        push(5);
        push(1);
        push(2);
        push(1);
        pop();
        pop();
        pop();
        pop();
        pop();
        pop();
    }

    public void push(int x) {
        stackData.addLast(x);
        if (stackMin.isEmpty() || x <= stackMin.peekLast()) {
            stackMin.addLast(x);
        }
    }

    public int pop() {
        if (!stackData.isEmpty() && !stackMin.isEmpty()) {
            if (stackData.peekLast().equals(stackMin.peekLast())) {
                stackMin.removeLast();
            }
            return stackData.removeLast();
        }
        return -1;
    }

    public int getMin() {
        if (!stackMin.isEmpty()) {
            return stackMin.peekLast();
        }
        return -1;
    }
}
