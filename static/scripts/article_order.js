(function() {
    angular.module("myApp").controller("articleOrderController", articleOrderController);
               
    function articleOrderController($http, $sessionStorage, $location) {

        var vm = this;
        vm.article = $sessionStorage.article;
        vm.ammount = 1;
        vm.user = $sessionStorage.user;
        vm.receipt = $sessionStorage.receipt;
        
        vm.decreaseAmmount = decreaseAmmount;
        vm.increaseAmmount = increaseAmmount;
        vm.goTo = goTo;
        vm.order = order;
        vm.getOldReceipt = getOldReceipt;
        vm.addItem = addItem;
        
        function decreaseAmmount() {
        	vm.ammount -= 1;
        }
        
        function increaseAmmount() {
        	vm.ammount += 1;
        }
        
        function goTo(path) {
        	$location.path('/' + path.toLowerCase());
        }
        
        // here should be a check if the certain article has already been added to the receipt, i dont want to add another item to receipt but
        // add values to the same item
        function order() {
        	if(vm.receipt) {
        		console.log(vm.receipt);
        		var item = {"receipt" : vm.receipt.code, "article" : vm.article.code, "ammount" : vm.ammount, "articlePrice" : vm.article.price,
        				"totalPrice" : vm.article.price * vm.ammount};
        		vm.addItem(item);
        	}
        	else {
        		var receipt = {"message" : vm.user.id};
        		$http.post("/api/customer/createNewReceipt", receipt).then(function(response) {
        			console.log(response.data)
        			$sessionStorage.receipt = response.data;
        			vm.receipt = response.data;
        			
        			var item = {"receipt" : vm.receipt.code, "article" : vm.article.code, "ammount" : vm.ammount, "articlePrice" : vm.article.price,
            				"totalPrice" : vm.article.price * vm.ammount};
        			vm.addItem(item);
                });
        	}
        }
        
        // add item to the existing receipt and set new receipt to the session
        function addItem(item) {
        	$http.post("/api/customer/addItem", item).then(function(response) {
    			
    			vm.getOldReceipt();
    			vm.goTo("customer");
    			
            });
        }
        
        // fetch receipt that you left last time you logged and didnt finish
        function getOldReceipt() {
        	$http.get("/api/customer/" + vm.user.id + "/getOldReceipt").then(function(response) {
        		if(response.data)
        			$sessionStorage.receipt = response.data;
        	});
        }
    
    }

})();