(function() {
    angular.module("myApp").controller("customerController", customerController);
               
    function customerController($http, $sessionStorage, $location) {

        var vm = this;
        
        vm.goTo = goTo;
        vm.getPage = getPage;
        vm.getArticles = getArticles;
        vm.getNumberArticles = getNumberArticles;
        vm.filter = filter;
        vm.removeFilter = removeFilter;
        vm.orderArticle = orderArticle;
        vm.getOldReceipt = getOldReceipt;
        
        vm.user = $sessionStorage.user;
        vm.items = []
        
        vm.getNumberArticles();
        vm.getPage();
        vm.getOldReceipt();
        
        function goTo(path) {
        	$location.path('/' + path.toLowerCase());
        }
        
        function getNumberArticles(code, name, minPrice, maxPrice, category, status) {
        	$http.post("/api/user/articles/count", {"code" : code, "name" : name, "minPrice" : minPrice, "maxPrice" : maxPrice,
        		"category" : category, "status": status}).then(function(response) {
        		vm.numberArticles = response.data;
            });
        }
        
        function getArticles(code, name, minPrice, maxPrice, category, status, page, count) {
        	$http.post("/api/user/articles", {"code" : code, "name" : name, "minPrice" : minPrice, "maxPrice" : maxPrice,
        		"category" : category, "status": status, "page" : page, "count": count}).then(function(response) {
            	//split articles in two lists so i can display them nicely
            	vm.artOne = response.data.splice(0, 3);
            	vm.artTwo = response.data.splice(0, 3);
            });
        }
        
        function getPage() {
        	getArticles(null, null, null, null, null, "ACTIVE", vm.currentPage - 1, 6);
        }
        
        function filter() {
        	vm.currentFilter = {"code" : vm.code, "name" : vm.name, "minPrice" : vm.minPrice, "maxPrice" : vm.maxPrice, "category" : vm.category};
        	getNumberArticles(vm.code, vm.name, vm.minPrice, vm.maxPrice, vm.category, "ACTIVE", 0, 6);
        	getArticles(vm.code, vm.name, vm.minPrice, vm.maxPrice, vm.category, "ACTIVE", 0, 6);
        }
        
        function removeFilter(field) {
        	vm[field] = null;
        	vm.filter();
        }
        
        function orderArticle(article) {
        	$sessionStorage.article = article;
        	vm.goTo("article_order");
        }
        
        // fetch receipt that you left last time you logged and didnt finish
        function getOldReceipt() {
        	$http.get("/api/customer/" + vm.user.id + "/getOldReceipt").then(function(response) {
        		if(response.data) {
        			$sessionStorage.receipt = response.data;
        			vm.receipt = response.data;
        		}
        	});
        }
        
        
    }

})();