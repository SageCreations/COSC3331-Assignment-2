

public class Item {
    private int key;
    private int timeStamp;

    public Item(int key, int timeStamp) {
        this.key = key;
        this.timeStamp = timeStamp;

    }

    public int getKey() {
        return key;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return (key + ":" + timeStamp);
    }


}
