
$("#reloadList").click(function () {
    window.parent.location.reload(true);
})

$("#addCartonOrderBtn").click(function () {
    $("#addCartonOrderForm").ajaxSubmit(function (data) {
        if (data.code == 0) {
            $('#addCartonOrderModal').modal('hide')
        }
        messageAlert(data.message, data.code);
    });
})

$("#editCartonOrderBtn").click(function () {
    $("#editCartonOrderForm").ajaxSubmit(function (data) {
        if (data.code == 0) {
            $('#editCartonOrderModal').modal('hide')
        }
        messageAlert(data.message, data.code);
    });
})

function toAddPage() {
    var url = basePath + "/cartonOrder/toAddPage";
    $.get(url, function (data) {
        $("#addCartonOrderBody").html(data);

        $('#publishDate').datetimepicker({
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
    var url = basePath + "/cartonOrder/toEditPage?id=" + id;
    $.get(url, {id: id}, function (data) {
        $("#editCartonOrderBody").html(data);

        $('#publishDate').datetimepicker({
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

function exportOrderInfo() {
    var choseElements = $("input[name='choseElement']");
    var orderIds = new Array();
    for (var i=0; i<choseElements.length; i++) {
        var _obj = $(choseElements[i]);
        if (_obj.prop("checked")) {
            orderIds.push(_obj.val());
        }
    }

    if (orderIds.length > 0) {
        var url = basePath + "/cartonOrder/downLoadOrderInfo?orderIds=" + orderIds;
        window.location.href = url;
    }
}







