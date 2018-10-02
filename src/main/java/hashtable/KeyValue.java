package hashtable;

/**
 * Created by MoaadA on 9/26/2018.
 */
public class KeyValue<k, v> {
    k key;
    v value;

    public KeyValue(k key, v value) {
        this.key = key;
        this.value = value;
    }

    public k getKey() {
        return key;
    }

    public void setKey(k key) {
        this.key = key;
    }

    public v getValue() {
        return value;
    }

    public void setValue(v value) {
        this.value = value;
    }
}

