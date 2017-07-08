<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	var menuTree;
	$(function() {
		menuTree = $('#menuTree').tree({
			url : '${pageContext.request.contextPath}/admin/menu/notNeedAuth_menuTree.do',
			onClick : function(node) {
				if (centerTabs.tabs('exists', node.text)) {
					centerTabs.tabs('select', node.text);
					return;
				}
				if (node.attributes) {
					centerTabs.tabs('add', {
						title : node.text,
						content : '<iframe src="${pageContext.request.contextPath}' + node.attributes.url + '"  frameborder="0" style="border:0;width:100%;height:99.4%;" ></iframe>',
						closable : true,
						fit : true,
						tools:[{    
					        iconCls:'icon-mini-refresh',    
					        handler:function(){    
					        	refreshTab(node.text);
					        }    
					    }] 
					});
				}
			}
		});
	});
	
	function refreshTab(title) {
		var tab = centerTabs.tabs('getTab', title);
		centerTabs.tabs('update', {
			tab : tab,
			options : tab.panel('options')
		});
	}
</script>
<ul id="menuTree"></ul>