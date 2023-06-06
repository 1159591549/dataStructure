package queue;

import java.util.Scanner;

public class MyListQueue {
    public static void main(String[] args) {
        ListQueue listQueue = new ListQueue(3);
        boolean loop = true;
        while (loop) {
            System.out.println("a(add)入队：");
            System.out.println("o(out)出队：");
            System.out.println("h(heafer)取栈顶元素：");
            System.out.println("s(show)展示站元素：");
            System.out.println("e(exit)退出程序：");
            Scanner scanner = new Scanner(System.in);
            char key = scanner.next().charAt(0);
            try {
                switch (key) {
                    case 'a':
                        System.out.println("请输入入队元素：");
                        int num = scanner.nextInt();
                        listQueue.addQueue(num);
                        break;
                    case 'o':
                        System.out.println(listQueue.outQueue());
                        break;
                    case 'h':
                        System.out.println(listQueue.getQueueHeader());
                        break;
                    case 's':
                        listQueue.showQueue();
                        break;
                    case 'e':
                        loop = false;
                        scanner.close();
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }

        }
    }
}

class ListQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queue;

    public ListQueue(int queueSize) {
        maxSize = queueSize;
        front = -1;
        rear = -1;
        queue = new int[queueSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加");
        }
        rear++;
        queue[rear] = n;
    }

    public int outQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列无数据，无法出队");
        }
        front++;
        return queue[front];
    }

    public int getQueueHeader() {
        if (isEmpty()) {
            throw new RuntimeException("队列无数据");
        }
        return queue[front + 1];
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列无数据");
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("a[%d]=%d", i, queue[i]);
            System.out.println();
        }
    }
}
