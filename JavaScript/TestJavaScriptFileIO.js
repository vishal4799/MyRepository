
//Currently there are three ways to write a file:
//
//1. fs.write(fd, buffer, offset, length, position, callback)
//You need to wait for the callback to ensure that the buffer is written to disk. It's not buffered.
//
//2. fs.writeFile(filename, data, [encoding], callback)
//All data must be stored at the same time; you cannot perform sequential writes.
//
//3.fs.createWriteStream(path, [options])
//Creates a WriteStream, which is convenient because you don't need to wait for a callback. But again, it's not buffered.

//File Writing ASync======================================================================
console.log("\n\nFile writing Sync[fs]..............");
var fs = require('fs');
// TestFileWrting.txt is not in folder, it will create it.
// if exist then override existing content with 2nd parameter.
fs.writeFile("TestFileWrting.txt", "\nHey there2!\n", function(err) {
    if(err) {
        return console.log(err);
    }

    console.log("The file was saved!");
}); 
fs.writeFile("TestFileWrting.txt", "\nHey there3!\n");
fs.writeFile("TestFileWrting.txt", "\nHey there4!\n");
console.log("\n\nFile writing end..............");
//File Writing ASync [fs stream]======================================================================
//You can of course make it a little more advanced. Non-blocking, writing bits and pieces, not writing the whole file at once:
var fs = require('fs');
var stream = fs.createWriteStream("TestFileWrtingWithStream.txt");
stream.once('open', function(fd) {
  stream.write("My first row\n");
  stream.write("My second row\n");
  stream.end();
});
console.log("\n\nFile Writing ASync [fs stream] end..............");
console.log("\n\nFile writing Sync[fs]..............");
//File reading Sync======================================================================
console.log("\n\nFile reading Sync[fs]..............");
var fs = require('fs');
var array = fs.readFileSync('InputFile.txt').toString().split("\n");
for(i in array) {
    console.log(array[i]);
}
console.log("\ntest msg for Sync check");
//File reading line by line[fs,readline] Async===========================================
console.log("\n\nFile reading line by line[fs,readline] Async.............");
var readline = require('readline');
//var filename = process.argv[2];
var inputStream = fs.createReadStream("InputFile.txt");
inputStream.on("end",function(){
	console.log("\n File end triggered..");
});
readline.createInterface({
    input: inputStream,
    terminal: false
}).on('line', function(line) {
   console.log('Line: ' + line);
});
console.log("\ntest msg for Async check");
//File reading Async=======================================================================
console.log("\n\nFile reading Async[fs].............");
fs.readFile('InputFile.txt', function(err, data) {
    if(err) throw err;
    var array = data.toString().split("\n");
    for(i in array) {
        console.log(array[i]);
    }
});
console.log("\ntest msg for Async check2");