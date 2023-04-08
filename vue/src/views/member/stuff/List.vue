<style>
@import url('../../../assets/css/component/member/stuff/component-detail.css');
</style>

<script>
export default {
    data() {
        return {
            list: [],
            categoryList: null
        }

    },
    mounted() {
        fetch("http://localhost:8081/stuff")
            .then(response => response.json())
            .then(result => {
                this.list = result.list;
                this.categoryList = result.categoryList;
            })
            .catch(error => console.log('error', error));
    }


}
</script>

<template>
    <section class="canvas p-rel b-rad-2">
        <header class="d-fl-al header-jc">

            <select class="selectbox-set" onchange="if(this.value) location.href=(this.value);">
                <option value="">신수동</option>
                <option value="">신설동</option>
                <option value="gps">GPS설정</option>
            </select>

            <div>
                <!-- <a class="icon icon-menu">메뉴</a> -->
                <a class="icon icon-alarm">알림</a> <a class="icon"> <input type="checkbox" id="menuicon"> <label
                        for="menuicon">
                        <span></span> <span></span> <span></span>
                    </label>
                    <div class="sidebar">
                    <div class="welcome f-weight">
                            <span class="f-color-2">뉴렉님</span><br>환영합니다.
                        </div>
                        <div class="side-menu">
                            <div></div>
                            <span class="sidebar-padding" onclick="location.href='list'">홈</span>
                            <span class="sidebar-padding" onclick="location.href='list-search'">검색하기</span>
                            <span class="sidebar-padding" onclick="location.href='reg'">글 등록하기</span> 
                            <span class="sidebar-padding" onclick="location.href='../participation/list'">채팅하기</span>
                        </div>
                    </div>
                </a>
            </div>
        </header>
        <nav>
            <form action="list" method="get">
                <div class="header-categ-box">
                    <button class="header-categ">전체</button>
                    <button class="header-categ" name="c" value="1">일반상품</button>
                    <!-- <button class="header-categ" name="c" value="2">딜리버리 푸드</button>
                        					<button class="header-categ" name="c" value="3">대형마트 대량 물품</button> -->
                </div>
            </form>
        </nav>
        <!-- member/stuff/list -->

    <!-- 나중에 onclick 이벤트 하트 부분만 빼고 넣기 -->
    <main>
        <div v-for="s in list">

            <div class="d-gr li-gr m-t-13px list-cl" onclick="location.href='detail'">
                <!-- 나중에 전체를 div로 묶어서 main으로 크게 묶기 -->
                <div class="li-pic b-rad-1">사진</div>
                <div class="li-categ header-categ li-header-categ">{{ s.catagoryName }}</div>
                <div class="li-heart icon icon-heart">찬하트</div>
                <div class="li-subj">{{ s.title }}</div>
                <div class="li-member">{{ s.numPeople }}</div>
                <div class="li-date">{{ s.deadline }}</div>
            </div>
            <div>
                <h1 class="icon icon-line">선 긋기</h1>
            </div>
        </div>


        <!-- <div class="d-gr li-gr  list-cl" onclick="location.href='detail'">
				나중에 전체를 div로 묶어서 main으로 크게 묶기
				<div class="li-pic b-rad-1">사진</div>
    				<div class="li-categ header-categ li-header-categ">딜리버리 푸드</div>
    				<div class="li-heart icon icon-heart">찬하트</div>
    				<div class="li-subj">서강대 앞 교촌치킨 시켜드실 분</div>
        				<div class="li-member">2/5</div>
        				<div class="li-date">2월 3일 금 18시까지</div>
            			</div>
            			<div>
            				<h1 class="icon icon-line">선 긋기</h1>
            			</div>

                        			<div class="d-gr li-gr list-cl" onclick="location.href='detail'">
                        				나중에 전체를 div로 묶어서 main으로 크게 묶기
                        				<div class="li-pic b-rad-1">사진</div>
                        				<div class="li-categ header-categ li-header-categ">딜리버리 푸드</div>
                        				<div class="li-heart icon icon-heart">찬하트</div>
                        				<div class="li-subj">서강대 앞 교촌치킨 시켜드실 분</div>
                        				<div class="li-member">2/5</div>
                        				<div class="li-date">2월 3일 금 18시까지</div>
                        			</div>
                        			<div>
                        				<h1 class="icon icon-line">선 긋기</h1>
                        			</div> -->
        </main>

        <nav class="navi-bar d-fl-jf" style="display: none;">
            <div>
                <a class="icon icon-home m-notop" href="./list.html">home</a>
            </div>
            <div>
                <a class="icon icon-search m-notop" href="./list-search.html">search</a>
            </div>
            <div>
                <a class="icon icon-post m-notop" href="./reg.html">post+</a>
            </div>
            <div>
                <a class="icon icon-chat m-notop" href="../participation/list.html">chat</a>
            </div>
            <div>
                <a class="icon icon-info m-notop">mypage</a>
            </div>
        </nav>
    </section>
</template>