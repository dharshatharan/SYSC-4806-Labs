
$(document).ready(function() {

    $("#get-data").click(function (event) {
        $.ajax({
            url: "http://localhost:8080/addressBooks/1"
        }).done(function (data) {
            $('.address-book-id').replaceWith(1);
            $('.address-book-buddies').replaceWith(data.buddyListAsString);
        });

        event.preventDefault();
    });
});