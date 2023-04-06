<style>
@import url('/src/assets/css/component/component-sign-up.css');
</style>

<template>
    <div class="canvas f-family ">
        <header class="d-fl fl-dir-col al-cen">
            <section>
                <span class="d-none">헤더</span>
                <div>
                    <a href="login" class="icon icon-back">Back</a>
                </div>
                <div class="d-fl-jf">
                    <h1 class="logo-main logo-moduel logo-size1 m-t-44px">mo_deul</h1>
                </div>
                <div>
                    <h1 class="logo title-3 m-t-42px">회원 가입</h1>
                </div>
            </section>
        </header>
        <!-- ----------------------------------------------------------- -->
        <main class="m-t-31px">
            <!-- flex 시작 -->
            <div class="sign-up-container">

                <form action="sign-up" method="post">

                    <div class="input-field-2">
                        <label for="uid" class="uid-label">
                            <span class="d-none">uid</span>
                            <input type="text" id="uid" name="uid" class="input-text-2" placeholder="아이디를 입력해주세요.">
                        </label>
                    </div>

                    <div class="input-field-2 m-t-1">
                        <label for="password" class="password-label">
                            <span class="d-none">pw</span>
                            <input type="text" id="password" name="password" class="input-text-2"
                                placeholder="비밀번호를 입력해주세요.">
                        </label>
                    </div>

                    <div class="input-field-2 m-t-1">
                        <label for="password-confirm" class="password-confirm-label">
                            <span class="d-none">pw-confirm</span>
                            <input type="text" id="password-confirm" name="repassword" class="input-text-2"
                                placeholder="비밀번호를 다시 입력해주세요.">
                        </label>
                    </div>

                    <div class="input-field-2 m-t-1">
                        <label for="name" class="name-label">
                            <span class="d-none">name</span>
                            <input type="text" id="name" name="name" class="input-text-2" placeholder="이름을 입력해주세요.">
                        </label>
                    </div>

                    <div class="input-field-2 m-t-1">
                        <label for="name" class="name-label">
                            <span class="d-none">nickname</span>
                            <input type="text" id="nickname" name="nickname" class="input-text-2"
                                placeholder="닉네임을 입력해주세요.">
                        </label>
                    </div>

                    <div class="input-field-2 m-t-1">
                        <label for="email" class="email-label">
                            <span class="d-none">email</span>
                            <input type="text" id="email" name="email" class="input-text-2" placeholder="이메일을 입력해주세요.">
                            <input class="btn-post" id="btn-post" type="button" value="전송">
                        </label>
                    </div>

                    <div class="input-field-2 m-t-1">
                        <label for="email" class="email-confirm-label">
                            <span class="d-none">email-confirm</span>
                            <input type="text" id="email" name="reemail" class="input-text-2"
                                placeholder="이메일 인증번호를 입력해주세요.">
                            <input class="btn-auth" id="btn-auth" type="button" value="확인">
                        </label>
                    </div>

                    <div class="d-fl-jf m-t-69px">
                        <input class="btn-3" type="submit" value="가입하기">
                    </div>
                </form>
            </div>
            <!-- flex 끝 -->


        </main>

    </div>
</template>