angular
    .module("myApp", ['ngResource', 'ngRoute', 'ngStorage', 'restangular', 'lodash', 'ui.bootstrap', 'angularCSS', 'ngFileUpload'])
    .config(["$routeProvider", function($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl: "../login.html",
                controller: "loginController",
                controllerAs: "loginCtrl",
                css: "../styles/login.css"
            })
            .when("/customer", {
                templateUrl: "../customer.html",
                controller: "customerController",
                controllerAs: "customerCtrl",
                css: "../styles/customer.css"
            })
            .when("/profile", {
                templateUrl: "../profile.html",
                controller: "profileController",
                controllerAs: "profileCtrl",
                css: "../styles/profile.css"
            })
            .when("/article_order", {
                templateUrl: "../article_order.html",
                controller: "articleOrderController",
                controllerAs: "articleOrderCtrl",
                css: "../styles/article_order.css"
            })
            .when("/cart", {
            	templateUrl: "../cart.html",
            	controller: "cartController",
            	controllerAs: "cartCtrl"
            })
            .when("/receipt", {
            	templateUrl: "../receipt.html",
            	controller: "receiptController",
            	controllerAs: "receiptCtrl",
            	css: "../styles/receipt.css"
            })
            .when("/salesman", {
            	templateUrl: "../salesman.html",
            	controller: "salesmanController",
            	controllerAs: "salesmanCtrl"
            })
            .when("/manager", {
            	templateUrl: "../manager.html",
            	controller: "managerController",
            	controllerAs: "managerCtrl"
            })
            .otherwise({
                redirectTo: "/"
            });
    }])
    .run(['Restangular', '$log', function(Restangular, $log) {
        Restangular.setErrorInterceptor(function (response) {
            if (response.status === 500) {
                $log.info("internal server error");
            }
            return true;
        });
    }]);