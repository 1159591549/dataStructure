package classicTitle;

public class FewList {
    // 普通数组转稀疏数组
    public int[][] commonToFew(int[][] chessArr) {
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        int fewList[][] = new int[sum + 1][3];
        fewList[0][0] = chessArr.length;
        fewList[0][1] = chessArr[0].length;
        fewList[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    fewList[count][0] = i;
                    fewList[count][1] = j;
                    fewList[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("稀疏矩阵如下");
        for (int i = 0; i < fewList.length; i++) {
            for (int j = 0; j < fewList[i].length; j++) {
                System.out.printf("%d\t", fewList[i][j]);
            }
            System.out.println();
        }
        return fewList;
    }

    // 稀疏数组转普通数组
    public int[][] fewToCommon(int[][] fewList) {
        int tmpList[][] = new int[fewList[0][0]][fewList[0][1]];
        for (int i = 1; i < fewList.length; i++) {
            tmpList[fewList[i][0]][fewList[i][1]] = fewList[i][2];
        }
        System.out.println("普通矩阵如下");
        for (int[] row : tmpList) {
            for (int num : row) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
        return tmpList;
    }

    public static void main(String[] args) {
        FewList FewList = new FewList();
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[5][9] = 99;
        int[][] commonArr = FewList.commonToFew(chessArr);
        FewList.fewToCommon(commonArr);
    }
}
