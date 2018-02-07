package com.chain.toychain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PeerToPeerNetwork {

    private Map<String, Peer> peers; //<id, peer>

    private BlockChain chain;

    public PeerToPeerNetwork() {
        this.peers = new HashMap<>();
        this.chain = new BlockChain();
        this.peers.put("0000", new Peer("0000", this.chain.clone())); //创世对等网络
    }

    public void register(String id) {
        if (!this.peers.containsKey(id)) {
            this.peers.put(id, new Peer(id, this.chain.clone()));
        }
    }

    public void out(String id) {
        this.peers.remove(id);
    }

    public void broadcast(String id, Block block) {
        if (id == null || block == null) {
            return;
        }
        int count = 1;
        String lastId = "";
        for (Map.Entry<String, Peer> peerEntry : this.peers.entrySet()) {
            String peerId = peerEntry.getKey();
            if (id.equals(peerId)) {
                continue;
            }
            Peer peer = peerEntry.getValue();
            BlockChain curChain = peer.getBlockChain();
            boolean added = curChain.addBlock(block);
            if (added) {
                count++;
                lastId = peerId;
            }
        }
        if (count > this.peers.size()/2) {
            boolean added = this.chain.addBlock(block);
            if (!added) {
                Peer lastPeer = this.peers.get(lastId);
                this.chain = lastPeer.getBlockChain().clone();
            }
        }
    }

    public void syncPeer(String id) {
        Peer peer = this.peers.get(id);
        Block currentBlock = peer.getBlockChain().getCurrentBlock();
        if (currentBlock.getHash().equals(this.chain.getCurrentBlock().getHash())) {
            return;
        } else {
            peer.setBlockChain(this.chain);
        }
    }


    public BlockChain getChain() {
        return chain;
    }

    public BlockChain getChainByPeer(String peerId) {
        if (this.peers.containsKey(peerId)) {
            return this.peers.get(peerId).getBlockChain();
        } else {
            return null;
        }
    }
}
