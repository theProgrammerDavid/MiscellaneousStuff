const SHA256 = require('crypto-js/sha256');
const { IllegalBlockTypeError } = require('./errors');
class CryptoBlock {
    /**
     * 
     * @param {Number} index 
     * @param {timestamp} timestamp 
     * @param {JSON} data 
     * @param {string} preceedingHash 
     */
    constructor(index, timestamp, data, precedingHash = ' ') {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.precedingHash = precedingHash;
        this.hash = this.computeHash();
        this.nonce = 0;
    }

    /**
     * Returns Hash of the current block
     * @returns string SHA256 hash of the current block
     */
    computeHash() {
        return SHA256(this.index + this.precedingHash + this.timestamp +
            JSON.stringify(this.data) + this.nonce).toString();
    }


    proofOfWork(difficulty) {
        while (
            this.hash.substring(0, difficulty) !==
            Array(difficulty + 1).join("0")
        ) {
            this.nonce++;
            this.hash = this.computeHash();
        }
    }
}

class CryptoBlockChain {
    constructor() {
        this.blockchain = [this.startGenesisBlock()];
        this.difficulty = 4;
    }

    /**
     * startGenesisBlock initializes the blockchain
     * @returns CryptoBlock with index 0
     */
    startGenesisBlock() {
        return new CryptoBlock(0, new Date(), "Initial Block", "0");
    }

    /**
     * Returns the last block in the blockchain of type CryptoBlock
     * @returns CryptoBlock
     */
    obtainLatestBlock() {
        return this.blockchain[this.blockchain.length - 1];
    }

    /**
     * 
     * @param {JSON} data data to insert
     */
    insertData(data) {
        let newBlock = new CryptoBlock(this.blockchain.length, new Date(), data);
        this.addNewBlock(newBlock);
    }

    /**
     * Adds a new block to the blockchain
     * @param {CryptoBlock} newBlock 
     */
    addNewBlock(newBlock) {

        if (!newBlock instanceof CryptoBlock) {
            throw new IllegalBlockTypeError("Error inserting into blockchain",
                `Cannot insert ${typeof newBlock} into blockchain of type ${typeof CryptoBlock}`);
        }
        newBlock.precedingHash = this.obtainLatestBlock().hash
        // newBlock.hash = newBlock.computeHash();
        newBlock.proofOfWork(this.difficulty);
        this.blockchain.push(newBlock);
    }


    verifyIntegrity() {
        for (let i = 1; i < this.blockchain.length; i++) {
            let currentBlock = this.blockchain[i];
            let prevBlock = this.blockchain[i - 1];

            if (currentBlock.hash !== currentBlock.computeHash() ||
                currentBlock.precedingHash !== prevBlock.hash) {
                return false;
            }
        }
        return true;
    }
}

module.exports = {
    CryptoBlock, CryptoBlockChain
}