package main.java.com.github.dawnflyc.mae;

/**
 * hash数据
 */
public class HashData {
    /**
     * hash值
     */
    private String hash;
    /**
     * 文件大小
     */
    private int size;

    public HashData(String hash, int size) {
        this.hash = hash;
        this.size = size;
    }

    public HashData() {
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
