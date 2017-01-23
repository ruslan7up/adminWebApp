/**
 * Created by ruslan on 23.01.2017.
 */
$('#updbtt').on('click', function () {
   var jsonRows = [];
    $($('tbody').children('tr')).each(function (index, element) {
        jsonRows.push({
            'id': $($($(element).children('.classn'))).html(),
            'startTime': $($($(element).children('.classst')).children('input')).val() ,
            'endTime': $($($(element).children('.classet')).children('input')).val()
        })
    });

    alert(JSON.stringify(jsonRows));
    
    $.ajax({
        type:'post',
        url:'/bellTimeRest/update',
        data:{
            'json' : JSON.stringify(jsonRows)
        },
        error: function () {
            alert('Возникла ошибка при обновлении!');
        }
    })
});