'use strict';

define(['angularMocks', 'controllers', 'controllers/loginCtrl'], function(angularmocks) {
/* jasmine specs for controllers go here */
describe('common-app-javaee7 controllers', function() {

    describe('LoginCtrl', function(){


        var $http, $httpBackend, $scope, ctrl;

        beforeEach(module('controllers'));
        beforeEach(inject(function(_$http_, _$httpBackend_) {
            $http = _$http_;
            $httpBackend = _$httpBackend_;

        }));
        beforeEach(inject(function(_$rootScope_, _$controller_) {
            $scope = _$rootScope_.$new();
            ctrl = _$controller_('LoginCtrl',{
                $scope : $scope
            })
        }));

        it('エラーならメッセージを$scopeに格納', function(){
            //リクエストに応じたレスポンスを設定
            $httpBackend.expectGET('webresources/login/A0001,A').respond(
                {
                    result: 'error',
                    messages: ['hogehoge']
                }
            );
            //Sscopeに値設定
            $scope.loginUserId = 'A0001';
            $scope.password = 'A';
            //テスト対象のメソッド実行、ここでリクエスト発生
            $scope.login();
            //expectGETで設定したレスポンスが返却される
            $httpBackend.flush();
            //値チェック
            expect($scope.messages).toEqual(['hogehoge']);
        });

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

    });

});
});