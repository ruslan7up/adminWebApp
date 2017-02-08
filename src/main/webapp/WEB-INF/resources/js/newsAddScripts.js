/**
 * Created by ruslan on 07.02.2017.
 */
$('#addnewsform').on('submit',function () {
 /*   var data = new FormData();
    data.append("title",$('#title').val());
    data.append("text", $('#newstext').val());

    for(var i = 0; i < $('#files')[0].length; i++) {
        data.append("file",$('#files')[0].files[i]);
    }
*/
    $.ajax({
        type:'POST',
        url:'/createnews',
        data:new FormData(this),
        processData:false,
        contentType: false,
        success: function () {
            alert("ФАЙЛЫ УСПЕШНО ПОЛУЧЕНЫ");
        }
    });
});
