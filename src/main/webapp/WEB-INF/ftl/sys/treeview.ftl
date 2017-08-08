<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>机构树菜单树 - Bootstrap后台管理系统模版Ace下载</title>
    <meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文"/>
    <meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- basic styles -->

    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
    <!-- fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="assets/css/ace.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="assets/css/self.css"/>


</head>

<body>

<div class="page-content">
    <div class="page-header">
        <h1>
            Treeview
            <small>
                <i class="icon-double-angle-right"></i>
                with selectable items(single &amp; multiple) and custom icons
            </small>
        </h1>
    </div><!-- /.page-header -->

    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->

            <div class="row">
                <div class="col-sm-6">
                    <div class="widget-box">
                        <div class="widget-header header-color-blue2">
                            <h4 class="lighter smaller">Choose Categories</h4>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main padding-8">
                                <div id="tree1" class="tree"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6">
                    <div class="widget-box">
                        <div class="widget-header header-color-green2">
                            <h4 class="lighter smaller">Browse Files</h4>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main padding-8">
                                <div id="tree2" class="tree"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <script type="text/javascript">
                var $assets = "assets";//this will be used in fuelux.tree-sampledata.js
            </script>

            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div><!-- /.row -->

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        模态框（Modal）标题
                    </h4>
                </div>
                <div class="modal-body">
                    在这里添加一些文本
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary">
                        提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div><!-- /.page-content -->

<!-- basic scripts -->


<script type="text/javascript">
    window.jQuery || document.write("<script src='${host!}/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>


<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='${host!}/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="${host!}/assets/js/bootstrap.min.js"></script>
<script src="${host!}/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="${host!}/assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
<script src="${host!}/assets/js/fuelux/fuelux.tree.min.js"></script>

<!-- ace scripts -->

<script src="${host!}/assets/js/ace-elements.min.js"></script>
<script src="${host!}/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">


    var treeDataSource1 = {};
    //  var treeDataSource = new DataSourceTree({data: treeData});
    jQuery(function ($) {
        $.post("index/menues",
                {},
                function (data, status) {
                    console.log("data" + data);
                    if (status == 'success' && data.status == '200') {
                        var tree_data = {};
                        var tree_data = showall(data.body.menues)
                        treeDataSource1 = new DataSourceTree({data: tree_data});
                        tree1();
                        tree2()
                        bind();
                    } else if (data.status = '401') {
                        $(".tooltip-error").removeClass("hidden");
                    }

                });


//        $('#tree1').on('loaded', function (evt, data) {
//
//        });

//        $('#tree1').on('opened', function (evt, data) {
//            bind();
//        });

//        $('#tree1').on('closed', function (evt, data) {
//
//        });

        $('#tree1').on('selected', function (evt, data) {
            console.log(data);
//             $('#myModal').modal({
//                 keyboard: true
//             })

        });

        $('#tree2').on('selected', function (evt, data) {
            console.log(data);
        });


    });

    function tree1() {
        $('#tree1').ace_tree({
            dataSource: treeDataSource1,
            //multiSelect: true,
            loadingHTML: '<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
            'open-icon': 'icon-minus',
            'close-icon': 'icon-plus',
            'selectable': true,
            //'selected-icon': 'icon-ok',
            //'unselected-icon': 'icon-remove'
            'selected-icon': null,
            'unselected-icon': null
        });

    }
    function tree2() {
        $('#tree2').ace_tree({
            dataSource: treeDataSource1,
            loadingHTML: '<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
            'open-icon': 'icon-folder-open',
            'close-icon': 'icon-folder-close',
            'selectable': true,
            'selected-icon': null,
            'unselected-icon': null
        });
    }

    function bind() {
        $(".no-radius").bind("click", function () {
            alert("edit")
        })
    }

    function showall(menu_list) {

        var tree_data;
        var haschild = false;
        for (var menu in menu_list) {
            if (menu_list[menu].subMenues.length > 0) {
                haschild = true;
            }
        }
        if (haschild == true) {
            tree_data = {};
        } else {
            tree_data = new Array();
        }

        for (var menu in menu_list) {
            //如果有子节点，则遍历该子节点
            var sub = menu_list[menu];
            if (sub.subMenues.length > 0) {
                var additionalParameters = {};
                var params = showall(sub.subMenues);
                additionalParameters["children"] = params;
                var sub_tree = {
                    "name": sub.name,
                    "type": "folder",
                    "menueId": sub.id,
                    "menuePid": sub.pid,
                    "additionalParameters": additionalParameters
                }
                tree_data[sub.name] = sub_tree;

            }
            else {
                var sub_tree = {"name": sub.name, "type": "item", "menueId": sub.id, "menuePid": sub.pid}
                if (haschild == true) {
                    tree_data[sub.name] = sub_tree;
                } else {
                    tree_data.push(sub_tree);
                }


            }

        }
        return tree_data;

    }


</script>
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>
</div>
</body>
</html>
