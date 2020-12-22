<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/ace.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/js/ace-extra.min.js'/>" />

</head>
<body class="no-skin">


	<%@include file="/common/admin/header.jsp"%>

	<dec:body />

	<script
		src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js'/>"></script>

	<script>
		function assignmentBuilding(buildingId) {
			openModalAssignmentBuilding();
			$('#buildingId').val(buildingId);
			console.log($('#buildingId').val());
		}

		function openModalAssignmentBuilding() {
			$('#assignmentBuildingModal').modal();
		}

		$('#btnAssignBuilding').click(
				function(e) {
					e.preventDefault();
					var data = {};
					data['buildingId'] = $('#buildingId').val();
					var staffs = $('#staffList').find(
							'tbody input[type=checkbox]:checked').map(
							function() {
								return $(this).val();
							}).get();
					data['staffs'] = staffs;
					assignStaff(data);

				});

		function assignStaff(data) {
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/api-user-assignment",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json",
				success : function(response) {
					console.log('success');
				},
				error : function(response) {
					console.log('failed');
					console.log(response);
				}
			});
		}

		$('#btnDeleteBuilding').click(
				function(e) {
					e.preventDefault();
					var data = {};
					var buildingIds = $('#buildingList').find(
							'tbody input[type=checkbox]:checked').map(
							function() {
								return $(this).val();
							}).get();
					data['buildingIds'] = buildingIds;
					deleteBuilding(data);
				});

		function deleteBuilding(data) {
			$.ajax({
				type : "DELETE",
				url : "http://localhost:8080/api-building",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json",
				success : function(response) {
					console.log('success');
				},
				error : function(response) {
					console.log('failed');
					console.log(response);
				}
			});
		}
	</script>



	<script type="text/javascript">
		window.jQuery
				|| document.write("<script src='assets/js/jquery.min.js'>"
						+ "<"+"/script>");
	</script>

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>

	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js"'/>"></script>

	<!-- ace scripts -->

	<script
		src="<c:url value='/template/admin/assets/js/ace-elements.min.js"'/>"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js"'/>"></script>


	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			$('.easy-pie-chart.percentage')
					.each(
							function() {
								var $box = $(this).closest('.infobox');
								var barColor = $(this).data('color')
										|| (!$box.hasClass('infobox-dark') ? $box
												.css('color')
												: 'rgba(255,255,255,0.95)');
								var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)'
										: '#E2E2E2';
								var size = parseInt($(this).data('size')) || 50;
								$(this)
										.easyPieChart(
												{
													barColor : barColor,
													trackColor : trackColor,
													scaleColor : false,
													lineCap : 'butt',
													lineWidth : parseInt(size / 10),
													animate : /msie\s*(8|7|6)/
															.test(navigator.userAgent
																	.toLowerCase()) ? false
															: 1000,
													size : size
												});
							})

			$('.sparkline').each(
					function() {
						var $box = $(this).closest('.infobox');
						var barColor = !$box.hasClass('infobox-dark') ? $box
								.css('color') : '#FFF';
						$(this).sparkline('html', {
							tagValuesAttribute : 'data-values',
							type : 'bar',
							barColor : barColor,
							chartRangeMin : $(this).data('min') || 0
						});
					});

			//flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
			//but sometimes it brings up errors with normal resize event handlers
			$.resize.throttleWindow = false;

			var placeholder = $('#piechart-placeholder').css({
				'width' : '90%',
				'min-height' : '150px'
			});
			var data = [ {
				label : "social networks",
				data : 38.7,
				color : "#68BC31"
			}, {
				label : "search engines",
				data : 24.5,
				color : "#2091CF"
			}, {
				label : "ad campaigns",
				data : 8.2,
				color : "#AF4E96"
			}, {
				label : "direct traffic",
				data : 18.6,
				color : "#DA5430"
			}, {
				label : "other",
				data : 10,
				color : "#FEE074"
			} ]
			function drawPieChart(placeholder, data, position) {
				$.plot(placeholder, data, {
					series : {
						pie : {
							show : true,
							tilt : 0.8,
							highlight : {
								opacity : 0.25
							},
							stroke : {
								color : '#fff',
								width : 2
							},
							startAngle : 2
						}
					},
					legend : {
						show : true,
						position : position || "ne",
						labelBoxBorderColor : null,
						margin : [ -30, 15 ]
					},
					grid : {
						hoverable : true,
						clickable : true
					}
				})
			}
			drawPieChart(placeholder, data);

			/**
			we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			so that's not needed actually.
			 */
			placeholder.data('chart', data);
			placeholder.data('draw', drawPieChart);

			//pie chart tooltip example
			var $tooltip = $(
					"<div class='tooltip top in'><div class='tooltip-inner'></div></div>")
					.hide().appendTo('body');
			var previousPoint = null;

			placeholder.on('plothover', function(event, pos, item) {
				if (item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : "
								+ item.series['percent'] + '%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({
						top : pos.pageY + 10,
						left : pos.pageX + 10
					});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}

			});

			/////////////////////////////////////
			$(document).one('ajaxloadstart.page', function(e) {
				$tooltip.remove();
			});

			var d1 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d1.push([ i, Math.sin(i) ]);
			}

			var d2 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d2.push([ i, Math.cos(i) ]);
			}

			var d3 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.2) {
				d3.push([ i, Math.tan(i) ]);
			}

			var sales_charts = $('#sales-charts').css({
				'width' : '100%',
				'height' : '220px'
			});
			$.plot("#sales-charts", [ {
				label : "Domains",
				data : d1
			}, {
				label : "Hosting",
				data : d2
			}, {
				label : "Services",
				data : d3
			} ], {
				hoverable : true,
				shadowSize : 0,
				series : {
					lines : {
						show : true
					},
					points : {
						show : true
					}
				},
				xaxis : {
					tickLength : 0
				},
				yaxis : {
					ticks : 10,
					min : -2,
					max : 2,
					tickDecimals : 3
				},
				grid : {
					backgroundColor : {
						colors : [ "#fff", "#fff" ]
					},
					borderWidth : 1,
					borderColor : '#555'
				}
			});

			$('#recent-box [data-rel="tooltip"]').tooltip({
				placement : tooltip_placement
			});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('.tab-content')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				//var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
					return 'right';
				return 'left';
			}

			$('.dialogs,.comments').ace_scroll({
				size : 300
			});

			//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
			//so disable dragging when clicking on label
			var agent = navigator.userAgent.toLowerCase();
			if ("ontouchstart" in document && /applewebkit/.test(agent)
					&& /android/.test(agent))
				$('#tasks').on('touchstart', function(e) {
					var li = $(e.target).closest('#tasks li');
					if (li.length == 0)
						return;
					var label = li.find('label.inline').get(0);
					if (label == e.target || $.contains(label, e.target))
						e.stopImmediatePropagation();
				});

			$('#tasks').sortable({
				opacity : 0.8,
				revert : true,
				forceHelperSize : true,
				placeholder : 'draggable-placeholder',
				forcePlaceholderSize : true,
				tolerance : 'pointer',
				stop : function(event, ui) {
					//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
					$(ui.item).css('z-index', 'auto');
				}
			});
			$('#tasks').disableSelection();
			$('#tasks input:checkbox').removeAttr('checked').on('click',
					function() {
						if (this.checked)
							$(this).closest('li').addClass('selected');
						else
							$(this).closest('li').removeClass('selected');
					});

			//show the dropdowns on top or bottom depending on window height and menu position
			$('#task-tab .dropdown-hover').on('mouseenter', function(e) {
				var offset = $(this).offset();

				var $w = $(window)
				if (offset.top > $w.scrollTop() + $w.innerHeight() - 100)
					$(this).addClass('dropup');
				else
					$(this).removeClass('dropup');
			});

		})
	</script>
</body>
</html>