//var var1 = 1;
(function() {
    var var1;
	var1 = 'variable 1 value in parent scope';
	var abc = function() {
        // Scope 1
        var1 = 'variable 1 value in scope 1';
        console.log('scope 1: ', var1); // Is 'variable 1 value in scope 1'
    };

    (function() {
        // Scope 2
        var1 = 'variable 1 value in scope 2';
        console.log('scope 2: ', var1); // Is 'variable 1 value in scope 2'
    }());
	abc();
	console.log('Parent scope: ', var1); // Is 'variable 1 value in parent scope'
	if(true){
		let letTest = 1;
		var varTest = 2;
    }
	console.log("test:var:"+varTest);//global scoped inside function
	//console.log("test:let:"+letTest);//only block(loop, if, inner fucntion) scoped inside function
    

}());
console.log("first:"+var1);//not in any function. so undefined or uncomment first line.

//const test
(function() {
    const constVar1 = 'const variable 1 value in parent scope';
    //const constVar1 = 'redclare in same scope';
    //constVar1 = 'modified in same scope';
    console.log('scope parent1: ', constVar1); 
    (function() {
        // Scope 1
        //console.log('scope 1: ', constVar1);
        // scope 1:  const variable 1 value in parent scope
        const constVar1 = 'reclare in other scope : const variable 1 value in scope 1';
        // Is Identifier 'constVar1' has already been declared
        console.log('scope 1: ', constVar1);    
    }());
    console.log('scope parent2: ', constVar1); 
}());