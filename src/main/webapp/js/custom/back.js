/**
 *
 * Created by peyppicp on 2017/3/31.
 */

function baseInfo() {
    $.get("index.html", function (data) {
        $("#tabContainer").tabs("add", {
            title: "nihao",
            content: "<iframe>" + data + "</iframe>",
            closable: true
        });
    });
}

function infoManage() {
    $("#futherChoice").html("<a href='javascript:void(0)' class='aBtn' onclick='getBaseInfoPage()'><span class='icon icon-add'></span>基础信息</a>" +
        "<a href='javascript:void(0)' class='aBtn' onclick='getAdvanceInfoPage()'><span class='icon icon-save'></span>进阶信息</a>");
}

function productManage() {
    $("#futherChoice").html("<a href='javascript:void(0)' class='aBtn' onclick='getAddProductPage()'><span class='icon icon-add'></span>新增产品</a>" +
        "<a href='javascript:void(0)' class='aBtn' onclick='getUpdateProductPage()'><span class='icon icon-save'></span>修改产品</a>" +
        "<a href='javascript:void(0)' class='aBtn' onclick='getQueryProductPage()'><span class='icon icon-search'></span>查找产品</a>" +
        "<a href='javascript:void(0)' class='aBtn' onclick='getDeleteProductPage()'><span class='icon icon-clear'></span>删除产品</a>");
}

function itemManage() {
    $("#futherChoice").html("<a href='javascript:void(0)' class='aBtn' onclick='getAddItemPage()'><span class='icon icon-add'></span>新增商品</a>" +
        "<a href='javascript:void(0)' class='aBtn' onclick='getUpdateItemPage()'><span class='icon icon-save'></span>修改商品</a>" +
        "<a href='javascript:void(0)' class='aBtn' onclick='getQueryItemPage()'><span class='icon icon-search'></span>查找商品</a>" +
        "<a href='javascript:void(0)' class='aBtn' onclick='getDeleteItemPage()'><span class='icon icon-clear'></span>删除商品</a>");
}

function orderManage() {

}

function getAddProductPage() {
    $("#tabContainer").tabs("add", {
        title: " 新增产品",
        closable: true,
        content: "<iframe scrolling='no' frameborder='0' src='/load-page.action?pageName=add-product' style='width:100%;min-height: 800px'></iframe>"
    });
}

function getUpdateProductPage() {
    $("#tabContainer").tabs("add", {
        title: " 新增产品",
        closable: true,
        content: "<iframe scrolling='yes' frameborder='0' src='/load-page.action?pageName=update-product' style='width:100%;height:100%;'></iframe>"
    });
}

function getQueryProductPage() {
    $("#tabContainer").tabs("add", {
        title: " 新增产品",
        closable: true,
        content: "<iframe scrolling='yes' frameborder='0' src='/load-page.action?pageName=query-product' style='width:100%;height:100%;'></iframe>"
    });
}

function getDeleteProductPage() {
    $("#tabContainer").tabs("add", {
        title: " 新增产品",
        closable: true,
        content: "<iframe scrolling='yes' frameborder='0' src='/load-page.action?pageName=delete-product' style='width:100%;height:100%;'></iframe>"
    });
}