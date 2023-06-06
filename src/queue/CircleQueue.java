package queue;

import java.util.Scanner;

public class CircleQueue {
    public static void main(String[] args) {

        CircleArray queue = new CircleArray(4); // 最大存储空间是4 实际有效存储空间是3
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

class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 判断是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 队列添加元素
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的头部元素
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }
    }

    // 求出当前队列的有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示头 素
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
