/**
 * Created by ruslan on 24.01.2017.
 */
var socket = new WebSocket("ws://localhost:8080/chat");

socket.onmessage = function (event) {
    var info = JSON.parse(event.data);
    for(var i = 0; i < info.length; i++) {
        var name= info[i].name;
        var message = info[i].message;
        $('<p>'+name+':'+message+'</p>').appendTo("#messages");
    }

};

socket.onopen = function () {
  alert("CONNECTION ESTABLISHED!");
};

$('#sendmessage').on('click', function () {
   var info = {
       "name":$('#nameofuser').val(),
       "message":$('#text').val()
   };

    socket.send(JSON.stringify(info));
});

