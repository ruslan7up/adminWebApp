/**
 * Created by ruslan on 24.05.2017.
 */
$('#submitbtn').on('click', function() {
    var date = new Date($('#date')[0].value);
    var obj = {
        "date": date.getTime(),
        "groupName": $('#group').val().trim(),
        "lesson1": $('#lesson1').val().trim(),
        "lesson2":$('#lesson2').val().trim()
    };
    $.ajax({
        type:'GET',
        url:'/lessons/addsubstitution',
        data: {
            'substition': JSON.stringify(obj)
        },
        success: function() {
            alert("ДОБАВЛЕНО");
        },
        error: function() {
            alert("ОШИБКА");
        }
    })
});

$('#searchdate').change(function () {
    $('tbody').empty();
    var date = new Date($('#searchdate')[0].value);
   $.ajax({
       type:'GET',
       url:'/lessons/getubstitutions',
       data: {
           'date':  date.getTime()
       },
       success: function (data) {

           for(var i = 0; i < data.length; i++)
           {
               $('tbody').append('<tr><td><input type="button" value="X" class="delete" data-id="'+data[i]['id']+'"></td><td>'+data[i]['groupName']+'</td><td>'+data[i]['lesson1']+'</td><td>'+data[i]['lesson2']+'</td>')
           }
       }
   })
});

$('tbody').on('click','input.delete', function() {

    var id = $(this).attr('data-id');
    alert(id);
    $.ajax({
        type:'GET',
        url:'/lessons/deletesubstitution',
        data: {
            'id': id
        },
        success: function () {
            $('[data-id="'+id+'"').remove();
        },
        error: function () {
            alert('Ошибка');
        }
    })
});
