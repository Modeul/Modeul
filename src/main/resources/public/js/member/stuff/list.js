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