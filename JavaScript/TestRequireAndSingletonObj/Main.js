var singleton = require("./ConstructorSingletonObj");
singleton.a = -1;
console.log("Singleton.a from main:"+singleton.a);
require("./App");