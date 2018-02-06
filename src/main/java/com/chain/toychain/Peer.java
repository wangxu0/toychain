package com.chain.toychain;

public class Peer {

    private String id;

    private BlockChain blockChain;

    public Peer(String id, BlockChain blockChain) {
        this.id = id;
        this.blockChain = blockChain;
    }

    public String getId() {
        return id;
    }

    public BlockChain getBlockChain() {
        return blockChain;
    }

    public void setBlockChain(BlockChain blockChain) {
        this.blockChain = blockChain;
    }

}
