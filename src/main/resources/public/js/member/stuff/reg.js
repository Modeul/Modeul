window.addEventListener("load", function(){

    // reg1에서 reg2로 페이지 이동 
    const reg2 = document.querySelector('.reg2-form');
    const reg1 = document.querySelector('.reg1-form');
    const btnReg = document.querySelector('.btn-next');
    const backArrow = document.querySelector('.reg2-back');

    const resultElement = document.querySelector('#result');
    const btnMinus = document.querySelector('.btn-minus');
    const btnPlus = document.querySelector('.btn-plus');

    btnReg.addEventListener('click', () => {
        // console.log("다음 출력");
        reg1.classList.toggle('d-none');
        reg2.classList.toggle('d-none');
    });

    backArrow.addEventListener('click', () => {
        // console.log("뒤로가기 출력");
        reg2.classList.toggle('d-none');
        reg1.classList.toggle('d-none');
    });


    // 인원수 조절 JS 
    // 현재 화면에 표시된 값
    let number = resultElement.value;

    btnMinus.addEventListener('click', () => {
        number = parseInt(number) - 1;
        resultElement.value = number;
    });

    btnPlus.addEventListener('click', () => {
        number = parseInt(number) + 1;
        resultElement.value = number;
    });
    
    // function count(type)  {
    //     // 결과를 표시할 element
    //     const resultElement = document.getElementById('result');
    //     // 현재 화면에 표시된 값
    //     let number = resultElement.innerText;
    //     // 더하기/빼기
    //     if(type === 'plus') {
    //       number = parseInt(number) + 1;
    //     }else if(type === 'minus')  {
    //       number = parseInt(number) - 1;
    //     }
    //     // 결과 출력
    //     resultElement.innerText = number;
    //   }
});