const greetModule = require('./build/Release/greet.node');
// const greetModule = require('bindings')('greet');
// exports.hello = greetModule.greetHello;

console.log(greetModule)
const { greetHello } = greetModule;
// console.log(__filename)
// console.log(makeGetRequest("https://davidvelho.tech"));
console.log(greetHello("David"));