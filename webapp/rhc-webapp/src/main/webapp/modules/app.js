/*
 * App Module
 */

app = angular.module("rhcapp", ['ngRoute']);

app.filter("trust", ['$sce', function ($sce) {
    return function (htmlCode) {
        return $sce.trustAsHtml(htmlCode);
    }
}]);