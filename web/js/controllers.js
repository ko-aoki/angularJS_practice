define(['angular', 'services'], function (angular) {
    'use strict';

    /* Controllers */

    return angular.module('myApp.controllers', [])
    .controller('LoginCtrl', ['$scope', '$injector', function($scope, $injector) {
        require(['controllers/loginCtrl'], function(loginCtrl) {
            // injector method takes an array of modules as the first argument
            // if you want your controller to be able to use components from
            // any of your other modules, make sure you include it together with 'ng'
            // Furthermore we need to pass on the $scope as it's unique to this controller
            $injector.invoke(loginCtrl, this, {'$scope': $scope});
        });
    }])
    .controller('MenuCtrl', ['$scope', '$injector', function($scope, $injector) {
        require(['controllers/menuCtrl'], function(menuCtrl) {
            $injector.invoke(menuCtrl, this, {'$scope': $scope});
        });
    }])
    .controller('MntMstUserCtrl', ['$scope', '$injector', function($scope, $injector) {
        require(['controllers/mntMstUserCtrl'], function(mntMstUserCtrl) {
            $injector.invoke(mntMstUserCtrl, this, {'$scope': $scope});
        });
    }])
    .controller('MntMstUserRegCtrl', ['$scope', '$injector', function($scope, $injector) {
        require(['controllers/mntMstUserRegCtrl'], function(mntMstUserRegCtrl) {
            $injector.invoke(mntMstUserRegCtrl, this, {'$scope': $scope});
        });
    }]);
});
