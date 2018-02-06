package com.chain.toychain;

public class Block {

    private long number;

    private long timestamp;

    private String data;

    private String hash;

    private String previousHash;

    private long diffculty;

    private long nonce;

    private int versoin;

    public Block() {

    }

    public Block(long number, long timestamp, String data, String hash, String previousHash, long diffculty, long nonce, int versoin) {
        this.number = number;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
        this.previousHash = previousHash;
        this.diffculty = diffculty;
        this.nonce = nonce;
        this.versoin = versoin;
    }

    public Block(long number, long timestamp, String data, String hash, String previousHash, int versoin) {
        this.number = number;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
        this.previousHash = previousHash;
        this.versoin = versoin;
    }

    public Block(long number, long timestamp, String data, String hash, String previousHash) {
        this.number = number;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
        this.previousHash = previousHash;
        this.versoin = 1;
    }

    public Block(long number, long timestamp, String data, String previousHash) {
        this.number = number;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.versoin = 1;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public long getDiffculty() {
        return diffculty;
    }

    public void setDiffculty(long diffculty) {
        this.diffculty = diffculty;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public int getVersoin() {
        return versoin;
    }

    public void setVersoin(int versoin) {
        this.versoin = versoin;
    }

    @Override
    public String toString() {
        return "Block{" +
                "number=" + number +
                ", timestamp=" + timestamp +
                ", data='" + data + '\'' +
                ", hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", diffculty=" + diffculty +
                ", nonce=" + nonce +
                ", versoin=" + versoin +
                '}';
    }
}
