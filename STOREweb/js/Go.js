var toggle = true;
function collapseColumn() {
    var ColumnContainer = document.getElementById('ColumnContainer');
    var DataContainer = document.getElementById('DataContainer');
    if (toggle) {
        ColumnContainer.style.height = "0%";
        setTimeout(function(){
            DataContainer.style.height = "100%";
        }, 500);
        toggle = false;
    } else {
        DataContainer.style.height = "0%";
        setTimeout(function(){
            ColumnContainer.style.height = "60%";
        }, 500);
        toggle = true;
    }

}

var url = "http://192.73.235.134:8070/api/listings";

function getData() {
    $.getJSON('http://192.73.235.134:8070/api/listings', function(data) {
        console.log(data);
        //data is the JSON string
});}

