/**
 * Created by peyppicp on 2017/4/10.
 */
var item_id = "";

$(function () {
    item_id = $.url().param("itemId");
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
                $.each(images_url, function (i, element) {
                    temp += "<img class='card-img-top img-fluid' src='" + element + "'>";
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
    if (value >= 1) {
        $("#numberInput").val(value - 1);
    }
}