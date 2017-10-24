<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="list"></table>
<script>
    var toolbar = [{
        iconCls: 'icon-add',
        text: '新增',
        handler: function () {
            console.log('add');
        }
    }, {
        iconCls: 'icon-remove',
        text: '删除',
        handler: function () {
            //获得选中的行
            var selectRows = $('#list').datagrid('getSelections');
            if (selectRows.length == 0) {
                $.messager.alert('提示', '未选中记录', 'warning');
                return;
            }
            //选取至少一行记录
            $.messager.confirm('确认', '您确认删除勾选条记录吗', function (r) {
                if (r) {
                    var ids = [];
                    for (var i = 0; i < selectRows.length; i++) {
                        ids.push(selectRows[i].id);
                    }
                    $.post(
                        //url :提交给后台那个动作去处理
                        'items/batch',
                        //data :提交给后台处理的数据
                        {'ids[]': ids},
                        //回调函数
                        function (data) {
                            $('#list').datagrid('reload');
                        },
                        'json'
                    );
                }
            });
        }
    }, {
        iconCls: 'icon-edit',
        text: '编辑',
        handler: function () {
        }
    }, {
        iconCls: 'icon-up',
        text: '上架',
        handler: function () {
            var selectedrows = $('#list').datagrid('getSelections');
            if (selectedrows.length == 0) {
                $.messager.alert('提示', '未选中记录', 'warning');
                return;
            }
            //选取至少一行记录
            $.messager.confirm('确认', '您确认上架勾选条记录吗', function (r) {
                if (r) {
                    var ids = [];
                    for (var i = 0; i < selectedrows.length; i++) {
                        ids.push(selectedrows[i].id);
                    }
                    $.post(
                        //url :提交给后台那个动作去处理
                        'items/up',
                        //data :提交给后台处理的数据
                        {'ids[]': ids},
                        //回调函数
                        function (data) {
                            $('#list').datagrid('reload');
                        },
                        'json'
                    );
                }
            });
        }
    }, {
        iconCls: 'icon-down',
        text: '下架',
        handler: function () {
            var selectedrows = $('#list').datagrid('getSelections');
            if (selectedrows.length == 0) {
                $.messager.alert('提示', '未选中记录', 'warning');
                return;
            }
            //选取至少一行记录
            $.messager.confirm('确认', '您确认下架勾选条记录吗', function (r) {
                if (r) {
                    var ids = [];
                    for (var i = 0; i < selectedrows.length; i++) {
                        ids.push(selectedrows[i].id);
                    }
                    $.post(
                        //url :提交给后台那个动作去处理
                        'items/down',
                        //data :提交给后台处理的数据
                        {'ids[]': ids},
                        //回调函数
                        function (data) {
                            $('#list').datagrid('reload');
                        },
                        'json'
                    );
                }
            });
        }
    }]
    $("#list").datagrid({
        multiSort: true,
        toolbar: toolbar,
        pageSize: 20,
        pageList: [20, 40, 50],
        fit: true,
        pagination: true,
        url: "items",
        columns: [[
            {field: "ck", checkbox: true},
            {field: "id", title: "商品编号", width: 100, sortable: true},
            {field: "title", title: "商品名称", width: 300, sortable: true},
            {field: "sellPoint", title: "卖点", width: 300},
            {field: 'price', title: '商品价格', width: 100},
            {field: 'num', title: '商品数量', width: 100},
            {field: 'barcode', title: '条形码', width: 100},
            {field: 'image', title: '图片', width: 100},
            {field: 'name', title: '类型', width: 100},
            {
                field: 'status', title: '状态', width: 100, formatter: function (value, row, index) {
                if (value == 1) {
                    return '正常';
                } else if (value == 2) {
                    return '下架';
                } else {
                    return '删除';
                }
            }
            },
            {
                field: 'created', title: '生成时间', width: 100, formatter: function (value, row, index) {
                return moment(value).format('dddd, MMMM Do YYYY, h:mm:ss a');
            }
            },
            {
                field: 'updated', title: '更新时间', width: 100, formatter: function (value, row, index) {
                return moment(value).format('dddd, MMMM Do YYYY, h:mm:ss a');
            }
            }
        ]]

    });

</script>