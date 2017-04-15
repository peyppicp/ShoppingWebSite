/**
 * Created by peyppicp on 2017/4/14.
 */

var data_container = "";

function getCart() {
    $.post(
        "/get-cart.action",
        function (data, status) {
            if (status == "success") {
                var temp = "";
                data_container = data;
                $.each(data, function (k, v) {
                    var seller_id = k;
                    temp += "<div class='row'>";
                    temp += "<div class='col-1'>";
                    temp += "<input id='" + k + "' type='checkbox' onclick='sellerProductSelect(\"" + seller_id + "\");'>";
                    temp += "</div>";
                    temp += "<div class='col-5'>" + v[0].seller_name + "</div>";
                    temp += "</div>";
                    $.each(v, function (i, element) {
                        temp += "<div class='row'>";
                        temp += "<div class='col-1'>";
                        temp += "<input type='checkbox' class='" + element.seller_id + "' onclick='calculate();'>";
                        temp += "<input type='hidden' value='" + element.item_id + "'>";
                        temp += "</div>";
                        temp += "<div class='col-5'>";
                        temp += "<div class='row'>";
                        temp += "<div class='col-4'>";
                        temp += "<a href='item.html?itemId=" + element.item_id + "' target='_blank'>";
                        temp += "<img src='" + element.img_src + "' class='img-fluid small-img'>";
                        temp += "</a></div>";
                        temp += "<div class='col-8'>";
                        temp += "<a href='item.html?itemId=" + element.item_id + "' target='_blank'>";
                        temp += "<p>" + element.product_name + "</p>";
                        temp += "</a>";
                        temp += "<p>" + element.item_type + "</p>";
                        temp += "</div></div></div>";
                        temp += "<div class='col-1'>";
                        temp += "<span class='item-price'>¥" + element.item_price + "</span>";
                        temp += "</div>";
                        temp += "<div class='col-2'>";
                        temp += "<div class='row'>";
                        temp += "<div class='col-12'>";
                        temp += "<input type='text' class='number-input' id='numberInput" + element.item_id + "' value='" + element.number + "'>";
                        temp += "<span class='span-number'>";
                        temp += "<span class='span-number-up' onclick='increase(\"" + element.item_id + "\",\"" + element.item_price + "\");'>↑</span>";
                        temp += "<span class='span-number-down' onclick='decrease(\"" + element.item_id + "\",\"" + element.item_price + "\");'>↓</span>";
                        temp += "</span></div></div></div>";
                        temp += "<div class='col-1'>";
                        temp += "<span id='total" + element.item_id + "' class='item-total-price'>" + element.number * element.item_price + "</span>";
                        temp += "</div>";
                        temp += "<div class='col-1'>";
                        temp += "<div>\.\.</div>";
                        temp += "</div></div>";
                    });
                    $("#cart-content").html("");
                    $("#cart-content").html(temp);
                });
            }
        }
    );
}

function sellerProductSelect(seller_id) {
    var flag = $("#" + seller_id).is(":checked");
    if (flag) {
        $("\." + seller_id).each(function (i, element) {
            element.checked = true;
            calculate();
        });
    } else {
        $("\." + seller_id).each(function (i, element) {
            element.checked = false;
            calculate();
        });
    }
}

function createOrder() {
    var data = new Array();
    $("#cart-content input:checkbox:checked").each(function () {
        var item_id = $(this).parent().find("input:hidden").val();
        if (item_id == undefined || item_id == null || item_id == NaN || item_id == "") {
            return true;
        }
        data.push(item_id);
    });
    $.post(
        "/create-order.action",
        {
            items: JSON.stringify(data)
        },
        function (data, status) {
            if (status == "success") {
                if (data.status == "ok") {
                    alert("订单创建成功，跳转支付页面");
                }
            }
        }
    );
}

function calculate() {
    var sum = 0;
    $("#cart-content input:checkbox:checked").each(function () {
        var temp = $(this).parent().parent().find(".item-total-price").text();
        if (temp == undefined || temp == null || temp == NaN || temp == "") {
            return true;
        }
        sum += parseInt(temp);
    });
    $("#totalCost").text("¥" + sum);
}

function increase(item_id, price) {
    var value = 1;
    value = $("#numberInput" + item_id).val();
    value++;
    $("#numberInput" + item_id).val(value);
    $("#total" + item_id).html(value * price);
}

function decrease(item_id, price) {
    var value = 0;
    value = $("#numberInput" + item_id).val();
    if (value >= 2) {
        value--;
        $("#numberInput" + item_id).val(value);
        $("#total" + item_id).html(value * price);
    }
}
