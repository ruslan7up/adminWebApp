/**
 * Created by ruslan on 24.01.2017.
 */
var stompClient = null;
$(document).ready(function () {
   var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        alert('CONNECTED: '+frame);
        stompClient.subscribe('/chat/get', function (text) {
            $('#messages').append('<p>'+JSON.parse(text.body).content+'</p>');
        })
    })
});