define(['controllers', 'jquery', 'jquery.treeview'],
    function(controllers, $) {
        controllers.controller('MenuCtrl', ['$scope', '$http', '$routeParams',
            function ($scope, $http, $routeParams) {
                $http.get('webresources/menu/' + $routeParams.roleId).success(function (data) {
                    var $menu = $("#menu");
                    writeMenuList(data, $menu);
                    $menu.treeview();
                });
                function writeMenuList(data, elm) {
                    for (var i = 0; i < data.length; i++) {
                        if (data[i].childMenu != undefined && data[i].childMenu.length > 0) {
                            var ul = $("<ul></ul>");
                            var li = $("<li>" + data[i].menuId + "</li>");
                            writeMenuList(data[i].childMenu, ul);
                            li.append(ul);
                            elm.append(li);
                            console.log("ul:" + data[i].path);
                        } else {
                            elm.append('<li><a href="' + data[i].url + '" target="_blank" "width=1024,height=800">' + data[i].menuId + '</a></li>');
                            console.log("li:" + data[i].path);
                        }
                    }
                }
            }
        ]);
    }
);
