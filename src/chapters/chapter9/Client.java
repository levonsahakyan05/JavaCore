package chapters.chapter9;

public class Client implements CallBack{
    @Override
    public void callBack(int param) {
        System.out.println("iovh" + param);
    }
    void nonIfaceMeth(){
        System.out.println("orihv");
    }
}
