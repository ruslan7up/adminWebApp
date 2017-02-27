/**
 * Created by ruslan on 29.01.2017.
 */
$('#sendnotify').on('click', function () {
    $.ajax({
        type : 'POST',
        url : "/notificationRest/sendNotification",
        data : {
            "message":$('#notificationtext').val()
        },
        success: function () {
            $('.result').removeClass('alert alert-success');
            $('.result').removeClass('alert alert-danger');
            $('.result').addClass('alert alert-success');
            $('.result').html('<strong>Готово!</strong> Уведомление было успешно разослано всем пользователям!');
            $('#notificationtext').val('');
        },
        error: function () {
            $('.result').removeClass('alert alert-success');
            $('.result').removeClass('alert alert-danger');
            $('.result').addClass('alert alert-danger');
            $('.result').html('<strong>Похоже что-то пошло не так!</strong> При отправке уведомления возникла ошибка!');
        }
    });
});