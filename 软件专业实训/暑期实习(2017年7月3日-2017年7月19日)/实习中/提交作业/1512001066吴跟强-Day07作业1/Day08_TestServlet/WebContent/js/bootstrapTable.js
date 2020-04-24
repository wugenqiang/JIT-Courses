var TableInit = function() {
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function(t_url,t_data) {
		//---先销毁表格 ---
		$('#table').bootstrapTable('destroy');
		$('#table').bootstrapTable({
			url: t_url, //请求后台的URL（*）
			method: 'post', //请求方式（*）
			locale: 'zh-CN',
			toolbar: '#toolbar', //工具按钮用哪个容器
			striped: true, //是否显示行间隔色
			cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true, //是否显示分页（*）
			sortable: true, //是否启用排序
			sortOrder: "asc", //排序方式
			sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
			pageNumber: 1, //初始化加载第一页，默认第一页
			pageSize: 10, //每页的记录行数（*）
			pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
			search: true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,
			editable:true,//开启编辑模式
			showColumns: true, //是否显示所有的列
			showRefresh: true, //是否显示刷新按钮
			showHeader: true, //是否显示头部
			showFooter: false, //是否显示底部
			showColumns: true, //是否显示 内容列下拉框
			showToggle: true, //是否显示详细视图和列表视图的切换按钮
			minimumCountColumns: 2, //最少允许的列数
			clickToSelect: true, //是否启用点击选中行
			//height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId: "ID", //每一行的唯一标识，一般为主键列
			cardView: false, //设置为 true将显示card视图，适用于移动设备。否则为table试图，适用于pc
			//showExport: true,                     //是否显示导出
			//exportDataType: "basic",              //basic', 'all', 'selected'
			contentType: "application/x-www-form-urlencoded",
			queryParamsType: 'limit', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
			//queryParams: oTableInit.queryParams,//传递参数（*）
			queryParams: function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					myoffset: params.offset, //每页起始位置
					mylimit: params.limit, //每页数量
					sortOrder: params.order,
					maxrows: params.limit,
					pageindex: params.pageNumber
				};
				return temp;
			},
			columns: [{
				field: 'id',
				title: 'ID',
				align: 'center',
				valign: 'middle',
				width: '50px',
			}, {
				field: 'name',
				title: '图书名',
				align: 'center',
				valign: 'middle',
				sortable: 'true',
				width: '20%',
				edit:{  
	                required:true,  
	                click:function(){  
	                }  
	            }
			}, {
				field: 'author',
				title: '图书作者',
				align: 'center',
				valign: 'middle',
				width: '100px',
			}, {
				field: 'publish',
				title: '出版社',
				align: 'center',
				valign: 'middle',
				width: '20%',
			}, {
				field: 'publishDate',
				title: '出版日期',
				align: 'center',
				valign: 'middle',
				width: '100px',
				edit:{  
		            type:'date'//日期  
		        },
			}, {
				field: 'page',
				title: '页数',
				align: 'center',
				valign: 'middle',
				width: '80px',
			}, {
				field: 'price',
				title: '价格',
				align: 'center',
				valign: 'middle',
				width: '80px',
			}, {
				field: 'content',
				title: '内容摘要',
				align: 'center',
				valign: 'middle',
				width: '30%',
			}, {
				field: 'operation',
				title: '操作',
				align: 'center',
				valign: 'middle',
				width: '20%',
				formatter: function(value, row, index) {
					var s = '<a class = "save" href="javascript:void(0)"><span class="glyphicon glyphicon-pencil" aria-hidden="true">修改</a>';
					var d = '<a class = "remove" href="javascript:void(0)"><span class="glyphicon glyphicon-remove" aria-hidden="true">删除</a>';
					return s + ' ' + d;
				},
				events: 'operateEvents'
			}],
			responseHandler: function(result) {
				//在ajax获取到数据，渲染表格之前，修改数据源
				return result;
			},
			//dataField:{total:50,
			//data: t_data,
		});
	};

	//查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			myoffset: params.offset, //第几页
			mylimit: params.limit, //每页条数
			sortOrder: params.order,
			maxrows: params.limit,
			pageindex: params.pageNumber,
		};
		return temp;
	};
	return oTableInit;
};

window.operateEvents = {
	'click .save': function(e, value, row, index) {
		$.ajax({
			type: "post",
			data: row,
			url: '/Analyze/EditMeterMeasureHistoryData',
			success: function(data) {
				alert('修改成功');
			}
		});
	},
	'click .remove': function(e, value, row, index) {
		$.ajax({
			type: "post",
			data: row,
			url: '/Analyze/DeleteMeterMeasureHistoryData',
			success: function(data) {
				alert('删除成功');
				$('#querylist').bootstrapTable('remove', {
					field: 'MeterMeasureHistoryID',
					values: [row.MeterMeasureHistoryID]
				});
			}
		});
	}
};