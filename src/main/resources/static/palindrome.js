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


            // var listItem = document.createElement("li");
            // listItem.className = "list-group-item";
            // listItem.textContent = "Text: " + pal.content + " created at: " + pal.timestamp;

            // ul.appendChild(listItem);


            // $("#content").html("Content: " + pal.content);
            // $("#timestamp").html("Timestamp: " + pal.timestamp);

        })

    },onError())

    // $(function () {
    //     $('[data-toggle="tooltip"]').tooltip()
    // })
});


function onError(){
    console.log("Error when connecting to the websocket");
}