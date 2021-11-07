import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface IParking {
    public void print();

    public boolean addCar(int carType);

    public static IParams parse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入车位容量和停车请求(格式：[\"ParkingSystem\", \"addCar\", \"addCar\", \"addCar\", \"addCar\"][[1, 1, 0], [1], [2], [3], [1]])");
        String s = sc.nextLine();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        int[] parking = new int[100];
        int i = 0;
        while (m.find()) {
            int num = Integer.parseInt(m.group());
            if (i == 0 && num < 0)
                throw new RuntimeException("车位容量设置禁止为负数");
            if (i >= 3 && num != 1 && num != 2 && num != 3)
                throw new RuntimeException("输入车型非法！");
            parking[i] = num;
            i++;
        }
        return new IParams() {

            public int getBig() {
                return parking[0];
            }

            public int getMedium() {
                return parking[1];
            }

            public int getSmall() {
                return parking[2];
            }

            public ArrayList<Integer> getPlanParking() {
                ArrayList<Integer> List = new ArrayList<Integer>();
                for (int i = 3; i < parking.length; i++) {
                    if (parking[i] ==0)
                        break;
                    List.add(parking[i]);
                }
                return List;
            }
        };
    }
}

