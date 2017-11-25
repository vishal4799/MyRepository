function CaPiTaLiZe(str) {
    let result = "";
    for(let i = 0, j = 1 ; i < str.length ; i+=2 , j+=2){
        result += str[i].toUpperCase();
        if(j < str.length){
            result += str[j].toLowerCase();
        }
    }
    return result;
}

//console.log(CaPiTaLiZe("Hello world"));  



function add(x) {
	return function add2(y) {
        add2.result = function(){
            return x;
        }
        x += y;
        return add2;
    }
}

//console.log(add(5)(2)(4)(1));
console.log(add(5)(2).result());

function a(){
    a.b = function(){ console.log("innder function, can be called outside the parent function");}
}
a();
a.b();