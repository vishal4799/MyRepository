'use restrict';

const express = require('express');
const app = express();
app.listen(8090,'0.0.0.0');

app.get('/',(req, res) => {
    console.log(req);
    res.send(`hellooo ${req.query.name}`);
});
console.log("Running on http://0.0.0.0:8090");
