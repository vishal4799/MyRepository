console.log("require........... ConstructorObj");
function ConstructorClass(){
    console.log("new ConstructorObj");
    this.a = 0;
}
ConstructorClass.prototype.init = ()=>{
    this.b = 1;
}

module.exports = ConstructorClass;