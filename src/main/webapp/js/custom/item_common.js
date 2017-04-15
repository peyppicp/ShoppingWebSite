/**
 * Created by peyppicp on 2017/4/10.
 */
var item_id = "";

$(function () {
    item_id = $.url().param("itemId");
    //获取数据
    $.post(
        "/get-item-info.action",
        {
            item_id: item_id
        },
        function (data, status) {
            if (status == "success") {
                $("#itemName").html(data.item_name);
                $("#description").html(data.item_description);
                $("#priceSpan").html(data.item_price);
                $("#inventory").html(data.item_inventory);
                $("#main-content").html(data.advertisement);
                var images_url = data.image_url;
                var temp = "";
                var head = "<img class='card-img-top img-fluid' src='" + images_url[0] + "'>";
                // onclick='imageOnClick(\"" + element + "\")'
                $.each(images_url, function (i, element) {
                    var src = element.replace(/\\/g, "\\\\");
                    temp += "<img class='card-img-top img-fluid pointerable' src='" + element + "' onclick='imageOnClick(\"" + src + "\")'>";
                });
                $("#headImage").html(head);
                $("#subImage").html(temp);
            }
        }
    );
});

function increase() {
    var value = 0;
    value = $("#numberInput").val();
    value++;
    $("#numberInput").val(value);
}

function decrease() {
    var value = 0;
    value = $("#numberInput").val();
    if (value >= 2) {
        $("#numberInput").val(value - 1);
    }
}

function imageOnClick(img_src) {
    var head = "<img class='card-img-top img-fluid' src='" + img_src + "'>";
    $("#headImage").html(head);
}

function buy() {
    checkLoginStatus();
}

function car() {
    var flag = checkLoginStatus();
    if (flag) {
        $.post(
            "/add-cart.action",
            {
                item_id: item_id,
                number: $("#numberInput").val()
            },
            function (data, status) {
                if (status == "success") {
                    getFavouriteCarNumber();
                }
            }
        );
    } else {
        $("#loginModal").modal("show");
    }
}

function favourite() {
    var flag = checkLoginStatus();
    if (flag) {
        $.post(
            "/add-favourite.action",
            {
                item_id: item_id
            },
            function (data, status) {
                if (status == "success") {
                    getFavouriteCarNumber();
                }
            }
        );
    } else {
        $("#loginModal").modal("show");
    }
}

