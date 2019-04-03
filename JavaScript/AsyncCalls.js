let numOfCalls = 0;

function async1(cb, msg, timeout){
    setTimeout(function(){
        cb(++numOfCalls, msg);
    },timeout);
}

function printDone(){
    console.log("done");
}

function callback(callCount, msg){
    console.log(msg);
    if(callCount === 2){
        printDone();
    }
}

function asyncHandler(){
    async1(callback, "done1", 1000);
    async1(callback, "done2", 2000);
}

asyncHandler();