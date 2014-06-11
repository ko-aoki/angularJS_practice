define(['controllers'],
    function(controllers) {
        controllers.controller('CodeDeptCtrl', ['$scope', '$http',
        function ($scope, $http) {
            $scope.find = function() {
                $http.post('webresources/codeDept/',
                    {
                        pDeptId: $scope.pDeptId,
                        pDeptNm: $scope.pDeptNm,
                        deptId: $scope.deptId,
                        deptNm: $scope.deptNm,
                        pageInfo: $scope.pageInfo
                    },
                    {headers: {
                        'Content-Type': 'application/json'
                    }}
                ).success(function (data) {
                    $scope.pageInfo = data.pageInfo;
                    $scope.recs = data.recs;
                });
            };
            $scope.pageJump = function(page) {
                $scope.pageInfo.requestPage = page;
                $scope.find();
            };
    }]);
});
