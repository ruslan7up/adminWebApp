/**
 * Created by ruslan on 07.02.2017.
 */
$('#btnsubmit').on('click',function () {
    alert($('#files')[0].files.length);
    var data = new FormData();
    data.append("title",$('#title').val());
    data.append("text", $('#newstext').val());
    data.enctype = "multipart/form-data; charset=utf-8";
    alert(document.inputEncoding);
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
            window.location = "/home";
        },
        error: function () {
            alert("При добавлении возникла ошибка!");
        }
    });
});
