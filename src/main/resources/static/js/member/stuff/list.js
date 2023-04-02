window.addEventListener("load", function(){

    var heartList = document.getElementsByClassName('icon-heart');


    function heartClick(e) {
        e.stopPropagation();
        e.target.classList.toggle('icon-empty-heart');
        e.target.classList.toggle('icon-full-heart');
    }

    for (var i = 0; i < heartList.length; i++) {
        heartList[i].addEventListener("click", heartClick);
    }
    

    
});

// 위에 있는 JS 이벤트 핸들러 Vue로 다 바꾸기!!** DOM과 Vue 중에서 우선 순위가 Vue.js이다. 
// ================== Vue.js ============================================
Vue
.createApp({
	
	// 테스트부터 해볼 것!
	data() {
	  return {
		    test: '가좌동',
		    list: [],
		    categoryList:[],
		    category:[],
		   	id:[]
	  };
	},
	
	methods:{
			viewClickHandler(id){
					
			},
			categoryClickHandler(){
					
			},
			getList(){
				var requestOptions = {
				  method: 'GET',
				  redirect: 'follow'
				};
				
				fetch("http://localhost:8080/member/stuffs", requestOptions)
				  .then(response => response.json())
				  .then(list => {
						this.list = list
					})
				  .catch(error => console.log('error', error));
			},
			
			getCategoryList(){
				var requestOptions = {
				  method: 'GET',
				  redirect: 'follow'
				};
				
				fetch("http://localhost:8080/member/stuff/categories", requestOptions)
				  .then(response => response.json())
				  .then(categoryList => {
						this.categoryList = categoryList
					})
				  .catch(error => console.log('error', error));
			}
			

		
	},
	
	beforeCreate(){console.log("beforeCreate")},
	created(){console.log("created")},
	beforeMount(){console.log("beforeMount")},
	mounted(){
		console.log("mounted")
		this.getList();
		this.getCategoryList();
		this.categoryClickHandler();
	},
	beforeUpdate(){console.log("beforeUpdate")},
	updated(){console.log("updated")},
	beforeUnmount(){console.log("beforeUnmount")},
	unmounted(){console.log("unmounted")}
	
})
.mount('#list-main-section');

