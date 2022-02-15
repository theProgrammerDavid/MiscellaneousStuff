const execFile = require('child_process').execFile;
const path = require('path');

const filePathSimple = "./sum_simple";
const filePathInput = "./sum_input";
const fileIo = "./file_io";

execFile(filePathSimple, [1, 100], function (err, stdout, stderr) {
    console.log('output from fimple file path exec is\n');
    console.log(stdout);
})

const child = execFile(filePathInput, [], function (err, stdout, stderr) {
    console.log('output from file input output is\n');
    console.log(stdout);
})

child.stdin.setDefaultEncoding('utf-8');

for (let i = 0; i < 5; i++) {
    child.stdin.write(`${i} ${i * 10}\n`);
}

const child2 = execFile(fileIo, [
    path.join(__dirname, 'input.txt'),
    path.join(__dirname, 'output.txt')
], function (err, stdout, stderr) {
    console.log('output from file io is stored in file output.txt\n');
})