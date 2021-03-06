// Quick ways of objection creation. Explain each way in details from line number 11.
// var temp = {a:1};
// var obj = {a:1}; // obj == temp or obj === temp 
// var obj2 = temp; 
// var obj3 = Object(temp);  
// var obj4 = new Object(temp); // Object constructor
// var a = new A(); 				 // Custom constructor
// var a = Object.create(obj, propertyObj(with propertyDescriptor)); // a.__proto__ === obj but a != obj, so no memory address changes
// var a = Object.assign({},obj1,obj2) // user memory address of first agrument obj.

// Step:1 Run each line of this file in chrome console and try to see the object strucure.

// Numbers =================================================================================================
    // below both declaration are same. both create primitive value instead of object
    var primitiveNumber1 = 1; var primitiveNumber2 = Number(1);
    console.log(typeof primitiveNumber1);// number
    console.log(typeof primitiveNumber2);// number
    console.log(primitiveNumber1 === primitiveNumber2);// true
    // This one creates Object
    var objNumber = new Number(1); // just like below example of Employee constructor
    console.log(typeof objNumber);// object
    console.log(objNumber === primitiveNumber1);// false

// Same goes for Strings =====================================================================================
    var primitiveString1 = "vishal"; var primitiveString2 = String("vishal");
    console.log(typeof primitiveString1);// string
    console.log(typeof primitiveString2);// string
    // This one creates Object
    var objString = new String("vishal"); // just like below example of Employee constructor  
    console.log(typeof objString);// object
    console.log(objString === primitiveString1);// false

// But for Object, it's always Object object no primitive, i mean yes its obvious....==============================
    // creating temp object to pass in argument
    var temp = {a:1};
    // below all statement will create same object(except obj1 as it occupied diff memory space), there is no difference. it doesnt clone, it uses temp reference
    var obj1 = {a:1}; var obj2 = temp; var obj3 = Object(temp);  var obj4 = new Object(temp);
    // if you change any thing in temp like below it will reflect in all obj, except obj1.
    temp.a = 2;
    console.log(obj1+":"+obj2+":"+obj3+":"+obj4);

// there are few other option which are actually different than above 3. See the below options

// Constructor method
    function Shape() {
        this.x = 0;
        this.y = 0;
    }
    
    // superclass method
    Shape.prototype.move = function(x, y) {
    this.x += x;
    this.y += y;
    console.info('Shape moved.');
    };
    var shape = new Shape();
    Shape.isPrototypeOf(shape) // false
    // remember Shape, Object, String, Number are not prototype of any object as they are consturctor, their prototype is (object not constructor) isPrototypeOf any custom object(except the primitives)
    Shape.prototype.isPrototypeOf(shape); // true
    Object.prototype.isPrototypeOf(shape) // true

// Object.create(proto[, propertiesObject]) =======================================================================
    // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/create 
    // The Object.create(proto[, propertiesObject]) method creates a new object with the specified prototype object and properties.
    // creating object to pass on proto argument
        var employee = {
            employeeId : 0,
            name : "defaultName",
            getDetails : function(){console.log("Employee details:"+this.id+" - "+this.name);}
        }
        // strictly not recommanded, it doesnt give any error but it will add new property named "prototype", which 
        // just confuse you with keyword prototype or __proto__
        // You should create .prototype object only with constructor method and not with obj. Here employee is object
        // employee.prototype = {
        //     type : "full-time",
        //     getID : function(){
        //         console.log("Employee id:"+this.id);
        //     }
        // }
    // creating object to pass on propertiesObject optional argument,Obj structure of it is really important
        var temp = {p: { value : "vishal" }, q : {value:2}};
        // when you pass temp as propertiesObject, it will map temp's p,q as key and p.value,q.value as values in newly created object. in new object structure will be {p:"vishal",q:2}
        // you cant declare temp as temp = {p:1} or temp = {p : {anyWordOtherthanValue : "vishal"}}
        // it's property descriptor, for more details visit https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty 
    // By below statement, object employee(memory address xyz) will become createObj4's __proto__
    // in technical word it  employee === createObj4.__proto__  (both will refer same memory address xyz, any change in this memory reflect in both. means)
    // employee.employeeId === createObj4.__proto__.employeeId
    // createObj4.employeeId != createObj4.__proto__.employeeId (very important)
    // employee === createObj4 (very important)
    // but any change in propertiesObject (means temp) will not reflect in newly created object.
    var createObj4 = Object.create(employee, temp);
    // observe createObj4 in chrome console, u will see the employee contents in __proto__
    temp.p = {value2 : "sumita"};
    console.log(createObj4.p) // "vishal"
    // properties added using propertiesObject are default properties, they are not WRITABLE, ENUMERABLE or CONFIGURABLE
    createObj4.p = "rakesh";
    console.log(createObj4) // {p: "vishal", q: 2} // better observer in chrome console
    employee.isPrototypeOf(createObj4) // true
    Object.prototype.isPrototypeOf(createObj4) // true
    // remember Shape, Object, String, Number are not prototype of any object as they are consturctor, their prototype is (object not constructor) isPrototypeOf any custom object(except the primitives)
    Object.isPrototypeOf(createObj4) // false

// Object.assign(target, ...sources) =============================================================================
    // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/assign 
    // used for merge. (o1,o2,o3,..) it will return o1 reference with merge of all.
    // used for clone. ({},o1,o2,..) it will return new object with merge of all object starting from 2nd arugment.   
    var assignObj = Object.assign(employee, temp, {sa:5});
    console.log("assignObj:"+JSON.stringify(assignObj));
    console.log("employee:"+JSON.stringify(employee));
    console.log("employee === assignObj:"+(employee === assignObj));
    console.log("employee == assignObj:"+(employee == assignObj));
    var cloneObj = Object.assign({}, temp, {ac:2});
    console.log(assignObj);

console.log("End");