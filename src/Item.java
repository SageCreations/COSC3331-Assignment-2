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

    // no get timeStamp accessor since i need to create a stable sorting algo for duplicate keys.

    @Override
    public String toString() {
        return (key + ":" + timeStamp);
    }
}
