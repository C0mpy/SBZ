(function() {
    angular.module("myApp").controller("loginController", loginController);

    function loginController($http, $scope, $sessionStorage, $location, Upload, $timeout) {

        var vm = this;

        vm.login = login;
        vm.register = register;
        vm.showPicker = showPicker;
        vm.goTo = goTo;
        
        vm.picture = "https://cdn.filestackcontent.com/XdxMB5qmSrashXV7JhFk";
        vm.errorUsernamePassword = false;
        vm.client = filestack.init('AKU3MhzicQTiwDpMd8Lx9z');
        
        function login() {
            $http.post("/api/user/login", {"username": vm.loginUsername, "password": vm.loginPassword}).then(function(response) {
            	response.data.user.type = response.data.type;
            	$sessionStorage.user = response.data.user;
            	vm.errorUsernamePassword = false;
            	if(response.data.user.type == "Salesman")
            		vm.goTo("salesman")
            	else if(response.data.user.type == "Manager")
            		vm.goTo("manager");
            	else
            		vm.goTo("customer");
            }, function(error) {
            	vm.errorUsernamePassword = true;
            });
        };
        
        function goTo(path) {
        	$location.path('/' + path.toLowerCase());
        }
        
        function register() {  
        	$http.post("/api/user/register", {"username": vm.registerUsername, "password": vm.registerPassword, "firstName" : vm.firstname,
        		"lastName" : vm.lastname, "address" : vm.address, "picture" : vm.picture}).then(function(response) {
        		
        		$sessionStorage.user = response.data;
            	$location.path("/customer");
            });

		
        };
        
        function showPicker() {
            vm.client.pick().then(function(result) {
            	console.log(result.filesUploaded[0]["url"])
            	vm.picture = result.filesUploaded[0]["url"];
            	$scope.$apply();
            });
        }
        

    }
})();
