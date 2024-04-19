public class Book<K, V, I> extends Dictionary<K, V> {
    private I info;

    public Book(K key, V value) {
        super(key, value);
    }

    public Book(K key, V value, I info) {
        super(key, value);
        this.info = info;
    }

    public I getInfo() {
        return this.info;
    }

    public void setInfo(I info) {
        this.info = info;
    }
}
