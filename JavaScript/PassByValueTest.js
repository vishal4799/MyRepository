//var means it can be object, array and primitive data
//java script is pass by value only in all above cases.
//when you pass "primitive data", change made inside function will not reflect outside function
//when you pass "object or array", you are passing reference value of it not the actual value.
    //so cannot change the reference of it(using new and assigning new obj to it). change made inside function(new assignment to passed reference) will not reflect outside function
    //but you can change the attribute/property of it and it will reflect outside the function. 

function passbyValue(obj1, obj2, b, arr1, arr2){
    obj1.x = 2; //will reflect
    obj2={}; //will not reflect
    b = b+1; //will not reflect
    arr1[1] = 'a'; //will reflect
    arr2 = []; //will not reflect
}

var obj1= {x:0}, obj2={y:0}, b=0, arr1 = [1,2,3], arr2= ['a','b','c'];

passbyValue(obj1,obj2,b,arr1,arr2);
console.log(obj1);//toString and toLocalString do not prints actual content of obj. so hv to write it separate
console.log(obj2);
console.log("b:"+b+"\narr1:"+arr1+"\narr2:"+arr2);
