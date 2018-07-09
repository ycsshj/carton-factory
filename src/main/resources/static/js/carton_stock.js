
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

$(function($) {
    $("#cartonCategoryParam").empty();
    $("#cartonCategory").empty();
    var url = basePath + "/cartonCategory/getSimpleCartonCategoryList";
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: url,
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            if (response != null && response != undefined && response.data != null && response.data != undefined) {
                $("#cartonCategoryParam").append("<option>请选择...</option>");
                $("#cartonCategory").append("<option>请选择...</option>");
                for (var i = 0; i < response.data.length; i++) {
                    $("#cartonCategoryParam").append("<option value='" + response.data[i]["id"] + "'>" + response.data[i]["simpleName"] + "</option>");
                    $("#cartonCategory").append("<option value='" + response.data[i]["id"] + "'>" + response.data[i]["simpleName"] + "</option>");
                }
            }
        }
    })
});

function initCartonCategory(id) {
    $("#" + id).empty();
    var url = basePath + "/cartonCategory/getSimpleCartonCategoryList";
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: url,
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            if (response != null && response != undefined && response.data != null && response.data != undefined) {
                $("#" + id).append("<option>请选择...</option>");
                for (var i = 0; i < response.data.length; i++) {
                    $("#" + id).append("<option value='" + response.data[i]["id"] + "'>" + response.data[i]["simpleName"] + "</option>");
                }
            }
        }
    })
}








