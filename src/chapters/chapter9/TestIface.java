package chapters.chapter9;

public class TestIface {
    public static void main(String[] args) {
        CallBack c = new Client();
        c.callBack(42);
    }
}
