#由两个栈组成的队列
##题目：
###实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
##要求：

 - pop、push、getMin操作的时间复杂度都是O(1)
 - 设计的栈类型可以使用现成的栈结构

```
static class GetMinStack1 {
        private Stack<Integer> dataStack,minStack;

        public GetMinStack1() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int num) {
            dataStack.push(num);
            if (minStack.isEmpty() || getMin() >= num) {
                minStack.push(num);
            }
        }

        public int pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            int val = dataStack.pop();
            if (val == getMin()) {
                minStack.pop();
            }
            return val;
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return minStack.peek();
        }
    }

    static class GetMinStack2 {
        private Stack<Integer> dataStack,minStack;

        public GetMinStack2() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int num) {
            dataStack.push(num);
            if (minStack.isEmpty()) {
                minStack.push(num);
                return;
            }
            int min = getMin();
            if (min >= num) {
                minStack.push(num);
            }else {
                minStack.push(min);
            }
        }

        public int pop() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return minStack.pop();
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return minStack.peek();
        }
    }
```
**方案1中minStack压入时稍省空间，弹出时稍费时间，而方案2中Stack压入时稍费空间，弹出时稍省时间**
