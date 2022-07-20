package chapters.chapter12;

public enum Apple {
    Jonathan(10),GoldenDel(15),RedDel(16),Winesap(65),CortLand(56);
    private int price;
    Apple(int p){
        price = p;
    }

    Apple() {

    }

    int getPrice(){
        return price;
    }
}
