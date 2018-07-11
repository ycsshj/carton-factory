
$("#reloadList").click(function () {
    window.parent.location.reload(true);
})

$("#addAccountBtn").click(function () {
    $("#addAccountForm").ajaxSubmit(function (data) {
        if (data.code == 0) {
            $('#addAccountModal').modal('hide')
        }
        messageAlert(data.message, data.code);
    });
})

$("#editAccountBtn").click(function () {
    $("#editAccountForm").ajaxSubmit(function (data) {
        if (data.code == 0) {
            $('#editAccountModal').modal('hide')
        }
        messageAlert(data.message, data.code);
    });
})

function toAddPage() {
    var url = basePath + "/account/toAddPage";
    $.get(url, function (data) {
        $("#addAccountBody").html(data);

        $('#birthday').datetimepicker({
            format: 'yyyy-mm-dd',
            language:  'zh-CN',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    })
}

function toEditPage(id) {
    var url = basePath + "/account/toEditPage?id=" + id;
    $.get(url, {id: id}, function (data) {
        $("#editAccountBody").html(data);

        $('#birthday').datetimepicker({
            format: 'yyyy-mm-dd',
            language:  'zh-CN',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    })
}









