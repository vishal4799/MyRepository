
var SAMPLE_OBJECT = (function(){
    var privateProp1 = 100;
    var privateFunction = function(){
        //same implementation...
    }
    return {
        publicProp1 : "HUNDREDS",
        getPrivateProp1 : function(){
            return privateProp1;
        },
        setPrivateProp1 : function(passedvalue){
            privateProp1 = passedvalue;
        }
    }
}());



console.log("PrivateProp : "+SAMPLE_OBJECT.privateProp1);
console.log("PrivateProp1 : "+SAMPLE_OBJECT.getPrivateProp1());
console.log("PublicProp1 : "+SAMPLE_OBJECT.publicProp1);

SAMPLE_OBJECT.setPrivateProp1(1000);
console.log("PrivateProp1 after update : "+SAMPLE_OBJECT.getPrivateProp1());

//Augmentation : expantion of old object, adding new attributes
SAMPLE_OBJECT = (function(oldObj){
    var privateProp2 = 200;
    var privateFunction2 = function(){
        //same implementation...
    }
    oldObj.publicProp2 = "Two HUNDREDS";
    oldObj.getPrivateProp2 = function(){
        console.log("oldObje.publicProp1:"+oldObj.publicProp1); 
        //console.log("oldObje.privateProp1:"+oldObj.privateProp1); // previous private props are not accessible 
        //console.log("oldObje.privateFunction:"+oldObj.privateFunction()); // previous private props are not accessible 
        return privateProp2;
    };
    oldObj.setPrivateProp2 = function(passedvalue){
        privateProp2 = passedvalue;
    };
    return oldObj;
    
}(SAMPLE_OBJECT));

console.log("After Augmentation");
console.log("PrivateProp1 : "+SAMPLE_OBJECT.getPrivateProp1());
console.log("PrivateProp2 : "+SAMPLE_OBJECT.getPrivateProp2());
console.log("PublicProp1 : "+SAMPLE_OBJECT.publicProp1);
console.log("PublicProp2 : "+SAMPLE_OBJECT.publicProp2);

SAMPLE_OBJECT.setPrivateProp1(1100);
console.log("PrivateProp1 after update : "+SAMPLE_OBJECT.getPrivateProp1());
SAMPLE_OBJECT.setPrivateProp2(2000);
console.log("PrivateProp2 after update : "+SAMPLE_OBJECT.getPrivateProp2());


