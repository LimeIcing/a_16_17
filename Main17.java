public class Main17 {

    public static void main(String[] args) {
        LinkedIntList17 a = new LinkedIntList17();
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        System.out.println(a);
        a.removeRange(3,6);
        System.out.println(a);
    }
}
