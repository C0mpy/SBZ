(function() {
    angular.module("myApp").controller("profileController", profileController);

    function profileController($http, $scope, $sessionStorage, $location) {

        var vm = this;
        vm.goTo = goTo;
        vm.getReceipts = getReceipts;
        
        vm.user = $sessionStorage.user;
        
        vm.getReceipts();    
        
        //this is only a mockup for receipts
        vm.receipts = [
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"},
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"},
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"},
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"},
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"},
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"},
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"},
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"},
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"},
        	{"id" : 1, "code" : 1, "date" : new Date(), "totalPrice" : 145, "totalDiscount" : 7, "finalPrice" : 123, "spentPoints" : 0, "earnedPoints" : 1, "state" : "ORDERED"}];
        
        
        function goTo(path) {
        	$location.path('/' + path.toLowerCase());
        }
        
        function getReceipts() {
        	
        	$http.get("/api/customer/" + vm.user.id + "/findReceipts").then(function(response) {
        		console.log("here they are!");
        		console.log(response.data);
        		vm.receipts = response.data;
        	});
        }
    }
})();
