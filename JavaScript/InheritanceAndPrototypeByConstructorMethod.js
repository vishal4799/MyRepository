//not normal method, it's constructive Method who create object in javascript.
// var sampleObj = new SampleObject(1,2);
function SampleObject(prop1,prop2){
//var SampleObject = function (prop1,prop2){ //it works same
    var privateProp1 = 100;
    var privateProp2 = "hundred";
    this.publicProp1 = prop1;
    this.publicProp2 = prop2;
    // if you uncomment below code it will no more prototype/constructiveMethod, for more detail refer .js
    // return {
    //     getPrivateProp1 : function(){
    //         return privateProp1;
    //     },
    //     setPrivateProp1 : function(passedvalue){
    //         privateProp1 = passedvalue;
    //     },
    // }
}
SampleObject.prototype = {
    getPublicProp1 : function(){
        return this.publicProp1;
    },
    setPublicProp1 : function(passedvalue){
        this.publicProp1 = passedvalue;
    },
    
    getPublicProp2 : function(){
        return this.publicProp2;
    },
    setPublicProp2 : function(passedvalue){
        this.publicProp2 = passedvalue;
    }
} 
console.log("SampleObject.constructor:"+SampleObject.constructor);
console.log("SampleObject.constructor.prototype:"+SampleObject.constructor.prototype);
console.log("SampleObject.constructor.__proto__:"+SampleObject.constructor.__proto__);
console.log("== : "+SampleObject.constructor.prototype == SampleObject.constructor.__proto__);
console.log("== : "+SampleObject.constructor.prototype ==- SampleObject.constructor.__proto__);

//lets try to test SampleObject calling it as a normal method instead of constructiveMethod
var test = SampleObject(0,1);
console.log("it works by returning test : "+test+", but there is no sense in it.");
var sampleObj = new SampleObject(1,"two");
console.log("sampleObj.hasOwnProperty(\"valueOf\"):"+sampleObj.hasOwnProperty("valueOf"));
console.log("sampleObj.__proto__.hasOwnProperty(\"valueOf\"):"+sampleObj.__proto__.hasOwnProperty("valueOf"));
console.log("sampleObj.__proto__.__proto__.hasOwnProperty(\"valueOf\"):"+sampleObj.__proto__.__proto__.hasOwnProperty("valueOf"));

var t = {};
console.log("t.hasOwnProperty(\"valueOf\"):"+t.hasOwnProperty("valueOf"));
console.log("t.__proto__.hasOwnProperty(\"valueOf\"):"+t.__proto__.hasOwnProperty("valueOf"));

console.log("PublicProp1 : "+sampleObj.publicProp1);
console.log("PublicProp1 : "+sampleObj.publicProp2);
console.log("PublicProp1 by function : "+sampleObj.getPublicProp1());
console.log("PublicProp2 by function : "+sampleObj.getPublicProp2());

sampleObj.setPublicProp1(1000);
console.log("PublicProp1 : "+sampleObj.getPublicProp1());
sampleObj.setPublicProp2("thousands");
console.log("PublicProp2 : "+sampleObj.getPublicProp2());

