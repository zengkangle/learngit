import java.util.ArrayList;

//第二次提交示范
public class ParkingSystem implements IParking {
    int big, mid, small;
    String result = "null,";

    public ParkingSystem(int big, int mid, int small) {
        this.big = big;
        this.mid = mid;
        this.small = small;
    }

    public void print() {
        System.out.println(result);
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big != 0) {
                result += "true,";
                big--;
                return true;
            }
            result += "false,";
            return false;
        } else if (carType == 2) {
            if (mid != 0) {
                result += "true,";
                mid--;
                return true;
            }
            result += "false,";
            return false;
        } else {
            if (small != 0) {
                result += "true,";
                small--;
                return true;
            }
            result += "false,";
            return false;
        }
    }

    public static void main(String[] args) {
        IParams params = IParking.parse();
        ParkingSystem ps = new ParkingSystem(params.getBig(), params.getMedium(), params.getSmall());
        ArrayList<Integer> plan = params.getPlanParking();
        for (int i = 0; i < plan.size(); i++) {
            ps.addCar(plan.get(i));
        }
        ps.print();
    }
}
