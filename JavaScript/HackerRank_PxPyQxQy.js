/*
Consider two points,  and . We consider the inversion or point reflection, , of point  across point  to be a  rotation of point  around .

Given  sets of points  and , find  for each pair of points and print two space-separated integers denoting the respective values of  and  on a new line.

Input Format

The first line contains an integer, , denoting the number of sets of points. 
Each of the  subsequent lines contains four space-separated integers describing the respective values of , , , and  defining points  and .

Constraints

Output Format

For each pair of points  and , print the corresponding respective values of  and  as two space-separated integers on a new line. 
*/

function processData(input) {
    //process.stdout.write("vishal::"+input);
    var lines = input.split("\n");
    var noOfQuestion = lines[0].trim();
    //process.stdout.write("\nnoOfQuestion::"+noOfQuestion);
    for(let i=1; i< lines.length; i++){
        let pq = lines[i].split(" ");
        let px = pq[0], py = pq[1], qx = pq[2], qy = pq[3];
        let rx = parseInt(qx)+parseInt(qx-px), ry = parseInt(qy)+parseInt(qy-py);
        //process.stdout.write("line:"+lines[i]+"\n");
        //process.stdout.write(`px ${px} py ${py} qx ${qx} qy ${qy} \n`);
        process.stdout.write(rx+" "+ry+"\n");
    }
    
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
    process.stdout.write(`input ${input}`);
});

process.stdin.on("end", function () {
   processData(_input);
});

/*
Input (stdin)

2
0 0 1 1
1 1 2 2
Your Output (stdout)

2 2
3 3
Expected Output

2 2
3 3
*/