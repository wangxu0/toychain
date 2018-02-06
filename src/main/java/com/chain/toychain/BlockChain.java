package com.chain.toychain;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    private List<Block> blocks;

    public BlockChain() {
        this.blocks = new ArrayList<>();
        //创世区块
        Block creationBlock = new Block(1, System.currentTimeMillis(), "Creation Block", "0");
        creationBlock.setHash(hash(creationBlock));
        this.blocks.add(creationBlock);
    }

    private BlockChain(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Block getCurrentBlock() {
        return blocks.get(blocks.size() - 1);
    }

    public Block assemblyNextBlock(String data) {
        Block previousBlock = this.getCurrentBlock();
        Block nextBlock = new Block(previousBlock.getNumber() + 1, System.currentTimeMillis(), data, previousBlock.getHash());
        nextBlock.setHash(hash(nextBlock));
        return nextBlock;
    }

    public boolean addBlock(Block block) {
        if (checkBlock(block)) {
            blocks.add(block);
            return true;
        } else {
            System.out.println("The block was lied which is " + block.toString());
            return false;
        }
    }

    public Block getBlockByHash(String hash) {
        for (Block block : blocks) {
            if (block.getHash().equals(hash)) {
                return block;
            }
        }
        return null;
    }
    private boolean checkBlock(Block block) {
        Block previousBlock = this.getCurrentBlock();
        if (block == null)
            return false;
        if (block.getNumber() != previousBlock.getNumber() + 1) {
            return false;
        }
        if (!previousBlock.getHash().equals(block.getPreviousHash())) {
            return false;
        }
        if (!this.hash(block).equals(block.getHash())) {
            return false;
        }
        return true;
    }

    private String hash(Block block) {
        if (block == null) {
            return "";
        }
        return SignatureUtils.SHA256(new StringBuilder().append(block.getNumber())
                .append(block.getTimestamp()).append(block.getData())
                .append(block.getPreviousHash()).append(block.getVersoin())
                .toString());
    }

    public BlockChain clone() {
        List<Block> cloneBlocks = new ArrayList<>(this.blocks);
        BlockChain cloneChain = new BlockChain(cloneBlocks);
        return cloneChain;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this.blocks);
    }

}
