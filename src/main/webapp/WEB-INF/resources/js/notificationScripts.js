/**
 * Created by ruslan on 29.01.2017.
 */
$('#sendnotify').on('click', function () {
    $.ajax({
        dataType: 'application/json',
        type : 'POST',
        url : "https://fcm.googleapis.com/fcm/send",
        headers : {
            Authorization : 'key=' + 'AIzaSyBint8ilw16Xp_0qhXv-FF4uk0Mpza1wP0'
        },

        data : {
            "to": "/topics/notifies",
            "data": {
                "message": "This is a Firebase Cloud Messaging Topic Message!",
            }
        },

    });
});