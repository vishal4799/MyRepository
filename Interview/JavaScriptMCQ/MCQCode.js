var a = !!(0);
var b = !!("0");
var c;
console.log(a);
console.log(b);
console.log(c == undefined);
console.log(c === null);
console.log(c == null);
console.log(c === undefined);
console.log("" == undefined);
console.log("" == null);
console.log(!"");
console.log(!c && !"" && !0);


var print_names = function() {
    for (var i=0; i<arguments.length; i++) console.log(arguments[i]);
}

print_names(1,2,3);

