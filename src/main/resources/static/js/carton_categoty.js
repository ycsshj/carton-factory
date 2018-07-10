function cartonBigTypeChange(value) {
    $("#smallCategoryParam").empty();
    $("#cartonSmallType").empty();
    var url = basePath + "/lov/getLovByCondition?category=CARTON_CATEGORY&parentCode=" + value + "&lovCode=";
    $.ajax({
        type: 'get',
        dataType: 'json',
        url: url,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            if (data != null && data != undefined) {
                $("#smallCategoryParam").append("<option value=''>请选择...</option>");
                $("#cartonSmallType").append("<option value=''>请选择...</option>");
                for (var i = 0; i < data.length; i++) {
                    $("#smallCategoryParam").append("<option value='" + data[i]["lovCode"] + "'>" + data[i]["lovValue"] + "</option>");
                    $("#cartonSmallType").append("<option value='" + data[i]["lovCode"] + "'>" + data[i]["lovValue"] + "</option>");
                }
            }
        }
    })
}

$("#reloadList").click(function () {
    window.parent.location.reload(true);
})

$("#addCartonCategoryBtn").click(function () {
    $("#addCartonCategoryForm").ajaxSubmit(function (data) {
        if (data.code == 0) {
            $('#addCartonCategoryModal').modal('hide')
        }
        messageAlert(data.message, data.code);
    });
})

$("#editCartonCategoryBtn").click(function () {
    $("#editCartonCategoryForm").ajaxSubmit(function (data) {
        if (data.code == 0) {
            $('#editCartonCategoryModal').modal('hide')
        }
        messageAlert(data.message, data.code);
    });
})

function cartonSizeCalculate() {
    var cartonLength = $("#cartonLength").val();
    var cartonWidth = $("#cartonWidth").val();
    var cartonHeight = $("#cartonHeight").val();
    var bigCategory = $("#cartonBigType").val();
    var smallCategory = $("#cartonSmallType").val();
    var result = 0;

    if (cartonLength !== "" && cartonLength !== undefined && cartonWidth !== "" && cartonWidth !== undefined && cartonHeight !== "" && cartonHeight !== undefined
        && smallCategory !== "" && smallCategory !== undefined && bigCategory !== "" && bigCategory !== undefined) {

        cartonLength = parseFloat(cartonLength);
        cartonWidth = parseFloat(cartonWidth);
        cartonHeight = parseFloat(cartonHeight);

        switch (smallCategory) {
            case "CARTON_CATEGORY_KA_TONG_THREE" :
                result = (cartonWidth + cartonHeight) * ((cartonLength + cartonWidth) * 2 + 3);
                break;
            case "CARTON_CATEGORY_CHUANG_THREE" :
                result = (cartonWidth + cartonHeight + 0.6) * ((cartonLength + cartonWidth) * 2 + 3);
                break;
            case "CARTON_CATEGORY_KA_TONG_FIVE" :
                result = (cartonWidth + cartonHeight + cartonWidth) * (cartonLength + cartonWidth + 3);
                break;
            case "CARTON_CATEGORY_CHUANG_FIVE" :

                break;
            case "CARTON_CATEGORY_BAN_GONG_TAI" :
                result = (cartonWidth + cartonHeight * 2) * (cartonLength + cartonHeight * 2);
                break;
            case "CARTON_CATEGORY_ZHONG_FENG" :
                result = (cartonWidth + cartonHeight) * 2 * (cartonLength + cartonHeight * 2);
                break;
        }

        $("#cartonStandard").val(result);
    }
}

function toAddPage() {
    var url = basePath + "/cartonCategory/toAddPage";
    $.get(url, function (data) {
        $("#addCartonCategoryBody").html(data);
    })
}

function toEditPage(id) {
    var url = basePath + "/cartonCategory/toEditPage?id=" + id;
    $.get(url, {id: id}, function (data) {
        $("#editCartonCategoryBody").html(data);
    })
}