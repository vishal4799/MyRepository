function callAPI() {
    // 1. Instantiate XHR - Start 
    var xhr; 
    if (window.XMLHttpRequest) 
        xhr = new XMLHttpRequest(); 
    else if (window.ActiveXObject) 
        xhr = new ActiveXObject("Msxml2.XMLHTTP");
    else 
        throw new Error("Ajax is not supported by your browser");
    
    // 2. Handle Response from Server - Start
    xhr.onreadystatechange = function () {
        if (xhr.readyState < 4)
            console.log("Loading...");
        else if (xhr.readyState === 4) {
            if (xhr.status == 200 && xhr.status < 300) 
                console.log(hr.responseText);
        }
    }
    
    // 3. Specify your action, location and Send to the server - Start   
    xhr.open('GET', 'https://www.ajax-tutor.com/demo/data1.html');
    xhr.send(null);

}
callAPI();