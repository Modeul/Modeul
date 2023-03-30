window.addEventListener("load", function(){

    // function을 addEventListener로 바꾸는 방법(아래 코드와 살펴보기 )
    const searchInput = document.querySelector('.search-input');
    const searchResult = document.querySelector('.result-list');

    searchInput.addEventListener('keypress',(e)=>{
        e.preventDefault(); 

        if(e.code == 'Enter' && searchResult.classList.contains('d-none')){
            searchResult.classList.remove('d-none');
        }
    });

    // 검색 수정하기!!
    // function search_result(e){
    //     const searchResult = document.querySelector('.result-list');

    //     // 이벤트 발생 시, 충돌나지 말라고 쓰는 것이다. 
    //     // 보통, CSR에서 a태그에 쓰인다. 페이지 로드될 때, 로드 시키고 데이터만 바뀌기 때문에 a 태그의 기본 기능을 무력화시켜야 한다. 
    //     e.preventDefault(); 

        
    //     if(e.code == 'Enter' && searchResult.classList.contains('d-none')){
    //         searchResult.classList.remove('d-none');
    //     }

    //     else if(e.code == 'Enter' && searchResult.classList.contains('d-none')){
    //         searchResult.classList.add('d-none');
    //     }

    // }

});