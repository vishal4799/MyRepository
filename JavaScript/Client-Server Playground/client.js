'use strict';	
	
//	
// app.js	
//	
	
const express = require('express');  	
const app = express();  	
const bodyParser = require('body-parser');	
var path = require('path');	
	
app.use(bodyParser.json());  	
app.use(bodyParser.urlencoded({ extended: false }));	
	
// app.get('/', function(req, res) {  	
//     let data = {	
//         message: 'Hello World!'	
//     };	
//     res.status(200).send(data);	
// });	
	
app.get('/', function(req, res) {	
    res.sendFile(path.join(__dirname, 'CallServerAPIUsingPlanJavascript.html'));	
});	
	
	
app.get('/olaengine/rest/olaapi/admin/manage/indexblocks', function(req, res) {  	
    let data = ["small","medium","large"];	
    res.header("Access-Control-Allow-Origin", "*");	
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");	
    res.status(200).send({'logTypeList' : data});	
});	
	
app.listen(4000, function() {  	
    console.log('Express server listening on port 4000');	
}); 