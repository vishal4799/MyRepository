var questions = ["name? \n","hobby? \n", "fav lang? \n"];
var answers = [];

function askQuestion(i){
	process.stdout.write(questions[i]);
}

process.stdin.on("data", function(data){
	answers.push(data.toString().trim());
	if(answers.length < questions.length){
		askQuestion(answers.length);
	} else {
		process.exit();
	}
});
process.stdin.on("end", function(data){
	console.log("\n Stdin stream end triggerd..");
});

process.on("exit", function(){
	process.stdout.write("Go for "+answers[1]+" "+answers[0]+", you can do "+answers[2]+" later.\n");	
	process.stdout.write(`Go for ${answers[1]} ${answers[0]}, you can do ${answers[2]} later.\n`);	
});
askQuestion(0);

