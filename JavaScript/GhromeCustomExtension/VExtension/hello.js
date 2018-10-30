// html2canvas(document.querySelector("#capture")).then(canvas => {
  //   document.body.appendChild(canvas)
  // });
//var bkg = chrome.extension.getBackgroundPage();
function captureImage(){
  //  bkg.console.log('Start capturing...');
    chrome.tabs.captureVisibleTab(function(screenshotUrl) {
    //    bkg.console.log('capture initiated...');
        document.getElementById('target').src = screenshotUrl;
      //  bkg.console.log('capture End...');
    });
}

window.addEventListener('load', function load(event){
    var createButton = document.getElementById('capture');
    createButton.addEventListener('click', function() { captureImage(); });
});
