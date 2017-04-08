/**
 * Created by peyppicp on 2017/4/5.
 */

function login() {
    var flag = false;
    var length = $("#loginForm input").length;
    var temp = 0;
    //检查是否有空值表单
    $("#loginForm input").each(function () {
        if ($(this).val() == "") {
            $(this).focus();
            return false;
        }
    });
    //检查所有输入框是否都有值
    $("#loginForm input").each(function () {
        if ($(this).val() != "") {
            temp++;
        }
    });

    if (temp == length) {
        flag = true;
    }

    //如果所有输入框都有值
    if (flag) {
        $("#loginForm").submit();
    } else {
        return false;
    }
}

function productManage() {
    $("#itemManageDiv").attr("hidden", "hidden");
    $.post(
        "/get-product.action",
        function (data, status) {
            if (status == "success") {
                var temp = "";
                $.each(data, function (i, element) {
                    i++;
                    temp += "<tr>";
                    temp += "<th scope='row'>" + i + "</th>";
                    temp += "<td>" + element.product_id + "</td>";
                    temp += "<td>" + element.product_name + "</td>";
                    temp += "<td>" + element.product_number + "</td>";
                    temp += "<td>" + element.description + "</td>";
                    temp += "<td>" + "..." + "</td>";
                    temp += "<td>";
                    temp += "<a class='btn btn-outline-primary btn-inline' href='javascript:void(0);' onclick='previewProduct(\"" + element.product_id + "\")'>预览</a>";
                    temp += "<a class='btn btn-outline-success btn-inline' href='javascript:void(0);' onclick='showUpdateProductPage(\"" + element.product_id + "\")'>修改</a>";
                    temp += "<a class='btn btn-outline-danger btn-inline' href='javascript:void(0);' onclick='deleteProduct(\"" + element.product_id + "\")'>删除</a>";
                    temp += "</td></tr>";
                });
                $("#productTableDiv tbody").html("");
                $("#productTableDiv tbody").append(temp);
                $("#productManageDiv").removeAttr("hidden");
                $("#productTableDiv").removeAttr("hidden");
                $("#newProductDiv").attr("hidden", "hidden");
                $("#productPreviewDiv").attr("hidden", "hidden");
                // $("#productManageDiv").show();
                // $("#productTableDiv").show();
            }
        }
    )
}

function itemManage() {
    $("#productManageDiv").attr("hidden", "hidden");
    $("#itemManageDiv").removeAttr("hidden");
}

function showNewProductPage() {
    $("#productPreviewDiv").attr("hidden", "hidden");
    $("#productTableDiv").attr("hidden", "hidden");
    $("#newProductDiv").removeAttr("hidden");
    var ue = UE.getEditor("ueditor");
    $("#inputProductName").val("");
    $("#inputProductNumber").val("");
    $("#inputProductDescription").val("");
    ue.ready(function () {
        ue.setContent("");
    });
}

function previewProduct(product_id) {
    $.post(
        "/get-product-id.action",
        {
            product_id: product_id
        },
        function (data, status) {
            if (status == "success") {
                $("#productPreviewDiv").html(data.advertisement);
                $("#productTableDiv").attr("hidden", "hidden");
                $("#productPreviewDiv").removeAttr("hidden");
            }
        }
    );
}

function showNewItemPage() {
    $("#productListDiv").removeAttr("hidden");
}

function chooseProduct(product_id) {
    $("#newItemDiv").removeAttr("hidden", "hidden");
    $("#inputProductItemID").val(product_id);
}

function getProductList() {
    $.post(
        "/get-product-list.action",
        function (data, status) {
            if (status == "success") {
                var temp = "";
                $.each(data, function (i, element) {
                    i++;
                    temp += "<tr>";
                    temp += "<th scope='row'>" + i + "</th>";
                    temp += "<td>" + element.product_id + "</td>";
                    temp += "<td>" + element.product_name + "</td>";
                    temp += "<td>" + element.product_number + "</td>";
                    temp += "<td>" + element.description + "</td>";
                    temp += "<td>";
                    temp += "<a class='btn btn-outline-primary btn-inline' href='javascript:void(0);' onclick='chooseProduct(\"" + element.product_id + "\")'>选中</a>";
                    temp += "</td></tr>";
                });
                $("#productList tbody").html("");
                $("#productList tbody").append(temp);
                $("#itemManageDiv").removeAttr("hidden");
            }
        }
    );
}

