/**
 * How to empty array?
 */
var foo = [1,2,3];
var bar = [1,2,3];
var foo2 = foo;
var bar2 = bar;
foo = [];
// But there is another way to empty an array that is more performant. You should use code like this:
bar.length = 0;
console.log(foo, bar, foo2, bar2);
// [] [] [1, 2, 3] []

/**
 * What is the difference between above 2 ways?
 * list = [] assigns a reference to a new array to a variable, while any other references are unaffected. which means that references to the contents of the previous array are still kept in memory, leading to memory leaks.
 * list.length = 0 deletes everything in the array, which does hit other references.
 * In other words, if you have two references to the same array (a = [1,2,3]; a2 = a;), and you delete the array’s contents using list.length = 0, both references (a and a2) will now point to the same empty array. (So don’t use this technique if you don’t want a2 to hold an empty array!)
 */


function AA(name){
    this.name = name;
    this.p = function(o){
        console.log(o.name);
        console.log(o.name.info);
    }
}
var aa= new AA("vihsal");
aa.p(aa);
console.log("===========")
var f= 0;
 function a(){
     if(false){

         var f = 1; 
     }
     console.log(f);

 }

 var b = new Array("0","1");
 console.log(b);
 var c = {a:0,b:1};
 c.b = undefined;
 console.log(JSON.stringify(c));
 a();