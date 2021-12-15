const express = require('express');
const fs = require("fs");

const app = express();

const PORT = process.env.PORT || 8000;

app.get("/video", (req,res)=>{
    const range = req.headers.range;
    if(!range){
        res.status(400).send("Requires range header");
    }

    const videoPath = __dirname + "/videos/vid1.mp4";
    const videoSize = fs.statSync(videoPath).size;

    const chunkSize = 10**6;
    const start = Number(range.replace(/\D/g, ""));
    const end = Math.min(start + chunkSize, videoSize - 1);

    const contentLength = end - start + 1;
    const headers = {
        "Content-Range": `bytes ${start}-${end}/${videoSize}`,
        "Accept-Ranges": "bytes",
        "Content-Length": contentLength,
        "Content-Type": "video/mp4",
    };

  // HTTP Status 206 for Partial Content
  res.writeHead(206, headers);

  // create video read stream for this particular chunk
  const videoStream = fs.createReadStream(videoPath, { start, end });

  // Stream the video chunk to the client
  videoStream.pipe(res);
})

app.get("/", (req,res)=>{
    res.sendFile(__dirname + "/static/index.html");
});

app.listen(PORT, function(){
    console.log(`Listening on port ${PORT}`);
})