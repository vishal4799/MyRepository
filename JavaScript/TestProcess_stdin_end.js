//hackerRank
process.stdin.resume();
process.stdin.setEncoding('ascii');

var lines = "";
var line_arr = [];
process.stdin.on('data', function(data) {
	console.log("data:"+data);
    lines += lines+data;

});

process.stdin.on('end', function() {
	line_arr = lines.split("\n");
    console.log(lines);
    process.stdout.write(`1:${lines[0]}  2:${lines[1]}  3:${lines[2]} end\n`);
    process.stdout.write("1:"+lines[0]+" 2:"+lines[1]+" 3"+lines[2]+" end\n");
});