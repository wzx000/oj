import { createRouter, createWebHistory } from 'vue-router'
import HomeIndexView from "../views/home/HomeIndexView"
import BankIndexView from "../views/bank/BankIndexView"
import BankProblemView from "../views/bank/problem/BankProblemView"
import SubjectIndexView from "../views/subject/SubjectIndexView"
import CompetitionIndexView from "../views/competition/CompetitionIndexView"
import CompetitionProblemView from "../views/competition/CompetitionProblemView"
import CompetitionOverviewView from "../views/competition/CompetitionOverviewView"
import CompetitionProblemOverviewView from "../views/competition/problem/CompetitionProblemOverviewView"
import CompetitionTitleView from "../views/competition/CompetitionTitleView"
import CompetitionRatingView from "../views/competition/CompetitionRatingView"
import CompetitionAddView from "../views/competition/CompetitionAddView"
import CompetitionProblemIndexView from "../views/competition/problem/CompetitionProblemIndexView"
import CompetitionProblemAddView from "../views/competition/problem/CompetitionProblemAddView"
import CompetitionProblemUpdateView from "../views/competition/problem/CompetitionProblemUpdateView"
import NotFound from "../views/error/NotFound"
import UserIndexView from "../views/user/UserIndexView"
import UserLoginView from "../views/user/UserLoginView"
import UserRegisterView from "../views/user/UserRegisterView"
import AdministratorIndexView from "../views/administrator/AdministratorIndexView"
import AdministratorUserView from "../views/administrator/user/AdministratorUserView"
import AdministratorTitleView from "../views/administrator/title/AdministratorTitleView"
import AdministratorCompetitionView from "../views/administrator/competition/AdministratorCompetitionView"
import ProblemAddView from "../views/problem/ProblemAddView"
import ProblemGetView from "../views/problem/ProblemGetView"
import ProblemGetListView from "../views/problem/ProblemGetListView"
import ProblemUpdateView from "../views/problem/ProblemUpdateView"
import store from '../store/index'

const routes = [
  {
    path: "/",
    name: "home",
    redirect: "/home/",
    meta: {
      requestAuth: true,
      administratorRequestAuth: false,
  },
},
{
    path: "/home/",
    name: "home_index",
    component: HomeIndexView,
    meta: {
      requestAuth: true,
      administratorRequestAuth: false,
  },
},
{
    path: "/bank/",
    name: "bank_index",
    component: BankIndexView,
    meta: {
      requestAuth: true,
      administratorRequestAuth: false,
  },
},
{
  path: "/bank/problem/",
  name: "bank_problem",
  component: BankProblemView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: false,
  },
},
{
  path: "/subject/",
  name: "subject_index",
  component:SubjectIndexView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: false,
  },
},
{
  path: "/competition/",
  name: "competition_index",
  component: CompetitionIndexView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: false,
  },
},
{
  path: "/competition/problem/",
  name: "competition_problem",
  component: CompetitionProblemView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: false,
  },
},
{
  path: "/competition/overview/",
  name: "competition_overview",
  component: CompetitionOverviewView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: false,
  },
},
{
  path: "/competition/problem/overview/",
  name: "competition_problem_overview",
  component: CompetitionProblemOverviewView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: false,
  },
},
{
  path: "/competition/title/",
  name: "competition_title",
  component: CompetitionTitleView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: false,
  },
},
{
  path: "/competition/rating/",
  name: "competition_rating",
  component: CompetitionRatingView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: false,
  },
},
{
  path: "/user/",
  name: "user_index",
  component: UserIndexView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: false,
  },
},
{
  path: "/user/login/",
  name: "user_login",
  component: UserLoginView,
  meta: {
    requestAuth: false,
    administratorRequestAuth: false,
  },
},
{
  path: "/user/register/",
  name: "user_register",
  component: UserRegisterView,
  meta: {
    requestAuth: false,
    administratorRequestAuth: false,
  },
},
{
  path: "/administrator/index/",
  name: "administrator_index",
  component: AdministratorIndexView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/competition/add/",
  name: "competition_add",
  component: CompetitionAddView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/competition/problem/index/",
  name: "competition_problem_index",
  component: CompetitionProblemIndexView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/competition/problem/add/",
  name: "competition_problem_add",
  component: CompetitionProblemAddView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/competition/problem/update/",
  name: "competition_problem_update",
  component: CompetitionProblemUpdateView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/administrator/competition/",
  name: "administrator_competition",
  component: AdministratorCompetitionView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/administrator/user/",
  name: "administrator_user",
  component: AdministratorUserView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/administrator/title/",
  name: "administrator_title",
  component: AdministratorTitleView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/problem/add/",
  name: "problem_add",
  component: ProblemAddView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/problem/get/",
  name: "problem_get",
  component: ProblemGetView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/problem/getlist/",
  name: "problem_getlist",
  component: ProblemGetListView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
  path: "/problem/update/",
  name: "problem_update",
  component: ProblemUpdateView,
  meta: {
    requestAuth: true,
    administratorRequestAuth: true,
  },
},
{
    path: "/404/",
    name: "404",
    component: NotFound,
    meta: {
      requestAuth: false,
      administratorRequestAuth: false,
    },
},
{
    path: "/:catchAll(.*)",
    redirect: "/404/",
},

]
const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.requestAuth && !store.state.user.is_login) {
      next({name: "user_login"});
  } else if(to.meta.administratorRequestAuth && store.state.user.username !== '王兆轩'){
    next({name: "home"});
  }else {
      next();
  }
})

export default router
