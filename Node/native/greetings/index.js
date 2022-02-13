// const greetModule = require('./build/Release/greet.node');
const greetModule = require('bindings')('greet');
exports.hello = greetModule.greetHello;