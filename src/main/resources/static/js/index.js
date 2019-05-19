$(function(){
    var myFullpage = new fullpage('#fullpage', {
        sectionsColor: ['#f2f2f2', '#4BBFC3', '#7BAABE', 'whitesmoke', '#ccddff']
    });
    
    $.ajax({
        url: 'reserve/num',
        success: function(data) {
            $("#reservenum").text(data);
        }
    });
    
    $("#btn-submit").click(function() {
        var username = $("#form-username").val();
        var mobile = $("#form-mobile").val();
        if (!username || !mobile) {
            alert('请输入姓名和手机号');
            return;
        }
        $.ajax({
            type: 'post',
            url: '/reserve/submit',
            data: {
                username: $("#form-username").val(),
                mobile: $("#form-mobile").val()
            },
            dataType: 'text',
            success: function(data, textStatus, jqXHR) {
                alert('登记成功');
                $("#reservenum").text(parseInt($("#reservenum").text()) + 1);
            },
            error: function(err) {
            	alert('登记失败');
                console.log(err);
            }
        });
    });
});