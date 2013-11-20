Ext.onReady(function() {
			/**
			 * Bugs： 1.已加载的页面会转移到Accordion中，使布局混乱。
			 * 2.回点至item1时，item1会消失，click事件全部失效 3.横向改变accordion宽度时，页面布局崩溃
			 */
			// Ext.Msg.alert('ext','welcome you!');
			Ext.Ajax.disableCaching = false;

			var tabPanel = Ext.create('Ext.tab.Panel', {
						region : 'center',
						enableTabScroll : true,
						deferredRender : false,
						activeTab : 0,
						items : [{
									title : 'index',
									html : '<h1>Welcome!</h1>',
									closable : true
								}]

					});

			var addPanel = function(btn, event) {
				var n;
				n = tabPanel.getComponent(btn.id);
				if (n) {
					tabPanel.setActiveTab(n);
					return;
				}
				n = tabPanel.add({
							id : btn.id,
							title : btn.text,
							html : '<iframe width=100% height=100% src="' + 'backend/' + btn.id + '" />',
							/*loader : {
								url : 'backend/' + btn.id,
								autoLoad : true
							},*/
							closable : 'true'
						});
				tabPanel.setActiveTab(n);
			};

			var item1 = Ext.create('Ext.panel.Panel', {
						title : '课件管理',
						collapsible : false,
						// html : '&lt;empty panel&gt;',
						items : [Ext.create('Ext.button.Button', {
											id : 'upwares.html',// id不能一样，否则会出重复问题
											text : '上传课件',
											width : '50%',
											listeners : {
												click : addPanel
											}
										}), Ext.create('Ext.button.Button', {
											id : 'cou!view',
											text : '课件一览',
											width : '50%',
											listeners : {
												// 文章的修改删除也在此Panel上做，以弹窗形式修改
												click : addPanel
											}

										})]
					});

			var item2 = Ext.create('Ext.panel.Panel', {
						title : '教学日历管理',
						collapsible : false,
						// html : '&lt;empty panel&gt;',
						cls : 'empty',
						items : [Ext.create('Ext.button.Button', {
											id : 'upcalendars.html',
											text : '日历上传',
											width : '50%',
											listeners : {
												click : addPanel
											}
										}), Ext.create('Ext.button.Button', {
											id : 'cal!view',
											text : '日历一览',
											width : '50%',
											listeners : {
												// 文章的修改删除也在此Panel上做，以弹窗形式修改
												click : addPanel
											}

										})

						]
					});

			var item3 = Ext.create('Ext.panel.Panel', {
						title : '教学视频管理',
						collapsible : false,
						// html : '&lt;empty panel&gt;',
						items : [Ext.create('Ext.button.Button', {
											id : 'upvideos.html',
											text : '上传视频',
											width : '50%',
											listeners : {
												click : addPanel
											}
										}), Ext.create('Ext.button.Button', {
											id : 'vid!view',
											text : '视频一览',
											width : '50%',
											listeners : {
												// 文章的修改删除也在此Panel上做，以弹窗形式修改
												click : addPanel
											}

										})

						]
					});

			var item4 = Ext.create('Ext.panel.Panel', {
						title : '教师管理',
						collapsible : false,
						// html : '&lt;empty panel&gt;',
						items : [Ext.create('Ext.button.Button', {
											id : 'tea!getTeacher?id=${u.id}',
											text : '个人资料',
											width : '50%',
											listeners : {
												click :  function(btn){
													Ext.Msg.alert('提示',btn.id);
												}
											}
										}), Ext.create('Ext.button.Button', {
											id : 'tea!view',
											text : '教师一览',
											width : '50%',
											listeners : {
												// 文章的修改删除也在此Panel上做，以弹窗形式修改
												click : addPanel
											}

										})

						]
					});

			var item5 = Ext.create('Ext.panel.Panel', {
						title : '题库管理',
						collapsible : false,
						// html : '&lt;empty panel&gt;',
						items : [Ext.create('Ext.button.Button', {
											id : '0',
											text : '添加题目',
											width : '50%',
											listeners : {
												click : function(){
													Ext.Msg.alert('提示','该功能未实现');
												}
											}
										}), Ext.create('Ext.button.Button', {
											id : '',
											text : '题目一览',
											width : '50%',
											listeners : {
												// 文章的修改删除也在此Panel上做，以弹窗形式修改
												click : function(){
													Ext.Msg.alert('提示','该功能未实现');
												}
											}

										})

						]
					});
			var item6 = Ext.create('Ext.panel.Panel', {
						title : '学生管理',
						collapsible : false,
						// html : '&lt;empty panel&gt;',
						items : [Ext.create('Ext.button.Button', {
											id : 'addstu.jsp',
											text : '添加学生',
											width : '50%',
											listeners : {
												click :  addPanel
											}
										}), Ext.create('Ext.button.Button', {
											id : 'stu!view',
											text : '学生一览',
											width : '50%',
											listeners : {
												click : addPanel
											}
										}), Ext.create('Ext.button.Button', {
											id : '5',
											text : '发布作业',
											width : '50%',
											listeners : {
												click : function(){
													Ext.Msg.alert('提示','该功能未实现');
												}
											}
										}), Ext.create('Ext.button.Button', {
											id : '6',
											text : '查看作业',
											width : '50%',
											listeners : {
												// 文章的修改删除也在此Panel上做，以弹窗形式修改
												click : function(){
													Ext.Msg.alert('提示','该功能未实现');
												}
											}
										})

						]
					});

			var accordion = Ext.create('Ext.panel.Panel', {
						region : 'west',
						margins : '5 0 5 5',
						// width : 210,
						layout : {
							type : 'accordion',
							hideCollapseTool : true,
							multi : true
							// animate : true
						},
						items : [item6, item1, item2, item3, item4, item5]
					});

			var top = Ext.create('Ext.panel.Panel', {
						region : 'north',
						title : 'LOGO',
						height : 80,
						html : 'LOGO'
					});

			var viewport = Ext.create('Ext.container.Viewport', {
						layout : 'border',
						items : [top, accordion, tabPanel],
						draggable : false
					});

		});