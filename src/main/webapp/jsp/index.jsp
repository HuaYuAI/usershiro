<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MQTT移信后台管理系统</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/e3.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout">
    <!-- 头部标题 -->
	<div data-options="region:'north',border:false" style="height:60px; padding:5px; background:#F3F3F3"> 
		<span class="northTitle">MQTT移信后台管理系统</span>
	    <span class="loginInfo">登录用户：admin&nbsp;&nbsp;姓名：管理员&nbsp;&nbsp;角色：系统管理员</span>
	</div>
    <div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
		<ul id="tt" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;"></ul>

    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
			<shiro:hasRole name="admin">
				<li>
					<span>工作人员</span>
					<ul>
						<%--<shiro:hasPermission name="addItem1111">--%>
						<li data-options="attributes:{'url':'sysuser-list'}">设置工作人员权限</li>
						<%--</shiro:hasPermission>--%>
						<%--<shiro:hasRole name="zongjingli">--%>
						<li data-options="attributes:{'url':'sysuser-list'}">查看工作人员</li>
						<%--</shiro:hasRole>--%>
					</ul>
				</li>
			</shiro:hasRole>
         	<li>
         		<span>管理用户</span>
         		<ul>
					<%--<shiro:hasRole name="zongjingli">--%>
	         			<li data-options="attributes:{'url':'item-list'}">添加白名单</li>
					<%--</shiro:hasRole>--%>
	         			<li data-options="attributes:{'url':'item-param-list'}">添加黑名单</li>
						<li data-options="attributes:{'url':'item-param-list'}">重置用户名密码</li>
	         	</ul>
         	</li>
         	<li>
         		<span>查询用户</span>
         		<ul>
	         		<li data-options="attributes:{'url':'user-list'}">全部用户</li>
	         		<li data-options="attributes:{'url':'content'}">白名单用户</li>
					<li data-options="attributes:{'url':'content'}">黑名单用户</li>
					<li data-options="attributes:{'url':'content'}">正常用户</li>
	         	</ul>
         	</li>
         </ul>
    </div>
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">
		        	
		    </div>
		</div>
    </div>
    <!-- 页脚信息 -->
	<div data-options="region:'south',border:false" style="height:20px; background:#F3F3F3; padding:2px; vertical-align:middle;">
		<span id="sysVersion">系统版本：V1.0</span>
	    <span id="nowTime"></span>
	</div>
<script type="text/javascript">
$(function(){
    $('#tt').tree({
        url:'sysTree',
        loadFilter: function(data){
            debugger;
			if (data.d){
				return data.d;
			} else {
			    debugger;
				return data;
			}
		},
        onClick: function(node){
            if($('#tt').tree("isLeaf",node.target)){
                var tabs = $("#tabs");
                var tab = tabs.tabs("getTab",node.text);
                if(tab){
                    tabs.tabs("select",node.text);
                }else{
                    tabs.tabs('add',{
                        title:node.text,
                        href: node.attributes.url,
                        closable:true,
                        bodyCls:"content"
                    });
                }
            }
        }
	});
    $('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
});
setInterval("document.getElementById('nowTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
</script>
</body>
</html>