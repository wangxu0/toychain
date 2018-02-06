package com.chain.toychain;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockChainRest {

    @Autowired
    private PeerToPeerNetwork peerToPeerNetwork;

    @GetMapping(value = "/chain")
    public String getBlockChain() {
        BlockChain chain = peerToPeerNetwork.getChain();
        return chain.toString();
    }

    @GetMapping(value = "/chain/{peerId}")
    public String getPeerBlockChain(@PathVariable("peerId") String peerId) {
        BlockChain chainByPeer = peerToPeerNetwork.getChainByPeer(peerId);
        if (chainByPeer != null){
            return chainByPeer.toString();
        } else {
            return "[]";
        }
    }

    @GetMapping(value = "/block/{hash}")
    public String getBlockByHash(@PathVariable("hash") String hash) {
        Block block = peerToPeerNetwork.getChain().getBlockByHash(hash);
        if (block == null) {
            return "{}";
        }
        return JSON.toJSONString(block);
    }

    @PostMapping(value = "/register/{id}")
    public void register(@PathVariable("id") String id) {
        peerToPeerNetwork.register(id);
    }

    @PostMapping(value = "/out/{id}")
    public void out(@PathVariable("id") String id) {
        peerToPeerNetwork.out(id);
    }

    @PostMapping(value = "/broatcast/{id}")
    public String broatcast(@PathVariable("id") String id, @RequestBody String data) {
        BlockChain chainByPeer = peerToPeerNetwork.getChainByPeer(id);
        Block block = chainByPeer.assemblyNextBlock(data);
        boolean added = chainByPeer.addBlock(block);
        if (added) {
            peerToPeerNetwork.broatcast(id, block);
            return "{'status':'true'}";
        } else {
            return  "{'status':'false'}";
        }
    }

    @PostMapping(value = "/peer/sync/{peerId}")
    public void syncPeer(@PathVariable("peerId") String peerId) {
        peerToPeerNetwork.syncPeer(peerId);
    }

}
