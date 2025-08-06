const { CryptoBlockChain, CryptoBlock } = require('./types')

let testCoin = new CryptoBlockChain();

console.log('testCoin mining in progress....');

testCoin.insertData({ sender: 'david', receiver: 'jack', quantity: 50 });
testCoin.insertData({ sender: 'jack', receiver: 'John', quantity: 100 });

console.log(JSON.stringify(testCoin, null, 4));