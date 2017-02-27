/**
 * Created by ruslan on 07.02.2017.
 */
$('#btnsubmit').on('click',function () {
    var data = new FormData();
    data.append("title",$('#title').val());
    data.append("text", $('#newstext').val());
    data.enctype = "multipart/form-data; charset=utf-8";
    for(var i = 0; i < $('#files')[0].files.length; i++) {
        data.append("file",$('#files')[0].files[i]);
    }
    $.ajax({
        type:'POST',
        url:'/createnews',
        data: data,
        processData:false,
        contentType: false,
        success: function () {
            alert("Новость добавлена!");
            window.location = "/news/create";
        },
        error: function () {
            alert("При добавлении возникла ошибка!");
        }
    });
});

$('button.btn-del').on('click', function () {
    var delConfirm = confirm("Вы действительно хотите удалить новость?");
    if(delConfirm) {
        var newsID = $(this).attr('data-id');
        $.ajax({
            type:'POST',
            url:'/delNews',
            data: {
                'id':newsID
            },
            error: function () {
                alert('Возникла ошибка при удалении!');
            }
        })
    }
});
