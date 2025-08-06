const express = require('express');
const http = require('http')
const cors = require('cors')
const { Server } = require('socket.io');

const picklistData = require('./SAMPLE_DATA/PICKLIST_DATA.json');
const productDetails = require('./SAMPLE_DATA/BOT_PRODUCT_DETAILS.json');

const app = express();
app.use(cors())
const server = http.createServer(app);

const io = new Server(server, {
  cors: {
    origin: "*"
  }
});

app.get("/help", (req, res) => {
  res.send('ok');
})

let counter = 0;
let batteryCount = 0;

io.on("connection", (socket) => {
  console.log('connected')
  // send a message to the client

  // const interval = setInterval(() => {
  //   socket.emit('send', { data: counter });
  //   counter++;
  // }, 1000);

  const timeout1 = setTimeout(() => {
    //  topic, reached, finished
    socket.emit('bot_movement', 'REACHED');
  }, 6000)

  const timeout2 = setTimeout(() => {
    //  topic, reached, finished
    socket.emit('picklist_data_ros', picklistData);
  }, 5000)

  const timeout3 = setTimeout(() => {
    //  topic, reached, finished
    socket.emit('product_details', productDetails);
  }, 5000)

  const interval = setInterval(() => {
    socket.emit('wifi', true, 65,);
    counter++;
  }, 1000);

  const interval2 = setInterval(() => {
    socket.emit('battery', true, (batteryCount++)%100);
    counter++;
  }, 1000);


  // receive a message from the client
  socket.on("get", (...args) => {
    // ...
    console.log(`received stuff: ${args}`)
  });

  socket.on('disconnect', () => {
    console.log('A client has disconnected');

    // Stop emitting events when the client disconnects
    clearInterval(interval);
    clearInterval(interval2);
    clearTimeout(timeout1);
    clearTimeout(timeout2);
    clearTimeout(timeout3);
  });
});

server.listen(4000, () => {
  console.log('listening on *:4000');
});