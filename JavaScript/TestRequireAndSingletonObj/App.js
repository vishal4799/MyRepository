console.log("==============StaticObj===============");
var staticObj = require("./StaticObj");
console.log("staticObj.a :" +staticObj.a);
staticObj.a = 1;
console.log("staticObj.a :" +staticObj.a);
var staticObj2 = require("./StaticObj");
console.log("staticObj2.a :" +staticObj2.a);
var STATICOBJ = require("./STATICOBJ");
console.log("STATICOBJ.a :" +STATICOBJ.a);

console.log("==============ConstructorClass===============");

var ConstructorClass = require("./ConstructorClass");
ConstructorClass.prototype.init2 = () =>{
    this.b = 2;
};
var constructorClass = new ConstructorClass();
console.log("ConstructorClass.a :" +constructorClass.a);
constructorClass.a = 1;
console.log("ConstructorClass.a :" +constructorClass.a);
constructorClass.init();
var ConstructorClass2 = require("./ConstructorClass");
var constructorClass2 = new ConstructorClass2();
constructorClass2.init2();
console.log("ConstructorClass2.a :" +constructorClass2.a);
var CONSTRUCTORCLASS = require("./CONSTRUCTORCLASS");
var CONSTRUCTOROBJ = new CONSTRUCTORCLASS();
console.log("CONSTRUCTORCLASS.a :" +CONSTRUCTOROBJ.a);
//TypeError: CONSTRUCTOROBJ.init2 is not a function
//CONSTRUCTOROBJ.init2();

console.log("==============ConstructorObj : Singleton===============");

var constructorObj = require("./ConstructorSingletonObj");
console.log("ConstructorObj.a :" +constructorObj.a);
constructorObj.a = 1;
console.log("ConstructorObj.a :" +constructorObj.a);

var constructorObj2 = require("./ConstructorSingletonObj");
console.log("ConstructorObj2.a :" +constructorObj2.a);
var CONSTRUCTOROBJ = require("./CONSTRUCTORSINGLETONObj");
console.log("CONSTRUCTOROBJ.a :" +CONSTRUCTOROBJ.a);

console.log("==============ConstructorClass : using Proxyquire===============");
var proxyquire = require('proxyquire').noCallThru();
var ProxyquireConstructorClass = proxyquire("./ConstructorClass");
ProxyquireConstructorClass.prototype.init2 = () =>{
    this.b = 2;
};
var pqconstructorClass = new ProxyquireConstructorClass();
console.log("ConstructorClass.a :" +pqconstructorClass.a);
pqconstructorClass.a = 1;
console.log("ConstructorClass.a :" +pqconstructorClass.a);
constructorClass.init();
var ProxyquireConstructorClass2 = require("./ConstructorClass");
var pqconstructorClass2 = new ProxyquireConstructorClass2();
pqconstructorClass2.init2();
console.log("pqConstructorClass2.a :" +pqconstructorClass2.a);
var PQCONSTRUCTORCLASS = require("./CONSTRUCTORCLASS");
var PQCONSTRUCTOROBJ = new PQCONSTRUCTORCLASS();
console.log("PQCONSTRUCTORCLASS.a :" +PQCONSTRUCTOROBJ.a);
//TypeError: CONSTRUCTOROBJ.init2 is not a function
//CONSTRUCTOROBJ.init2();


