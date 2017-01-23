/**
 * Created by ruslan on 20.01.2017.
 */

$('#addsched').on('click', function () {
   window.location.href = "/schedule/addschedule";
});

$('button.btn-edt').on('click', function () {
    window.location.href="/schedule/updateschedule/"+$(this).attr("data-id");
});


$('button.btn-del').on('click', function () {

    var delConfirm = confirm("Вы действительно хотите удалить расписание?");
    if(delConfirm) {
        var scheduleID = $(this).attr('data-id');
        $.ajax({
            type:'post',
            url:'/scheduleRest/remove',
            data: {
                'id':scheduleID
            },
            error: function () {
                alert('При удалении возникла ошибка!');
            }
        })
    }
});

