//主机+地址
var host = "http://"+window.location.host+"/LibraryManageSystem/";
var TableInit = function(t_data) {
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function() {
		//---先销毁表格 ---
		$('#table').bootstrapTable('destroy');
		$('#table').bootstrapTable({
			url: host+'booksPage.do', //请求后台的URL（*）
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
			pageSize: 5, //每页的记录行数（*）
			pageList: [5,10, 25, 50, 100], //可供选择的每页的行数（*）
			search: true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,//设置为true启用全匹配
			searchOnEnterKey:true,
			//editable:true,//开启编辑模式
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
			contentType: "application/x-www-form-urlencoded",//必须的，没有这个后端收不到post数据
			queryParamsType: 'limit', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
			// 设置为 '' 在这种情况下传给服务器的参数为：pageSize,pageNumber
			queryParams: oTableInit.queryParams,//传递参数（*）
			columns: oTableInit.columns,//设置表格显示的字段
			responseHandler: function(result) {
				//在ajax获取到数据，渲染表格之前，修改数据源
				return result;
			},
			onEditableSave: oTableInit.onEditableSave,
			onEditableHidden: function(field, row, $el, reason) { // 当编辑状态被隐藏时触发
                 if(reason === 'save') {
                    
                 } else if(reason === 'nochange') {
                     
                 }
             },
		});
	};

	//查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			offset: params.offset, //第几页
			limit: params.limit, //每页条数
			search:params.search,//搜索字段
			sortOrder: params.order,//排序方式
			maxrows: params.limit,
			pageindex: params.pageNumber,
		};
		return temp;
	};
	
	//编辑后操作
	oTableInit.onEditableSave = function(field, row, oldValue, $el){
		$.ajax({
	        type: "post",
	        url: host+'bookUpdate.do',
	        async: false,
	        data: row,
	        //dataType: 'JSON',
	        traditional: true,
	        success: function (data, status) {
	            if (status == "success") {
	                alert('数据保存成功');
	            }
	        },
	        error: function () {
	            alert('数据保存失败');
	        },
	        complete: function () {
				//alert('complete');
	        }
	
	    });
	};
	
	//列表信息
	oTableInit.columns = [{
        checkbox: true
    }, {
		field: 'id',
		title: 'ID',
		align: 'center',
		valign: 'middle',
		width: '5%',
		visible: false,
	}, {
		field: 'name',
		title: '图书名',
		align: 'center',
		valign: 'middle',
		sortable: 'true',
		searchable:'true',
		width: '20%',
		editable:{  
            required:true,  
            validate: function (v) {
                if (!v) return '图书名不能为空';
            }
        }
	}, {
		field: 'author',
		title: '图书作者',
		align: 'center',
		valign: 'middle',
		width: '10%',
		editable: {
			//mode: 'inline',
            type: 'text',
            title: '图书作者',
            validate: function (v) {
                if (!v) return '图书作者不能为空';
            }
        }
	}, {
		field: 'publish',
		title: '出版社',
		align: 'center',
		valign: 'middle',
		width: '20%',
		editable:{  
            type:'text',
            title: '出版社',
            source: function(){
            	if (!v) return '出版社不能为空';
            }
        },
	}, {
		field: 'publishdate',
		title: '出版日期',
		align: 'center',
		valign: 'middle',
		width: '10%',
		editable:{  
            type:'date',//日期  
            title: '出版日期',
            source: function(){
            	if (!v) return '出版日期不能为空';
            }
        },
	}, {
		field: 'page',
		title: '页数',
		align: 'center',
		valign: 'middle',
		width: '5%',
		editable:{  
            type:'text',
            title: '页数',
            source: function(){
            	if (!v) return '页数不能为空';
            }
        },
	}, {
		field: 'price',
		title: '价格',
		align: 'center',
		valign: 'middle',
		width: '5%',
		editable:{  
            type:'text',
            title: '价格',
            source: function(){
            	if (!v) return '价格不能为空';
            }
        },
	}, {
		field: 'content',
		title: '内容摘要',
		align: 'center',
		valign: 'middle',
		width: '25%',
		editable:{  
            type:'text',
            title: '内容摘要',
            source: function(){
            	if (!v) return '内容摘要不能为空';
            }
        },
	}];
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

$(function(){
	//新增
	$('#btn_add').on('click', function () {
        $(document.body).append('<div id="modal"></div>');
        Modal = new Modal();
        Modal.title = "";
        Modal.renderto = "#modal";
        Modal.InitShow = true;
        //Modal.btns = [{id:"btn1",text:"保存"}, { id: "closebtn" }];
        tab = new Tab();
        Modal.OnfirstInited = function (thismodal) {
            tab.tabs = [{
                id: "tab1",
                title: "增加书籍资料",
                active: true,
                isiframe: true,
                url: 'html/insertBook.html',
            }];
            tab.renderto = thismodal.body;
            tab.Init();
        }
        Modal.show();
	});
	
	//删除
	$('#btn_delete').on('click', function () {
		var selections = $('#table').bootstrapTable('getSelections');
		var ids;
		//alert(typeof selections);
		//alert(JSON.stringify(selections));
		var ids = $.map(selections, function(row) {
            return row.id;
        });
		//alert(selections[0].name);
		if(ids.length == 0){
			alert("没有勾选任何内容");
		}else{
			$.ajax({
				type: "post",
				//data: $(ids).serializeArray(),
				data: {id:ids},
				url: host+'bookDelete.do',
				async: false,
	            //dataType: 'JSON',
	            traditional: true,
	            success: function (data, status) {
	                if (status == "success") {
	                    alert('数据删除成功');
	                    $('#table').bootstrapTable('remove', {field: 'id', values: ids});
	                }
	            },
	            error: function () {
	                alert('数据删除失败');
	            },
	            complete: function () {
					//alert('complete');
	            }
			});
		}
	});
});