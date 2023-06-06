package queue;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

import javafx.scene.shape.LineTo;

public class MyCircleQueue {
    public static void main(String[] args) {
        MyQueue1 queue = new MyQueue1(4); // 最大存储空间是4 实际有效存储空间是3
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
                    queue.printCircleQueue();
                    break;
                case 'e':
                    loop = false;
                    scanner.close();
                    break;
                case 'a':
                    try {
                        System.out.println("输入一个数");
                        int value = scanner.nextInt();
                        queue.addCircleQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'g':
                    try {
                        System.out.println("取出队首元素为:" + queue.outHeader());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("获得队首元素为:" + queue.getHeader());
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

class MyQueue1 {
    private int front;
    private int rear;
    private int maxSize;
    private int[] list;

    public MyQueue1(int size) {
        maxSize = size;
        list = new int[size];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public int outHeader() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int index = front;
        front = (front + 1) % maxSize;
        return list[index];
    }

    public void addCircleQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        list[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public int getHeader() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return list[front];
    }

    public int getFunSize() {
        return (rear - front + maxSize) % maxSize;
    }

    public void printCircleQueue() {
        for (int i = front; i < front + getFunSize(); i++) {
            System.out.printf("arr[%d]=%d", i % maxSize, list[i % maxSize]);
            System.out.println();
        }
    }
}