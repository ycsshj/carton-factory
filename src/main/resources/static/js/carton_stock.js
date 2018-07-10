
$("#reloadList").click(function () {
    window.parent.location.reload(true);
})

$("#addCartonStockBtn").click(function () {
    $("#addCartonStockForm").ajaxSubmit(function (data) {
        if (data.code == 0) {
            $('#addCartonStockModal').modal('hide')
        }
        messageAlert(data.message, data.code);
    });
})

$("#editCartonStockBtn").click(function () {
    $("#editCartonStockForm").ajaxSubmit(function (data) {
        if (data.code == 0) {
            $('#editCartonStockModal').modal('hide')
        }
        messageAlert(data.message, data.code);
    });
})

function toAddPage() {
    var url = basePath + "/cartonStock/toAddPage";
    $.get(url, function (data) {
        $("#addCartonStockBody").html(data);
    })
}

function toEditPage(id) {
    var url = basePath + "/cartonStock/toEditPage?id=" + id;
    $.get(url, {id: id}, function (data) {
        $("#editCartonStockBody").html(data);
    })
}









