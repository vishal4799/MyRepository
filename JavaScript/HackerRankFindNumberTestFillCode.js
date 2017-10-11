var fs = require('fs');
var wstream = fs.createWriteStream(process.env.OUTPUT_PATH);
process.stdin.on('end', function () {
    __input_stdin_array = __input_stdin.split("\n");
    var res;

    var _arr_size = 0;
    _arr_size = parseInt(__input_stdin_array[__input_currentline].trim(), 10);
    __input_currentline += 1;
    
    var _arr = [];
    var _arr_item;
    for(var _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
        var _arr_item = parseInt(__input_stdin_array[__input_currentline].trim(), 10);
        __input_currentline += 1;
        _arr.push(_arr_item);
    }
    
    var _k = parseInt(__input_stdin_array[__input_currentline].trim(), 10);
    __input_currentline += 1;
    
    res = findNumber(_arr, _k);
    wstream.write(res+"\n");
    
    wstream.end();
});
