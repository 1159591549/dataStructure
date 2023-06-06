package queue;

import java.util.Scanner;

public class QueuePractice {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';

        while (loop) {
            System.out.println("a(add)入队");
            System.out.println("o(out)出队");
            System.out.println("g(get)取队首元素");
            System.out.println("s(show)展示队列元素");
            System.out.println("e(exit)退出程序");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输入入队值");
                    int value = scanner.nextInt();
                    myQueue.addQueue(value);
                    break;
                case 'o':
                    try {
                        myQueue.outQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println("队首元素为:" + myQueue.getHeader());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    myQueue.showQueue();
                    break;
                case 'e':
                    return;
                default:
                    break;
            }
        }
    }
}

class MyQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public MyQueue(int size) {
        maxSize = size;
        arr = new int[maxSize];
        rear = -1;
        front = -1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear + 1 == maxSize;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满了");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int outQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    public int getHeader() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("当前队列没有值");
        }
        for (int i = front + 1; i < rear + 1; i++) {
            System.out.printf("a[%d]=%d", i, arr[i]);
            System.out.println();
        }
    }
}