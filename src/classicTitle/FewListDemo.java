package classicTitle;

public class FewListDemo {
    // 普通数组转换为稀疏数组
    public int[][] arrToFewList(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
        }
        int[][] fewList = new int[count + 1][3];
        fewList[0][0] = arr.length;
        fewList[0][1] = arr[0].length;
        fewList[0][2] = count;
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    fewList[count][0] = i;
                    fewList[count][1] = j;
                    fewList[count][2] = arr[i][j];
                }
            }
        }
        return fewList;
    }

    // 稀疏数组转换为普通数组
    public int[][] fewListToArr(int[][] fewList) {
        int[][] list = new int[fewList[0][0]][fewList[0][1]];
        for (int i = 1; i < fewList.length; i++) {
            for (int j = 0; j < fewList[i].length; j++) {
                list[fewList[i][0]][fewList[i][1]] = fewList[i][j];
            }
        }
        return list;
    }

    // 数组打印
    public void printList(int[][] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                System.out.printf("%d\t", list[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[20][20];
        arr[3][8] = 1;
        arr[6][7] = 3;
        arr[9][1] = 4;
        FewListDemo fewListDemo = new FewListDemo();
        System.out.println("原数组如下：");
        fewListDemo.printList(arr);

        int[][] fewList = fewListDemo.arrToFewList(arr);
        System.out.println("稀疏数组如下：");
        fewListDemo.printList(fewList);

        int[][] list = fewListDemo.fewListToArr(fewList);
        System.out.println("转原数组如下：");
        fewListDemo.printList(list);
        // fewListDemo.printList(arr);
    }
}
