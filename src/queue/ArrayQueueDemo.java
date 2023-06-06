package queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show) 显示队列");
            System.out.println("e(exit) 退出程序");
            System.out.println("a(add) 添加数据");
            System.out.println("g(get) 从队列中获取出数");
            System.out.println("h(head) 获取队首元素");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    scanner.close();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        System.out.println("取出队首元素为:" + queue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        System.out.println("获得队首元素为:" + queue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                default:
                    break;
            }
            System.out.println("-------------------------------------------------");
        }
        System.out.println("退出程序");
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    // 创建队列
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        // 指向队列头的前一个位置
        front = -1;
        // 指向队列尾部
        rear = -1;

    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    // 出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    // 显示队列的数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的,没有数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列头部数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列中没有数据");
        }
        return arr[front + 1];
    }
}