window.addEventListener("load", function(){

    var detailSection = document.querySelector(".detail");

    var modal = detailSection.querySelector(".detail-modal");
    var img = detailSection.querySelector(".detail-img");
    var modalImg = detailSection.querySelector(".modal-img");
    var closeIcon = detailSection.querySelector(".icon-close");
	
	// const image = [[${imageName}]];
	
    img.onclick = function(){
        modal.style.display = 'block';
        
        //modalImg.src = "/images/member/stuff/" + image;
        modalImg.src = "/images/member/stuff/chick.jpg";
        
       
    };

    closeIcon.onclick = function(){
        event.stopPropagation();
        modal.style.display = 'none';
    }

    // 왜? addEventListener()로 작성하는 방식이 모던할까?
    // 1. 여러 개의 이벤트를 overwrite할 수 있다.
    // 2. 작성 중에 bubbling, capturing을 설정할 수 있다.
    // 3. 여러개의 이벤트 타입들을 쉽게 바인딩 할 수 있다.
    //  “onclick()으로 얻을 수 있는 장점이 물론 있겠지만 addEventListener()를 사용해서 얻는 장점에 비하면 너무 적을 것 같다.”


	// 찜 기능
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