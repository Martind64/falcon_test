var stompClient = null;

$(document).ready(function () {
    if (stompClient != null)
        stompClient.disconnect();

    var socket = new SockJS('/palindrome-websocket');

    stompClient = Stomp.over(socket);

    stompClient.connect({}, function () {
        stompClient.subscribe("/topic/palindrome", function (palindrome) {

            let pal = JSON.parse(palindrome.body);

            $("#content").html("Content: " + pal.content);
            $("#timestamp").html("Timestamp: " + pal.timestamp);

        })

    },onError())
});

function onError(){
    console.log("Error when connecting to the websocket");
}