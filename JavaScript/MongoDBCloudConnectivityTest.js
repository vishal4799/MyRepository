//Description : it connects with mongodb installed on localhost on port 27017(admin instance)
//              fetch data from collection "system.version" using mongoclient (can be done using mongoose as well)
//Install mongo db software
//do : npm install mongodb
//run cmd: mongod from cmd.exe to start mongo db server
//you can open mongo db client console using "mongo" command in cmd.exe
//few usefull cmds : show dbs , use 'admin', show collections, db.collectionname.find().limit()
//import db using mongorestore 'dumbfoldername'

var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var url = 'mongodb://localhost:27017/admin';
MongoClient.connect(url, function(err, db) {
  assert.equal(null, err);
  console.log("Connected correctly to db server." );

  var cursor = db.collection('system.version').find().limit(10);
  console.log("Data of collection 'system.version' : ");
  cursor.each(function (err, doc) {
      if (doc != null) {
          console.dir(doc);
      }
  });
  db.close();
});


