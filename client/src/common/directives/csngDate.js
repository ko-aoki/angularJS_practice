//引用：http://stackoverflow.com/questions/14474555/how-to-format-a-date-using-ng-model
angular.module('directives').directive('csngDate', [ function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModelCtrl) {
            ngModelCtrl.$formatters.push(formatter);
            ngModelCtrl.$parsers.push(parser);

            element.on('change', function (e) {
                var element = e.target;
                element.value = formatter(ngModelCtrl.$modelValue);
            });

            function parser(value) {
                var m = moment(value);
                var valid = m.isValid();
                ngModelCtrl.$setValidity('csngDate', valid);
                if (valid) {
                    return m.toDate();
                }
                else {
                    return value;
                }
            }

            function formatter(value) {
                var m = moment(value);
                var valid = m.isValid();
                if (valid) {
                    return m.format("YYYY/MM/DD");
                }
                else {
                    return value;
                }
            }

        }
    };
}]);
