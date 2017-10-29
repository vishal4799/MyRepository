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
    var primitiveString1 = "vishal"; var primitiveString2 = new String("vishal");
    console.log(typeof primitiveString1);// string
    console.log(typeof primitiveString2);// string
    // This one creates Object
    var objString = new String("vishal"); // just like below example of Employee constructor  
    console.log(typeof objString);// object
    console.log(objString === primitiveString1);// false

// But for Object, it's always Object object no primitive, i mean yes its obvious....==============================
    // creating temp object to pass in argument
    var temp = {a:1};
    // below all statement will create same object, there is no difference. it doesnt clone, it uses temp reference
    var obj1 = {a:1}; var obj2 = temp; var obj3 = Object(temp);  var obj4 = new Object(temp);
    // if you change any thing in temp like below it will reflecton all obj? except obj1.
    temp.a = 2;
    console.log(obj1+":"+obj2+":"+obj3+":"+obj4);

// there are few other option which are actually different than above 3. See the below options

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
        //when you pass temp as propertiesObject, it will map temp's p,q as key and p.value,q.value as values in newly created object. in new object structure will be {p:"vishal",q:2}
        // you cant declare temp as temp = {p:1} or temp = {p : {anyWordOtherthanValue : "vishal"}}
    // By below statement, object employee(memory address xyz) will become createObj4's prototype
    // in technical word it  employee === createObj4.__proto__  (both will refer same memory address xyz, any change in this memory reflect in both)
    // but any change in propertiesObject (means temp) will not reflect in newly created object.
    var createObj4 = Object.create(employee, temp);
    // observer createObj4 in chrome console, u will see the employee contents in __protp__
    temp.p = {value2 : "sumita"};
    console.log(createObj4.p) // "vishal"
    // properties added using propertiesObject are default properties, they are not WRITABLE, ENUMERABLE or CONFIGURABLE
    createObj4.p = "rakesh";
    console.log(createObj4) // {p: "vishal", q: 2} // better observer in chrome console
    employee.isPrototypeOf(createObj4) // true
    Object.prototype.isPrototypeOf(createObj4) // true
    // remember Object, String, Number are not prototype of any object. Their prototype are prototype of any custom object(except the primitives)
    Object.isPrototypeOf(createObj4) 

// Object.assign(target, ...sources)
    // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/assign 
    // used for merge. (o1,o2,o3,..) it will return o1 reference with merge of all.
    // used for clone. ({},o1,o2,..) it will return new object with merge of all object starting from 2nd arugment.   
    var assignObj = Object.assign(employee, temp, {sa:5});
    console.log(assignObj);
    var cloneObj = Object.assign({}, temp, {ac:2});
    console.log(assignObj);
console.log("End");