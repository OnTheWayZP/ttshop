<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<script src="<%=request.getContextPath() %>/static/js/jquery.min.js" type="text/javascript"></script>

<html>

    <head>
        
    </head>
    
    <body>
        
    <form action="<%=request.getContextPath() %>/alipay/goAlipay" method="post">
    	<input type="hidden" name="orderId" value="${order.id }" />
        <table>
        	<tr>
        		<td>
        			订单编号: ${order.id }
        		</td>
        	</tr>
        		<td>
        			产品名称: ${p.name }
        		</td>
        	<tr>
        	</tr>
        		<td>
        			订单价格: ${order.orderAmount }
        		</td>
        	<tr>
        	</tr>
        		<td>
        			购买个数：${order.buyCounts }
        		</td>
        	</tr>
        	</tr>
        		<td>
        			<input type="submit" value="前往支付宝进行支付">
        		</td>
        	</tr>
        </table>
    </form>
    
    
        <input type="hidden" id="hdnContextPath" name="hdnContextPath" value="<%=request.getContextPath() %>"/>
    </body>
    
</html>


<script type="text/javascript">

	$(document).ready(function() {
		
		var hdnContextPath = $("#hdnContextPath").val();
		
		
	});
	

</script>