function showUpdateProductPage(product_id) {
    $("#productPreviewDiv").attr("hidden", "hidden");
    $("#productTableDiv").attr("hidden", "hidden");
    $("#newProductDiv").removeAttr("hidden");
    var ue = UE.getEditor("ueditor");
    ue.ready(function () {
        $.post(
            "/get-product-id.action",
            {
                product_id: product_id
            },
            function (data, status) {
                if (status == "success") {
                    $("#inputProductName").val(data.product_name);
                    $("#inputProductNumber").val(data.product_number);
                    $("#inputProductDescription").val(data.description);
                    ue.setContent(data.advertisement);
                    $("#inputSubmit").removeAttr("onclick");
                    $("#inputSubmit").text("修改");
                    $("#inputSubmit").click(function () {
                        updateProduct(data.product_id);
                    });
                }
            }
        );
    });
}

function updateProduct(product_id) {
    var flag = false;
    var length = $("#newProductDiv input").length;
    var temp = 0;
    $("#newProductDiv input").each(function () {
        if ($(this).val() == "") {
            $(this).focus();
            return false;
        }
    });

    $("#newProductDiv input").each(function () {
        if ($(this).val() != "") {
            temp++;
        }
    });

    if (temp == length) {
        flag = true;
    }

    if (flag) {
        $.post(
            "/update-product.action",
            {
                productId: product_id,
                productName: $("#inputProductName").val().trim(),
                productNumber: $("#inputProductNumber").val().trim(),
                productDescription: $("#inputProductDescription").val().trim(),
                advertisement: UE.getEditor("ueditor").getContent().trim()
            },
            function (data, status) {
                if (status == "success") {
                    productManage();
                    $("#newProductDiv").attr("hidden", "hidden");
                    $("#inputProductName").val("");
                    $("#inputProductNumber").val("");
                    $("#inputProductDescription").val("");
                    UE.getEditor("ueditor").ready(function () {
                        setContent("");
                    });
                }
            }
        )
    }
}

function deleteProduct(product_id) {
    $.post(
        "/delete-product.action",
        {
            product_id: product_id
        },
        function (data, status) {
            if (status == "success") {
                productManage();
            }
        }
    )
}

function newItem() {
    var flag = false;
    var length = $("#newItemDiv input").length;
    var temp = 0;
    $("#newItemDiv input").each(function () {
        if ($(this).val() == "") {
            $(this).focus();
            return false;
        }
    });

    $("#newItemDiv input").each(function () {
        if ($(this).val() != "") {
            temp++;
        }
    });

    if (temp == length) {
        flag = true;
    }

    $.post(
        "/add-item.action",
        {
            productId: $("#inputProductItemID").val(),
            itemPrice: $("#inputItemPrice").val(),
            itemType: $("#inputItemType").val(),
            itemSize: $("#inputItemSize").val(),
            itemInventory: $("#inputItemInventory").val(),
            itemBreakable: $("#inputItemBreakable").val()
        }
    );
}

function newProduct() {
    var flag = false;
    var length = $("#newProductDiv input").length;
    var temp = 0;
    $("#newProductDiv input").each(function () {
        if ($(this).val() == "") {
            $(this).focus();
            return false;
        }
    });

    $("#newProductDiv input").each(function () {
        if ($(this).val() != "") {
            temp++;
        }
    });

    if (temp == length) {
        flag = true;
    }

    if (flag) {
        $.post(
            "/add-product.action",
            {
                productName: $("#inputProductName").val().trim(),
                productNumber: $("#inputProductNumber").val().trim(),
                productDescription: $("#inputProductDescription").val().trim(),
                advertisement: UE.getEditor("ueditor").getContent().trim()
            },
            function (data, status) {
                if (status == "success") {
                    productManage();
                    $("#newProductDiv").attr("hidden", "hidden");
                    $("#inputProductName").val("");
                    $("#inputProductNumber").val("");
                    $("#inputProductDescription").val("");
                    UE.getEditor("ueditor").setContent("");
                }
            }
        )
    }
}