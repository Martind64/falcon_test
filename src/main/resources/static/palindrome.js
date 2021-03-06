var stompClient = null;

$(document).ready(function () {
    if (stompClient != null)
        stompClient.disconnect();

    var socket = new SockJS('/palindrome-websocket');

    stompClient = Stomp.over(socket);

    stompClient.connect({}, function () {
        stompClient.subscribe("/topic/palindrome", function (palindrome) {

            let pal = JSON.parse(palindrome.body);

            $("#palindromes tr:last")
                .after("" +
                    "<tr>" +
                        "<td>" + pal.content + "</td>" +
                        "<td>" + pal.timestamp + "</td>" +
                        "<td>" + pal.longest_palindrome_size + "</td>" +
                    "</tr>" );
        })
    },onError())
});


function onError(){
    console.log("Error when connecting to the websocket");
}