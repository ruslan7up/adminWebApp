/**
 * Created by ruslan on 18.01.2017.
 */
$('#tryedit').on('click',function() {
    var jsonRows = {
        'id': $('#tryedit').val(),
        'name':$('#name').val(),
        'shift':$('#shift option:selected').val(),
        'monday':[],
        'tuesday':[],
        'wednesday':[],
        'thursday':[],
        'friday':[]
    };

    $($('#monday').children('tr')).each(function (index, element) {
        var name = $($(element).children('td').children('input[type="text"]')).val().trim();
        var cabnumber = $($(element).children('td').children('input[type="number"]')).val().trim();
        if(name != '') {
            jsonRows.monday.push({
                'nameofasubject':name,
                'cabinetnumber':cabnumber
            });
        }
    });

    $($('#tuesday').children('tr')).each(function (index, element) {
        var name = $($(element).children('td').children('input[type="text"]')).val().trim();
        var cabnumber = $($(element).children('td').children('input[type="number"]')).val().trim();
        if(name != '') {
            jsonRows.tuesday.push({
                'nameofasubject':name,
                'cabinetnumber':cabnumber
            });
        }
    });

    $($('#wednesday').children('tr')).each(function (index, element) {
        var name = $($(element).children('td').children('input[type="text"]')).val().trim();
        var cabnumber = $($(element).children('td').children('input[type="number"]')).val().trim();
        if(name != '') {
            jsonRows.wednesday.push({
                'nameofasubject':name,
                'cabinetnumber':cabnumber
            });
        }
    });

    $($('#thursday').children('tr')).each(function (index, element) {
        var name = $($(element).children('td').children('input[type="text"]')).val().trim();
        var cabnumber = $($(element).children('td').children('input[type="number"]')).val().trim();
        if(name != '') {
            jsonRows.thursday.push({
                'nameofasubject':name,
                'cabinetnumber':cabnumber
            });
        }
    });

    $($('#friday').children('tr')).each(function (index, element) {
        var name = $($(element).children('td').children('input[type="text"]')).val().trim();
        var cabnumber = $($(element).children('td').children('input[type="number"]')).val().trim();
        if(name != '') {
            jsonRows.friday.push({
                'nameofasubject':name,
                'cabinetnumber':cabnumber
            });
        }
    });


  /*  alert('DEBUG: '+JSON.stringify(jsonRows));*/

    $.ajax({
        type: 'post',
        url:'/scheduleRest/update',
        data: {
            'json':JSON.stringify(jsonRows)
        },
        success: function () {
            alert('Успешно добавлено');
            window.location="/schedule/schedulelist";
        },
        error: function () {
            alert('Возникла ошибка при добавлении!');
        }
    })
});