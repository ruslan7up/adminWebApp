/**
 * Created by ruslan on 14.01.2017.
 */

$('#trytologin').on('click', function () {
    $('#errfield').hide();
    var login = $('#login').val();
    var pass = $('#pass').val();
    $.ajax({
        type:'post',
        url:'/login',
        data:{
            'login':login,
            'pass':pass
        },
        success:function () {
            location.reload();
        },
        error: function () {
            $('#errfield').html('Неправильный логин или пароль!').show();
        }
    });
});