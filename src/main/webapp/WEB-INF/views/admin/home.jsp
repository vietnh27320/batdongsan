<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Home Page</title>

</head>

<body>



	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div id="sidebar" class="sidebar                  responsive">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed')
				} catch (e) {
				}
			</script>

			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- /.sidebar-shortcuts -->

			<ul class="nav nav-list">
				<!-- li class="active">
						<a href="index.html">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Dashboard </span>
						</a>

						<b class="arrow"></b>
					</li> -->

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-desktop"></i> <span class="menu-text">
							Tòa nhà </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">

						<li class=""><a href="typography.html"> <i
								class="menu-icon fa fa-caret-right"></i> Danh sách tòa nhà
						</a> <b class="arrow"></b></li>
					</ul></li>
			</ul>
			<!-- /.nav-list -->

			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>

			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch (e) {
				}
			</script>
		</div>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
						</li>
						<li class="active">Dashboard</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box">
								<div class="widget-header">
									<h4 class="widget-title">Tìm kiếm</h4>

									<div class="widget-toolbar">
										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div class="row">
											<div class="col-xs-12">
												<!-- PAGE CONTENT BEGINS -->
												<div class="col-sm-6">
													<div>
														<label for="name">Tên tòa nhà</label> <input type="text"
															id="name" name="name" class="form-control" />
													</div>
												</div>
												<div class="col-xs-12 col-sm-6">
													<div>
														<label for="buildingArea">Diện tích sàn</label> <input
															type="number" id="buildingArea" name="buildingArea"
															class="form-control" />
													</div>
												</div>
												<!-- PAGE CONTENT ENDS -->
											</div>
											<!-- /.col -->
										</div>

										<div class="row">
											<div class="col-xs-12">
												<!-- PAGE CONTENT BEGINS -->
												<div class="col-xs-12 col-sm-4">
													<div>
														<label for="name">Quận hiện có</label>
														<!-- <input type="text" id="name" name="" class="form-control" /> -->
														<select name="" onchange="">
															<option value="-1">--- Chọn quận ---</option>
														</select>
													</div>
												</div>
												<div class="col-xs-12 col-sm-4">
													<div>
														<label for="buildingArea">Phường</label> <input
															type="number" id="" name="" class="form-control" />
													</div>
												</div>
												<div class="col-xs-12 col-sm-4">
													<div>
														<label for="buildingArea">Đường</label> <input
															type="number" id="" name="" class="form-control" />
													</div>
												</div>
												<!-- PAGE CONTENT ENDS -->
											</div>
											<!-- /.col -->
										</div>

										<div class="row">
											<div class="col-xs-12">
												<!-- PAGE CONTENT BEGINS -->
												<div class="col-sm-4">
													<div>
														<label for="name">Số tầng hầm</label> <input type="number"
															id="" class="form-control" />
													</div>
												</div>
												<div class="col-xs-12 col-sm-4">
													<div>
														<label for="buildingArea">Hướng</label> <input type="text"
															id="" name="" class="form-control" />
													</div>
												</div>
												<div class="col-xs-12 col-sm-4">
													<div>
														<label for="buildingArea">Hạng</label> <input type="text"
															id="" name="" class="form-control" />
													</div>
												</div>
												<!-- PAGE CONTENT ENDS -->
											</div>
											<!-- /.col -->
										</div>

										<div class="row">
											<div class="col-xs-12">
												<!-- PAGE CONTENT BEGINS -->
												<div class="col-sm-3">
													<div>
														<label for="name">Diện tích từ</label> <input
															type="number" id="areaRentFrom" name="areaRentFrom"
															class="form-control" />
													</div>
												</div>
												<div class="col-xs-12 col-sm-3">
													<div>
														<label for="buildingArea">Diện tích đến</label> <input
															type="number" id="areaRentTo" name="areaRentTo"
															class="form-control" />
													</div>
												</div>
												<div class="col-xs-12 col-sm-3">
													<div>
														<label for="buildingArea">Giá thuê từ</label> <input
															type="number" id="costRentFrom" name="costRentFrom"
															class="form-control" />
													</div>
												</div>
												<div class="col-xs-12 col-sm-3">
													<div>
														<label for="buildingArea">Giá thuê đến</label> <input
															type="number" id="costRentTo" name="costRentTo"
															class="form-control" />
													</div>
												</div>
												<!-- PAGE CONTENT ENDS -->
											</div>
											<!-- /.col -->
										</div>

										<div class="row">
											<div class="col-xs-12">
												<!-- PAGE CONTENT BEGINS -->
												<div class="col-xs-12 col-sm-4">
													<div>
														<label for="name">Tên quản lý</label> <input type="text"
															id="" name="" class="form-control" />
													</div>
												</div>
												<div class="col-xs-12 col-sm-4">
													<div>
														<label for="buildingArea">Điện thoại quản lý</label> <input
															type="number" id="" name="" class="form-control" />
													</div>
												</div>
												<div class="col-xs-12 col-sm-4">
													<div>
														<label for="buildingArea">Chọn nhân viên phụ trách</label>
														<select name="" onchange="">
															<option value="-1">--- Chọn nhân viên yêu thích
																---</option>
														</select>
													</div>
												</div>
												<!-- PAGE CONTENT ENDS -->
											</div>
											<!-- /.col -->
										</div>

										<div class="row">
											<div class="col-xs-12">
												<div class="col-xs-12 col-sm-4">
													<input type="checkbox" id="" name="" value="">Tầng
													trệt <input type="checkbox" id="" name="" value="">Nguyên
													căn <input type="checkbox" id="" name="" value="">Nội
													thất
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-xs-12">
							<div class="pull-right">
								<button class="btn btn-white btn-info btn-bold"
									data-toggle="tooltip" title="Thêm tòa nhà">
									<i class="fa fa-plus-circle" aria-hidden="true"></i>
								</button>
								<button class="btn btn-white btn-info btn-bold"
									data-toggle="tooltip" title="Xóa tòa nhà"
									id="btnDeleteBuilding">
									<i class="fa fa-trash" aria-hidden="true"></i>
								</button>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="buildingList"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th></th>
										<th>Tên sản phẩm</th>
										<th>Địa chỉ</th>
										<th>Tên quản lý</th>
										<th>Số điện thoại</th>
										<th>DT sàn</th>
										<th>Giá thuê</th>
										<th>Phí dịch vụ</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="checkbox" value="1" id="check_1" /></td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>
											<button class="btn btn-xs btn-info" data-toggle="tooltip"
												title="Giao tòa nhà">
												<i class="fa fa-bars" aria-hidden="true"
													onclick="assignmentBuilding(1)"></i>
											</button>
										</td>
									</tr>
									<tr>
										<td><input type="checkbox" value="2" id="check_2" /></td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>abc</td>
										<td>
											<button class="btn btn-xs btn-info" data-toggle="tooltip"
												title="Giao tòa nhà">
												<i class="fa fa-bars" aria-hidden="true"
													onclick="assignmentBuilding(2)"></i>
											</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<div class="footer">
			<div class="footer-inner">
				<div class="footer-content">
					<span class="bigger-120"> <span class="blue bolder">Ace</span>
						Application &copy; 2013-2014
					</span> &nbsp; &nbsp; <span class="action-buttons"> <a href="#">
							<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-rss-square orange bigger-150"></i>
					</a>
					</span>
				</div>
			</div>
		</div>

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- assignment building modal -->
	<div class="modal fade" id="assignmentBuildingModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Danh sách nhân viên</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered" id="staffList">
						<thead>
							<tr>
								<th>Chọn nhân viên</th>
								<th>Tên nhân viên</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" value="2" id="check_2" checked /></td>
								<td>Nguyễn Văn B</td>
							</tr>
							<tr>
								<td><input type="checkbox" value="3" id="check_3" /></td>
								<td>Nguyễn Văn C</td>
							</tr>
							<tr>
								<td><input type="checkbox" value="4" id="check_4" /></td>
								<td>Nguyễn Văn D</td>
							</tr>
						</tbody>
					</table>
					<input type="hidden" id="buildingId" name="buildingId" value="" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						id="btnAssignBuilding">Giao tòa nhà</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			</div>

		</div>
	</div>

</body>

</html>