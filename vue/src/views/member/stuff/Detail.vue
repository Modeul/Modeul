<style>
@import url('/src/assets/css/component/member/stuff/component-detail.css');
</style>

<script type="text/javascript" src="../../../assets/js/member/stuff/reg.js"></script>

<template>
    <!-- detail : flex-container -->
    <div class="detail">
        <header>
            <a class="icon icon-back" onclick="location.href='list'">뒤로가기</a>
        </header>

        <!-- detail - item1  -->
        <main>
            <!-- detail-main : flex-container -->
            <div class="detail-main">
                <!-- detail-img : detail-main - item1 -->
                <div class="detail-img">
                    <img src="../../../../images/member/stuff/chick.jpg" alt="img">

                    <!-- image : modal -->
                    <div class="detail-modal">

                        <div class="icon-close" src="../../images/member/stuff/heart.png">&times;</div>
                        <!-- <img class="icon-close" src="../../images/member/stuff/heart.png"> -->
                        <img class="modal-img">
                    </div>

                    <!-- image : slideshow -->


                </div>

                <!-- detail-heading : detail-main - item2 -->
                <section class="canvas detail-heading">
                    <h1 class="d-none">heading</h1>
                    <div class="detail-category">대형마트 대량 물품</div>
                    <p class="detail-heading-title">금요일에 같이 치킨 드실 분?</p>
                    <div class="d-fl">
                        <div class="detail-price">22,000원</div>
                        <div class="detail-status">모집중</div>
                        <div class="detail-heart">찜</div>
                        <div class="icon-heart">하트</div>
                    </div>
                </section>
                <!-- detail-info : detail-main - item3 -->
                <section class="canvas detail-info">
                    <h1 class="d-none">info</h1>
                    <div>•인원</div>
                    <div>2 / 5</div>
                    <div>•기한</div>
                    <div>2월 10일 13:00</div>
                    <div>•장소</div>
                    <div>땡땡아파트 정문</div>
                </section>
                <!-- detail-writing : detail-main - item4 -->
                <section class="canvas detail-writing">
                    <h1 class="d-none">writing</h1>
                    <p class="detail-paragraph">
                        hi<br>
                        hi<br>
                        hi<br>
                        hi<br>
                        hi<br>
                        hi<br>
                        hi<br>
                        hi<br>
                        hi<br>
                        hi<br>
                        hi<br>
                        hi<br>
                    </p>
                </section>
            </div>
        </main>

        <!-- detail-join : detail - itme2  -->

        <section class="canvas detail-join">
            <h1 class="d-none">join</h1>
            <h2 class="detail-join-title">참여중인 사람</h2>
            <div class="detail-join-members">
                <a class="icon-member">멤버a</a>
                <a class="icon-member">멤버b</a>
                <a class="icon-member">멤버c</a>
                <a class="icon-member">멤버d</a>
                <a class="icon-member">멤버e</a>
            </div>
            <button class="detail-join-button" onclick="location.href='list'">참여하기</button>
        </section>
    </div>
</template>