/**
 * Created by User on 27.02.2017.
 */
$('button').on('click',function () {
    var oldpass = $('#oldpass').val();
    var newpass = $('#newpass').val();
    if(newpass == $('#newpass2').val()) {
        $.ajax({
            type:'POST',
            url:'/changepass',
            data:{
                'oldpass': oldpass,
                'newpass': newpass
            },
            success: function () {
                window.location = "/home";
            },
            error: function () {
                alert('Проверьте правилность ввода старого пароля');
            }
        })
    } else {
        alert('Проверьте правильность набора нового пароля');
    }

});