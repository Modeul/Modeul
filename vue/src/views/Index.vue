<style>
@import url('/src/assets/css/component/component-index.css');
</style>

<script>

</script>

<template>
    <div class="canvas">
        <header>
            <h1 class="d-none">제목입니다.</h1>
            <div class="header-container d-fl-jf">
                <h1 class="logo-main logo-moduel m-t-138px">mo_deul</h1>
            </div>
        </header>
        <!--  -->
        <main>
            <!-- flex start -->
            <div class="main-container">
                <h1 class="d-none">바디</h1>
                <p>
                <h2 class="title">우리 동네 공구 마켓 vue</h2><br>
                <span class="text">
                    모들은 이웃 주민들과<br>
                    물건을 함께 구매하는 마켓이에요<br>
                    로그인을 하여 이용해보세요<br>
                </span>
                </p>
            </div>
            <!-- flex end -->

            <!-- flex start -->
            <div class="link-container">
                <h1 class="d-none">시작</h1>
                <div class="btn-1 start-text">
                    <router-link to="/login">START</router-link>
                </div>
            </div>
            <!-- flex end -->
        </main>
    </div>
</template>