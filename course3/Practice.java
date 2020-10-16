package coursera.course3;

public class Practice {
    int a, b;
    Practice(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int sum(int a, int b) {
        return a + b;
    }
    public int sum(int a, int b, int c) {
        return a + b + c;
    }
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }
    public static void main(String[] args) {
        int a = 9, b = 7;
        swap(a, b);
        System.out.println(a + " " + b);
    }
}
