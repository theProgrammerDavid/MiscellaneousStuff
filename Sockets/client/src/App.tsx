import React from 'react';
import logo from './logo.svg';
import './App.css';

import { io, type Socket } from 'socket.io-client';

interface ServerToClientEvents {
  send: (a: any) => void;
}

interface ClientToServerEvents {
  get: (a: string) => void;
}
const socket: Socket<ServerToClientEvents, ClientToServerEvents> = io(`http://${window.location.hostname}:4000`);

function App() {

  const [msg, setMsg] = React.useState<string>('');

  socket.on("send", (count) => {
    console.log(JSON.stringify(count))
    setMsg(`count is ${count.data}`);

    socket.emit('get', msg);
  })


  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          msg |<code>{JSON.stringify(msg)}</code>|
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
