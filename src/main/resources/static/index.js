angular.module('app', []).controller('indexController', function($scope, $http){
    const contextPath = 'http://localhost:8189/app';

    //запрос списка продуктов из репозитория
    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
             .then(function (response) {
                 $scope.ProductsList = response.data;
             });
    };

    //удаление продукта из репозитория по id
    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
             .then(function (response) {
                $scope.loadProducts();
             });
    }

    //изменение количества продуктов по id
    $scope.changeQuantity = function (studentId, quantity) {
        $http({
            url: contextPath + '/products/changeQuantity',
            method: 'GET',
            params: {
                id: studentId,
                quantity: quantity
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();
});