/**
 * Created by peyppicp on 2017/4/15.
 */

function loadShips() {
    $.post(
        "/get-ship.action",
        function (data, status) {
            if (status == "success") {
                var temp = "";
                $.each(data, function (i, element) {
                    temp += "<div>";
                    temp += "<div class='col-1 p-0 fl text-center xh'>" + i + "</div>";
                    temp += "<div class='col-11 p-0 fl'><p class='mb-1'>" + element.country + element.province + element.city +
                        element.district + "邮编：" + element.zip + "。" + "</p>";
                    temp += "<p class='mb-1'>详细地址：" +
                        element.address + "，联系电话：" + element.phonenum + "，联系人姓名：" +
                        element.name + "。" +
                        "<span><a href='javascript:void(0);' class='delete-link' onclick='deleteShip(\"" + element.id + "\")'>删除此地址</a></span>" +
                        "</p>";
                    temp += "</div>";
                });
                $("#shipContent").html("");
                $("#shipContent").html(temp);
            }
        }
    )
}

function createShip() {
    var country = $("#country").val();
    var province = $("#province").val();
    var city = $("#city").val();
    var district = $("#district").val();
    var details = $("#detailed").val();
    var zip = $("#zip").val();
    var phone = $("#phone").val();
    var name = $("#name").val();
    $.post(
        "/add-ship.action",
        {
            country: country,
            province: province,
            city: city,
            district: district,
            details: details,
            zip: zip,
            phone: phone,
            name: name
        },
        function (data, status) {
            if (status == "success") {
                $("#newShipAddressModel").modal("hide");
                $("#province").val("");
                $("#city").val("");
                $("#district").val("");
                $("#detailed").val("");
                $("#zip").val("");
                $("#phone").val("");
                $("#name").val("");
                loadShips();
            }
        }
    );
}

function deleteShip(ship_id) {
    $.post(
        "/delete-ship.action",
        {
            ship_id: ship_id
        },
        function (data, status) {
            if (status == "success") {
                loadShips();
            }
        }
    );
}