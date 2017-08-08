<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Bootstrap网格 - Bootstrap后台管理系统模版Ace下载</title>
		<meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
		<meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->

		<link href="${host!}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${host!}/assets/css/font-awesome.min.css" />
		<!-- ace styles -->

		<link rel="stylesheet" href="${host!}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${host!}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${host!}/assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="assets/css/self.css" />
		<!-- inline styles related to this page -->

		<style>
			.center {
	text-align:center;
}
.center [class*="col-"] {
	margin-top:2px;
	margin-bottom:2px;
	padding-top:4px;
	padding-bottom:4px;

	position:relative;
	text-overflow:ellipsis;
}
.center [class*="col-"]  span{
  position:relative;
  z-index:2;
	
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;

  width: 100%;
}
.center [class*="col-"]:before {
	position:absolute;
	top:0; bottom:0;
	left:2px; right:2px;
	content:"";
	display:block;
	border:1px solid #DDD;
	z-index: 1;
}

.center [class*="col-"]:hover:before {
	background-color:#FCE6A6;
	border-color:#EFD27A;
}
		</style>

		<!-- ace settings handler -->

		<script src="${host!}/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${host!}/assets/js/html5shiv.js"></script>
		<script src="${host!}/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>


    <div class="page-content">
        <div class="page-header">
            <h1>
                Grid
                <small>
                    <i class="icon-double-angle-right"></i>
                    bootstrap grid sizing
                </small>
            </h1>
        </div><!-- /.page-header -->

        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->

                <div class="center">
                    <div class="row">
                        <div class="col-xs-12">
                            <span>.col-xs-12</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-1">
                            <span>.col-xs-1</span>
                        </div>

                        <div class="col-xs-11">
                            <span>.col-xs-11</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-6 col-sm-2">
                            <span>.col-xs-6.col-sm-2</span>
                        </div>

                        <div class="col-xs-6 col-sm-10">
                            <span>.col-xs-6.col-sm-10</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12 col-lg-6">
                            <span>.col-xs-12.col-lg-6</span>
                        </div>

                        <div class="col-xs-12 col-lg-6">
                            <span>.col-xs-12.col-lg-6</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-4">
                            <span>.col-xs-4</span>
                        </div>

                        <div class="col-xs-8">
                            <span>.col-xs-8</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-5">
                            <span>.col-xs-5</span>
                        </div>

                        <div class="col-xs-7">
                            <span>.col-xs-7</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-6">
                            <span>.col-xs-6</span>
                        </div>

                        <div class="col-xs-6">
                            <span>.col-xs-6</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-7">
                            <span>.col-xs-7</span>
                        </div>

                        <div class="col-xs-5">
                            <span>.col-xs-5</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-8">
                            <span>.col-xs-8</span>
                        </div>

                        <div class="col-xs-4">
                            <span>.col-xs-4</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-9">
                            <span>.col-xs-9</span>
                        </div>

                        <div class="col-xs-3">
                            <span>.col-xs-3</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-10">
                            <span>.col-xs-10</span>
                        </div>

                        <div class="col-xs-2">
                            <span>.col-xs-2</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-11">
                            <span>.col-xs-11</span>
                        </div>

                        <div class="col-xs-1">
                            <span>.col-xs-1</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <span>.col-xs-12</span>
                        </div>
                    </div>
                </div>

                <!-- PAGE CONTENT ENDS -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
		<!-- basic scripts -->




		<script type="text/javascript">
			window.jQuery || document.write("<script src='${host!}/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>




		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${host!}/assets/js/bootstrap.min.js"></script>
		<script src="${host!}/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!-- ace scripts -->

		<script src="${host!}/assets/js/ace-elements.min.js"></script>
		<script src="${host!}/assets/js/ace.min.js"></script>
</body>
</html>
