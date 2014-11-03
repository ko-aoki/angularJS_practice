angular.module('controllers').controller('CodeDeptCtrl', ['$scope', 'codeDeptResource',
        function ($scope, codeDeptResource) {
            $scope.find = function () {
                codeDeptResource.find(
                    {
                        pDeptId: $scope.pDeptId,
                        pDeptNm: $scope.pDeptNm,
                        deptId: $scope.deptId,
                        deptNm: $scope.deptNm,
                        pageInfo: $scope.pageInfo
                    },
                    function (data) {
                        $scope.pageInfo = data.pageInfo;
                        $scope.recs = data.recs;
                    }
                );
            };
            $scope.pageJump = function (page) {
                $scope.pageInfo.requestPage = page;
                $scope.find();
            };
            $scope.ok = function ok(rec) {
                $scope.$emit('CodeDeptOK', rec);
            };
            $scope.cancel = function cancel() {
                $("#codeDept").removeClass("show");
                $("#codeDept").addClass("hide");
            };
        }]
);
