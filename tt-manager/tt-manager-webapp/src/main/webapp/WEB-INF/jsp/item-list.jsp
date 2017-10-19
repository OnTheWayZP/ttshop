<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="list"></table>
<script>

    $("#list").datagrid({
        fit:true,
        pagination:true,
        url:"items",
        columns:[[
            {field:"id",title:"商品编号",width:100},
            {field:"title",title:"商品名称",width:300},
            {field:"sellPoint",title:"卖点",width:300},
            {field:'price',title:'商品价格',width:100},
            {field:'num',title:'商品数量',width:100},
            {field:'barcode',title:'条形码',width:100},
            {field:'image',title:'图片',width:100},
            {field:'cid',title:'类型',width:100},
            {field:'status',title:'状态',width:100},
            {field:'created',title:'生成时间',width:100},
            {field:'updated',title:'更新时间',width:100}
        ]]

    });

</script>