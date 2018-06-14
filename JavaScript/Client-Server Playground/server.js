'use strict';	
	
//	
// app.js	
//	
	
const express = require('express');  	
const app = express();  	
const bodyParser = require('body-parser');	
	
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));	
	
app.use(function(req, res, next) {	
    res.header("Access-Control-Allow-Origin", "*");	
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");	
    next();	
});	
	
app.get('/', function(req, res) {  	
    let data = {	
        message: 'Hello World!'	
    };	
    res.status(200).send(data);	
});	
	
app.get('/olaengine/rest/olaapi/11.3/indexblocks', function(req, res) {  	
    let data =  {	
	
        blocklist : [	
    	
                        {	
                            "id" : "1",	
                            "blockName": "SmallIndexBlock",	
                	
                            "blockAttributes": {	
                	
                                "retention": 7,	
                	
                                "archival": false,	
                	
                                "redundancy": false	
                	
                            }	
                        },{	
                            "id" : "2",	
                            "blockName": "MediumIndexBlock",	
                	
                            "blockAttributes": {	
                	
                                "retention": 14,	
                	
                                "archival": false,	
                	
                                "redundancy": false	
                	
                            }	
                        },{	
                            "id" : "3",	
                            "blockName": "LargeIndexBlock",	
                	
                            "blockAttributes": {	
                	
                                "retention": 20,	
                	
                                "archival": false,	
                	
                                "redundancy": false	
                	
                            }	
                	
                        }	
                    ]	
    	
    }	
    res.status(200).send(data);	
});	
	
app.listen(4040, function() {  	
    console.log('Express server listening on port 4040');	
}); 