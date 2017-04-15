/**
 * Created by peyppicp on 2017/4/13.
 */
function loadFavourite() {
    $.post(
        "/get-favourite.action",
        function (data, status) {
            if (status == "success") {
                var temp = "";
                $.each(data, function (i, element) {
                    temp += "<div class='col-6 col-sm-6 col-md-4 col-lg-3'>";
                    temp += "<div class='card'>";
                    temp += "<div class='card-block'>";
                    temp += "<a href='item.html?itemId=" + element.item_id + "' target='_blank'>";
                    temp += "<img class='card-img img-fluid' src='" + element.img_src + "'>";
                    temp += "</a>";
                    temp += "<span class='text-on-image'>";
                    temp += "<a class='btn btn-outline-secondary btn-sm btn-label' href='javascript:void(0);' onclick='deleteFavourite(\"" + element.item_id + "\")'>删除</a>"
                    temp += "</span>";
                    temp += "<div class='dv'>";
                    temp += "<a href='item.html?itemId=" + element.item_id + "' target='_blank'>";
                    temp += "<span class='item-title'>" + element.product_name + "</span>";
                    temp += "</a>";
                    temp += "<div class='ds'>";
                    temp += "<span>¥</span>";
                    temp += "<span>" + element.item_price + "</span>";
                    temp += "</div></div></div></div></div>";
                    $("#favourite-content").html(temp);
                });
            }
        }
    )
}

function deleteFavourite(item_id) {
    $.post(
        "/delete-favourite.action",
        {
            item_id: item_id
        },
        function (data, status) {
            if (status == "success") {
                loadFavourite();
                getFavouriteCarNumber();
            }
        }
    )
}