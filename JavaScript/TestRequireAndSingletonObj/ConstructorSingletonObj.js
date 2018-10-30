console.log("require........... ConstructorSingletonObj");
function ConstructorSingletonObj(){
    this.a = 0;
    console.log("new Object ::"+ this.a);
}
ConstructorSingletonObj.prototype.init = ()=>{
    this.b = 1;
}

module.exports = new ConstructorSingletonObj();