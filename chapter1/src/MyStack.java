import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author mutianjie
 * @Date 2021/2/13 9:22 下午
 * @Version 1.0
 **/

public class MyStack {
    // 普通栈
    private LinkedList<Integer> stackData = new LinkedList<>();
    // 取最小值的栈
    private LinkedList<Integer> stackMin = new LinkedList<>();
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
        if (stackMin.isEmpty() || stackMin.peekLast() > x) {
            // 若最小值栈为空或者栈顶元素小大于x，则x入栈
            stackMin.addLast(x);
        } else {
            stackMin.addLast(stackMin.peekLast());
        }
    }

    public int pop() {
        if (!stackData.isEmpty()) {
            // 普通栈不为空，两个栈一起弹出
            stackMin.removeLast();
            // 返回
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
