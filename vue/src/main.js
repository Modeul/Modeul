import App from './App.vue';
import { createApp } from 'vue';
import { createRouter, createWebHashHistory} from 'vue-router';

import Test from './views/Test.vue';

import Index from './views/Index.vue';
import Login from './views/Login.vue';
import SignUp from './views/SignUp.vue';
import List from './views/member/stuff/List.vue';
import Reg from './views/member/stuff/Reg.vue';
import Datail from './views/member/stuff/Detail.vue';

const routes = [
    { path: '/test', component: Test},


    { path: '/index', component: Index},
    { path: '/login', component: Login},
    { path: '/signup', component: SignUp},
    { path: '/member/stuff/list', component: List},
    { path: '/member/stuff/reg', component: Reg},
    { path: '/member/stuff/detail', component: Datail}
];


const router = createRouter({
    history: createWebHashHistory(),
    routes
});

const app = createApp(App)
app.use(router)
app.mount('#app')
