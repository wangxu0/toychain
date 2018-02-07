# toychain，区块链模拟实现
## Overview
Toychain is a sample block chain toy.<br>

<p>参考此代码会帮助你更好的理解区块链的概念和原理。此外为了更好的体现区块链的概念，代码的实现尽可能的简单明了，忽略了一些编程细节。因此不会保证代码在并发场景下的正确性。如果你有更好的想法欢迎贡献代码。</p>

<p>This code will help you better understand the concept and principle of blockchain. In addition, in order to better embody the concept of blockchain, the implementation of the code is as simple as possible, ignoring some programming details.
Therefore, it will not guarantee the correctness of the code under concurrency scenarios. If you have better ideas welcome to commit your code.</p>

## Document
### Running
```
mvn clean package
```
```
nohup java -jar ./toychain-0.0.1-SNAPSHOT.jar &amp;
```
### Get blockchain
```
curl http://localhost:8080/toychain/chain
```
### Get chain from peer
```
curl http://localhost:8080/toychain/chain/{peerId}
```
### Get block by block hash
```
curl http://localhost:8080/toychain/block/{hash}
```
### Register peer to peer to peer network
```
curl -X POST http://localhost:8080/toychain/regitster/{id}
```
### Out peer
```
curl -X POST http://localhost:8080/toychain/out/{id}
```
### Broadcast a block with a peer id
```
curl -X POST --data "{transaction json data}" http://localhost:8080/toychain/broadcast/{id}
```
### Request to synchronous blockchain data
```
curl -X POST http://localhost:8080/toychain/peer/sync/{peerId}
```

