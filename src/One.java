import java.util.ArrayList;

public class One {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (Integer num : list) {
            System.out.println(num);
        }
        System.out.println("----------------------------------------");
        for (Integer i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}